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

import in.co.grade.sys.dao.TeacherDAOInt;
import in.co.grade.sys.dto.TeacherDTO;
import in.co.grade.sys.exception.DuplicateRecordException;
import in.co.grade.sys.util.EmailBuilder;

@Service
public class TeacherServiceImpl implements TeacherServiceInt {

	private static Logger log=Logger.getLogger(TeacherServiceImpl.class.getName());
	
	@Autowired
	private TeacherDAOInt dao;
	
	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(TeacherDTO dto) throws DuplicateRecordException {
		log.info("TeacherServiceImpl Add method start");
		TeacherDTO existdto=dao.findByEmail(dto.getEmailId());
		System.out.println("in Teacher add After finad b pk");
		if(existdto !=null)
			throw new DuplicateRecordException("Login Already Exist");
		long pk=dao.add(dto);
		log.info("TeacherServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(TeacherDTO dto) {
		log.info("TeacherServiceImpl Delete method start");
		dao.delete(dto);
		log.info("TeacherServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public TeacherDTO findBypk(long pk) {
		log.info("TeacherServiceImpl findBypk method start");
		TeacherDTO dto=dao.findBypk(pk);
		log.info("TeacherServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public TeacherDTO findByEmail(String email) {
		log.info("TeacherServiceImpl findByTeacherName method start");
		TeacherDTO dto=dao.findByEmail(email);
		log.info("TeacherServiceImpl findByTeacherName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(TeacherDTO dto) throws DuplicateRecordException {
		log.info("TeacherServiceImpl update method start");
		TeacherDTO existdto=dao.findByEmail(dto.getEmailId());
		if(existdto !=null && dto.getId()!=existdto.getId())
			throw new DuplicateRecordException("Login Already Exist");
		dao.update(dto);
		log.info("TeacherServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<TeacherDTO> list() {
		log.info("TeacherServiceImpl list method start");
		List<TeacherDTO> list=dao.list();
		log.info("TeacherServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<TeacherDTO> list(int pageNo, int pageSize) {
		log.info("TeacherServiceImpl list method start");
		List<TeacherDTO> list=dao.list(pageNo, pageSize);
		log.info("TeacherServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<TeacherDTO> search(TeacherDTO dto) {
		log.info("TeacherServiceImpl search method start");
		List<TeacherDTO> list=dao.search(dto);
		log.info("TeacherServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<TeacherDTO> search(TeacherDTO dto, int pageNo, int pageSize) {
		log.info("TeacherServiceImpl search method start");
		List<TeacherDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("TeacherServiceImpl search method end");
		return list;
	}

	

	
}
