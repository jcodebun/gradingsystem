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

import in.co.grade.sys.dto.ScheduleDTO;




@Repository
public class ScheduleDAOImpl implements ScheduleDAOInt {

	private static Logger log = Logger.getLogger(ScheduleDAOImpl.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long add(ScheduleDTO dto) {
		log.info("ScheduleDAOImpl Add method Start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(dto);
		log.info("ScheduleDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(ScheduleDTO dto) {
		log.info("ScheduleDAOImpl Delete method Start");
		Session session = sessionFactory.getCurrentSession();
		session.delete(dto);
		log.info("ScheduleDAOImpl Delete method End");
		
	}

	@Override
	public ScheduleDTO findBypk(long pk) {
		log.info("ScheduleDAOImpl FindByPk method Start");
		Session session = sessionFactory.getCurrentSession();
		ScheduleDTO dto = (ScheduleDTO) session.get(ScheduleDTO.class, pk);
		log.info("ScheduleDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public ScheduleDTO findByName(String name) {
		log.info("ScheduleDAOImpl FindByLogin method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ScheduleDTO.class);
		criteria.add(Restrictions.eq("studentName", name));
		ScheduleDTO dto = (ScheduleDTO) criteria.uniqueResult();
		log.info("ScheduleDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(ScheduleDTO dto) {
		log.info("ScheduleDAOImpl Update method Start");
		Session session = sessionFactory.getCurrentSession();
		session.merge(dto);
		log.info("ScheduleDAOImpl update method End");
	}

	@Override
	public List<ScheduleDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<ScheduleDTO> list(int pageNo, int pageSize) {
		log.info("ScheduleDAOImpl List method Start");
		Session session = sessionFactory.getCurrentSession();
		Query<ScheduleDTO> query = session.createQuery("from ScheduleDTO", ScheduleDTO.class);
		List<ScheduleDTO> list = query.getResultList();
		log.info("ScheduleDAOImpl List method End");
		return list;
	}

	@Override
	public List<ScheduleDTO> search(ScheduleDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<ScheduleDTO> search(ScheduleDTO dto, int pageNo, int pageSize) {
		log.info("ScheduleDAOImpl Search method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ScheduleDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getCourseId() > 0) {
				criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
			}
			if (dto.getLocationName() != null && dto.getLocationName().length() > 0) {
				criteria.add(Restrictions.like("locationName", dto.getLocationName() + "%"));
			}
			if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {
				criteria.add(Restrictions.like("courseName", dto.getCourseName() + "%"));
			}
			
		
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("ScheduleDAOImpl Search method End");
		return criteria.list();
	}


}
