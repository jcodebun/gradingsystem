package in.co.grade.sys.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.grade.sys.dao.ScheduleDAOInt;
import in.co.grade.sys.dto.ScheduleDTO;
import in.co.grade.sys.exception.DuplicateRecordException;

@Service
public class ScheduleServiceImpl implements ScheduleServiceInt {

	private static Logger log=Logger.getLogger(ScheduleServiceImpl.class.getName());
	
	@Autowired
	private ScheduleDAOInt dao;
	
	
	@Override
	@Transactional
	public long add(ScheduleDTO dto) throws DuplicateRecordException {
		log.info("ScheduleServiceImpl Add method start");
		/*
		 * ScheduleDTO existdto=dao.findByName(dto.getName());
		 * System.out.println("in Schedule add After finad b pk"); if(existdto !=null)
		 * throw new DuplicateRecordException("Name Already Exist");
		 */
		long pk=dao.add(dto);
		log.info("ScheduleServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(ScheduleDTO dto) {
		log.info("ScheduleServiceImpl Delete method start");
		dao.delete(dto);
		log.info("ScheduleServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public ScheduleDTO findBypk(long pk) {
		log.info("ScheduleServiceImpl findBypk method start");
		ScheduleDTO dto=dao.findBypk(pk);
		log.info("ScheduleServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public ScheduleDTO findByName(String name) {
		log.info("ScheduleServiceImpl findByScheduleName method start");
		ScheduleDTO dto=dao.findByName(name);
		log.info("ScheduleServiceImpl findByScheduleName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(ScheduleDTO dto) throws DuplicateRecordException {
		log.info("ScheduleServiceImpl update method start");
		/*
		 * ScheduleDTO existdto=dao.findByName(dto.getName()); if(existdto !=null &&
		 * dto.getId()!=existdto.getId()) throw new
		 * DuplicateRecordException("Name Already Exist");
		 */
		dao.update(dto);
		log.info("ScheduleServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<ScheduleDTO> list() {
		log.info("ScheduleServiceImpl list method start");
		List<ScheduleDTO> list=dao.list();
		log.info("ScheduleServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<ScheduleDTO> list(int pageNo, int pageSize) {
		log.info("ScheduleServiceImpl list method start");
		List<ScheduleDTO> list=dao.list(pageNo, pageSize);
		log.info("ScheduleServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<ScheduleDTO> search(ScheduleDTO dto) {
		log.info("ScheduleServiceImpl search method start");
		List<ScheduleDTO> list=dao.search(dto);
		log.info("ScheduleServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<ScheduleDTO> search(ScheduleDTO dto, int pageNo, int pageSize) {
		log.info("ScheduleServiceImpl search method start");
		List<ScheduleDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("ScheduleServiceImpl search method end");
		return list;
	}

	

	
}
