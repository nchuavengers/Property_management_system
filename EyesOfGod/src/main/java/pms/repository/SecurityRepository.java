package pms.repository;

import java.util.List;

import org.apache.ibatis.annotations.*;

import pms.dto.AllDayShareDto;
import pms.dto.BlurOueryDto;
import pms.dto.TemporayShareDto;
import pms.dto.VisitorCarDto;
import pms.entity.Owner;
import pms.entity.Security;
import pms.entity.VisitorRecord;

/*
 * -保安页面所需repo
 */
@Mapper
public interface SecurityRepository {

	/**
	 * -核实保安身份
	 * @param account 手机号
	 * @param password
	 * @return  Security 保安对象
	 */ 
	@Select("select * from pms.security where securityPhoneNumber=#{securityPhoneNumber} and securityPassword=#{securityPassword}")
	public Security validSecurity(@Param("securityPhoneNumber")String securityPhoneNumber , @Param("securityPassword")String securityPassword); 
	
	/**
	 * -展示当前访客车辆 离开小区时间为空
	 * @return
	 */
	@Select("SELECT *\r\n" + 
			" FROM pms.visitorrecord,pms.parkingspace\r\n" + 
			" where pms.visitorrecord.departureTime is null \r\n" + 
			" and pms.parkingspace.parkingSpaceId=pms.visitorrecord.parkingSpaceId") 
	public List<VisitorCarDto> findNowVisitor();
    
	
	
	/**
	 * -全天可用共享车辆
	 * @return
	 */
	@Select("select pms.parkingspace.parkingSpaceId,pms.parkingspace.parkingSpaceLocation "
			+ "from pms.parkingspace \r\n" + 
			"where pms.parkingspace.parkingSpaceType=1 and pms.parkingspace.parkingSpaceStatus=1") 
	public List<AllDayShareDto> fingAllDayShareParkingSpace();

	
	
	
	/**
	 * -临时可用共享车辆
	 * @return
	 */
	@Select("select      pms.parkingspace.parkingSpaceId,\r\n" + 
			"     parkingSpaceLocation,\r\n" + 
			"     shareingBeginTime,\r\n" + 
			"     shareingEndingTime,\r\n" + 
			"     ownerName,\r\n" + 
			"     ownerPhoneNumber\r\n" + 
			"     \r\n" + 
			"     from pms.owner,pms.ownerparkingspace,pms.parkingspace\r\n" + 
			"where \r\n" + 
			" to_days(pms.parkingspace.shareingBeginTime) = to_days(now())\r\n" + 
			"and\r\n" + 
			"pms.owner.ownerId=pms.ownerparkingspace.ownerId \r\n" + 
			"and\r\n" + 
			" pms.parkingspace.parkingSpaceId=pms.ownerparkingspace.parkingSpaceId ") 
	public List<TemporayShareDto> FindTemporayShareParkingSpace();
	
	
	
	
	
	/**
	 * -更新访客记录离开小区修改该访问记录（可选择缴费)   修改离开时间  缴费金额   触发器 车位状态为1
	 * @param visitorRecord
	 * @return
	 */
	@Update(" update  pms.visitorrecord set \r\n" + 
			"pms.visitorrecord.departureTime =#{departureTime},\r\n" + 
			"pms.visitorrecord.paymentMoney=#{paymentMoney}\r\n" + 
			" where pms.visitorrecord.visitorId=#{visitorId}  ")
	public boolean updateVisitorRecord(VisitorRecord visitorRecord);
	
	
	
	
	
	
	
	//判断车位是否存在
	@Select("select  if(count(parkingSpaceId)!=0,1,0) from pms.parkingspace where pms.parkingspace.parkingSpaceId=#{parkingSpaceId}")
	public boolean IsExistParkingSpace(int parkingSpaceId);
	
    //判断车位状态是否为1   
	@Select("select if(count(parkingSpaceId)!=0,1,0) from pms.parkingspace\r\n" + 
			" where pms.parkingspace.parkingSpaceStatus=1\r\n" + 
			" and pms.parkingspace.parkingSpaceId=#{parkingSpaceId}")
	public boolean IsEmployed(int parkingSpaceId);
	/**
	 * -添加新访客
	 * @param visitorRecord
	 * @return
	 */
	@Insert("INSERT INTO `pms`.`visitorRecord` ( `parkingSpaceId`,`securityId`,`licensePlate`,`entryTime`,`departureTime`,`paymentMoney`) "
			+ "VALUES (#{parkingSpaceId},'1000',#{licensePlate},#{entryTime},null,null);")
	public boolean addVisitor(VisitorRecord visitorRecord);
	
	
	
	/**
	 * -返回业主车位编号或者0
	 * @return
	 */
	@Select("select  pms.owner.ownerId,ownerName,ownerPhoneNumber,ownerSex,pms.parkingspace.parkingSpaceId,parkingSpaceLocation\r\n" + 
			" from pms.owner ,pms.parkingspace,pms.ownerparkingspace\r\n" + 
			" where\r\n" + 
			" pms.owner.ownerId=pms.ownerparkingspace.ownerId \r\n" + 
			"and \r\n" + 
			"pms.parkingspace.parkingSpaceId=pms.ownerparkingspace.parkingSpaceId\r\n" + 
			"and \r\n" + 
			"pms.parkingspace.parkingSpaceId \r\n" + 
			"in(\r\n" + 
			"select pms.parkingspace.parkingSpaceId  \r\n" + 
			"from pms.owner ,pms.parkingspace\r\n" + 
			"where \r\n" + 
			"ownerName like concat('%',#{string},'%')\r\n" + 
			"or ownerPhoneNumber like concat('%',#{string},'%')\r\n" + 
			"or parkingSpaceLocation like concat('%',#{string},'%')\r\n" + 
			" and pms.parkingspace.parkingSpaceId\r\n" + 
			");") 
	public List<BlurOueryDto> FindOwnerParkingSpace(String string);
	
	
	
	
}





