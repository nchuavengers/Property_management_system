package pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dto.OwnerHouseDto;
import pms.dto.OwnerManagerDto;
import pms.entity.Owner;
import pms.repository.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;	
	
	@Override
	public List<OwnerManagerDto> findAllOwnerManagerDto() {

		List<OwnerManagerDto> list  = ownerRepository.findAllOwnerManagerDto();
		
		return list;
	}

	@Override
	public boolean UpdateOwner(Owner owner) {
		boolean b=ownerRepository.UpdateOwner(owner);
		return b;
	}

	@Override
	public boolean deleteOwner(int ownerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addOwner(Owner owner) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addOwnerHouse(OwnerHouseDto ownerHouseDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Owner findOwner(int ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
