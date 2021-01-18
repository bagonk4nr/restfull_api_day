package com.api.libs;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*; 

public class logApps  {

    private Logger log;
    private Handler handlerObj;

    public logApps(){
        super();
        log = null;
        handlerObj = new ConsoleHandler();
    }

    public void showLog(Class className, String params) throws FileNotFoundException {
        log = Logger.getLogger(className.getName());
        handlerObj.setLevel(Level.ALL);
        log.addHandler(handlerObj);
        log.setLevel(Level.ALL);
        log.setUseParentHandlers(false);
        log.info(params);
        PrintStream o = new PrintStream(new File("A.txt")); 
        System.setOut(o); 
        System.out.println(params);
    }
}
