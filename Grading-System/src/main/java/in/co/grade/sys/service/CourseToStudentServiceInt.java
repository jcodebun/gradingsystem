package in.co.grade.sys.service;

import java.util.List;

import in.co.grade.sys.dto.CourseToStudentDTO;
import in.co.grade.sys.exception.DuplicateRecordException;


public interface CourseToStudentServiceInt {

	public long add(CourseToStudentDTO dto) throws DuplicateRecordException;

	public void delete(CourseToStudentDTO dto);

	public CourseToStudentDTO findBypk(long pk);

	public CourseToStudentDTO findByName(String name);

	public void update(CourseToStudentDTO dto) throws DuplicateRecordException;

	public List<CourseToStudentDTO> list();

	public List<CourseToStudentDTO> list(int pageNo, int pageSize);

	public List<CourseToStudentDTO> search(CourseToStudentDTO dto);

	public List<CourseToStudentDTO> search(CourseToStudentDTO dto, int pageNo, int pageSize);

	

}
