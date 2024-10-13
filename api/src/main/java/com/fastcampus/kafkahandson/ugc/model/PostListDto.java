package com.fastcampus.kafkahandson.ugc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class PostListDto {
	private final Long id;
	private final String title;
	private final String userName;
	private final LocalDateTime createdAt;
}
