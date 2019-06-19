package pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dto.FinanceExpenseDto;
import pms.dto.FinancePaymentDto;
import pms.repository.PaymentRepository;
@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentRepository pr;
	@Override
	public List<FinancePaymentDto> findAllPayment() {
		return pr.findAllPayment();
	}

	@Override//添加缴费记录
	public boolean addPayment(FinancePaymentDto pay) {
		// TODO Auto-generated method stub
		return pr.addPayment(pay);
	}

	@Override
	public boolean delPayment(int payId) {
		// TODO Auto-generated method stub
		return pr.delPayment(payId);
	}

	@Override
	public boolean modifyPayment(FinancePaymentDto pay) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<FinancePaymentDto> findPersonalPayment(int ownerId) {
		// TODO Auto-generated method stub
		return pr.findPersonalPayment(ownerId);
	}

	

}
