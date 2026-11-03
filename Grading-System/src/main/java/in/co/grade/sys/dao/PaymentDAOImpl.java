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

import in.co.grade.sys.dto.PaymentDTO;




@Repository
public class PaymentDAOImpl implements PaymentDAOInt {

	private static Logger log = Logger.getLogger(PaymentDAOImpl.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long add(PaymentDTO dto) {
		log.info("PaymentDAOImpl Add method Start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(dto);
		log.info("PaymentDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(PaymentDTO dto) {
		log.info("PaymentDAOImpl Delete method Start");
		Session session = sessionFactory.getCurrentSession();
		session.delete(dto);
		log.info("PaymentDAOImpl Delete method End");
		
	}

	@Override
	public PaymentDTO findBypk(long pk) {
		log.info("PaymentDAOImpl FindByPk method Start");
		Session session = sessionFactory.getCurrentSession();
		PaymentDTO dto = (PaymentDTO) session.get(PaymentDTO.class, pk);
		log.info("PaymentDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public PaymentDTO findByName(String name) {
		log.info("PaymentDAOImpl FindByLogin method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PaymentDTO.class);
		criteria.add(Restrictions.eq("studentName", name));
		PaymentDTO dto = (PaymentDTO) criteria.uniqueResult();
		log.info("PaymentDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(PaymentDTO dto) {
		log.info("PaymentDAOImpl Update method Start");
		Session session = sessionFactory.getCurrentSession();
		session.merge(dto);
		log.info("PaymentDAOImpl update method End");
	}

	@Override
	public List<PaymentDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<PaymentDTO> list(int pageNo, int pageSize) {
		log.info("PaymentDAOImpl List method Start");
		Session session = sessionFactory.getCurrentSession();
		Query<PaymentDTO> query = session.createQuery("from PaymentDTO", PaymentDTO.class);
		List<PaymentDTO> list = query.getResultList();
		log.info("PaymentDAOImpl List method End");
		return list;
	}

	@Override
	public List<PaymentDTO> search(PaymentDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<PaymentDTO> search(PaymentDTO dto, int pageNo, int pageSize) {
		log.info("PaymentDAOImpl Search method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PaymentDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			
			if (dto.getStudentId() > 0) {
				criteria.add(Restrictions.eq("studentId", dto.getStudentId()));
			}
			
			if (dto.getStudentName() != null && dto.getStudentName().length() > 0) {
				criteria.add(Restrictions.like("studentName", dto.getStudentName() + "%"));
			}
			
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("PaymentDAOImpl Search method End");
		return criteria.list();
	}


}
