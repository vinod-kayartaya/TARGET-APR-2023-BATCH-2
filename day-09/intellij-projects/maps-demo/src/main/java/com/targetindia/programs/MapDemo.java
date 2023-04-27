package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.Map.Entry;

@Slf4j
public class MapDemo {
    public static void main(String[] args) {

        // collection of emails accessible using names
        Map<String, String> data = new TreeMap<>();

        data.put("Vinod", "vinod@vinod.co");
        data.put("Anil", "anil@xmpl.com");
        data.put("Vinod", "vinod@knowledgeworksindia.com");
        data.put("Shyam", "shyam@xmpl.com");
        data.put("Arun", "arun@xmpl.com");
        data.put("Ravi", "ravi@xmpl.com");
        data.put("Jacob", null);

        log.trace("data.size() is {}", data.size());
        log.trace("data.containsKey(\"Vinod\") is {}", data.containsKey("Vinod"));
        log.trace("data.containsKey(\"vinod\") is {}", data.containsKey("vinod"));
        log.trace("data contains {}", data);
        log.trace("data.get(\"Shyam\") is {}", data.get("Shyam"));
        log.trace("data.get(\"Robert\") is {}", data.get("Robert"));
        log.trace("data.get(\"Jacob\") is {}", data.get("Jacob"));

        log.trace("The keys in data are: ");
        for (String key : data.keySet()) {
            log.trace("key = {} and value = {}", key, data.get(key));
        }

        log.trace("The values in data are: ");
        for (String value : data.values()) {
            log.trace("value = {}", value);
        }

        log.trace("The key/value pair are: ");
        for (Entry<String, String> entry : data.entrySet()) {
            log.trace("key = {} and value = {}", entry.getKey(), entry.getValue());
        }

    }
}
