package pms.service;

import java.util.List;


import org.springframework.stereotype.Service;

import pms.dto.HouseManagerDto;
import pms.entity.House;


@Service
public interface HouseService {
	/**
	 * -查询所有房屋信息HouseManagerDto
	 * @return
	 */
	public List<HouseManagerDto>  findAllHouseManagerDto();
	public List<House>  findAllHouse();
	
	/**
	 * -删除房屋信息
	 * --同时删除业主关系
	 * @param ownerId
	 * @return
	 */
	public boolean deleteHouse(int houseId );
	
	
	/**
	 * -增加房屋信息
	 * @param House
	 * @return
	 */
	public boolean addHouse(String houseBuildingNumber, String houseUnit, String houseFloor, String houseNumber);
	
	/**
	 * -查询指定业主所有房屋信息
	 * @return
	 */
	public List<HouseManagerDto> findOwnerAllHourse(int ownerId);



	
	/**
	 * -查询指定业主所有房屋信息
	 * @return
	 */
	public House fingHouseByHouseId(int houseId);
	
	/**
	 * -查询房屋是否有业主
	 * 返回业主id
	 * @return
	 */
	public int IsHouseFromOwnerHouse(int houseId);
}
