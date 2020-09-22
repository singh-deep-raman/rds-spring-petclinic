package com.raman.springboot.rdspetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /** It means in case of root, /, /index or /index.html call this requet mapping method */
    @RequestMapping({"","/","index","index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping("/oups")
    public String error() {
        return "notimplemented";
    }
}
