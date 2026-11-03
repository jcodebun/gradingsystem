package in.co.grade.sys.dao;

import java.util.List;

import in.co.grade.sys.dto.CourseToTeacherDTO;


public interface CourseToTeacherDAOInt {

	public long add(CourseToTeacherDTO dto);
	
	public void delete(CourseToTeacherDTO dto);
	
	public CourseToTeacherDTO findBypk(long pk);
	
	public CourseToTeacherDTO findByName(String name);
	
	public void update(CourseToTeacherDTO dto);
	
	public List<CourseToTeacherDTO> list();
	
	public List<CourseToTeacherDTO>list(int pageNo,int pageSize);
	
	public List<CourseToTeacherDTO> search(CourseToTeacherDTO dto);
	
	public List<CourseToTeacherDTO> search(CourseToTeacherDTO dto,int pageNo,int pageSize);
	
}
