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
		
		
		
//		Security b=securityRepository.validSecurity("111", "222");
//	
//		
//		System.out.print(b);
		
		
		
		
//		
//		     Date d=new Date();
//		     System.out.println("系统时间"+d);
//		     String dd="2019-06-18T00:59";
//		     //去掉T
//		     dd=dd.replace("T", " ");
//		     String ddd=dd+":00";
//		     System.out.println("jia"+ddd);
//		     
//		     String strDate="2019-06-18 00:59:00" ;
//		     
//		     
//		     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		     ParsePosition pos = new ParsePosition(0);
//		     Date strtodate = formatter.parse(strDate, pos);
//		     
//		     System.out.println("转换时间"+strtodate);
		 
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
