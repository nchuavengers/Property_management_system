package pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dto.UserDto;
import pms.entity.Manager;
import pms.entity.Owner;
import pms.entity.Security;
import pms.repository.ManagerRepository;
import pms.repository.OwnerRepository;
import pms.repository.SecurityRepository;

@Service
public class HomeServiceImpl implements HomeService{

    @Autowired
    private ManagerRepository managerRepository;		
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private SecurityRepository securityRepository;
	
    //1.判断管理员账号密码 
	@Override
	public Manager validManager(UserDto userDto) {
		
		Manager manager=managerRepository.validManager(userDto.getUserAccount(),userDto.getUserPassword());
		
		return manager;

	}

	//2.判断业主账号密码
	@Override
	public Owner validOwner(UserDto userDto) {
		
		Owner owner=ownerRepository.validOwner(userDto.getUserAccount(),userDto.getUserPassword());
		
		return owner;
	}

    //3.判断保安账号密码 
	@Override
	public Security validSecurity(UserDto userDto) {

		Security security=securityRepository.validSecurity(userDto.getUserAccount(),userDto.getUserPassword());
		
		return security;

	}

}
