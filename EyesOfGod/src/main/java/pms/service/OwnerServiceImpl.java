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
		boolean b=ownerRepository.deleteOwner(ownerId);
		return b;
	}

	@Override
	public boolean addOwner(Owner owner) {
		boolean b=ownerRepository.addOwner(owner);
		return b;
	}

	@Override
	public boolean addOwnerHouse(OwnerHouseDto ownerHouseDto) {

		boolean b=ownerRepository.addOwnerHouse(ownerHouseDto);
		return b;
	}

	@Override
	public Owner findOwner(int ownerId) {

		return ownerRepository.fingOwnerByOwnerId(ownerId);
	}

}
