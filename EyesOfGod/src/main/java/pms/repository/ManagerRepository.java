package pms.repository;

import org.apache.ibatis.annotations.Select;

import pms.entity.Manager;
import pms.entity.Owner;

public interface ManagerRepository {
	

	/**
	 * -核实管理员身份
	 * @param account
	 * @param password
	 * @return  Manager 管理员对象
	 */
	@Select("") 
	public Manager validManager(int account , String password); 
}
