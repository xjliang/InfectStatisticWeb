package edu.fzu.infect.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpUtils {

    public static final String HTTP_URL = "https://ncportal.esrichina.com.cn/JKZX/yq_";
    public static final String HTTP_SUFFIX = ".json";

    public static String httpData(String httpUrl) {
        BufferedReader reader;
        String result = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String strRead;
            while ((strRead = reader.readLine()) != null) {
                stringBuilder.append(strRead);
                stringBuilder.append("\r\n");
            }
            reader.close();
            result = stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //例子
    public static String httpToStr(String httpArg) { //20200117
        String url = HTTP_URL + httpArg + HTTP_SUFFIX;
        return HttpUtils.httpData(url);
    }

    public static void main(String[] args) {
        System.out.println("start");
        String str = HttpUtils.httpToStr("20200117");
        System.out.println(str);
        System.out.println("end");
    }
}
