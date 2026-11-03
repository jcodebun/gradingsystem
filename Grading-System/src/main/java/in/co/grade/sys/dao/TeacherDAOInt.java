package in.co.grade.sys.dao;

import java.util.List;

import in.co.grade.sys.dto.TeacherDTO;


public interface TeacherDAOInt {

	public long add(TeacherDTO dto);
	
	public void delete(TeacherDTO dto);
	
	public TeacherDTO findBypk(long pk);
	
	public TeacherDTO findByEmail(String email);
	
	public void update(TeacherDTO dto);
	
	public List<TeacherDTO> list();
	
	public List<TeacherDTO>list(int pageNo,int pageSize);
	
	public List<TeacherDTO> search(TeacherDTO dto);
	
	public List<TeacherDTO> search(TeacherDTO dto,int pageNo,int pageSize);
	
}
