
//package pms.restController;
//import java.io.PrintWriter;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import pms.AlipayConfig;
//import com.alibaba.fastjson.JSON;
//import com.alipay.api.*;
//import com.alipay.api.internal.util.AlipaySignature;
//import com.alipay.api.request.*;
//
//import pms.AlipayVo;
//
//@Controller
//public class AliController {
//	//@PostMapping("/aliPay")
//	    @RequestMapping(value = "/aliPay",method = RequestMethod.POST)
//	   // @RequestMapping(produces = "select")
//	    @ResponseBody
//	    public String alipayPay(String out_trade_no, Double total_amount, String subject) throws AlipayApiException{
//
//	        System.out.println("进入pay接口");
//	        System.out.println(total_amount+"金额");
//	        System.out.println(out_trade_no+"订单号");
//	        System.out.println(subject+"内容");
//
//	        //商户订单号，商户网站订单系统中唯一订单号，必填
//	        //付款金额，必填
//	        //订单名称，必填
//	        
//	        AlipayVo vo=new AlipayVo();
//	        vo.setOut_trade_no(out_trade_no);
//	        vo.setSubject(subject);
//	        DecimalFormat df=new DecimalFormat("#.00");//定义浮点数格式
//	        String moneytoo=df.format(total_amount);//转换成string类型
//	        vo.setTotal_amount(Double.parseDouble(moneytoo));
//	        vo.setProduct_code("FAST_INSTANT_TRADE_PAY");//销售产品码
//
//	        String json =JSON.toJSONString(vo);
//
//	        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,AlipayConfig.app_id,AlipayConfig.merchant_private_key, "json",AlipayConfig.charset,AlipayConfig.alipay_public_key,AlipayConfig.sign_type);
//	        // 设置请求参数
//	        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//	        alipayRequest.setReturnUrl(AlipayConfig.return_url);
//	        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
//	        alipayRequest.setBizContent(json);
//
//	        //执行请求
//	       
//	      String result = alipayClient.pageExecute(alipayRequest).getBody();
//	      return result; //这里生成一个表单，会自动提交
//	    }
//	    @GetMapping("ali2")
//	    public String a() {
//	    	return "ali2";
//	    }
//	    @RequestMapping("alipaySum")
//	    public Object alipayIumpSum(Model model, String payables, String subject, String body, HttpServletResponse response)
//	            throws Exception {
//	        // 获得初始化的AlipayClient
//	        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
//	        		AlipayConfig.merchant_private_key, "json", AlipayConfig.charset,
//	        		AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
//	        // 设置请求参数
//	        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//	        alipayRequest.setReturnUrl(AlipayConfig.return_url);
//	        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
//	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//	        // 商户订单号，商户网站订单系统中唯一订单号，必填
//	        String out_trade_no = sdf.format(new Date());
//	        // 付款金额，必填
//	        String total_amount = payables.replace(",", "");
//	        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
//	                + "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
//	                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
//	        // 请求
//	        String result = alipayClient.pageExecute(alipayRequest).getBody();
//	        // System.out.println(result);
//	        AlipayConfig.logResult(result);// 记录支付日志
//	        response.setContentType("text/html; charset=gbk");
//	        PrintWriter out = response.getWriter();
//	        out.print(result);
//	        return null;
//	    }
//
//}

package pms.restController;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pms.AlipayConfig;
import com.alibaba.fastjson.JSON;
import com.alipay.api.*;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.*;

import pms.AlipayVo;

