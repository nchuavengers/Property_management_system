package pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dto.HouseManagerDto;
import pms.entity.House;
import pms.repository.HouseRepository;
@Service
public class HouseServiceImpl implements HouseService{

	@Autowired 
	private HouseRepository houseRepository;
	@Override
	public List<HouseManagerDto> findAllHouseManagerDto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteHouse(int houseId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addHouse(House house) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HouseManagerDto> findOwnerAllHourse(int ownerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public House fingHouseByHouseId(int houseId) {		
		return houseRepository.fingHouseByHouseId(houseId);
	}

	@Override
	public int IsHouseFromOwnerHouse(int houseId) {
 
		return houseRepository.IsHouseFromOwnerHouse(houseId);
	}
	
	
	

}
