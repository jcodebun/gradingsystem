package in.co.grade.sys.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.grade.sys.dao.CourseToStudentDAOInt;
import in.co.grade.sys.dto.CourseToStudentDTO;
import in.co.grade.sys.exception.DuplicateRecordException;

@Service
public class CourseToStudentServiceImpl implements CourseToStudentServiceInt {

	private static Logger log=Logger.getLogger(CourseToStudentServiceImpl.class.getName());
	
	@Autowired
	private CourseToStudentDAOInt dao;
	
	private JavaMailSenderImpl mailSender;
	
	
	
	@Override
	@Transactional
	public long add(CourseToStudentDTO dto) throws DuplicateRecordException {
		log.info("CourseToStudentServiceImpl Add method start");
		/*
		 * CourseToStudentDTO existdto=dao.findByName(dto.getName());
		 * System.out.println("in CourseToStudent add After finad b pk"); if(existdto
		 * !=null) throw new DuplicateRecordException("Name Already Exist");
		 */
		
		long pk=dao.add(dto);
		log.info("CourseToStudentServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(CourseToStudentDTO dto) {
		log.info("CourseToStudentServiceImpl Delete method start");
		dao.delete(dto);
		log.info("CourseToStudentServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public CourseToStudentDTO findBypk(long pk) {
		log.info("CourseToStudentServiceImpl findBypk method start");
		CourseToStudentDTO dto=dao.findBypk(pk);
		log.info("CourseToStudentServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public CourseToStudentDTO findByName(String name) {
		log.info("CourseToStudentServiceImpl findByCourseToStudentName method start");
		CourseToStudentDTO dto=dao.findByName(name);
		log.info("CourseToStudentServiceImpl findByCourseToStudentName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(CourseToStudentDTO dto) throws DuplicateRecordException {
		log.info("CourseToStudentServiceImpl update method start");
		/*
		 * CourseToStudentDTO existdto=dao.findByName(dto.getName()); if(existdto !=null
		 * && dto.getId()!=existdto.getId()) throw new
		 * DuplicateRecordException("Name Already Exist");
		 */
		dao.update(dto);
		log.info("CourseToStudentServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<CourseToStudentDTO> list() {
		log.info("CourseToStudentServiceImpl list method start");
		List<CourseToStudentDTO> list=dao.list();
		log.info("CourseToStudentServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<CourseToStudentDTO> list(int pageNo, int pageSize) {
		log.info("CourseToStudentServiceImpl list method start");
		List<CourseToStudentDTO> list=dao.list(pageNo, pageSize);
		log.info("CourseToStudentServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<CourseToStudentDTO> search(CourseToStudentDTO dto) {
		log.info("CourseToStudentServiceImpl search method start");
		List<CourseToStudentDTO> list=dao.search(dto);
		log.info("CourseToStudentServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<CourseToStudentDTO> search(CourseToStudentDTO dto, int pageNo, int pageSize) {
		log.info("CourseToStudentServiceImpl search method start");
		List<CourseToStudentDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("CourseToStudentServiceImpl search method end");
		return list;
	}

	

	
}
