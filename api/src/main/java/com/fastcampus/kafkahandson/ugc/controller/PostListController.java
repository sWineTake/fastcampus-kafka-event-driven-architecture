package com.fastcampus.kafkahandson.ugc.controller;

import com.fastcampus.kafkahandson.ugc.SubscribingPostListUsecase;
import com.fastcampus.kafkahandson.ugc.SubscribingPostListUsecaseImpl;
import com.fastcampus.kafkahandson.ugc.model.PostInListDto;
import com.fastcampus.kafkahandson.ugc.model.PostListDto;
import com.fastcampus.kafkahandson.ugc.post.model.ResolvedPost;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/list")
public class PostListController {

	private final SubscribingPostListUsecase subscribingPostListUsecase;

	@GetMapping("/{userId}")
	public ResponseEntity<List<PostInListDto>> getList(
		@PathVariable Long userId,
		@RequestParam(name = "page", defaultValue = "0", required = false) int page
	) {
		List<ResolvedPost> inboxList =
			subscribingPostListUsecase.listSubscribingInboxPosts(
				new SubscribingPostListUsecaseImpl.Request(page, userId)
			);

		return ResponseEntity.ok(inboxList.stream().map(this::toDto).toList());
	}

	@GetMapping("/search")
	public ResponseEntity<List<PostListDto>> getSearchList(
		@RequestParam("query") String query
	) {
		return ResponseEntity.internalServerError().build();
	}

	private PostInListDto toDto(ResolvedPost resolvedPost) {
		return new PostInListDto(
			resolvedPost.getId(),
			resolvedPost.getTitle(),
			resolvedPost.getUserName(),
			resolvedPost.getCreatedAt()
		);
	}
}
