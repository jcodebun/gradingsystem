package in.co.grade.sys.service;

import java.util.List;

import in.co.grade.sys.dto.LocationDTO;
import in.co.grade.sys.exception.DuplicateRecordException;


public interface LocationServiceInt {

	public long add(LocationDTO dto) throws DuplicateRecordException;

	public void delete(LocationDTO dto);

	public LocationDTO findBypk(long pk);

	public LocationDTO findByName(String name);

	public void update(LocationDTO dto) throws DuplicateRecordException;

	public List<LocationDTO> list();

	public List<LocationDTO> list(int pageNo, int pageSize);

	public List<LocationDTO> search(LocationDTO dto);

	public List<LocationDTO> search(LocationDTO dto, int pageNo, int pageSize);

	

}
