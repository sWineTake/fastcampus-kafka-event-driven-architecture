package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.post.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public interface PostCreateUsecase {

	Post create(Request request);

	@Getter
	@Setter
	@AllArgsConstructor
	class Request {
		private final Long userId;
		private final String title;
		private final String content;
		private final Long categoryId;
	}


}
