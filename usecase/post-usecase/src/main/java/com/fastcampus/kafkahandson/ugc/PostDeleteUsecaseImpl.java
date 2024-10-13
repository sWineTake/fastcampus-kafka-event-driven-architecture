package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.post.model.Post;
import org.springframework.stereotype.Service;

@Service
public class PostDeleteUsecaseImpl implements PostDeleteUsecase {
	@Override
	public Post delete(Request id) {
		return null;
	}
}
