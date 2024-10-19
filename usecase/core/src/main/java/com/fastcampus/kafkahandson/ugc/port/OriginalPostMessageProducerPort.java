package com.fastcampus.kafkahandson.ugc.port;

import com.fastcampus.kafkahandson.ugc.post.model.Post;

public interface OriginalPostMessageProducerPort {

	void sendCreateMessage(Post post);
	void sendUpdateMessage(Post post);
	void sendDeleteMessage(Post post);

}
