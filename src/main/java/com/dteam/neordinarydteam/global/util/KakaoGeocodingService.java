package com.dteam.neordinarydteam.global.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoGeocodingService {

    @Value("${kakao.rest-api-key}")
    private String restApiKey;

    private final ObjectMapper objectMapper;

    public KakaoAddressResult getAddressInfo(String roadAddress) {
        URI uri = UriComponentsBuilder.fromHttpUrl("https://dapi.kakao.com/v2/local/search/address.json")
                .queryParam("query", roadAddress)
                .build()
                .encode()
                .toUri();

        log.info("카카오 API 요청 URI: {}", uri);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + restApiKey);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

            String body = response.getBody();
            log.info("카카오 API 응답: {}", body);

            JsonNode root = objectMapper.readTree(body);
            JsonNode documents = root.path("documents");
            if (documents.isMissingNode() || !documents.isArray() || documents.size() == 0) {
                throw new RuntimeException("주소에 대한 좌표를 찾을 수 없습니다: " + roadAddress);
            }
            JsonNode first = documents.get(0);

            String sido;
            String sigungu;
            String fullRoadAddress;

            JsonNode roadAddr = first.path("road_address");
            if (!roadAddr.isMissingNode() && !roadAddr.isNull()) {
                sido = roadAddr.path("region_1depth_name").asText();
                sigungu = roadAddr.path("region_2depth_name").asText();
                fullRoadAddress = roadAddr.path("address_name").asText();
            } else {
                JsonNode addr = first.path("address");
                sido = addr.path("region_1depth_name").asText();
                sigungu = addr.path("region_2depth_name").asText();
                fullRoadAddress = first.path("address_name").asText();
            }

            String latitude = first.path("y").asText();
            String longitude = first.path("x").asText();

            return new KakaoAddressResult(sido, sigungu, fullRoadAddress, latitude, longitude);
        } catch (Exception e) {
            log.error("카카오 Geocoding API 실패 - 주소: {}, 에러: {}", roadAddress, e.getMessage(), e);
            throw new RuntimeException("주소에 대한 좌표를 찾을 수 없습니다: " + roadAddress, e);
        }
    }

    public record KakaoAddressResult(
            String sido, String sigungu, String roadAddress, String latitude, String longitude) {}
}
