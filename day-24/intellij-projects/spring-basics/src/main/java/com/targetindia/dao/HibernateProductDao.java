package com.targetindia.dao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HibernateProductDao implements ProductDao{
    public HibernateProductDao() {
        log.trace("HibernateProductDao instantiated");

    }

    @Override
    public long count() {
        log.trace("HibernateProductDao.count() called");
        return 2000;
    }
}
