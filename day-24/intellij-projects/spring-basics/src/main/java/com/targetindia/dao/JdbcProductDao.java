package com.targetindia.dao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JdbcProductDao implements ProductDao{

    public JdbcProductDao() {
        log.trace("JdbcProductDao instantiated");
    }

    @Override
    public long count() {
        log.trace("JdbcProductDao.count() called");
        return 1000;
    }
}
