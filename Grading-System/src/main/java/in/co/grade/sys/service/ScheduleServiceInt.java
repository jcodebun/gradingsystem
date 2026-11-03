package in.co.grade.sys.service;

import java.util.List;

import in.co.grade.sys.dto.ScheduleDTO;
import in.co.grade.sys.exception.DuplicateRecordException;


public interface ScheduleServiceInt {

	public long add(ScheduleDTO dto) throws DuplicateRecordException;

	public void delete(ScheduleDTO dto);

	public ScheduleDTO findBypk(long pk);

	public ScheduleDTO findByName(String name);

	public void update(ScheduleDTO dto) throws DuplicateRecordException;

	public List<ScheduleDTO> list();

	public List<ScheduleDTO> list(int pageNo, int pageSize);

	public List<ScheduleDTO> search(ScheduleDTO dto);

	public List<ScheduleDTO> search(ScheduleDTO dto, int pageNo, int pageSize);

	

}
