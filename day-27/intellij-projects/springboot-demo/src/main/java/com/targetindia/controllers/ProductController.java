package com.targetindia.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @RequestMapping(path = "/info", produces = "text/plain")
    public String info() {
        return "Name: Product Service\n" +
                "Version: 1.0.0\n" +
                "Author: Vinod Kumar <vinod@vinod.co>";
    }

    @RequestMapping(path = "/info", produces = "application/json")
    public Map<String, Object> infoAsJson() {
        Map<String, Object> info = new HashMap<>();
        info.put("author", "Vinod Kumar");
        info.put("email", "vinod@vinod.co");
        info.put("phone", "9731424784");
        info.put("version", "1.0.0");
        info.put("name", "Product Service");
        return info;
    }
}
