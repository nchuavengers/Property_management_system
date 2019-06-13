package pms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import pms.entity.Manager;

@Mapper
public interface ManagerRepository {
	

	/**
	 * -核实管理员身份
	 * @param 手机号  12345678910
	 * @param 密码  123456
	 * @return  Manager 管理员对象
	 */
	@Select("select * from pms.manager where managerPhoneNumber=#{managerPhoneNumber} and managerPassword=#{managerPassword}")
	public Manager validManager(@Param("managerPhoneNumber")String managerPhoneNumber , @Param("managerPassword")String managerPassword); 
	
	
	
//	@Select("select * from t_teacher where teacher_account=#{account} and teacher_password=md5(#{password})")
//	public Teacher validTeacher(@Param("account")String account,@Param("password")String password);
	
}
