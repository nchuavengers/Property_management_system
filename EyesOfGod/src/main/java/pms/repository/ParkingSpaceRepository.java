package pms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pms.dto.MyParkingSpaceDto;
import pms.dto.OwnerParkingSpaceDto;
import pms.dto.ParkingSpaceManagerDto;
import pms.entity.ParkingSpace;

@Mapper
public interface ParkingSpaceRepository {

	
	/**
	 * -修改车位信息   修改共享开始和结束时间
	 * @param parkingSpace
	 * @return
	 */
	@Update("update  pms.parkingspace set pms.parkingspace.shareingBeginTime=#{shareingBeginTime},\r\n" + 
			"pms.parkingspace.shareingEndingTime=#{shareingEndingTime} where pms.parkingspace.parkingSpaceId=#{parkingSpaceId}")
	public boolean UpdateParkingSpace(MyParkingSpaceDto myParkingSpaceDto);
	
	
	
	/**
	 * -查询业主所有车位信息   MyParkingSpaceDto
	 * @return
	 */
	@Select("select * from pms.parkingspace \r\n" + 
			"where pms.parkingspace.parkingSpaceId \r\n" + 
			"in(\r\n" + 
			"select pms.ownerparkingspace.parkingSpaceId from pms.ownerparkingspace,pms.owner\r\n" + 
			" where pms.owner.ownerId=#{ownerId} and pms.owner.ownerId=pms.ownerparkingspace.ownerId\r\n" + 
			");") 
	public List<MyParkingSpaceDto>   findOwnerParkingSpace(int ownerId);
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * -查询所有车位信息ParkingSpaceManagerDto
	 * @return
	 */
	@Select("") 
	public List<ParkingSpaceManagerDto> findAllParkingSpaceManagerDto();
	/**
	 * -删除车位信息       
	 * @param parkingSpaceId
	 * @return
	 */
	@Delete("")
	public boolean deleteParkingSpace(int parkingSpaceId );
	
	/**
	 * -删除业主车位（一个车位属于一个业主，根据车位删除关系）
	 * @param parkingSpaceId
	 * @return
	 */
	@Delete("")
	public boolean deleteOwnerSparkingSpace(int parkingSpaceId);
	
	
	/**
	 * -添加车位
	 * @param ParkingSpace
	 * @return
	 */
	@Insert("")
	public boolean addParkingSpacer(ParkingSpace ParkingSpace);
	
	
	/**
	 * -添加业主车位
	 * @param ownerParkingSpaceDto
	 * @return
	 */
	@Insert("")
	public boolean addOwnerParkingSpace(OwnerParkingSpaceDto ownerParkingSpaceDto);
	

}
