package com.fastcampus.kafkahandson.ugc.adapter.inspectedport;

import com.fastcampus.kafkahandson.ugc.adapter.common.OperationType;
import com.fastcampus.kafkahandson.ugc.post.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class InspectedPostMessage {

	private Long id;
	private Payload payload;
	private OperationType operationType;

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
	public static class Payload {
		private Post post;
		private String categoryName;
		private List<String> tags;
		private LocalDateTime inspectedAt;
	}

}
