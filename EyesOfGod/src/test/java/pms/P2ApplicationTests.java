package pms;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pms.entity.Owner;
import pms.entity.Security;
import pms.entity.testtime;
import pms.repository.FacilityRepository;
import pms.repository.OwnerRepository;
import pms.repository.SecurityRepository;
import pms.repository.TeacherRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class P2ApplicationTests {

    @Autowired
    private SecurityRepository securityRepository;

    
	@Test
	public void contextLoads() {
		

	}

}
