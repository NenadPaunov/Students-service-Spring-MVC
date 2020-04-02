package nenad.paunov.singidunum.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nenad.paunov.singidunum.entities.Country;

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

	public boolean deleteCountry(int id) {
		try {
			session.getCurrentSession().delete(session.getCurrentSession().get(Country.class, id));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
}
