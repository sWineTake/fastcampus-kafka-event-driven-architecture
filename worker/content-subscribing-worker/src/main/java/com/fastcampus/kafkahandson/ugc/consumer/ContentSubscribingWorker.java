package com.fastcampus.kafkahandson.ugc.consumer;

import com.fastcampus.kafkahandson.ugc.CustomObjectMapper;
import com.fastcampus.kafkahandson.ugc.SubscribingPostAddInboxUsecase;
import com.fastcampus.kafkahandson.ugc.SubscribingPostRemoveInboxUsecase;
import com.fastcampus.kafkahandson.ugc.adapter.common.OperationType;
import com.fastcampus.kafkahandson.ugc.adapter.common.Topic;
import com.fastcampus.kafkahandson.ugc.adapter.inspectedport.InspectedPostMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ContentSubscribingWorker {

	private final CustomObjectMapper objectMapper = new CustomObjectMapper();

	private final SubscribingPostAddInboxUsecase subscribingPostAddInboxUsecase;
	private final SubscribingPostRemoveInboxUsecase subscribingPostRemoveInboxUsecase;

	@KafkaListener(
		topics = { Topic.INSPECTED_POST },
		groupId = "subscribing-post-consumer-group",
		concurrency = "3"
	)
	public void listen(String message) {
		try {
			InspectedPostMessage inspectedPostMessage = objectMapper.readValue(message, InspectedPostMessage.class);
			if (inspectedPostMessage.getOperationType() == OperationType.CREATE) {
				this.handleCreate(inspectedPostMessage);
			} else if (inspectedPostMessage.getOperationType() == OperationType.UPDATE) {
				// 업데이트할때 아무것도 하지않음
			} if (inspectedPostMessage.getOperationType() == OperationType.DELETE) {
				this.handleDelete(inspectedPostMessage);
			}
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}

	}

	private void handleCreate(InspectedPostMessage inspectedPostMessage) {
		subscribingPostAddInboxUsecase.saveSubscribingInboxPost(inspectedPostMessage.getPayload().getPost());
	}

	private void handleDelete(InspectedPostMessage inspectedPostMessage) {
		subscribingPostRemoveInboxUsecase.deleteSubscribingInboxPost(inspectedPostMessage.getId());
	}
}
