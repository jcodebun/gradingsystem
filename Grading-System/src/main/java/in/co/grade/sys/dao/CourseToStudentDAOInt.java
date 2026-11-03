package in.co.grade.sys.dao;

import java.util.List;

import in.co.grade.sys.dto.CourseToStudentDTO;


public interface CourseToStudentDAOInt {

	public long add(CourseToStudentDTO dto);
	
	public void delete(CourseToStudentDTO dto);
	
	public CourseToStudentDTO findBypk(long pk);
	
	public CourseToStudentDTO findByName(String name);
	
	public void update(CourseToStudentDTO dto);
	
	public List<CourseToStudentDTO> list();
	
	public List<CourseToStudentDTO>list(int pageNo,int pageSize);
	
	public List<CourseToStudentDTO> search(CourseToStudentDTO dto);
	
	public List<CourseToStudentDTO> search(CourseToStudentDTO dto,int pageNo,int pageSize);
	
}
