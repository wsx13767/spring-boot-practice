package com.siang.springboot.practice.springbootpractice.service.impl;

import com.siang.springboot.practice.springbootpractice.service.PrinterService;
import org.springframework.stereotype.Service;

@Service("SharpPrinter")
public class SharpPrinterService implements PrinterService {
    @Override
    public String showInfo() {
        return "this is Sharp Printer";
    }
}
