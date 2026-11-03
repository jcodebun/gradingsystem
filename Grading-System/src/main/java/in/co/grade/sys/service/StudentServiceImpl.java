package in.co.grade.sys.service;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.grade.sys.dao.StudentDAOInt;
import in.co.grade.sys.dto.StudentDTO;
import in.co.grade.sys.exception.DuplicateRecordException;
import in.co.grade.sys.util.EmailBuilder;

@Service
public class StudentServiceImpl implements StudentServiceInt {

	private static Logger log=Logger.getLogger(StudentServiceImpl.class.getName());
	
	@Autowired
	private StudentDAOInt dao;
	
	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(StudentDTO dto) throws DuplicateRecordException {
		log.info("StudentServiceImpl Add method start");
		StudentDTO existdto=dao.findByEmail(dto.getEmailId());
		System.out.println("in Student add After finad b pk");
		if(existdto !=null)
			throw new DuplicateRecordException("Login Already Exist");
		long pk=dao.add(dto);
		log.info("StudentServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(StudentDTO dto) {
		log.info("StudentServiceImpl Delete method start");
		dao.delete(dto);
		log.info("StudentServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public StudentDTO findBypk(long pk) {
		log.info("StudentServiceImpl findBypk method start");
		StudentDTO dto=dao.findBypk(pk);
		log.info("StudentServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public StudentDTO findByEmail(String email) {
		log.info("StudentServiceImpl findByStudentName method start");
		StudentDTO dto=dao.findByEmail(email);
		log.info("StudentServiceImpl findByStudentName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(StudentDTO dto) throws DuplicateRecordException {
		log.info("StudentServiceImpl update method start");
		StudentDTO existdto=dao.findByEmail(dto.getEmailId());
		if(existdto !=null && dto.getId()!=existdto.getId())
			throw new DuplicateRecordException("Login Already Exist");
		dao.update(dto);
		log.info("StudentServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<StudentDTO> list() {
		log.info("StudentServiceImpl list method start");
		List<StudentDTO> list=dao.list();
		log.info("StudentServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<StudentDTO> list(int pageNo, int pageSize) {
		log.info("StudentServiceImpl list method start");
		List<StudentDTO> list=dao.list(pageNo, pageSize);
		log.info("StudentServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<StudentDTO> search(StudentDTO dto) {
		log.info("StudentServiceImpl search method start");
		List<StudentDTO> list=dao.search(dto);
		log.info("StudentServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<StudentDTO> search(StudentDTO dto, int pageNo, int pageSize) {
		log.info("StudentServiceImpl search method start");
		List<StudentDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("StudentServiceImpl search method end");
		return list;
	}

	

	
}
