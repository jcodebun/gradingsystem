package in.co.grade.sys.service;

import java.util.List;

import in.co.grade.sys.dto.CourseDTO;
import in.co.grade.sys.exception.DuplicateRecordException;


public interface CourseServiceInt {

	public long add(CourseDTO dto) throws DuplicateRecordException;

	public void delete(CourseDTO dto);

	public CourseDTO findBypk(long pk);

	public CourseDTO findByName(String name);

	public void update(CourseDTO dto) throws DuplicateRecordException;

	public List<CourseDTO> list();

	public List<CourseDTO> list(int pageNo, int pageSize);

	public List<CourseDTO> search(CourseDTO dto);

	public List<CourseDTO> search(CourseDTO dto, int pageNo, int pageSize);

	

}
