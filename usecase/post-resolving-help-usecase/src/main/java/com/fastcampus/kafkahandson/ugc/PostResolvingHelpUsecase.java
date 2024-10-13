package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.post.model.ResolvedPost;

import java.util.List;

public interface PostResolvingHelpUsecase {

	ResolvedPost resolvePost(Long postId);

	List<ResolvedPost> resolvePosts(List<Long> postIds);

}
