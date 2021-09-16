package com.siang.springboot.practice.springbootpractice.controller;

import com.siang.springboot.practice.springbootpractice.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/printer")
public class PrinterController {

    @Autowired
    @Qualifier("HPPrinter")
    private PrinterService hp;

    @Autowired
    @Qualifier("SharpPrinter")
    private PrinterService sharp;

    @GetMapping("/info/{production}")
    public String showInfo(@PathVariable("production") String production) {
        if ("hp".equalsIgnoreCase(production)) {
            return hp.showInfo();
        }

        if ("sharp".equalsIgnoreCase(production)) {
            return sharp.showInfo();
        }

        return "not find production";
    }


}
