package com.controller;

import com.service.BitlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class BitlyController {

    private final
    BitlyService bitlyService;

    @Autowired
    public BitlyController(BitlyService bitlyService) {
        this.bitlyService = bitlyService;
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public RedirectView localRedirect(@RequestParam("bitlyUrl") String bitlyUrl) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(bitlyService.redirect(bitlyUrl));
        return redirectView;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/longUrl")
    @ResponseBody
    ResponseEntity<String> getShortUrl(@RequestParam("longUrl") String longUrl) {
        String result = bitlyService.shortUrl(longUrl);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
