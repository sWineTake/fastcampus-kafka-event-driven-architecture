package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.post.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public interface PostDeleteUsecase {

	Post delete(Request id);

	@Getter
	@Setter
	@AllArgsConstructor
	class Request {
		private final Long postId;
	}

}
