package pms;

import static org.junit.Assert.assertEquals;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pms.dto.NavigationMessage;
import pms.entity.Owner;
import pms.entity.PaymentRecord;
import pms.entity.Security;
import pms.entity.testtime;
import pms.repository.AnnouncementRepository;
import pms.repository.ExpenseRepository;
import pms.repository.FacilityRepository;
import pms.repository.HouseRepository;
import pms.repository.OwnerRepository;
import pms.repository.PaymentRepository;
import pms.repository.SecurityRepository;
import pms.repository.TeacherRepository;
import pms.service.HomeServiceImpl;
import pms.service.SecurityService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class P2ApplicationTests {

	
	@Autowired
	private PaymentRepository pr;
	@Autowired
	private ExpenseRepository er;
	@Autowired
	private HomeServiceImpl homeServiceImpl; 
	@Autowired
	private NavigationMessage navMessage;
	@Autowired
	private AnnouncementRepository ar;
	@Autowired
	private FacilityRepository fr;
    
	@Test
	public void contextLoads() {
		navMessage=homeServiceImpl.getNavagationMessage();
		assertEquals(6, navMessage.getNumOwner());
		assertEquals(5, navMessage.getNumAnn());
		assertEquals(9, navMessage.getUsedParking());
		
		assertEquals(5, ar.findAllannouncementManageDto().size());
		assertEquals(14, fr.findAllFacilityManageDto().size());

		
		
	}

}
