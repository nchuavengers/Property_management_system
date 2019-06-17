package pms.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pms.dto.HouseManagerDto;
import pms.entity.House;

@Mapper
public interface HouseService {

	/**
	 * -查询所有房屋信息HouseManagerDto
	 * @return
	 */
	public List<HouseManagerDto>  findAllHouseManagerDto();
	
	
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
	public boolean addHouse(House house );
	
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
