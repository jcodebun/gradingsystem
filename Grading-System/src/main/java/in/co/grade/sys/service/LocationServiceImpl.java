package in.co.grade.sys.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.grade.sys.dao.LocationDAOInt;
import in.co.grade.sys.dto.LocationDTO;
import in.co.grade.sys.exception.DuplicateRecordException;

@Service
public class LocationServiceImpl implements LocationServiceInt {

	private static Logger log=Logger.getLogger(LocationServiceImpl.class.getName());
	
	@Autowired
	private LocationDAOInt dao;
	
	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(LocationDTO dto) throws DuplicateRecordException {
		log.info("LocationServiceImpl Add method start");
		/*
		 * LocationDTO existdto=dao.findByName(dto.getName());
		 * System.out.println("in Location add After finad b pk"); if(existdto !=null)
		 * throw new DuplicateRecordException("Name Already Exist");
		 */
		long pk=dao.add(dto);
		log.info("LocationServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(LocationDTO dto) {
		log.info("LocationServiceImpl Delete method start");
		dao.delete(dto);
		log.info("LocationServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public LocationDTO findBypk(long pk) {
		log.info("LocationServiceImpl findBypk method start");
		LocationDTO dto=dao.findBypk(pk);
		log.info("LocationServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public LocationDTO findByName(String name) {
		log.info("LocationServiceImpl findByLocationName method start");
		LocationDTO dto=dao.findByName(name);
		log.info("LocationServiceImpl findByLocationName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(LocationDTO dto) throws DuplicateRecordException {
		log.info("LocationServiceImpl update method start");
		/*
		 * LocationDTO existdto=dao.findByName(dto.getName()); if(existdto !=null &&
		 * dto.getId()!=existdto.getId()) throw new
		 * DuplicateRecordException("Name Already Exist");
		 */
		dao.update(dto);
		log.info("LocationServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<LocationDTO> list() {
		log.info("LocationServiceImpl list method start");
		List<LocationDTO> list=dao.list();
		log.info("LocationServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<LocationDTO> list(int pageNo, int pageSize) {
		log.info("LocationServiceImpl list method start");
		List<LocationDTO> list=dao.list(pageNo, pageSize);
		log.info("LocationServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<LocationDTO> search(LocationDTO dto) {
		log.info("LocationServiceImpl search method start");
		List<LocationDTO> list=dao.search(dto);
		log.info("LocationServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<LocationDTO> search(LocationDTO dto, int pageNo, int pageSize) {
		log.info("LocationServiceImpl search method start");
		List<LocationDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("LocationServiceImpl search method end");
		return list;
	}

	

	
}
