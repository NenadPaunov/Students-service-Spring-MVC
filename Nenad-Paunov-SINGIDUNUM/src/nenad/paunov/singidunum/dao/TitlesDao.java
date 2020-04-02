package nenad.paunov.singidunum.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nenad.paunov.singidunum.entities.Title;

@Transactional
@Component
public class TitlesDao {
	@Autowired
	SessionFactory session;

	@SuppressWarnings("unchecked")
	public List<Title> getAllTitles() {
		return session.getCurrentSession().createQuery("FROM Title").list();
	}

	public Title getTitle(int id) {
		return session.getCurrentSession().get(Title.class, id);
	}

	public Title saveOrUpdateTitle(Title title) {
		session.getCurrentSession().saveOrUpdate(title);
		return title;
	}

	public boolean deleteTitle(int id) {
		try {
			session.getCurrentSession().delete(session.getCurrentSession().get(Title.class, id));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
}