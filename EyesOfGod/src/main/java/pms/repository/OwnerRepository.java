package pms.repository;


import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import pms.entity.Owner;


@Mapper
public interface OwnerRepository {
	
	
	/*验证账号有效validTeacher()
	 * 
	 * 
	 */
	@Select("")
//	@ResultMap(value="teacherMap")
	public Owner validOwner();
	 
    /*查询所有业主findAllOwner()	
     * *入口：无
     * *出口：List<Owner>
     */
	@Select("") 
	public List<Owner> findAllOwner();

	
    /*增加业主addOwner()
     * *入口：Owner owner
     * *出口：List<Owner>
     */
	@Insert("")
	public Boolean addOwner(Owner owner);
	
    /*删除业主deleteOwner()
     * 
     */
	@Delete("")
	public Boolean deleteOwner();
	
    /*修改业主modifyOwner()
     * 
     */
	@Update({ })
	public Boolean  modifyOwner();

    /*查询指定业主fingOwnerByOwnerId()  
     * *入口：无
     * *出口：Owner
     */
	@Select("")		
	public Owner fingOwnerByOwnerId();	
	
	

	

	

}
