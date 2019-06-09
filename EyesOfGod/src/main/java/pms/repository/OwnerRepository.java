package pms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pms.entity.Teacher;

@Repository
public interface OwnerRepository {

	public List<Teacher> findAll();
	
	public Teacher validTeacher(String account,String password);
}
