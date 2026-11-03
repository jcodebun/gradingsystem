package in.co.grade.sys.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.grade.sys.dao.CourseDAOInt;
import in.co.grade.sys.dto.CourseDTO;
import in.co.grade.sys.exception.DuplicateRecordException;

@Service
public class CourseServiceImpl implements CourseServiceInt {

	private static Logger log=Logger.getLogger(CourseServiceImpl.class.getName());
	
	@Autowired
	private CourseDAOInt dao;
	
	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(CourseDTO dto) throws DuplicateRecordException {
		log.info("CourseServiceImpl Add method start");
		CourseDTO existdto=dao.findByName(dto.getName());
		System.out.println("in Course add After finad b pk");
		if(existdto !=null)
			throw new DuplicateRecordException("Name Already Exist");
		long pk=dao.add(dto);
		log.info("CourseServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(CourseDTO dto) {
		log.info("CourseServiceImpl Delete method start");
		dao.delete(dto);
		log.info("CourseServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public CourseDTO findBypk(long pk) {
		log.info("CourseServiceImpl findBypk method start");
		CourseDTO dto=dao.findBypk(pk);
		log.info("CourseServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public CourseDTO findByName(String name) {
		log.info("CourseServiceImpl findByCourseName method start");
		CourseDTO dto=dao.findByName(name);
		log.info("CourseServiceImpl findByCourseName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(CourseDTO dto) throws DuplicateRecordException {
		log.info("CourseServiceImpl update method start");
		CourseDTO existdto=dao.findByName(dto.getName());
		if(existdto !=null && dto.getId()!=existdto.getId())
			throw new DuplicateRecordException("Name Already Exist");
		dao.update(dto);
		log.info("CourseServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<CourseDTO> list() {
		log.info("CourseServiceImpl list method start");
		List<CourseDTO> list=dao.list();
		log.info("CourseServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<CourseDTO> list(int pageNo, int pageSize) {
		log.info("CourseServiceImpl list method start");
		List<CourseDTO> list=dao.list(pageNo, pageSize);
		log.info("CourseServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<CourseDTO> search(CourseDTO dto) {
		log.info("CourseServiceImpl search method start");
		List<CourseDTO> list=dao.search(dto);
		log.info("CourseServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<CourseDTO> search(CourseDTO dto, int pageNo, int pageSize) {
		log.info("CourseServiceImpl search method start");
		List<CourseDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("CourseServiceImpl search method end");
		return list;
	}

	

	
}
