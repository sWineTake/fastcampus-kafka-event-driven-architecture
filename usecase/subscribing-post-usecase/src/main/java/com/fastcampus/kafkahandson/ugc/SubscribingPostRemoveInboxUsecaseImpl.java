package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.port.SubscribingPostPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubscribingPostRemoveInboxUsecaseImpl implements SubscribingPostRemoveInboxUsecase {

	private final SubscribingPostPort subscribingPostPort;

	@Override
	public void deleteSubscribingInboxPost(Long postId) {
		subscribingPostPort.removePostFromFollowerInboxes(postId);
	}
}
