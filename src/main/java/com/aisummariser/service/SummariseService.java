
package com.aisummariser.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.aisummariser.dto.SummariseResponse;

@Service
public class SummariseService {

    @Value("${gemini.api.url}")
    private String apiUrl;

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public SummariseResponse summariseText(String text) {
        if (text == null || text.trim().isEmpty()) {
            return new SummariseResponse("Input text cannot be empty.", 0);
        }

        // Construct Gemini prompt and payload JSON structure
        String prompt = "Summarize the following text concisely in 1-2 key points:\n\n" + text;

        Map<String, Object> part = Map.of("text", prompt);
        Map<String, Object> content = Map.of("parts", List.of(part));
        Map<String, Object> requestBody = Map.of("contents", List.of(content));

        // Prepare Headers & Request Entity
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        // Build endpoint with API Key parameter
        String fullUrl = apiUrl + "?key=" + apiKey;

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(fullUrl, entity, Map.class);
            String summary = extractTextFromGeminiResponse(response.getBody());

            int wordCount = text.trim().split("\\s+").length;
            int estimatedReadTime = Math.max(1, wordCount / 200);

            return new SummariseResponse(summary, estimatedReadTime);

        } catch (HttpStatusCodeException e) {
            return new SummariseResponse("Gemini API Error (" + e.getStatusCode() + "): " + e.getResponseBodyAsString(), 0);
        } catch (Exception e) {
            return new SummariseResponse("Unexpected Error: " + e.getMessage(), 0);
        }
    }
    @SuppressWarnings("unchecked")
    private String extractTextFromGeminiResponse(Map responseBody) {
        try {
            List candidates = (List) responseBody.get("candidates");
            Map firstCandidate = (Map) candidates.get(0);
            Map content = (Map) firstCandidate.get("content");
            List parts = (List) content.get("parts");
            Map firstPart = (Map) parts.get(0);
            return (String) firstPart.get("text");
        } catch (Exception e) {
            return "Failed to parse response from Gemini API.";
        }
    } 

}