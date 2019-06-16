package pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dto.HouseManagerDto;
import pms.entity.House;
import pms.repository.HouseRepository;
	
	@Service
	public class HouseServiceImpl implements HouseService {
	@Autowired
	private HouseRepository houseRepository ;
	@Override
	
	public List<HouseManagerDto> findAllHouseManagerDto() {
	    List<HouseManagerDto>  list=houseRepository.findAllHouseManagerDto();
		return list;
	}

	@Override
	public boolean deleteHouse(int houseId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addHouse(String houseBuildingNumber, String houseUnit, String houseFloor, String houseNumber){
		return houseRepository.addHouse(houseBuildingNumber, houseUnit, houseFloor, houseNumber);
		
	}

	@Override
	public List<HouseManagerDto> findOwnerAllHourse(int ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<House> findAllHouse() {
	    List<House>  list=houseRepository.findAllHouse();
		return list;
	}


}
