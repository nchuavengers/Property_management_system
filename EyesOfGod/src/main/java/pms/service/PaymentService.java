package pms.service;
import java.util.List;
import org.springframework.stereotype.Service;
import pms.dto.FinancePaymentDto;

@Service
public interface PaymentService {
	//查找所有缴费记录
	List<FinancePaymentDto> findAllPayment() ;
	//查找所有缴费记录
	List<FinancePaymentDto> findPersonalPayment(int ownerId) ;
	//增加缴费记录
	boolean addPayment(FinancePaymentDto pay);
	//删除缴费记录
	boolean delPayment(int payId);
	//修改缴费记录
	boolean modifyPayment(FinancePaymentDto pay);
	
}
