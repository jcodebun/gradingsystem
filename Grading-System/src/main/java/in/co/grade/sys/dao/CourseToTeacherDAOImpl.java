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

import in.co.grade.sys.dto.CourseToTeacherDTO;




@Repository
public class CourseToTeacherDAOImpl implements CourseToTeacherDAOInt {

	private static Logger log = Logger.getLogger(CourseToTeacherDAOImpl.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long add(CourseToTeacherDTO dto) {
		log.info("CourseToTeacherDAOImpl Add method Start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(dto);
		log.info("CourseToTeacherDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(CourseToTeacherDTO dto) {
		log.info("CourseToTeacherDAOImpl Delete method Start");
		Session session = sessionFactory.getCurrentSession();
		session.delete(dto);
		log.info("CourseToTeacherDAOImpl Delete method End");
		
	}

	@Override
	public CourseToTeacherDTO findBypk(long pk) {
		log.info("CourseToTeacherDAOImpl FindByPk method Start");
		Session session = sessionFactory.getCurrentSession();
		CourseToTeacherDTO dto = (CourseToTeacherDTO) session.get(CourseToTeacherDTO.class, pk);
		log.info("CourseToTeacherDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public CourseToTeacherDTO findByName(String name) {
		log.info("CourseToTeacherDAOImpl FindByLogin method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CourseToTeacherDTO.class);
		criteria.add(Restrictions.eq("name", name));
		CourseToTeacherDTO dto = (CourseToTeacherDTO) criteria.uniqueResult();
		log.info("CourseToTeacherDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(CourseToTeacherDTO dto) {
		log.info("CourseToTeacherDAOImpl Update method Start");
		Session session = sessionFactory.getCurrentSession();
		session.merge(dto);
		log.info("CourseToTeacherDAOImpl update method End");
	}

	@Override
	public List<CourseToTeacherDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<CourseToTeacherDTO> list(int pageNo, int pageSize) {
		log.info("CourseToTeacherDAOImpl List method Start");
		Session session = sessionFactory.getCurrentSession();
		Query<CourseToTeacherDTO> query = session.createQuery("from CourseToTeacherDTO", CourseToTeacherDTO.class);
		List<CourseToTeacherDTO> list = query.getResultList();
		log.info("CourseToTeacherDAOImpl List method End");
		return list;
	}

	@Override
	public List<CourseToTeacherDTO> search(CourseToTeacherDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<CourseToTeacherDTO> search(CourseToTeacherDTO dto, int pageNo, int pageSize) {
		log.info("CourseToTeacherDAOImpl Search method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CourseToTeacherDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getCourseId() > 0) {
				criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
			}
			if (dto.getTeacherId() > 0) {
				criteria.add(Restrictions.eq("teacherId", dto.getTeacherId()));
			}
			if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {
				criteria.add(Restrictions.like("courseName", dto.getCourseName() + "%"));
			}
			if (dto.getTeacherName() != null && dto.getTeacherName().length() > 0) {
				criteria.add(Restrictions.like("teacherName", dto.getTeacherName() + "%"));
			}
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("CourseToTeacherDAOImpl Search method End");
		return criteria.list();
	}


}
