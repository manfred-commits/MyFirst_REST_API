package com.manfredipiraino.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("myapplication")
public class ApplicationConfig extends Application {
	// getClasses(): aggiunge le classi resource all'applicazione
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(MyResource.class);
        return set;
    }
}
