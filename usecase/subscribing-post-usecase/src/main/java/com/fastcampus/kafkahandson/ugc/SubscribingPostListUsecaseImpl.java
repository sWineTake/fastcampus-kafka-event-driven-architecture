package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.post.model.ResolvedPost;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public interface SubscribingPostListUsecaseImpl {

	// 구독자의 인박스에있는 컨텐츠 목록을 조회한다.
	List<ResolvedPost> listSubscribingInboxPosts(Request request);

	@Getter
	@AllArgsConstructor
	class Request {
		private final int pageNumber;
		private final Long followerUesrId;
	}

}
