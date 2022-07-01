package com.bdia.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
    private static Properties props = new Properties();

    public Properties getProps() throws IOException {
        InputStream istream = null;
        String propertyFile = "config.properties" ;
        if(props.isEmpty()){
            try{
                istream = getClass().getClassLoader().getResourceAsStream(propertyFile);
                props.load(istream);
            }catch (Exception e){
                throw new IllegalStateException("Properties not loaded  ==> ABORT !!!!");
            }finally {
                if(istream != null){
                    istream.close();
                }
            }
        }

        return props ;
    }
}
