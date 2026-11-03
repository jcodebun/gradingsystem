package in.co.grade.sys.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.grade.sys.dto.StudentDTO;




@Repository
public class StudentDAOImpl implements StudentDAOInt {

	private static Logger log = Logger.getLogger(StudentDAOImpl.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long add(StudentDTO dto) {
		log.info("StudentDAOImpl Add method Start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(dto);
		log.info("StudentDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(StudentDTO dto) {
		log.info("StudentDAOImpl Delete method Start");
		Session session = sessionFactory.getCurrentSession();
		session.delete(dto);
		log.info("StudentDAOImpl Delete method End");
		
	}

	@Override
	public StudentDTO findBypk(long pk) {
		log.info("StudentDAOImpl FindByPk method Start");
		Session session = sessionFactory.getCurrentSession();
		StudentDTO dto = (StudentDTO) session.get(StudentDTO.class, pk);
		log.info("StudentDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public StudentDTO findByEmail(String email) {
		log.info("StudentDAOImpl FindByLogin method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(StudentDTO.class);
		criteria.add(Restrictions.eq("emailId", email));
		StudentDTO dto = (StudentDTO) criteria.uniqueResult();
		log.info("StudentDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(StudentDTO dto) {
		log.info("StudentDAOImpl Update method Start");
		Session session = sessionFactory.getCurrentSession();
		session.merge(dto);
		log.info("StudentDAOImpl update method End");
	}

	@Override
	public List<StudentDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<StudentDTO> list(int pageNo, int pageSize) {
		log.info("StudentDAOImpl List method Start");
		Session session = sessionFactory.getCurrentSession();
		Query<StudentDTO> query = session.createQuery("from StudentDTO", StudentDTO.class);
		List<StudentDTO> list = query.getResultList();
		log.info("StudentDAOImpl List method End");
		return list;
	}

	@Override
	public List<StudentDTO> search(StudentDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<StudentDTO> search(StudentDTO dto, int pageNo, int pageSize) {
		log.info("StudentDAOImpl Search method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(StudentDTO.class);
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
		log.info("StudentDAOImpl Search method End");
		return criteria.list();
	}


}
