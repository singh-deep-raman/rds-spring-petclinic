package com.raman.springboot.rdspetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    /** R--> Don't specify '/' here, it will not work */
    @RequestMapping({"", "/index", "/index.html"})
    public String getOwnerList() {
        return "owners/index";
    }
}
