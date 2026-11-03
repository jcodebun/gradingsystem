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

import in.co.grade.sys.dto.CourseToStudentDTO;




@Repository
public class CourseToStudentDAOImpl implements CourseToStudentDAOInt {

	private static Logger log = Logger.getLogger(CourseToStudentDAOImpl.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long add(CourseToStudentDTO dto) {
		log.info("CourseToStudentDAOImpl Add method Start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(dto);
		log.info("CourseToStudentDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(CourseToStudentDTO dto) {
		log.info("CourseToStudentDAOImpl Delete method Start");
		Session session = sessionFactory.getCurrentSession();
		session.delete(dto);
		log.info("CourseToStudentDAOImpl Delete method End");
		
	}

	@Override
	public CourseToStudentDTO findBypk(long pk) {
		log.info("CourseToStudentDAOImpl FindByPk method Start");
		Session session = sessionFactory.getCurrentSession();
		CourseToStudentDTO dto = (CourseToStudentDTO) session.get(CourseToStudentDTO.class, pk);
		log.info("CourseToStudentDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public CourseToStudentDTO findByName(String name) {
		log.info("CourseToStudentDAOImpl FindByLogin method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CourseToStudentDTO.class);
		criteria.add(Restrictions.eq("name", name));
		CourseToStudentDTO dto = (CourseToStudentDTO) criteria.uniqueResult();
		log.info("CourseToStudentDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(CourseToStudentDTO dto) {
		log.info("CourseToStudentDAOImpl Update method Start");
		Session session = sessionFactory.getCurrentSession();
		session.merge(dto);
		log.info("CourseToStudentDAOImpl update method End");
	}

	@Override
	public List<CourseToStudentDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<CourseToStudentDTO> list(int pageNo, int pageSize) {
		log.info("CourseToStudentDAOImpl List method Start");
		Session session = sessionFactory.getCurrentSession();
		Query<CourseToStudentDTO> query = session.createQuery("from CourseToStudentDTO", CourseToStudentDTO.class);
		List<CourseToStudentDTO> list = query.getResultList();
		log.info("CourseToStudentDAOImpl List method End");
		return list;
	}

	@Override
	public List<CourseToStudentDTO> search(CourseToStudentDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<CourseToStudentDTO> search(CourseToStudentDTO dto, int pageNo, int pageSize) {
		log.info("CourseToStudentDAOImpl Search method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CourseToStudentDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getStudentId() > 0) {
				criteria.add(Restrictions.eq("studentId", dto.getStudentId()));
			}
			
			if (dto.getCourseId() > 0) {
				criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
			}
			if (dto.getStudentName() != null && dto.getStudentName().length() > 0) {
				criteria.add(Restrictions.like("studentName", dto.getStudentName() + "%"));
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
		log.info("CourseToStudentDAOImpl Search method End");
		return criteria.list();
	}


}
