package com.targetindia.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
    private HibernateUtil() {
    }

    public static Session getSession(){
        Configuration cfg = new Configuration();
        cfg.configure(); // by default this loads all the configuration from hibernate.cfg.xml
        SessionFactory factory = cfg.buildSessionFactory(); // returns an object of an interface called SessionFactory
        return factory.openSession();
    }
}
