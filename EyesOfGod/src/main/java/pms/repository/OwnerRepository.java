package pms.repository;


import java.util.List;

import org.apache.ibatis.annotations.*;

import pms.dto.OwnerHouseDto;
import pms.dto.OwnerManagerDto;
import pms.entity.Owner;


@Mapper
public interface OwnerRepository {
	

	/**
	 * -核实业主身份
	 * @param account
	 * @param password
	 * @return  Owner 业主对象
	 */
	@Select("select * from pms.owner where ownerPhoneNumber=#{ownerPhoneNumber} and ownerPassword=#{ownerPassword}")
	public Owner validOwner(@Param("ownerPhoneNumber")String ownerPhoneNumber , @Param("ownerPassword")String ownerPassword); 
	 
	/**
	 * -查询所有业主信息OwnerManagerDto
	 * @return
	 */

//	select pms.owner.ownerId,ownerName,ownerPhoneNumber,ownerSex,ownerPassword,houseNumber,houseBuildingNumber,houseUnit,houseFloor
//	from pms.house,pms.owner,pms.ownerhouse
//	where pms.house.houseId=pms.ownerhouse.houseId and pms.owner.ownerId=pms.ownerhouse.ownerId;
	
//	SELECT  o1.ownerId,o1.ownerName,o1.ownerPhoneNumber,o1.ownerSex,o1.ownerPassword,
//	h1.houseNumber,h1.houseBuildingNumber,h1.houseUnit,h1.houseFloor
//	FROM (pms.owner o1  LEFT OUTER JOIN pms.ownerhouse oh1 ON(oh1.ownerId= o1.ownerId)
//
//	 left OUTER JOIN pms.house h1 ON(h1.houseId= oh1.houseId))
//	;
	@Select("	SELECT  o1.ownerId,o1.ownerName,o1.ownerPhoneNumber,o1.ownerSex,o1.ownerPassword,\n" + 
			"h1.houseNumber,h1.houseBuildingNumber,h1.houseUnit,h1.houseFloor\n" + 
			"FROM (pms.owner o1  LEFT OUTER JOIN pms.ownerhouse oh1 ON(oh1.ownerId= o1.ownerId)\n" + 
			"\n" + 
			" left OUTER JOIN pms.house h1 ON(h1.houseId= oh1.houseId))\n" + 
			";") 

	public List<OwnerManagerDto>  findAllOwnerManagerDto();
   
	/**
	 * -更新业主信息
	 * @param owner
	 * @return
	 */
	@Update("UPDATE pms.owner SET ownerPhoneNumber=#{ownerPhoneNumber},ownerPassword=#{ownerPassword} WHERE  ownerId=#{ownerId};")
	public boolean UpdateOwner(Owner owner);
	
	/**
	 * -删除业主信息       （触发器 房屋  车位  消费  缴费 ）
	 * @param ownerId
	 * @return
	 */
	@Delete("delete from pms.owner where ownerId=#{ownerId}")
	public boolean deleteOwner(int ownerId );
	
	/**
	 * -删除业主所有房屋
	 * @param ownerId
	 * @return
	 */
	@Delete("")
	public boolean deleteOwnerHouse(int ownerId );
	
	/**
	 * -删除业主所有车位
	 * @param ownerId
	 * @return
	 */
	@Delete("")
	public boolean deleteOwnerSparkingSpace(int ownerId );
	
	/**
	 * -增加业主信息
	 * @param owner
	 * @return
	 */
	@Insert("INSERT INTO `pms`.`owner` ( `ownerName`,`ownerPhoneNumber`,`ownerSex`,`ownerPassword`) VALUES (#{ownerName},#{ownerPhoneNumber},#{ownerSex},#{ownerPassword});")
	public boolean addOwner(Owner owner);
	
	
	
	
	/**
	 * -增加业主房屋
	 * @param ownerHouseDto
	 * @return
	 */
	@Insert("INSERT INTO `pms`.`ownerHouse` ( `ownerId`,`houseId`) VALUES (#{ownerId},#{houseId});")
	public boolean addOwnerHouse(OwnerHouseDto ownerHouseDto);
	

	/**
	 * -查询指定业主信息
	 * @return
	 */
	@Select("SELECT * FROM pms.owner where ownerId=#{ownerId};")		
	public Owner fingOwnerByOwnerId(int ownerId);	
	
	
}
