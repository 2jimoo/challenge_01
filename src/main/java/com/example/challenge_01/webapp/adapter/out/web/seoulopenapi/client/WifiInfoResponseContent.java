package com.example.challenge_01.webapp.adapter.out.web.seoulopenapi.client;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record WifiInfoResponseContent(
        //총 데이터 건수 (정상조회 시 출력됨)
        @JsonProperty("list_total_count")
        Integer totalCount,
        //요청결과 코드, 요청결과 메시지 (하단 메세지설명 참고)
        @JsonProperty("RESULT")
        Result result,
        @JsonProperty("row")
        List<WifiInfoResponseContentRow> rows) {
    public record Result(
            @JsonProperty("CODE")
            String code,
            @JsonProperty("MESSAGE")
            String message) {
    }
}
