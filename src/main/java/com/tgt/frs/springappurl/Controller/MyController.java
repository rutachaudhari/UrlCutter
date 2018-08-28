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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


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

    @PostMapping(path = "/cuturl")
    public ModelAndView cutUrl(@RequestBody String longurl) {
        String shorturl = appService.cutUrl(longurl);
        // return "result";
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("surl",  shorturl);
        return modelAndView;

        //return new ResponseEntity<> (shortUrl,HttpStatus.OK);
    }


    @RequestMapping(value = "{shorturl}", method = RequestMethod.GET)
    public RedirectView getUrl(@PathVariable("shorturl") String shortUrl) {

            UrlClass urlClass = appService.getUrlbySurl(shortUrl);
            String str = urlClass.getLongUrl();
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl(str);
            return redirectView;
            //return new ResponseEntity<>(urlClass, HttpStatus.OK);

    }

}
