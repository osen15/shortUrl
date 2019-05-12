package com.service;


import com.constants.BitlyConstants;
import com.model.User;
import com.rosaloves.bitlyj.Bitly;
import com.rosaloves.bitlyj.Url;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class BitlyService {
    private Map<String, String> someDB = new HashMap<>();  //< key:String 7 symbols, value:String 6 symbols>
    private final User user;

    @Autowired
    public BitlyService(User user) {
        this.user = user;
    }

    public String shortUrl(String longUrl) {
        String shortUrl6Symb;

        Url url = Bitly.as(BitlyConstants.LOGIN,
                BitlyConstants.API_KEY).call(Bitly.shorten(longUrl));

        shortUrl6Symb = "bit.ly/" + randomString();

        if (someDB != null) {
            for (Map.Entry<String, String> entry : someDB.entrySet()) {
                if (entry.getKey().equals(url.getShortUrl()))
                    return entry.getValue();
            }
            someDB.put(url.getShortUrl(), shortUrl6Symb);
        }
        System.out.println(someDB);
        return shortUrl6Symb;

    }

    public String redirect(String bitliUrl) {
        if (someDB != null) {
            for (Map.Entry<String, String> entry : someDB.entrySet()) {
                if (entry.getValue().equals(bitliUrl))
                    return entry.getKey();
            }
        }
        return null;

    }

    private String randomString() {
        int length = 6;
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}