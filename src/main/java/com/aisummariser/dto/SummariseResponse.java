package com.aisummariser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummariseResponse {
	
	private String summary;
	private int estimatedReadTimeMinutes;
	
}
