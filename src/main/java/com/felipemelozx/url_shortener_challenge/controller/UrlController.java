package com.felipemelozx.url_shortener_challenge.controller;

import com.felipemelozx.url_shortener_challenge.dto.UrlDto;
import com.felipemelozx.url_shortener_challenge.service.UrlService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {

  private final UrlService urlService;

  public UrlController(UrlService urlService) {
    this.urlService = urlService;
  }

  @PostMapping(path = "/shorten-url")
  public UrlDto urlShorten(@RequestBody UrlDto urlDto){
    return urlService.shortenUrl(urlDto);
  }
  @GetMapping("/{key}")
  public ResponseEntity<Void> redirectToOriginal(@PathVariable String key) {
    String originalUrl = urlService.findUrl(key);

    if (originalUrl != null) {
      return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
          .header(HttpHeaders.LOCATION, originalUrl)
          .build();
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
