package in.co.grade.sys.dao;

import java.util.List;

import in.co.grade.sys.dto.ResultDTO;


public interface ResultDAOInt {

	public long add(ResultDTO dto);
	
	public void delete(ResultDTO dto);
	
	public ResultDTO findBypk(long pk);
	
	public ResultDTO findByName(String name);
	
	public void update(ResultDTO dto);
	
	public List<ResultDTO> list();
	
	public List<ResultDTO>list(int pageNo,int pageSize);
	
	public List<ResultDTO> search(ResultDTO dto);
	
	public List<ResultDTO> search(ResultDTO dto,int pageNo,int pageSize);
	
}
