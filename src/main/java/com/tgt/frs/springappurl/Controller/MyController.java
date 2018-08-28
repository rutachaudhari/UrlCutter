package com.tgt.frs.springappurl.Controller;

import com.tgt.frs.springappurl.Model.UrlClass;
import com.tgt.frs.springappurl.Repository.UrlRepository;
import com.tgt.frs.springappurl.Service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
@Slf4j
public class MyController {

    @Autowired
    AppService appService;

    @Autowired
    UrlRepository urlRepository;


    @GetMapping("/")
    public String getForm(Model model) {
       // model.addAttribute("urlClass", new UrlClass());
        return "login";
    }
//
//    @PostMapping("/urlClass1")
//    public String gettingSubmit(@ModelAttribute UrlClass urlClass) {
//        return "result";
//    }

   // @PostMapping(path= "/cuturl", consumes = "text/plain")
   @PostMapping(path= "/cuturl")
    public String cutUrl(@RequestBody String longurl){
        String shortUrl = appService.cutUrl(longurl);
        return "result";
        //System.out.println("request submitted");
        //return new ResponseEntity<> (shortUrl,HttpStatus.OK);
    }

    @RequestMapping(value= "{shorturl}",method = RequestMethod.GET)
    public ResponseEntity<UrlClass> getUrl(@PathVariable("shorturl") String shortUrl){
        try{
            UrlClass urlClass = appService.getUrlbySurl(shortUrl);
            //return
            return new ResponseEntity<> (urlClass,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity (HttpStatus.NOT_FOUND);
        }

    }

}
