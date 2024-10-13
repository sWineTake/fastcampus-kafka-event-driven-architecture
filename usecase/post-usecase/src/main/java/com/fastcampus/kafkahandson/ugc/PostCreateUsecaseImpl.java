package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.post.model.Post;
import org.springframework.stereotype.Service;

@Service
public class PostCreateUsecaseImpl implements PostCreateUsecase {
	@Override
	public Post create(Request request) {
		return Post.create(request.getUserId(), request.getTitle(), request.getContent(), request.getCategoryId());
	}

}
