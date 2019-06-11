package pms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import pms.dto.HouseManagerDto;
import pms.entity.House;
import pms.entity.Owner;

public interface HouseRepository {

	/**
	 * -查询所有房屋信息HouseManagerDto
	 * @return
	 */
	@Select("") 
	public List<HouseManagerDto>  findAllHouseManagerDto();
	
	/**
	 * -删除房屋
	 * @param houseId
	 * @return
	 */
	@Delete("")
	public boolean deleteHouse(int houseId );
	
	/**
	 * -删除房屋业主关系
	 * * @param houseId
	 * @return
	 */
	@Delete("")
	public boolean deleteOwnerHouse(int houseId );
	
	/**
	 * -增加房屋信息
	 * @param House
	 * @return
	 */
	@Insert("")
	public Boolean addHouse(House house);
	
	
	/**
	 * -查询指定业主所有房屋信息
	 * @return
	 */
	@Select("") 
	public List<HouseManagerDto> findOwnerAllHourse(int ownerId);
	
	
	
	
	
	
	
}
















