package com.fastcampus.kafkahandson.ugc.meta;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MetadataClient {

	private final WebClient webClient;

	public CategoryResponse getCategoryById(Long categoryId) {
		return webClient
				.get()
				.uri("/categories/{categoryId}", categoryId)
				.retrieve()
				.bodyToMono(CategoryResponse.class)
				.block();
	}

	public UserResponse getUserById(Long userId) {
		return webClient
				.get()
				.uri("/users/{userId}", userId)
				.retrieve()
				.bodyToMono(UserResponse.class)
				.block();
	}

	public List<Long> getFollowersByUserId(Long userId) {
		return webClient
				.get()
				.uri("/followers?followingId=" + userId + "/followers")
				.retrieve()
				.bodyToFlux(Long.class)
				.collectList()
				.block();
	}

	@Data
	public static class CategoryResponse {
		private Long id;
		private String name;
	}

	@Data
	@NoArgsConstructor
	public static class UserResponse {
		private Long id;
		private String email;
		private String name;
	}

}
