package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.port.PostPort;
import com.fastcampus.kafkahandson.ugc.post.model.Post;
import com.fastcampus.kafkahandson.ugc.post.model.ResolvedPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostReadUsecaseImpl implements PostReadUsecase {

	private final PostPort postPort;

	@Override
	public ResolvedPost getById(Long id) {
		Post post = postPort.findById(id);
		if (post == null) return null;

		// return ResolvedPost.create(post, );
		return null;
	}
}
