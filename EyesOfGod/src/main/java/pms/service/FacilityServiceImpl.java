package pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dto.FacilityManageDto;
import pms.entity.PublicUtility;
import pms.entity.RepairRecord;
import pms.repository.FacilityRepository;
/*
 * *用于实现公共设施服务接口
 * 15202137 汪浩 6.15
 * my batis
 */
@Service
public class FacilityServiceImpl implements FacilityService {
	@Autowired
	private FacilityRepository fr;
	@Override
	public List<FacilityManageDto> findAllFacilityManageDto() {
		
		return fr.findAllFacilityManageDto();
		
	}

	@Override
	public boolean doRepair(RepairRecord repairRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addFacility(PublicUtility publicUtility) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean finishedRepair(int ficilityId) {
		return fr.updateRepairRecord(ficilityId);
	}

	@Override
	public boolean applyRequired(int ficilityId) {
		return fr.applyRequired(ficilityId);
		
	}

	@Override
	public boolean finishedRepair(String ficilityId) {
		// TODO Auto-generated method stub
		return false;
	}

}
