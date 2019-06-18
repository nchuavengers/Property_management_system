package pms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pms.dto.FacilityManageDto;
import pms.entity.PublicUtility;

import pms.entity.RepairRecord;

/*
 * *用于增删查改公共设施数据
 * 15202137 汪浩 6.15
 * my batis
 */

@Mapper
public interface FacilityRepository {
   
	//-查询所有设备信息FacilityManageDto
	@Select("SELECT pms.`publicutility`.`publicUtilityId`,\r\n" + 
			"pms.`publicutility`.`publicUtilityName`,\r\n" + 
			"pms.`publicutility`.`publicUtilityType`,\r\n" + 
			"pms.`publicutility`.`publicUtilityStatus`,\r\n" + 
			"pms.`repairrecord`.`repairerInfomation`,\r\n" + 
			"pms.`repairrecord`.`repairMoney`,\r\n" + 
			"pms.`repairrecord`.`repairTime` \r\n" + 
			"FROM pms.`publicutility` LEFT OUTER JOIN  pms.`repairrecord` ON(pms.`publicutility`.`publicUtilityId`=pms.`repairrecord`.`publicUtilityId`);") 
	public List<FacilityManageDto>  findAllFacilityManageDto();
	
	//添加维修记录
	@Insert("INSERT INTO `pms`.`repairRecord` ( `publicUtilityId`,`repairerInfomation`,`repairMoney`,`repairTime`) "
			+ "VALUES (#{publicUtilityId},#{repairerInfomation},#{repairMoney},#{repairTime});")
	public boolean addRepairRecord(FacilityManageDto facilityManageDto);
	
    //-申请维修
  	@Update("UPDATE  pms.`publicutility` SET pms.`publicutility`.`publicUtilityStatus`='Repairing' WHERE  publicUtilityId=#{publicUtilityId};")
  	public boolean applyRequired(int publicUtilityId);
  	
  	
    // -完成维修(修改设施状态)更新维修记录
	@Update("UPDATE  pms.`publicutility` SET pms.`publicutility`.`publicUtilityStatus`='Well' WHERE  publicUtilityId=#{publicUtilityId}")
	public boolean updateRepairRecord(int publicUtilityId);
	
	//添加公共设施
	@Insert("INSERT INTO publicutility (publicUtilityName,publicUtilityType,publicUtilityStatus) VALUE(#{publicUtilityName},publicUtilityType,'Well');")
	public boolean addFacility(PublicUtility publicUtility);
	
	
	
	
}
