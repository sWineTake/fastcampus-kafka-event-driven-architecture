package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.adapter.originpost.OriginPostMessageProduceAdapter;
import com.fastcampus.kafkahandson.ugc.port.PostPort;
import com.fastcampus.kafkahandson.ugc.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostCreateUsecaseImpl implements PostCreateUsecase {

	private final PostPort postPort;
	private final OriginPostMessageProduceAdapter originPostMessageProduceAdapter;

	@Override
	@Transactional
	public Post create(Request request) {
		Post post = postPort.save(
			Post.create(
				request.getUserId(),
				request.getTitle(),
				request.getContent(),
				request.getCategoryId()
			)
		);

		// 메시지 전송
		originPostMessageProduceAdapter.sendCreateMessage(post);

		return post;
	}

}
