package com.fastcampus.kafkahandson.ugc.controller;

import com.fastcampus.kafkahandson.ugc.*;
import com.fastcampus.kafkahandson.ugc.model.PostDetailDto;
import com.fastcampus.kafkahandson.ugc.model.PostDto;
import com.fastcampus.kafkahandson.ugc.post.model.Post;
import com.fastcampus.kafkahandson.ugc.post.model.ResolvedPost;
import com.fastcampus.kafkahandson.ugc.request.PostCreateRequest;
import com.fastcampus.kafkahandson.ugc.request.PostUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
	private final PostCreateUsecaseImpl postCreateUsecase;
	private final PostDeleteUsecase postDeleteUsecase;
	private final PostReadUsecase postReadUsecase;
	private final PostUpdateUsecase postUpdateUsecase;

	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostCreateRequest request) {
		Post post = postCreateUsecase.create(
			new PostCreateUsecase.Request(
				request.getUserId(),
				request.getTitle(),
				request.getContent(),
				request.getCategoryId()
			)
		);
		return ResponseEntity.ok(convertToDto(post));
	}

	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(
		@PathVariable Long id,
		@RequestBody PostUpdateRequest request
	) {
		Post post = postUpdateUsecase.update(
			new PostUpdateUsecase.Request(
				id,
				request.getTitle(),
				request.getContent(),
				request.getCategoryId()
			)
		);
		return ResponseEntity.ok(convertToDto(post));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostDetailDto> readPost(@PathVariable Long id) {
		ResolvedPost post = postReadUsecase.getById(id);
		if (post == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(convertToDto(post));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable Long id) {
		postDeleteUsecase.delete(
			new PostDeleteUsecase.Request(id)
		);
		return ResponseEntity.ok().build();
	}

	private PostDto convertToDto(Post post) {
		return new PostDto(
			post.getId(),
			post.getTitle(),
			post.getContent(),
			post.getUserId(),
			post.getCategoryId(),
			post.getCreatedAt(),
			post.getUpdatedAt(),
			post.getDeletedAt()
		);
	}

	private PostDetailDto convertToDto(ResolvedPost post) {
		return new PostDetailDto(
			post.getId(),
			post.getTitle(),
			post.getContent(),
			post.getUserName(),
			post.getCategoryName(),
			post.getCreatedAt(),
			post.isUpdated()
		);
	}


}
