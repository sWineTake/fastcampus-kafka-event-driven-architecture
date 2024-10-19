package com.fastcampus.kafkahandson.ugc.adapter.originpost;

import com.fastcampus.kafkahandson.ugc.adapter.common.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OriginalPostMessage {

	private Long id;
	private Payload payload;
	private OperationType operationType;

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
	public static class Payload {
		private Long id;
		private String title;
		private String content;
		private Long userId;
		private Long categoryId;
		private LocalDateTime createdAt;
		private LocalDateTime updatedAt;
		private LocalDateTime deletedAt;
	}

}
