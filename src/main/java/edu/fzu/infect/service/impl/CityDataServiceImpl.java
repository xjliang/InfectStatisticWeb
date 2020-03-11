package edu.fzu.infect.service.impl;

import edu.fzu.infect.service.CityDataService;
import edu.fzu.infect.utils.XmlBuilder;
import edu.fzu.infect.vo.City;
import edu.fzu.infect.vo.CityList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() {
        // 读取XML文件
        Resource resource = new ClassPathResource("./xmls/province.xml");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(resource.getInputStream(),
                StandardCharsets.UTF_8));

            StringBuilder buffer = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
            br.close();

            // XML转为Java对象
            CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());
            return cityList.getCityList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
