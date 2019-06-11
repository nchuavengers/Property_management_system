package pms.service;

import pms.dto.UserDto;
import pms.entity.Manager;
import pms.entity.Owner;
import pms.entity.Security;

public interface HomeService {

	/**
	 * -验证是否是管理员
	 * @param ud
	 * @return Manager 对象
	 */
	public Manager validManager(UserDto ud);

	/**
	 * -验证是否是业主
	 * @param ud
	 * @return Owner 业主对象
	 */
	public Owner validOwner(UserDto ud); 

	/**
	 * -验证是否是保安
	 * @param ud
	 * @return  Security 保安对象
	 */
	public Security validSecurity(UserDto ud);  
}
