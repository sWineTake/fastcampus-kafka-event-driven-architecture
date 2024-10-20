package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.inspectedpost.InspectedPost;
import com.fastcampus.kafkahandson.ugc.post.model.Post;

public interface PostInspectUsecase {

	InspectedPost inspectAndGetIfValid(Post post); // Good이면 받고 BAD이면 null
	
}
