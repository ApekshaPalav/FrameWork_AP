package com.learnAutomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider
{
    Properties prop;
    public ConfigDataProvider() throws IOException {
        File src=new File("./Config/config.properties");
        FileInputStream fis=new FileInputStream(src);
        prop=new Properties();
        prop.load(fis);


    }

    public String getDataFromConfig(String keyToSearch)
    {
        return prop.getProperty(keyToSearch);
    }
    public String getBrowser()
    {
       return prop.getProperty("Browser");
    }
    public String getUrl()
    {
       return prop.getProperty("QAurl");
    }
}
