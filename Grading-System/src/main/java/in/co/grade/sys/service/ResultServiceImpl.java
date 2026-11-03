package in.co.grade.sys.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.grade.sys.dao.ResultDAOInt;
import in.co.grade.sys.dto.ResultDTO;
import in.co.grade.sys.exception.DuplicateRecordException;

@Service
public class ResultServiceImpl implements ResultServiceInt {

	private static Logger log=Logger.getLogger(ResultServiceImpl.class.getName());
	
	@Autowired
	private ResultDAOInt dao;
	
	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(ResultDTO dto) throws DuplicateRecordException {
		log.info("ResultServiceImpl Add method start");
		/*
		 * ResultDTO existdto=dao.findByName(dto.getName());
		 * System.out.println("in Result add After finad b pk"); if(existdto !=null)
		 * throw new DuplicateRecordException("Name Already Exist");
		 */
		long pk=dao.add(dto);
		log.info("ResultServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(ResultDTO dto) {
		log.info("ResultServiceImpl Delete method start");
		dao.delete(dto);
		log.info("ResultServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public ResultDTO findBypk(long pk) {
		log.info("ResultServiceImpl findBypk method start");
		ResultDTO dto=dao.findBypk(pk);
		log.info("ResultServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public ResultDTO findByName(String name) {
		log.info("ResultServiceImpl findByResultName method start");
		ResultDTO dto=dao.findByName(name);
		log.info("ResultServiceImpl findByResultName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(ResultDTO dto) throws DuplicateRecordException {
		log.info("ResultServiceImpl update method start");
		/*
		 * ResultDTO existdto=dao.findByName(dto.getName()); if(existdto !=null &&
		 * dto.getId()!=existdto.getId()) throw new
		 * DuplicateRecordException("Name Already Exist");
		 */
		dao.update(dto);
		log.info("ResultServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<ResultDTO> list() {
		log.info("ResultServiceImpl list method start");
		List<ResultDTO> list=dao.list();
		log.info("ResultServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<ResultDTO> list(int pageNo, int pageSize) {
		log.info("ResultServiceImpl list method start");
		List<ResultDTO> list=dao.list(pageNo, pageSize);
		log.info("ResultServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<ResultDTO> search(ResultDTO dto) {
		log.info("ResultServiceImpl search method start");
		List<ResultDTO> list=dao.search(dto);
		log.info("ResultServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<ResultDTO> search(ResultDTO dto, int pageNo, int pageSize) {
		log.info("ResultServiceImpl search method start");
		List<ResultDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("ResultServiceImpl search method end");
		return list;
	}

	

	
}
