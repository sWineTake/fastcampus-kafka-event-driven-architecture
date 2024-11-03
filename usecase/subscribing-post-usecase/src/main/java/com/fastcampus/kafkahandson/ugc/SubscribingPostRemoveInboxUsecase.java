package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.post.model.Post;

public interface SubscribingPostRemoveInboxUsecase {

	void deleteSubscribingInboxPost(Long postId);

}
