package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.port.MetadataPort;
import com.fastcampus.kafkahandson.ugc.port.PostPort;
import com.fastcampus.kafkahandson.ugc.port.ResolvedPostCachePort;
import com.fastcampus.kafkahandson.ugc.post.model.Post;
import com.fastcampus.kafkahandson.ugc.post.model.ResolvedPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostResolvingHelpUsecaseImpl implements PostResolvingHelpUsecase {

	private final PostPort postPort;
	private final MetadataPort metadataPort;
	// private final ResolvedPostCachePort resolvedPostCachePort;

	@Override
	public ResolvedPost resolvePost(Long postId) {
		ResolvedPost resolvedPost = null;

		Post post = postPort.findById(postId);
		if (post != null) {
			// 외부 서버에 API를 호출하여 각각 응답값을 받아옴
			String userName = metadataPort.getUserNameByUserId(post.getUserId());
			String categoryName = metadataPort.getCategoryNameByCategoryId(post.getCategoryId());

			if (userName != null && categoryName != null) {
				resolvedPost = ResolvedPost.create(
					post,
					userName,
					categoryName
				);
			}
		}

		return resolvedPost;
	}

	@Override
	public List<ResolvedPost> resolvePosts(List<Long> postIds) {

	}
}
