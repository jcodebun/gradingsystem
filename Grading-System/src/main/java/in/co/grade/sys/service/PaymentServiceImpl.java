package in.co.grade.sys.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.grade.sys.dao.PaymentDAOInt;
import in.co.grade.sys.dto.PaymentDTO;
import in.co.grade.sys.exception.DuplicateRecordException;

@Service
public class PaymentServiceImpl implements PaymentServiceInt {

	private static Logger log=Logger.getLogger(PaymentServiceImpl.class.getName());
	
	@Autowired
	private PaymentDAOInt dao;
	
	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(PaymentDTO dto) throws DuplicateRecordException {
		log.info("PaymentServiceImpl Add method start");
		/*
		 * PaymentDTO existdto=dao.findByName(dto.getName());
		 * System.out.println("in Payment add After finad b pk"); if(existdto !=null)
		 * throw new DuplicateRecordException("Name Already Exist");
		 */
		long pk=dao.add(dto);
		log.info("PaymentServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(PaymentDTO dto) {
		log.info("PaymentServiceImpl Delete method start");
		dao.delete(dto);
		log.info("PaymentServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public PaymentDTO findBypk(long pk) {
		log.info("PaymentServiceImpl findBypk method start");
		PaymentDTO dto=dao.findBypk(pk);
		log.info("PaymentServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public PaymentDTO findByName(String name) {
		log.info("PaymentServiceImpl findByPaymentName method start");
		PaymentDTO dto=dao.findByName(name);
		log.info("PaymentServiceImpl findByPaymentName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(PaymentDTO dto) throws DuplicateRecordException {
		log.info("PaymentServiceImpl update method start");
		/*
		 * PaymentDTO existdto=dao.findByName(dto.getName()); if(existdto !=null &&
		 * dto.getId()!=existdto.getId()) throw new
		 * DuplicateRecordException("Name Already Exist");
		 */
		dao.update(dto);
		log.info("PaymentServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<PaymentDTO> list() {
		log.info("PaymentServiceImpl list method start");
		List<PaymentDTO> list=dao.list();
		log.info("PaymentServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<PaymentDTO> list(int pageNo, int pageSize) {
		log.info("PaymentServiceImpl list method start");
		List<PaymentDTO> list=dao.list(pageNo, pageSize);
		log.info("PaymentServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<PaymentDTO> search(PaymentDTO dto) {
		log.info("PaymentServiceImpl search method start");
		List<PaymentDTO> list=dao.search(dto);
		log.info("PaymentServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<PaymentDTO> search(PaymentDTO dto, int pageNo, int pageSize) {
		log.info("PaymentServiceImpl search method start");
		List<PaymentDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("PaymentServiceImpl search method end");
		return list;
	}

	

	
}
