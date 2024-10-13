package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.post.model.ResolvedPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostResolvingHelpUsecaseImpl implements PostResolvingHelpUsecase {

	// private final PostPort postPort;
	private final MetadataPort metadataPort;

	@Override
	public ResolvedPost resolvePost(Long postId) {
		ResolvedPost resolvedPost = null;
		return resolvedPost;
	}

	@Override
	public List<ResolvedPost> resolvePosts(List<Long> postIds) {
		return List.of();
	}
}
