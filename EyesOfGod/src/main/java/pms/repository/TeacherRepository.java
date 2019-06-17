package pms.repository;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import pms.entity.Manager;
import pms.entity.testtime;

@Mapper
public interface TeacherRepository {
	
	
	@Select("select * from `pms`.`datetime` where id=#{id}") 
	public testtime findTime(int id);
	
	@Insert("INSERT INTO `pms`.`datetime` (`id`, `date`) VALUES (#{id},#{date} )")
	public Boolean addTime(testtime d);
	
	
	
//	@Results(id="teacherMap", value={ 
//    @Result(property = "id", column = "teacher_id",  jdbcType=JdbcType.INTEGER), 
//    @Result(property = "account", column = "teacher_account"),
//    @Result(property = "name", column = "teacher_name")
//	})
//
//	@Select("select * from t_teacher") 
//	public List<Teacher> findAll();
//	
//	@Select("select * from t_teacher where teacher_account=#{account} and teacher_password=md5(#{password})")
//	@ResultMap(value="teacherMap")
//	public Teacher validTeacher(@Param("account")String account,@Param("password")String password);
//	
//	@Select("select * from t_teacher where teacher_name like concat('%',#{name},'%')")
//	@ResultMap(value="teacherMap")			
//	public List<Teacher> findByName(@Param("name")String name);
//	
//	@Insert("INSERT INTO `lab`.`t_teacher` (`teacher_account`, `teacher_password`, `teacher_name`) VALUES (#{account}, md5(#{password}), #{name})")
//	@ResultMap(value="teacherMap")
//	public Boolean addTeacher(Teacher teacher);
}
//@Repository
//public class TeacherRepository {	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;	
//	public List<Teacher> findAll(){		
//		String sql="select teacher_id as id,teacher_account as account,teacher_name as name from t_teacher ";		
//		RowMapper<Teacher> rowMapper=new BeanPropertyRowMapper<Teacher>(Teacher.class);
//		List<Teacher> teachers= jdbcTemplate.query(sql, rowMapper);
//		for (Teacher teacher : teachers) {//
//		    System.out.println(teacher.getName());
//		}
//		return teachers;
//	}
//	
//	public Teacher validTeacher(String account,String password) {
//		String sql="select teacher_id as id,teacher_account as account,teacher_name as name from t_teacher where teacher_account=? and teacher_password=md5(?)";		
//		//jdbc template
//		RowMapper<Teacher> rowMapper=new BeanPropertyRowMapper<Teacher>(Teacher.class);
//		List<Teacher> list = jdbcTemplate.query(sql, rowMapper,account,password);	
//		if (list != null && list.size()>0) {
//			System.out.println(list.get(0).getName());
//			return list.get(0);
//		}else
//			return null;				
//	}
//}