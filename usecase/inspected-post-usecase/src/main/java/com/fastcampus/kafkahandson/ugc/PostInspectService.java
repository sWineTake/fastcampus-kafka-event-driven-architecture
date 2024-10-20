package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.inspectedpost.AutoInspectionResult;
import com.fastcampus.kafkahandson.ugc.inspectedpost.InspectedPost;
import com.fastcampus.kafkahandson.ugc.port.MetadataPort;
import com.fastcampus.kafkahandson.ugc.port.PostAutoInspectPort;
import com.fastcampus.kafkahandson.ugc.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostInspectService implements PostInspectUsecase {

	// 카테고리 이름 조회 API
	private final MetadataPort metadataPort;

	// GPT 모델 호출 API
	private final PostAutoInspectPort postAutoInspectPort;

	@Override
	public InspectedPost inspectAndGetIfValid(Post post) {

		String categoryName = metadataPort.getCategoryNameByCategoryId(post.getCategoryId());
		AutoInspectionResult inspect = postAutoInspectPort.inspect(post, categoryName);

		// 검수 완료 케이스일때만 InspectedPost 객체를 생성하여 반환
		return  "GOOD".equals(inspect.getStatus())
			? InspectedPost.create(post, categoryName, List.of(inspect.getTags()))
			: null
		;
	}

}
