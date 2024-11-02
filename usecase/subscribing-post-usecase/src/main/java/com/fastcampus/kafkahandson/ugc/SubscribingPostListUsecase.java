package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.port.SubscribingPostPort;
import com.fastcampus.kafkahandson.ugc.post.model.ResolvedPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubscribingPostListUsecase implements SubscribingPostListUsecaseImpl {

	private static final int PAGE_SIZE = 5;

	private final SubscribingPostPort subscribingPostPort;
	private final PostResolvingHelpUsecase postResolvingHelpUsecase;

	@Override
	public List<ResolvedPost> listSubscribingInboxPosts(Request request) {

		List<Long> postIdList =
			subscribingPostPort.listPostIdsByFollowerUserIdWithPagination(
				request.getFollowerUesrId(),
				request.getPageNumber(),
				PAGE_SIZE
			);

		return postResolvingHelpUsecase.resolvePosts(postIdList);
	}
}
