package in.co.grade.sys.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.grade.sys.dao.CourseToTeacherDAOInt;
import in.co.grade.sys.dto.CourseToTeacherDTO;
import in.co.grade.sys.exception.DuplicateRecordException;

@Service
public class CourseToTeacherServiceImpl implements CourseToTeacherServiceInt {

	private static Logger log=Logger.getLogger(CourseToTeacherServiceImpl.class.getName());
	
	@Autowired
	private CourseToTeacherDAOInt dao;
	
	private JavaMailSenderImpl mailSender;
	
	
	
	@Override
	@Transactional
	public long add(CourseToTeacherDTO dto) throws DuplicateRecordException {
		log.info("CourseToTeacherServiceImpl Add method start");
		/*
		 * CourseToTeacherDTO existdto=dao.findByName(dto.getName());
		 * System.out.println("in CourseToTeacher add After finad b pk"); if(existdto
		 * !=null) throw new DuplicateRecordException("Name Already Exist");
		 */
		
		long pk=dao.add(dto);
		log.info("CourseToTeacherServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(CourseToTeacherDTO dto) {
		log.info("CourseToTeacherServiceImpl Delete method start");
		dao.delete(dto);
		log.info("CourseToTeacherServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public CourseToTeacherDTO findBypk(long pk) {
		log.info("CourseToTeacherServiceImpl findBypk method start");
		CourseToTeacherDTO dto=dao.findBypk(pk);
		log.info("CourseToTeacherServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public CourseToTeacherDTO findByName(String name) {
		log.info("CourseToTeacherServiceImpl findByCourseToTeacherName method start");
		CourseToTeacherDTO dto=dao.findByName(name);
		log.info("CourseToTeacherServiceImpl findByCourseToTeacherName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(CourseToTeacherDTO dto) throws DuplicateRecordException {
		log.info("CourseToTeacherServiceImpl update method start");
		/*
		 * CourseToTeacherDTO existdto=dao.findByName(dto.getName()); if(existdto !=null
		 * && dto.getId()!=existdto.getId()) throw new
		 * DuplicateRecordException("Name Already Exist");
		 */
		dao.update(dto);
		log.info("CourseToTeacherServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<CourseToTeacherDTO> list() {
		log.info("CourseToTeacherServiceImpl list method start");
		List<CourseToTeacherDTO> list=dao.list();
		log.info("CourseToTeacherServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<CourseToTeacherDTO> list(int pageNo, int pageSize) {
		log.info("CourseToTeacherServiceImpl list method start");
		List<CourseToTeacherDTO> list=dao.list(pageNo, pageSize);
		log.info("CourseToTeacherServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<CourseToTeacherDTO> search(CourseToTeacherDTO dto) {
		log.info("CourseToTeacherServiceImpl search method start");
		List<CourseToTeacherDTO> list=dao.search(dto);
		log.info("CourseToTeacherServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<CourseToTeacherDTO> search(CourseToTeacherDTO dto, int pageNo, int pageSize) {
		log.info("CourseToTeacherServiceImpl search method start");
		List<CourseToTeacherDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("CourseToTeacherServiceImpl search method end");
		return list;
	}

	

	
}
