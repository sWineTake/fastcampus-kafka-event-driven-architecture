package com.fastcampus.kafkahandson.ugc.controller;

import com.fastcampus.kafkahandson.ugc.model.PostListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/list")
public class PostListController {

	@GetMapping("/{userId}")
	public ResponseEntity<List<PostListDto>> getList(
		@PathVariable Long userId
	) {
		return ResponseEntity.internalServerError().build();
	}

	@GetMapping("/search")
	public ResponseEntity<List<PostListDto>> getSearchList(
		@RequestParam("query") String query
	) {
		return ResponseEntity.internalServerError().build();
	}


}
