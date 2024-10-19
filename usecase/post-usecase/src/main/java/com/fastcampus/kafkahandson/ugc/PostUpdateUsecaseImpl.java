package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.adapter.originpost.OriginPostMessageProduceAdapter;
import com.fastcampus.kafkahandson.ugc.port.PostPort;
import com.fastcampus.kafkahandson.ugc.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostUpdateUsecaseImpl implements PostUpdateUsecase {

	private final PostPort postPort;
	private final OriginPostMessageProduceAdapter originPostMessageProduceAdapter;

	@Override
	@Transactional
	public Post update(Request request) {

		Post post = postPort.findById(request.getPostId());

		// 빠른 리턴
		if (post == null) return null;
		Post savePost = postPort.save(
			post.update(
				request.getTitle(),
				request.getContent(),
				request.getCategoryId()
			)
		);

		originPostMessageProduceAdapter.sendUpdateMessage(savePost);
		return post;
	}
}
