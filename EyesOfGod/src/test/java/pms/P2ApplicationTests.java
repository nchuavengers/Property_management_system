package pms;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pms.entity.testtime;
import pms.repository.TeacherRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class P2ApplicationTests {

    @Autowired
    private TeacherRepository teacherRepository;	
	@Test
	public void contextLoads() {
		
//		testtime t=new testtime();
//		t.setId(2);
//		t.setDate(new Date());
//		
//		teacherRepository.addTime(t);
//		testtime t=teacherRepository.findTime(1);
//		System.out.println(t.getDate());
	}

}
