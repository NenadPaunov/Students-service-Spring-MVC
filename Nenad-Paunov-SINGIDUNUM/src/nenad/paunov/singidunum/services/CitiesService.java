package nenad.paunov.singidunum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nenad.paunov.singidunum.dao.CitiesDao;
import nenad.paunov.singidunum.entities.City;
import nenad.paunov.singidunum.entities.Student;

@Service
@Transactional
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

	public void deleteCity(int id) {
		 citiesDao.deleteCity(id);
	}
	
	public  List<City> getPaginated(int page, int number){
		return citiesDao.getPaginated(page, number);
	}

}
