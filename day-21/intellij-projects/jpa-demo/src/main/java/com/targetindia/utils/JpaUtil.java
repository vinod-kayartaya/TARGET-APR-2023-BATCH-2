package com.targetindia.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class JpaUtil {
    private JpaUtil() {
    }

    // represents a database
    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("h2-testdb");
        log.trace("factory is an instanceof {} class", factory.getClass().getName());
    }

    public static EntityManager createEnitytManager() {
        // EntityManager represents a connection to the database
        return factory.createEntityManager();
    }
}
