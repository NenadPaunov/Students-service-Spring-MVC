package nenad.paunov.singidunum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nenad.paunov.singidunum.dao.CountriesDao;
import nenad.paunov.singidunum.entities.Country;
import nenad.paunov.singidunum.entities.Student;
@Service
public class CountriesService {
	@Autowired
	CountriesDao countriesDao;
	
	public List<Country> getAllCountries() {
		return countriesDao.getAllCountries();
	}
	
	public Country getCountry(int id) {
		return countriesDao.getCountry(id);
	}
	
	public Country saveOrUpdateCountry(Country country) {
		return countriesDao.saveOrUpdateCountry(country);
	}
	
	public void deleteCountry(int id) {
		 countriesDao.deleteCountry(id);
	}
	
	public  List<Country> getPaginated(int page, int number){
		return countriesDao.getPaginated(page, number);
	}
}
