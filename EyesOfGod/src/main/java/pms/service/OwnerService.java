package pms.service;

import java.util.List;

import pms.dto.OwnerHouseDto;
import pms.dto.OwnerManagerDto;
import pms.entity.Owner;

public interface OwnerService {

	/**
	 * -查询所有业主信息OwnerManagerDto
	 * @return
	 */
	public List<OwnerManagerDto>  findAllOwnerManagerDto();

	/**
	 * -修改业主信息
	 * @param  owner
	 * @return  
	 */
	public boolean UpdateOwner(Owner owner);
	
	/**
	 * -删除业主
	 * --同时删除业主房屋，业主车位
	 * @param ownerId
	 * @return
	 */
	public boolean deleteOwner(int ownerId );
	
	/**
	 * -增加业主信息
	 * @param owner
	 * @return
	 */
	public boolean addOwner(Owner owner );
	
	/**
	 * -增加业主房屋
	 * @param ownerHouseDto
	 * @return
	 */
	public boolean addOwnerHouse(OwnerHouseDto ownerHouseDto);
	
	/**
	 * -查询指定业主信息
	 * @return
	 */
	public Owner findOwner(int ownerId);
	
	
	
	
	
	
	
	
}
