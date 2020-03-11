package edu.fzu.infect.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 * @author xjliang
 */
public class PropertyUtils {

    public static void readPro(String fileName) {
        Properties prop = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(fileName));
            prop.load(in);
            for (String key : prop.stringPropertyNames()) {
                System.out.println(key + ":" + prop.getProperty(key));
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> readToMap(String fileName) {
        Map<String, String> map = new HashMap<>();
        Properties prop = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(fileName));
            prop.load(in);
            for (String key : prop.stringPropertyNames()) {
                map.put(key, prop.getProperty(key));
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }


    public static void savePro(String fileName, Map<String, Object> map) {
        Properties prop = new Properties();
        try {
            FileOutputStream oFile = new FileOutputStream(fileName, true);
            Set<Entry<String, Object>> entrySet = map.entrySet();
            for (Entry<String, Object> entry : entrySet) {
                prop.setProperty(entry.getKey(), (String) entry.getValue());
            }
            prop.store(oFile, "The New properties file");
            oFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readByKey(String fileName, String key) {
        Properties prop = new Properties();
        String str = "";
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(fileName));
            prop.load(in);
            str = prop.getProperty(key);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) {
        String name = "./src/main/resources/property/my.properties";
        PropertyUtils.readPro(name);
        Map<String, Object> map = new HashMap<>();
        // lastDay 2020-02-10
        map.put("key", "li");
        map.put("phone", "312235335");
        PropertyUtils.savePro(name, map);
    }

    public void backMap() {
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("name", "wang");
        hm.put("phone", "154322145XX");
        hm.put("age", 25);

        Set<Entry<String, Object>> entrySet = hm.entrySet();
        for (Entry<String, Object> entry : entrySet) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
