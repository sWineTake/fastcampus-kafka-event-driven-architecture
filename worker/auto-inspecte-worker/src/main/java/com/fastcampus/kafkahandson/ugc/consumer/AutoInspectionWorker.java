package com.fastcampus.kafkahandson.ugc.consumer;

import com.fastcampus.kafkahandson.ugc.CustomObjectMapper;
import com.fastcampus.kafkahandson.ugc.PostInspectUsecase;
import com.fastcampus.kafkahandson.ugc.adapter.common.OperationType;
import com.fastcampus.kafkahandson.ugc.adapter.common.Topic;
import com.fastcampus.kafkahandson.ugc.adapter.originpost.OriginalPostMessage;
import com.fastcampus.kafkahandson.ugc.adapter.originpost.OriginalPostMessageConverter;
import com.fastcampus.kafkahandson.ugc.inspectedpost.InspectedPost;
import com.fastcampus.kafkahandson.ugc.port.InspectedPostMessageProducerPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AutoInspectionWorker {

	private final CustomObjectMapper objectMapper = new CustomObjectMapper();
	private final PostInspectUsecase postInspectUsecase;
	private final InspectedPostMessageProducerPort inspectedPostMessageProducerPort;

	@KafkaListener(
		topics = {Topic.ORIGINAL_POST},
		groupId = "auto-inspection-worker-1",
		concurrency = "3"
	)
	public void listener(ConsumerRecord<String, String> message) {

		try {
			sendMessage(
				objectMapper.readValue(message.value(), OriginalPostMessage.class)
			);

		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	private void sendMessage(OriginalPostMessage originPostMessage) {

		if (originPostMessage == null) return;

		if (originPostMessage.getOperationType().equals(OperationType.CREATE)
			|| originPostMessage.getOperationType().equals(OperationType.UPDATE)
		) {
			InspectedPost inspectedPost = postInspectUsecase.inspectAndGetIfValid(
				OriginalPostMessageConverter.toModel(originPostMessage)
			);
			// 검수가 불가능한 경우 게시글 삭제시킴
			if (inspectedPost == null) {
				sendDelete(originPostMessage.getId());
			}

			inspectedPostMessageProducerPort.sendCreateMessage(inspectedPost);
		} else if (originPostMessage.getOperationType().equals(OperationType.DELETE)) {
			sendDelete(originPostMessage.getId());
		}
	}

	private void sendDelete(Long id) {
		inspectedPostMessageProducerPort.sendDeleteMessage(id);
	}

}
