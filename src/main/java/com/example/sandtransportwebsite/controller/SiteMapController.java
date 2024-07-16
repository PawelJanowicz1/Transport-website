package com.example.sandtransportwebsite.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping
public class SiteMapController {

    @GetMapping(value = "/sitemap.xml", produces = "application/xml")
    public ResponseEntity<String> getSitemap() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/sitemap.xml");
        String sitemapContent = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/xml; charset=utf-8");

        return new ResponseEntity<>(sitemapContent, headers, HttpStatus.OK);
    }
}
