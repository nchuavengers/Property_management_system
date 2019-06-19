package pms.service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dto.MyParkingSpaceDto;
import pms.dto.OwnerParkingSpaceDto;
import pms.dto.ParkingSpaceManagerDto;
import pms.entity.ParkingSpace;
import pms.repository.ParkingSpaceRepository;

@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {


	@Autowired
	private ParkingSpaceRepository parkingSpaceRepository;
	
    //业主所有车位
	@Override
	public List<MyParkingSpaceDto> findOwnerParkingSpace(int ownerId) {
		
		return parkingSpaceRepository.findOwnerParkingSpace(ownerId);
	}
	
	/*
	 * yyyy-MM-ddTHH:mm->yyyy-MM-dd HH:mm:ss
	 * js获取的时间字符串转变成date
	 */
	public Date strToDate(String dd){
		 dd=dd.replace("T", " ");
	     String ddd=dd+":00";     

	     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     ParsePosition pos = new ParsePosition(0);
	     Date strtodate = formatter.parse(ddd, pos);
	     return strtodate;
	}

	//设置or重置
	@Override
	public boolean setShareTime(MyParkingSpaceDto myParkingSpaceDto) {
		
		return parkingSpaceRepository.UpdateParkingSpace(myParkingSpaceDto);
		
	}
    
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean resetShareTime(ParkingSpace parkingSpaceDto) {

		
		return false;
	}

	
	
	
	
	
	
	
	@Override
	public List<ParkingSpaceManagerDto> findAllParkingSpaceManagerDto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean UpdateOwner(ParkingSpace parkingSpace) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteParkingSpace(int parkingSpaceId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addParkingSpace(ParkingSpace parkingSpace) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addOwnerParkingSpace(OwnerParkingSpaceDto ownerParkingSpaceDto) {
		// TODO Auto-generated method stub
		return false;
	}
}
