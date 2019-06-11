package pms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pms.dto.FacilityManageDto;
import pms.entity.Owner;
import pms.entity.PublicUtility;
import pms.entity.RepairRecord;

public interface FacilityRepository {

	/**
	 * -查询所有设备信息FacilityManageDto
	 * @return
	 */
	@Select("") 
	public List<FacilityManageDto>  findAllFacilityManageDto();
	
	
	/**
	 * -增加维修记录
	 * @param RepairRecord
	 * @return
	 */
	@Insert("")
	public Boolean addRepairRecord(RepairRecord repairRecord);
	
	
	/**
	 * -完成维修(修改设施状态)更新维修记录
	 * @param  repairRecordId
	 * @return  
	 */
	@Update("")
	public boolean updateRepairRecord(int  repairRecordId);
	
	
	/**
	 * -添加公共设施
	 * @param publicUtility
	 * @return
	 */
	@Insert("")
	public boolean addFacility(PublicUtility publicUtility);
	
	
}
