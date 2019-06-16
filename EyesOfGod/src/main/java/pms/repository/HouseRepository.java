package pms.repository;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
	@Select("SELECT pms.`house`.`houseId`, pms.`house`.`houseBuildingNumber`, pms.`house`.`houseUnit`,pms.`house`.`houseFloor`, pms.`house`.`houseNumber`,pms.`owner`.`ownerName`, pms.`owner`.`ownerPhoneNumber` FROM pms.house,pms.owner,pms.ownerhouse WHERE pms.house.houseId=pms.ownerhouse.houseId AND pms.owner.ownerId=pms.ownerhouse.ownerId;") 
	public List<HouseManagerDto>  findAllHouseManagerDto();
	
	@Select("SELECT pms.`house`.`houseId`, pms.`house`.`houseBuildingNumber`, pms.`house`.`houseUnit`,pms.`house`.`houseFloor`, pms.`house`.`houseNumber`FROM pms.house;") 
	public List<House>  findAllHouse();
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
	//INSERT INTO pms.`house`   ( pms.`house`.`houseId`, pms.`house`.`houseNumber`, pms.`house`.`houseBuildingNumber`, pms.`house`.`houseUnit`,pms.`house`.`houseFloor`  ) VALUE(#{houseBuildingNumber},#{houseUnit},#{houseFloor},#{houseNumber}) ;
	@Insert("INSERT INTO pms.`house`"
		+ "(pms.`house`.`houseBuildingNumber`, pms.`house`.`houseUnit`,pms.`house`.`houseFloor`,pms.`house`.`houseNumber`) "
			+ "VALUE(#{houseBuildingNumber},#{houseUnit},#{houseFloor},#{houseNumber}) ;")
	public boolean addHouse(
			@Param("houseBuildingNumber") String houseBuildingNumber,
			@Param("houseUnit") String houseUnit,
			@Param("houseFloor") String houseFloor,
			@Param("houseNumber") String houseNumber
			);
	
	
	/**
	 * -查询指定业主所有房屋信息
	 * @return
	 */
	@Select("") 
	public List<HouseManagerDto> findOwnerAllHourse(int ownerId);
	
	
	
	
	
	
	
}
















