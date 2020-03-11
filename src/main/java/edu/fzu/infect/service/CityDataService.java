package edu.fzu.infect.service;

import edu.fzu.infect.vo.City;
import java.util.List;

/**
 * @author xjliang
 */
public interface CityDataService {

	List<City> listCity() throws Exception;
}
