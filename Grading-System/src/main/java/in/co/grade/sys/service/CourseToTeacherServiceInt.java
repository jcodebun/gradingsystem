package in.co.grade.sys.service;

import java.util.List;

import in.co.grade.sys.dto.CourseToTeacherDTO;
import in.co.grade.sys.exception.DuplicateRecordException;


public interface CourseToTeacherServiceInt {

	public long add(CourseToTeacherDTO dto) throws DuplicateRecordException;

	public void delete(CourseToTeacherDTO dto);

	public CourseToTeacherDTO findBypk(long pk);

	public CourseToTeacherDTO findByName(String name);

	public void update(CourseToTeacherDTO dto) throws DuplicateRecordException;

	public List<CourseToTeacherDTO> list();

	public List<CourseToTeacherDTO> list(int pageNo, int pageSize);

	public List<CourseToTeacherDTO> search(CourseToTeacherDTO dto);

	public List<CourseToTeacherDTO> search(CourseToTeacherDTO dto, int pageNo, int pageSize);

	

}
