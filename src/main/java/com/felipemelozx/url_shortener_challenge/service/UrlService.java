package com.felipemelozx.url_shortener_challenge.service;

import com.felipemelozx.url_shortener_challenge.dto.UrlDto;
import com.felipemelozx.url_shortener_challenge.entity.Url;
import com.felipemelozx.url_shortener_challenge.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Service
public class UrlService {

  private final UrlRepository urlRepository;

  public UrlService(UrlRepository urlRepository) {
    this.urlRepository = urlRepository;
  }

  public UrlDto shortenUrl(UrlDto urlDto) {
    Url url = new Url(urlDto.url());
    url.setUrlKey(generateUrlKey());
    Timestamp validFuture = Timestamp.valueOf(LocalDateTime.now().plusDays(3));
    var urlSave = urlRepository.save(url);
    return new UrlDto("http://localhost:8080/" + urlSave.getUrlKey());
  }
  
  
  private String generateUrlKey(){
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    StringBuilder urlKey = new StringBuilder();
    int numberChart =  (int) (Math.random() * (10 - 5 + 1)) + 5;
    for (int i = 0; i < numberChart; i++){
      int randomNumber = (int) (Math.random() * 62);

      char character = characters.charAt(randomNumber);
      urlKey.append(character);
    }
    return urlKey.toString();
  }

  public String findUrl(String key) {
    Url url =  urlRepository.findByUrlKey(key)
        .orElseThrow(() -> new RuntimeException("Url not found or don't valid"));
    if(url.getValid().before(Timestamp.valueOf(LocalDateTime.now()))){
      return url.getOrigenUrl();
    }
    return null;
  }
}

