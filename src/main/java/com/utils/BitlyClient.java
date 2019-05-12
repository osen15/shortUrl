package com.utils;

import com.constants.BitlyConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Objects;

import static com.constants.BitlyConstants.ACCESS_TOKEN;
import static com.constants.BitlyConstants.API_KEY;
import static com.constants.BitlyConstants.LOGIN;

@Component
public class BitlyClient {

    private RestTemplate restTemplate;
    private Map expand;
    private String EXPAND =
            "https://api-ssl.bitly.com/v4/expand" + "?access_token=" + ACCESS_TOKEN + "&login=" + LOGIN + "&apiKey=" + API_KEY;


    public BitlyClient() {
        restTemplate = new RestTemplate();
    }

    public Map getExpand() {
        try {
            expand = (Map) Objects
                    .requireNonNull(restTemplate.getForObject(new URI("https://api-ssl.bitly.com/v4/expand"
                            + "?access_token=" + ACCESS_TOKEN + "&login=" + LOGIN + "&apiKey=" + API_KEY), Map.class)
                    ).get("expand");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println(expand);
        return expand;
    }
}
