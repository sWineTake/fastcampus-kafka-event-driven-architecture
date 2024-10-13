package com.fastcampus.kafkahandson.ugc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class PostDetailDto {

	private final Long id;
	private final String title;
	private final String content;
	private final String userName;
	private final String categoryName;
	private final LocalDateTime createdAt;
	private final Boolean updated;

}
