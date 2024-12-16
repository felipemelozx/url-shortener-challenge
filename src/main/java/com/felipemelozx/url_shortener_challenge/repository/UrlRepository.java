package com.felipemelozx.url_shortener_challenge.repository;


import com.felipemelozx.url_shortener_challenge.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByUrlKey(String shortUrl);
}
