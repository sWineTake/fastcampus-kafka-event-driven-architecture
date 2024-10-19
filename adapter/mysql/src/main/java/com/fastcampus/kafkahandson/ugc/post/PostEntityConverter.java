package com.fastcampus.kafkahandson.ugc.post;

import com.fastcampus.kafkahandson.ugc.port.PostPort;
import com.fastcampus.kafkahandson.ugc.post.model.Post;

public class PostEntityConverter {

	public static PostEntity toEntity(Post post) {
		return new PostEntity(
			post.getId(),
			post.getTitle(),
			post.getContent(),
			post.getUserId(),
			post.getCategoryId(),
			post.getCreatedAt(),
			post.getUpdatedAt(),
			post.getDeletedAt()
		);
	}

	public static Post toModel(PostEntity entity) {
		return new Post(
			entity.getId(),
			entity.getTitle(),
			entity.getContent(),
			entity.getUserId(),
			entity.getCategoryId(),
			entity.getCreatedAt(),
			entity.getUpdatedAt(),
			entity.getDeletedAt()
		);
	}

}
