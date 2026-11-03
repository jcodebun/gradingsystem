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

import in.co.grade.sys.dto.LocationDTO;

@Repository
public class LocationDAOImpl implements LocationDAOInt {

	private static Logger log = Logger.getLogger(LocationDAOImpl.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long add(LocationDTO dto) {
		log.info("LocationDAOImpl Add method Start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(dto);
		log.info("LocationDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(LocationDTO dto) {
		log.info("LocationDAOImpl Delete method Start");
		Session session = sessionFactory.getCurrentSession();
		session.delete(dto);
		log.info("LocationDAOImpl Delete method End");
		
	}

	@Override
	public LocationDTO findBypk(long pk) {
		log.info("LocationDAOImpl FindByPk method Start");
		Session session = sessionFactory.getCurrentSession();
		LocationDTO dto = (LocationDTO) session.get(LocationDTO.class, pk);
		log.info("LocationDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public LocationDTO findByName(String name) {
		log.info("LocationDAOImpl FindByLogin method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(LocationDTO.class);
		criteria.add(Restrictions.eq("studentName", name));
		LocationDTO dto = (LocationDTO) criteria.uniqueResult();
		log.info("LocationDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(LocationDTO dto) {
		log.info("LocationDAOImpl Update method Start");
		Session session = sessionFactory.getCurrentSession();
		session.merge(dto);
		log.info("LocationDAOImpl update method End");
	}

	@Override
	public List<LocationDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<LocationDTO> list(int pageNo, int pageSize) {
		log.info("LocationDAOImpl List method Start");
		Session session = sessionFactory.getCurrentSession();
		Query<LocationDTO> query = session.createQuery("from LocationDTO", LocationDTO.class);
		List<LocationDTO> list = query.getResultList();
		log.info("LocationDAOImpl List method End");
		return list;
	}

	@Override
	public List<LocationDTO> search(LocationDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<LocationDTO> search(LocationDTO dto, int pageNo, int pageSize) {
		log.info("LocationDAOImpl Search method Start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(LocationDTO.class);
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
		log.info("LocationDAOImpl Search method End");
		return criteria.list();
	}


}
