package pms;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pms.entity.Owner;
import pms.entity.testtime;
import pms.repository.FacilityRepository;
import pms.repository.OwnerRepository;
import pms.repository.TeacherRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class P2ApplicationTests {

    @Autowired
    private OwnerRepository ownerRepository;

    
	@Test
	public void contextLoads() {
		
//		Owner owner=new Owner();
//		owner.setOwnerId(1001);
//		owner.setOwnerName("ironMan");
//		owner.setOwnerPassword("123456");
//		owner.setOwnerPhoneNumber("10987654321");
//		owner.setOwnerSex("女");
//		boolean b=ownerRepository.UpdateOwner(owner);
//		System.out.println("b="+b);
		
//		testtime t=new testtime();
//		t.setId(2);
//		t.setDate(new Date());
//		
//		teacherRepository.addTime(t);
//		testtime t=teacherRepository.findTime(1);
//		System.out.println(t.getDate());
	}

}
