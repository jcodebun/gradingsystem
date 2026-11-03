package in.co.grade.sys.dao;

import java.util.List;
import java.util.logging.Logger;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.grade.sys.dto.TeacherDTO;




@Repository
public class TeacherDAOImpl implements TeacherDAOInt {

	private static Logger log = Logger.getLogger(TeacherDAOImpl.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long add(TeacherDTO dto) {
		log.info("TeacherDAOImpl Add method Start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(dto);
		log.info("TeacherDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(TeacherDTO dto) {
		log.info("TeacherDAOImpl Delete method Start");
		Session session = sessionFactory.getCurrentSession();
		session.delete(dto);
		log.info("TeacherDAOImpl Delete method End");
		
	}

	@Override
	public TeacherDTO findBypk(long pk) {
		log.info("TeacherDAOImpl FindByPk method Start");
		Session session = sessionFactory.getCurrentSession();
		TeacherDTO dto = (TeacherDTO) session.get(TeacherDTO.class, pk);
		log.info("TeacherDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public TeacherDTO findByEmail(String email) {
		log.info("TeacherDAOImpl FindByLogin method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TeacherDTO.class);
		criteria.add(Restrictions.eq("emailId", email));
		TeacherDTO dto = (TeacherDTO) criteria.uniqueResult();
		log.info("TeacherDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(TeacherDTO dto) {
		log.info("TeacherDAOImpl Update method Start");
		Session session = sessionFactory.getCurrentSession();
		session.merge(dto);
		log.info("TeacherDAOImpl update method End");
	}

	@Override
	public List<TeacherDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<TeacherDTO> list(int pageNo, int pageSize) {
		log.info("TeacherDAOImpl List method Start");
		Session session = sessionFactory.getCurrentSession();
		Query<TeacherDTO> query = session.createQuery("from TeacherDTO", TeacherDTO.class);
		List<TeacherDTO> list = query.getResultList();
		log.info("TeacherDAOImpl List method End");
		return list;
	}

	@Override
	public List<TeacherDTO> search(TeacherDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<TeacherDTO> search(TeacherDTO dto, int pageNo, int pageSize) {
		log.info("TeacherDAOImpl Search method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TeacherDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
			}
			if (dto.getEmailId() != null && dto.getEmailId().length() > 0) {
				criteria.add(Restrictions.like("emailId", dto.getEmailId() + "%"));
			}
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("TeacherDAOImpl Search method End");
		return criteria.list();
	}


}
