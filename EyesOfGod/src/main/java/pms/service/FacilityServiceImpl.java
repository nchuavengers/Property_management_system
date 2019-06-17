package pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dto.FacilityManageDto;
import pms.entity.PublicUtility;
import pms.entity.RepairRecord;
import pms.repository.FacilityRepository;
@Service
public class FacilityServiceImpl implements FacilityService {
	@Autowired
	private FacilityRepository fr;
	@Override
	public List<FacilityManageDto> findAllFacilityManageDto() {
		List<FacilityManageDto> list=fr.findAllFacilityManageDto();
		
		return list;
		
	}

	@Override
	public boolean doRepair(RepairRecord repairRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addFacility(PublicUtility publicUtility) {
		// TODO Auto-generated method stub
		return fr.addFacility(publicUtility);
	}

	@Override
	public boolean finishedRepair(int ficilityId) {
		return fr.updateRepairRecord(ficilityId);
	}

	@Override
	public boolean applyRequired(FacilityManageDto facilityManageDto) {
		boolean a=fr.applyRequired(facilityManageDto.getPublicUtilityId());
		boolean b=fr.addRepairRecord(facilityManageDto);
		return a&b;
		
	}

	@Override
	public boolean finishedRepair(String ficilityId) {
		// TODO Auto-generated method stub
		return false;
	}

}
