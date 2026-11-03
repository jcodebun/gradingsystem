package in.co.grade.sys.dao;

import java.util.List;

import in.co.grade.sys.dto.StudentDTO;


public interface StudentDAOInt {

	public long add(StudentDTO dto);
	
	public void delete(StudentDTO dto);
	
	public StudentDTO findBypk(long pk);
	
	public StudentDTO findByEmail(String email);
	
	public void update(StudentDTO dto);
	
	public List<StudentDTO> list();
	
	public List<StudentDTO>list(int pageNo,int pageSize);
	
	public List<StudentDTO> search(StudentDTO dto);
	
	public List<StudentDTO> search(StudentDTO dto,int pageNo,int pageSize);
	
}
