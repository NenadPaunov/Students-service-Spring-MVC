package nenad.paunov.singidunum.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nenad.paunov.singidunum.entities.City;
import nenad.paunov.singidunum.entities.Person;
import nenad.paunov.singidunum.entities.Student;

@Component
@Transactional
public class CitiesDao {
	@Autowired
	SessionFactory session;

	@SuppressWarnings("unchecked")
	public List<City> getAllCities() {
		return session.getCurrentSession().createQuery("FROM City").list();
	}

	public City getCity(int id) {
		return session.getCurrentSession().get(City.class, id);
	}

	public City saveOrUpdateCity(City city) {
		session.getCurrentSession().saveOrUpdate(city);
		return city;
	}

	public void deleteCity(int id) {
		for (Person person : getCity(id).getPersons()) {
			person.setCity(null);
		}
		session.getCurrentSession().delete(session.getCurrentSession().get(City.class, id));

	}
	
	 public List<City> getPaginated(int page, int number) {
	        Query<City> query = session.getCurrentSession().createQuery("from City", City.class);
	        query.setFirstResult((page - 1) * number);
	        query.setMaxResults(number);
	        return query.getResultList();
	    }

}
