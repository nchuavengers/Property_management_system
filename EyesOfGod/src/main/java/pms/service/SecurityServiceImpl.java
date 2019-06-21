package pms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pms.dto.AllDayShareDto;
import pms.dto.BlurOueryDto;
import pms.dto.TemporayShareDto;
import pms.dto.VisitorCarDto;
import pms.entity.VisitorRecord;
import pms.repository.SecurityRepository;

@Component
public class SecurityServiceImpl implements SecurityService{

	@Autowired
	private SecurityRepository securityRepository;
	
	@Autowired
	private VisitorRecord visitorRecord;
	
	//在小区中的访客
	@Override
	public List<VisitorCarDto> findNowVisitor() {

		List<VisitorCarDto> list=securityRepository.findNowVisitor();
		for(VisitorCarDto v:list) {
			if(v.getParkingSpaceType().equals("2")) {//私有
				v.setParkingSpaceType("私有");
			}else {
				v.setParkingSpaceType("共享");
			}
		}
		return list;
	}

	//全天共享车辆
	@Override
	public List<AllDayShareDto> fingAllDayShareParkingSpace() {

		return securityRepository.fingAllDayShareParkingSpace();
	}

	//临时共享
	@Override
	public List<TemporayShareDto> FingTemporayShareParkingSpace() {
 
		return securityRepository.FindTemporayShareParkingSpace();
	}

	//更新访客记录//离区时间  缴费 触发器车位状态
	@Override
	public boolean updateVisitorRecord(VisitorRecord visitorRecord) {
		
		return securityRepository.updateVisitorRecord(visitorRecord);
	}

	//添加访客记录

	@Override
	public int addVisitor(String licensePlate ,int parkingSpaceId) {
		//添加访客在service判断  车位不存在 1   车位正在使用 2 返回错误页面       3车位可用成功则添加访客记录   触发器修改车位状态
		
		//判断车位是否存在
		boolean a=securityRepository.IsExistParkingSpace(parkingSpaceId);
		//判断车位状态是否为1
		boolean b=securityRepository.IsEmployed(parkingSpaceId);
		if(!a) {
			return 1;
		}else if(!b){
			return 2;
		}
		
		
		//保安id 先默认1000
		//入区时间  new Date()  现在
		Date entryTime=new Date();
		//添加一条记录
		visitorRecord.setLicensePlate(licensePlate);//车牌
		visitorRecord.setParkingSpaceId(parkingSpaceId);//车位
		visitorRecord.setSecurityId(1000);
		visitorRecord.setEntryTime(entryTime);
        //修改车位状态为0用触发器ok
		boolean c=securityRepository.addVisitor(visitorRecord);
		return 3;

		
	}

	
	//模糊查询业主车位有关业主的id 电话  
	@Override
	public List<BlurOueryDto> FindOwnerParkingSpace(String string) {
		
		return securityRepository.FindOwnerParkingSpace(string);
	}

}
