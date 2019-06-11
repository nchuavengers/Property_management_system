package pms.repository;

import java.util.List;

import org.apache.ibatis.annotations.*;

import pms.dto.AllDayShareDto;
import pms.dto.TemporayShareDto;
import pms.dto.VisitorCarDto;
import pms.entity.Owner;
import pms.entity.Security;
import pms.entity.VisitorRecord;

/*
 * -保安页面所需repo
 */
public interface SecurityRepository {

	/**
	 * -核实保安身份
	 * @param account
	 * @param password
	 * @return  Security 保安对象
	 */
	@Select("") 
	public Security validSecurity(int account , String password); 
	 
	
	/**
	 * -展示当前访客车辆
	 * @return
	 */
	@Select("") 
	public List<VisitorCarDto> findNowVisitor();

	/**
	 * -全天可用共享车辆
	 * @return
	 */
	@Select("") 
	public List<AllDayShareDto> fingAllDayShareParkingSpace();

	/**
	 * -临时可用共享车辆
	 * @return
	 */
	@Select("") 
	public List<TemporayShareDto> FingTemporayShareParkingSpace();
	
	/**
	 * -更新访客记录离开小区修改该访问记录（可选择缴费
	 * @param visitorRecord
	 * @return
	 */
	@Update("")
	public boolean updateVisitorRecord(VisitorRecord visitorRecord);
	
	
	/**
	 * -添加访客
	 * @param visitorRecord
	 * @return
	 */
	@Insert("")
	public boolean addVisitor(VisitorRecord visitorRecord);
	
	/**
	 * -返回业主车位编号或者0
	 * @return
	 */
	@Select("") 
	public int FindOwnerParkingSpace(String a);
}
