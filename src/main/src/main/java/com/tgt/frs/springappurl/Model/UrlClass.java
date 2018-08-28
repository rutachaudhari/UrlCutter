package com.tgt.frs.springappurl.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UrlClass {

    String longUrl;
    @Id
    String shortUrl;

    public UrlClass() {
    }

    public UrlClass(String longUrl, String shortUrl) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
