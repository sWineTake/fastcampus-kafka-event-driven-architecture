package com.fastcampus.kafkahandson.ugc.meta;

import com.fastcampus.kafkahandson.ugc.port.MetadataPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MetaDataAdapter implements MetadataPort {

	private final MetadataClient metadataClient;

	@Override
	public String getCategoryNameByCategoryId(Long categoryId) {
		MetadataClient.CategoryResponse response = metadataClient.getCategoryById(categoryId);
		return response == null ? "" : response.getName();
	}

	@Override
	public String getUserNameByUserId(Long userId) {
		MetadataClient.UserResponse response = metadataClient.getUserById(userId);
		return response == null ? "" : response.getName();
	}

	@Override
	public List<Long> listFollowerIdsByUserId(Long userId) {
		return metadataClient.getFollowersByUserId(userId);
	}
}
