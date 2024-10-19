package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.adapter.originpost.OriginPostMessageProduceAdapter;
import com.fastcampus.kafkahandson.ugc.port.PostPort;
import com.fastcampus.kafkahandson.ugc.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostDeleteUsecaseImpl implements PostDeleteUsecase {

	private final PostPort postPort;
	private final OriginPostMessageProduceAdapter originPostMessageProduceAdapter;

	@Override
	@Transactional
	public Post delete(PostDeleteUsecase.Request request) {

		Post post = postPort.findById(request.getPostId());

		if (post == null) return null;

		post.delete();
		Post deletePost = postPort.save(post);

		originPostMessageProduceAdapter.sendDeleteMessage(deletePost);
		return deletePost;
	}
}
