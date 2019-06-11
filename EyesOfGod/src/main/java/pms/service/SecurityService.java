package pms.service;

import java.util.List;

import pms.dto.AllDayShareDto;
import pms.dto.TemporayShareDto;
import pms.dto.VisitorCarDto;
import pms.entity.VisitorRecord;

/*
 * 
 * --保安页面所需service
 */
public interface SecurityService {

	

	/**
	 * -展示当前访客车辆
	 * @return
	 */
	public List<VisitorCarDto> findNowVisitor();

	/**
	 * -全天可用共享车辆
	 * @return
	 */
	public List<AllDayShareDto> fingAllDayShareParkingSpace();

	/**
	 * -临时可用共享车辆
	 * @return
	 */
	public List<TemporayShareDto> FingTemporayShareParkingSpace();
	
	/**
	 * -更新访客记录离开小区修改该访问记录（可选择缴费
	 * @param visitorRecord
	 * @return
	 */
	public boolean updateVisitorRecord(VisitorRecord visitorRecord);
	
	
	/**
	 * -添加访客
	 * @param visitorRecord
	 * @return
	 */
	public boolean addVisitor(VisitorRecord visitorRecord);
	
	/**
	 * -返回业主车位编号或者0
	 * @return
	 */
	public int FindOwnerParkingSpace(String a);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
