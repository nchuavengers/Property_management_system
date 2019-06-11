package pms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pms.dto.MyParkingSpaceDto;
import pms.dto.OwnerHouseDto;
import pms.dto.OwnerParkingSpaceDto;
import pms.dto.ParkingSpaceManagerDto;
import pms.entity.Owner;
import pms.entity.ParkingSpace;

public interface ParkingSpaceRepository {

	/**
	 * -查询所有车位信息ParkingSpaceManagerDto
	 * @return
	 */
	@Select("") 
	public List<ParkingSpaceManagerDto> findAllParkingSpaceManagerDto();
	
	/**
	 * -修改车位信息
	 * @param parkingSpace
	 * @return
	 */
	@Update("")
	public boolean UpdateParkingSpace(ParkingSpace parkingSpace);
	
	
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
	public Boolean addParkingSpacer(ParkingSpace ParkingSpace);
	
	
	/**
	 * -添加业主车位
	 * @param ownerParkingSpaceDto
	 * @return
	 */
	@Insert("")
	public boolean addOwnerParkingSpace(OwnerParkingSpaceDto ownerParkingSpaceDto);
	

	
	/**
	 * -查询业主所有车位信息   MyParkingSpaceDto
	 * @return
	 */
	@Select("") 
	public List<MyParkingSpaceDto>   findOwnerParkingSpace(int ownerId);
	

	
	
	
	
}
