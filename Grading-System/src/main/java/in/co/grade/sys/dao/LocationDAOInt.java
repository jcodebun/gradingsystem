package in.co.grade.sys.dao;

import java.util.List;

import in.co.grade.sys.dto.LocationDTO;


public interface LocationDAOInt {

	public long add(LocationDTO dto);
	
	public void delete(LocationDTO dto);
	
	public LocationDTO findBypk(long pk);
	
	public LocationDTO findByName(String name);
	
	public void update(LocationDTO dto);
	
	public List<LocationDTO> list();
	
	public List<LocationDTO>list(int pageNo,int pageSize);
	
	public List<LocationDTO> search(LocationDTO dto);
	
	public List<LocationDTO> search(LocationDTO dto,int pageNo,int pageSize);
	
}
