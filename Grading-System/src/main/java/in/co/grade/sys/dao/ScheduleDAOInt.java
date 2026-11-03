package in.co.grade.sys.dao;

import java.util.List;

import in.co.grade.sys.dto.ScheduleDTO;


public interface ScheduleDAOInt {

	public long add(ScheduleDTO dto);
	
	public void delete(ScheduleDTO dto);
	
	public ScheduleDTO findBypk(long pk);
	
	public ScheduleDTO findByName(String name);
	
	public void update(ScheduleDTO dto);
	
	public List<ScheduleDTO> list();
	
	public List<ScheduleDTO>list(int pageNo,int pageSize);
	
	public List<ScheduleDTO> search(ScheduleDTO dto);
	
	public List<ScheduleDTO> search(ScheduleDTO dto,int pageNo,int pageSize);
	
}
