package com.tgt.frs.springappurl.Service;

import com.tgt.frs.springappurl.Model.UrlClass;
import com.tgt.frs.springappurl.Repository.UrlRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppService {

    @Autowired
    UrlRepository urlRepository;

    UrlClass urlClass = new UrlClass();


    public String cutUrl(String longurl) {
        String shorturl = longurl.substring(26,29);
        urlClass.setLongUrl(longurl);
        urlClass.setShortUrl(shorturl);
        urlRepository.save(urlClass);
        return longurl.substring(26,29);

    }

    public UrlClass getUrlbySurl(String shortUrl){
        return urlRepository.findById(shortUrl).get();
        //urlRepository.save(urlClass);

    }

}
