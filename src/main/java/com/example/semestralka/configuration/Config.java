package com.example.semestralka.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.util.Properties;

@Configuration
public class Config {

    String path = "config.properties";
    Properties prop = new Properties();
    InputStream inputStream;

    Logger log = LoggerFactory.getLogger(getClass());

    public Config(){
        loadProperty();
    }

    private void loadProperty(){
        try {
            inputStream = new FileInputStream(path);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                log.error("property file '" + path + "' not found in the classpath");
            }
        }catch (Exception ex){

        }
    }

    public boolean setProperty(String key, String value){
        try (OutputStream output = new FileOutputStream(path)) {
            // set the properties value
            prop.setProperty(key, value);
            // save properties to project root folder
            prop.store(output, null);
        } catch (IOException io) {
            return false;
        }
        return true;
    }

    public String getPropertyStr(String key){
        return prop.getProperty(key);
    }

    public boolean getPropertyBool(String key) throws Exception {
        String s = (String) prop.get(key);
        s.toLowerCase();
        if(s.equals("true")){
            return true;
        }
        else  if(s.equals("false")){
            return false;
        }
        else {
           throw new Exception("Error config client - key is not bool");
        }
    }

}
