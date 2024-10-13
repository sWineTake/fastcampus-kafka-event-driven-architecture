package com.fastcampus.kafkahandson.ugc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class PostDto {

	private final Long id;
	private final String title;
	private final String content;
	private final Long userId;
	private final Long categoryId;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;
	private final LocalDateTime deletedAt;

}
