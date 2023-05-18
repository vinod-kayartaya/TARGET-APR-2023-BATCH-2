package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SqlInjectionSimulation {
    public static void main(String[] args) {
        String username = KeyboardUtil.getString("Enter username: "); // try with ' or 1=1 limit 1 --
        String password = KeyboardUtil.getString("Enter password: "); // try anything or nothing

        String sqlCmd = String.format("select * from users where email='%s' and password='%s'", username, password);
        log.trace("sqlCmd: {}", sqlCmd);
        // select * from users where email='' or 1=1 limit 1--' and password='hahaha'
    }
}
