package pms.service;

import java.util.List;

import pms.dto.MyParkingSpaceDto;
import pms.dto.OwnerHouseDto;
import pms.dto.OwnerParkingSpaceDto;
import pms.dto.ParkingSpaceManagerDto;
import pms.entity.Owner;
import pms.entity.ParkingSpace;



public interface ParkingSpaceService {

	/**
	 * -查询所有车位信息ParkingSpaceManagerDto
	 * @return
	 */
	public List<ParkingSpaceManagerDto> findAllParkingSpaceManagerDto();
	
	/**
	 * -修改业主车位
	 * @param parkingSpace
	 * @return
	 */
	public boolean UpdateOwner(ParkingSpace parkingSpace);
	
	/**
	 * -删除车位
	 * --同时删除业主关系
	 * @param parkingSpaceId
	 * @return
	 */
	public boolean deleteParkingSpace(int parkingSpaceId );
	
	/**
	 * -添加车位
	 * @param parkingSpace
	 * @return
	 */
	public boolean addParkingSpace(ParkingSpace parkingSpace );
	
	/**
	 * -添加业主车位
	 * @param ownerParkingSpaceDto
	 * @return
	 */
	public boolean addOwnerParkingSpace(OwnerParkingSpaceDto ownerParkingSpaceDto);
	
	
	/**
	 * -查询业主所有车位信息   MyParkingSpaceDto
	 * @return
	 */
	public List<MyParkingSpaceDto>   findOwnerParkingSpace(int ownerId);
	
	
	/**
	 * -设置共享时间
	 * @param ParkingSpaceDto
	 * @return
	 */
	public boolean setShareTime(ParkingSpace parkingSpaceDto);
	
	
	/**
	 * -重置共享时间
	 * @param MyParkingSpaceDto
	 * @return
	 */
	public boolean resetShareTime(ParkingSpace parkingSpaceDto);
}

























