package com.raman.springboot.rdspetclinic.controllers;

import com.raman.springboot.rdspetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    /** R--> Don't specify '/' here, it will not work */
    @RequestMapping({"", "/index", "/index.html"})
    public String getOwnerList(Model model) {
        model.addAttribute("ownersList", ownerService.findAll());
        return "owners/index";
    }

    /** return a blank page */
    @RequestMapping("/find")
    public String findOwners() {
        return "notimplemented";
    }
}
