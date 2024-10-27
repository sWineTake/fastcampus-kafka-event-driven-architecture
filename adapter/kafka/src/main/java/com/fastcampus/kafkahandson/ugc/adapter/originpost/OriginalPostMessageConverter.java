package com.fastcampus.kafkahandson.ugc.adapter.originpost;

import com.fastcampus.kafkahandson.ugc.post.model.Post;

public class OriginalPostMessageConverter {

	public static Post toModel(OriginalPostMessage message) {
		return new Post(
			message.getId(),
			message.getPayload().getTitle(),
			message.getPayload().getContent(),
			message.getPayload().getUserId(),
			message.getPayload().getCategoryId(),
			message.getPayload().getCreatedAt(),
			message.getPayload().getUpdatedAt(),
			message.getPayload().getDeletedAt()
		);
	}

}
