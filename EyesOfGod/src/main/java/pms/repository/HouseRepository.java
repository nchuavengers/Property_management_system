package pms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import pms.dto.HouseManagerDto;
import pms.entity.House;
import pms.entity.Owner;

@Mapper
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
	public boolean addHouse(House house);
	
	
	/**
	 * -查询指定业主所有房屋信息
	 * @return
	 */
	@Select("") 
	public List<HouseManagerDto> findOwnerAllHourse(int ownerId);
	
	
	
	/**
	 * -查询指定房屋信息
	 * @return
	 */
	@Select("SELECT * FROM pms.house where houseId=#{houseId};")		
	public House fingHouseByHouseId(int houseId);
	
	
	/**
	 * -查询房屋是否有业主
	 * @return
	 */
	@Select("SELECT ownerId FROM pms.ownerhouse where houseId=#{houseId};")
	public int IsHouseFromOwnerHouse(int houseId);
	
	
}
















