package pms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pms.dto.FacilityManageDto;
import pms.entity.Owner;
import pms.entity.PublicUtility;
import pms.entity.RepairRecord;

/*
 * *用于增删查改公共设施数据
 * 15202137 汪浩 6.15
 * my batis
 */
@Mapper
public interface FacilityRepository {

	/**
	 * -查询所有设备信息FacilityManageDto
	 * @return
	 */
	@Select("SELECT pms.`publicutility`.`publicUtilityId`,\r\n" + 
			"pms.`publicutility`.`publicUtilityName`,\r\n" + 
			"pms.`publicutility`.`publicUtilityType`,\r\n" + 
			"pms.`publicutility`.`publicUtilityStatus`,\r\n" + 
			"pms.`repairrecord`.`repairerInfomation`,\r\n" + 
			"pms.`repairrecord`.`repairMoney`,\r\n" + 
			"pms.`repairrecord`.`repairTime` \r\n" + 
			"FROM pms.`publicutility` LEFT OUTER JOIN  pms.`repairrecord` ON(pms.`publicutility`.`publicUtilityId`=pms.`repairrecord`.`publicUtilityId`);") 
	public List<FacilityManageDto>  findAllFacilityManageDto();
	
	
	//"UPDATE pms.owner SET ownerPhoneNumber=#{ownerPhoneNumber},ownerPassword=#{ownerPassword} WHERE  ownerId=#{ownerId};"
	// UPDATE  pms.`publicutility` SET pms.`publicutility`.`publicUtilityStatus`='Repairing111' WHERE  publicUtilityId=#{publicUtilityId};
    @Update("UPDATE  pms.`publicutility` SET pms.`publicutility`.`publicUtilityStatus`='Repairing' WHERE  publicUtilityId=#{publicUtilityId}")
	public boolean addRepairRecord(int publicUtilityId);
	
	
	/**
	 * -完成维修(修改设施状态)更新维修记录
	 * @param  repairRecordId
	 * @return  
	 */
	//"UPDATE pms.owner SET ownerPhoneNumber=#{ownerPhoneNumber},ownerPassword=#{ownerPassword} WHERE  ownerId=#{ownerId};"
	// UPDATE  pms.`publicutility` SET pms.`publicutility`.`publicUtilityStatus`='Repairing111' WHERE  publicUtilityId=#{publicUtilityId};
    @Update("UPDATE  pms.`publicutility` SET pms.`publicutility`.`publicUtilityStatus`='Well' WHERE  publicUtilityId=#{publicUtilityId}")
	public boolean updateRepairRecord(int publicUtilityId);
	
	
	/**
	 * -添加公共设施
	 * @param publicUtility
	 * @return
	 */
	@Insert("")
	public boolean addFacility(PublicUtility publicUtility);
	
	/**
	 * -申请维修
	 * @param publicUtility
	 * @return
	 */
	@Update("UPDATE  pms.`publicutility` SET pms.`publicutility`.`publicUtilityStatus`='Repairing' WHERE  publicUtilityId=#{publicUtilityId};")
	public boolean applyRequired(int  publicUtilityId);
	
}
