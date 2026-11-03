package in.co.grade.sys.service;

import java.util.List;

import in.co.grade.sys.dto.TeacherDTO;
import in.co.grade.sys.exception.DuplicateRecordException;


public interface TeacherServiceInt {

	public long add(TeacherDTO dto) throws DuplicateRecordException;

	public void delete(TeacherDTO dto);

	public TeacherDTO findBypk(long pk);

	public TeacherDTO findByEmail(String login);

	public void update(TeacherDTO dto) throws DuplicateRecordException;

	public List<TeacherDTO> list();

	public List<TeacherDTO> list(int pageNo, int pageSize);

	public List<TeacherDTO> search(TeacherDTO dto);

	public List<TeacherDTO> search(TeacherDTO dto, int pageNo, int pageSize);

	

}
