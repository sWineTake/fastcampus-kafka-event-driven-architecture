package com.fastcampus.kafkahandson.ugc.post.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResolvedPost { // Post + meta data => 조립

	private Long id;
	private String title;
	private String content;
	private Long userId;
	private String userName;
	private Long categoryId;
	private String categoryName;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private boolean updated;

	public static ResolvedPost create(Post post, String userName, String categoryName) {
		return new ResolvedPost(
			post.getId(),
			post.getTitle(),
			post.getContent(),
			post.getUserId(),
			userName,
			post.getCategoryId(),
			categoryName,
			post.getCreatedAt(),
			post.getUpdatedAt(),
			post.getUpdatedAt() != null
		);
	}


}
