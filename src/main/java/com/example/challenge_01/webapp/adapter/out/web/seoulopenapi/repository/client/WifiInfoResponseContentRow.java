package com.example.challenge_01.webapp.adapter.out.web.seoulopenapi.repository.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WifiInfoResponseContentRow(

        //관리번호
        @JsonProperty("X_SWIFI_MGR_NO")
        String X_SWIFI_MGR_NO,
        //자치구
        @JsonProperty("X_SWIFI_WRDOFC")
        String X_SWIFI_WRDOFC,
        //와이파이명
        @JsonProperty("X_SWIFI_MAIN_NM")
        String X_SWIFI_MAIN_NM,
        //도로명주소
        @JsonProperty("X_SWIFI_ADRES1")
        String X_SWIFI_ADRES1,
        //상세주소
        @JsonProperty("X_SWIFI_ADRES2")
        String X_SWIFI_ADRES2,
        //설치위치(층)
        @JsonProperty("X_SWIFI_INSTL_FLOOR")
        String X_SWIFI_INSTL_FLOOR,
        //설치유형
        @JsonProperty("X_SWIFI_INSTL_TY")
        String X_SWIFI_INSTL_TY,
        //설치기관
        @JsonProperty("X_SWIFI_INSTL_MBY")
        String X_SWIFI_INSTL_MBY,
        //서비스구분
        @JsonProperty("X_SWIFI_SVC_SE")
        String X_SWIFI_SVC_SE,
        //망종류
        @JsonProperty("X_SWIFI_CMCWR")
        String X_SWIFI_CMCWR,
        // 설치년도
        @JsonProperty("X_SWIFI_CNSTC_YEAR")
        Integer X_SWIFI_CNSTC_YEAR,
        //실내외구분
        @JsonProperty("X_SWIFI_INOUT_DOOR")
        String X_SWIFI_INOUT_DOOR,
        //wifi접속환경
        @JsonProperty("X_SWIFI_REMARS3")
        String X_SWIFI_REMARS3,
        //Y좌표
        @JsonProperty("LAT")
        Double LAT,
        //X좌표
        @JsonProperty("LNT")
        Double LNT,
        //작업일자
        @JsonProperty("WORK_DTTM")
        String WORK_DTTM) {
}