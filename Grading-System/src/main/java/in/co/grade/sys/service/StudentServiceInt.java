package in.co.grade.sys.service;

import java.util.List;

import in.co.grade.sys.dto.StudentDTO;
import in.co.grade.sys.exception.DuplicateRecordException;


public interface StudentServiceInt {

	public long add(StudentDTO dto) throws DuplicateRecordException;

	public void delete(StudentDTO dto);

	public StudentDTO findBypk(long pk);

	public StudentDTO findByEmail(String login);

	public void update(StudentDTO dto) throws DuplicateRecordException;

	public List<StudentDTO> list();

	public List<StudentDTO> list(int pageNo, int pageSize);

	public List<StudentDTO> search(StudentDTO dto);

	public List<StudentDTO> search(StudentDTO dto, int pageNo, int pageSize);

	

}
