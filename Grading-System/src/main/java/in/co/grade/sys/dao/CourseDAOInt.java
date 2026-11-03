package in.co.grade.sys.dao;

import java.util.List;

import in.co.grade.sys.dto.CourseDTO;


public interface CourseDAOInt {

	public long add(CourseDTO dto);
	
	public void delete(CourseDTO dto);
	
	public CourseDTO findBypk(long pk);
	
	public CourseDTO findByName(String name);
	
	public void update(CourseDTO dto);
	
	public List<CourseDTO> list();
	
	public List<CourseDTO>list(int pageNo,int pageSize);
	
	public List<CourseDTO> search(CourseDTO dto);
	
	public List<CourseDTO> search(CourseDTO dto,int pageNo,int pageSize);
	
}