@Controller
public class AliController {
	//@PostMapping("/aliPay")
	    @RequestMapping(value = "/testalipay/aliPay",method = RequestMethod.POST)
	   // @RequestMapping(produces = "select")
	    @ResponseBody
	    public String alipayPay(String out_trade_no, Double total_amount, String subject) throws AlipayApiException{

	        System.out.println("进入pay接口");
	        System.out.println(total_amount+"金额");
	        System.out.println(out_trade_no+"订单号");
	        System.out.println(subject+"内容");

	        //商户订单号，商户网站订单系统中唯一订单号，必填
	        //付款金额，必填
	        //订单名称，必填
	        
	        AlipayVo vo=new AlipayVo();
	        vo.setOut_trade_no(out_trade_no);
	        vo.setSubject(subject);
	        DecimalFormat df=new DecimalFormat("#.00");//定义浮点数格式
	        String moneytoo=df.format(total_amount);//转换成string类型
	        vo.setTotal_amount(Double.parseDouble(moneytoo));
	        vo.setProduct_code("FAST_INSTANT_TRADE_PAY");//销售产品码

	        String json =JSON.toJSONString(vo);

	        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,AlipayConfig.app_id,AlipayConfig.merchant_private_key, "json",AlipayConfig.charset,AlipayConfig.alipay_public_key,AlipayConfig.sign_type);
	        // 设置请求参数
	        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
	        alipayRequest.setReturnUrl(AlipayConfig.return_url);
	        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
	        alipayRequest.setBizContent(json);

	        //执行请求
	       
	      String result = alipayClient.pageExecute(alipayRequest).getBody();
	      return result; //这里生成一个表单，会自动提交
	    }
	    @GetMapping("ali2")
	    public String a() {
	    	return "ali2";
	    }
	    @RequestMapping("alipaySum")
	    public Object alipayIumpSum(Model model, String payables, String subject, String body, HttpServletResponse response)
	            throws Exception {
	        // 获得初始化的AlipayClient
	        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
	        		AlipayConfig.merchant_private_key, "json", AlipayConfig.charset,
	        		AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
	        // 设置请求参数
	        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
	        alipayRequest.setReturnUrl(AlipayConfig.return_url);
	        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	        // 商户订单号，商户网站订单系统中唯一订单号，必填
	        String out_trade_no = sdf.format(new Date());
	        // 付款金额，必填
	        String total_amount = payables.replace(",", "");
	        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
	                + "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
	                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
	        // 请求
	        String result = alipayClient.pageExecute(alipayRequest).getBody();
	        // System.out.println(result);
	        AlipayConfig.logResult(result);// 记录支付日志
	        response.setContentType("text/html; charset=gbk");
	        PrintWriter out = response.getWriter();
	        out.print(result);
	        return null;
	    }
	    /**
	     * 支付宝服务器异步通知
	     * @param request
	     * @param out_trade_no
	     * @param trade_no
	     * @param trade_status
	     * @return
	     * @throws AlipayApiException
	     */
	    @RequestMapping(value = "/notify_url",method = RequestMethod.POST)
	    public String alipayNotify(HttpServletRequest request, String out_trade_no, String trade_no, String trade_status) throws AlipayApiException {
	        Map<String, String> params = getParamsMap(request);
	        // 验证签名
	        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);

	        if (signVerified) {
	            //处理你的业务逻辑，更新订单状态等

	            return ("success");
	        } else {
	            return ("fail");
	        }
	    }

	    /**
	     * 支付宝服务器同步通知
	     * @param request
	     * @param out_trade_no
	     * @param trade_no 支付宝交易凭证号
	     * @param total_amount 交易状态
	     * @return
	     * @throws AlipayApiException
	     */
	    @RequestMapping(value = "/return_url",method = RequestMethod.GET)
	    public String alipayReturn(HttpServletRequest request, String out_trade_no, String trade_no, String total_amount) throws AlipayApiException {
	        Map<String, String> params = getParamsMap(request);
	        // 验证签名
	        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);

	        if (signVerified) {
	            //处理业务逻辑，更新订单状态等


	            return "ownerFinance";
	        } else {
	            return ("fail");
	        }
	    }

	    private Map<String, String> getParamsMap(HttpServletRequest request) {
	        Map<String,String> params = new HashMap<>();
	        Map requestParams = request.getParameterMap();
	        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
	            String name = (String) iter.next();
	            String[] values = (String[]) requestParams.get(name);
	            String valueStr = "";
	            for (int i = 0; i < values.length; i++) {
	                valueStr = (i == values.length - 1) ? valueStr + values[i]
	                        : valueStr + values[i] + ",";
	            }
	            //乱码解决，这段代码在出现乱码时使用
	            try {
	                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
	                params.put(name, valueStr);
	            } catch (UnsupportedEncodingException e) {
	                e.printStackTrace();
	            }
	        }
	        return params;
	    }

}

