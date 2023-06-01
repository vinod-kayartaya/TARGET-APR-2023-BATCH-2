package com.targetindia.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
public class MybatisProductDao implements ProductDao{
    public MybatisProductDao() {
        log.trace("MybatisProductDao instantiated");
    }

    @Override
    public long count() {
        log.trace("MybatisProductDao.count() called");
        return 3000;
    }
}
