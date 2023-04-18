package com.targetindia.programs;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractClassDemo {

    // static Logger log = LoggerFactory.getLogger(AbstractClassDemo.class);

    public static void main(String[] args) {
        // System.out.println("Abstract class demo");
        // log levels -> trace, debug, info, warning, error
        log.trace("This is a trace message");
        log.debug("This is a debug message");
        log.info("This is a info message");
        log.warn("This is a warn message");
        log.error("This is a error message");
    }

}
