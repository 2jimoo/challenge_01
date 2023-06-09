package com.example.challenge_01.webapp.adapter.out.web.seoulopenapi.repository.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WifiResponse {
    @JsonProperty("TbPublicWifiInfo")
    private WifiInfoResponseContent content;
}
