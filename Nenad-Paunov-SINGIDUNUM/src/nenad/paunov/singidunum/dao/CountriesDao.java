package nenad.paunov.singidunum.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nenad.paunov.singidunum.entities.City;
import nenad.paunov.singidunum.entities.Country;
import nenad.paunov.singidunum.entities.Person;
import nenad.paunov.singidunum.entities.Student;

@Component
@Transactional
public class CountriesDao {
	@Autowired
	SessionFactory session;

	@SuppressWarnings("unchecked")
	public List<Country> getAllCountries() {
		return session.getCurrentSession().createQuery("FROM Country").list();
	}

	public Country getCountry(int id) {
		return session.getCurrentSession().get(Country.class, id);
	}

	public Country saveOrUpdateCountry(Country country) {
		session.getCurrentSession().saveOrUpdate(country);
		return country;
	}

	public void deleteCountry(int id) {
		for (City city : getCountry(id).getCities()) {
			city.setCountry(null);
		}
			session.getCurrentSession().delete(session.getCurrentSession().get(Country.class, id));
	}
	 public List<Country> getPaginated(int page, int number) {
	        Query<Country> query = session.getCurrentSession().createQuery("from Country", Country.class);
	        query.setFirstResult((page - 1) * number);
	        query.setMaxResults(number);
	        return query.getResultList();
	    }
}
