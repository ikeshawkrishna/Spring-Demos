package com.org.CommercialService.Common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Component
public class Util {

    @Autowired
    RestTemplate restTemplate;

    public URI setInputParam(String uri, Map<String, String> params){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri);

        for(Map.Entry<String, String> entry : params.entrySet()){
            builder.queryParam(entry.getKey(), entry.getValue());
        }
        return  builder.build().encode().toUri();
    }
}
