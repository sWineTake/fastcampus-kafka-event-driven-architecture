package com.fastcampus.kafkahandson.ugc.inspectedpost;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutoInspectionResult {

	private String status; // "GOOD" or "BAD"
	private String[] tags;

}
