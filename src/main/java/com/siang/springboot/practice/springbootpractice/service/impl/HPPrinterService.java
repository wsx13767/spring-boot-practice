package com.siang.springboot.practice.springbootpractice.service.impl;

import com.siang.springboot.practice.springbootpractice.service.PrinterService;
import org.springframework.stereotype.Service;

@Service("HPPrinter")
public class HPPrinterService implements PrinterService {
    @Override
    public String showInfo() {
        return "This is HP Printer";
    }
}
