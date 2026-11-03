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

import in.co.grade.sys.dto.CourseDTO;




@Repository
public class CourseDAOImpl implements CourseDAOInt {

	private static Logger log = Logger.getLogger(CourseDAOImpl.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long add(CourseDTO dto) {
		log.info("CourseDAOImpl Add method Start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(dto);
		log.info("CourseDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(CourseDTO dto) {
		log.info("CourseDAOImpl Delete method Start");
		Session session = sessionFactory.getCurrentSession();
		session.delete(dto);
		log.info("CourseDAOImpl Delete method End");
		
	}

	@Override
	public CourseDTO findBypk(long pk) {
		log.info("CourseDAOImpl FindByPk method Start");
		Session session = sessionFactory.getCurrentSession();
		CourseDTO dto = (CourseDTO) session.get(CourseDTO.class, pk);
		log.info("CourseDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public CourseDTO findByName(String name) {
		log.info("CourseDAOImpl FindByLogin method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CourseDTO.class);
		criteria.add(Restrictions.eq("name", name));
		CourseDTO dto = (CourseDTO) criteria.uniqueResult();
		log.info("CourseDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(CourseDTO dto) {
		log.info("CourseDAOImpl Update method Start");
		Session session = sessionFactory.getCurrentSession();
		session.merge(dto);
		log.info("CourseDAOImpl update method End");
	}

	@Override
	public List<CourseDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<CourseDTO> list(int pageNo, int pageSize) {
		log.info("CourseDAOImpl List method Start");
		Session session = sessionFactory.getCurrentSession();
		Query<CourseDTO> query = session.createQuery("from CourseDTO", CourseDTO.class);
		List<CourseDTO> list = query.getResultList();
		log.info("CourseDAOImpl List method End");
		return list;
	}

	@Override
	public List<CourseDTO> search(CourseDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<CourseDTO> search(CourseDTO dto, int pageNo, int pageSize) {
		log.info("CourseDAOImpl Search method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CourseDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("CourseDAOImpl Search method End");
		return criteria.list();
	}


}
