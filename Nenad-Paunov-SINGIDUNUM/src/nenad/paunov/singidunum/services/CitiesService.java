package nenad.paunov.singidunum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nenad.paunov.singidunum.dao.CitiesDao;
import nenad.paunov.singidunum.entities.City;

@Service
public class CitiesService {
	@Autowired
	CitiesDao citiesDao;
	
	public List<City> getAllCities() {
		return citiesDao.getAllCities();
	}
	
	public City getCity(int id) {
		return citiesDao.getCity(id);
	}

	public City saveOrUpdateCity(City city) {
		return citiesDao.saveOrUpdateCity(city);
	}
	
	public boolean deleteCity(int id) {
		return citiesDao.deleteCity(id);
	}
}
