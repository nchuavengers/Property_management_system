package pms.service;
import java.util.List;
import org.springframework.stereotype.Service;
import pms.dto.FacilityManageDto;
import pms.entity.PublicUtility;
import pms.entity.RepairRecord;
/*
 * *用于调用仓储层增删查改公共设施数据
 * 15202137 汪浩 6.15
 * my batis
 */
@Service
public interface FacilityService {

	
	/**
	 * -查询所有设备信息FacilityManageDto
	 * @return
	 */
	public List<FacilityManageDto>  findAllFacilityManageDto();
	
	/**
	 * --登记维修（添加维修记录）
	 * @param RepairRecord
	 * @return
	 */
	public boolean doRepair(RepairRecord repairRecord);
	
	
	/**
	 * -完成维修(修改设施状态)
	 * @param  ficilityId
	 * @return  
	 */
	public boolean finishedRepair(String  ficilityId);
	
	/**
	 * -添加公共设施
	 * @param publicUtility
	 * @return
	 */
	public boolean addFacility(PublicUtility publicUtility);

	public boolean applyRequired(int ficilityId);

	public boolean finishedRepair(int ficilityId);
	
	
	
	
	
	
	
	
	
	
	
	
}
