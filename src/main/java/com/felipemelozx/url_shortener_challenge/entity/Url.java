package com.felipemelozx.url_shortener_challenge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;


@Entity
@Table(name = "url-short")
public class Url {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String origenUrl;
  @Column(unique = true)
  private String urlKey;
  private Date valid;

  public Url() {
  }

  public Url(Long id, String origenUrl, String shortUrl, Date isValid) {
    this.id = id;
    this.origenUrl = origenUrl;
    this.urlKey = shortUrl;
    this.valid = isValid;
  }

  public Url(String url) {
    this.origenUrl = url;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOrigenUrl() {
    return origenUrl;
  }

  public void setOrigenUrl(String origenUrl) {
    this.origenUrl = origenUrl;
  }

  public String getUrlKey() {
    return urlKey;
  }

  public void setUrlKey(String urlKey) {
    this.urlKey = urlKey;
  }

  public Date getValid() {
    return valid;
  }

  public void setValid(Date valid) {
    this.valid = valid;
  }
}
