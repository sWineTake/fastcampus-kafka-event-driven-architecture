package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.post.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public interface PostUpdateUsecase {

	Post update(Request request);

	@Getter
	@Setter
	@AllArgsConstructor
	class Request {
		private final Long postId;
		private final String title;
		private final String content;
		private final Long categoryId;
	}
}
