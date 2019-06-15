package pms.repository;


import java.util.List;

import org.apache.ibatis.annotations.*;

import pms.dto.OwnerHouseDto;
import pms.dto.OwnerManagerDto;
import pms.entity.Manager;
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
	@Select("") 
	public List<OwnerManagerDto>  findAllOwnerManagerDto();
   
	/**
	 * -更新业主信息
	 * @param owner
	 * @return
	 */
	@Update("")
	public boolean UpdateOwner(Owner owner);
	
	/**
	 * -删除业主信息       
	 * @param ownerId
	 * @return
	 */
	@Delete("")
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
	@Insert("")
	public boolean addOwner(Owner owner);
	
	/**
	 * -增加业主房屋
	 * @param ownerHouseDto
	 * @return
	 */
	@Insert("")
	public boolean addOwnerHouse(OwnerHouseDto ownerHouseDto);
	

	/**
	 * -查询指定业主信息
	 * @return
	 */
	@Select("")		
	public Owner fingOwnerByOwnerId(int ownerId);	
	
	

	

	

}
