//package pms.restController;
//import java.io.PrintWriter;
//import java.io.UnsupportedEncodingException;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
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
//	    @RequestMapping(value = "/testalipay/aliPay",method = RequestMethod.POST)
//	   // @RequestMapping(produces = "select")
//	    @ResponseBody
//	    public String alipayPay(String out_trade_no, Double total_amount, String subject) throws AlipayApiException{
//
//	        System.out.println("杩涘叆pay鎺ュ彛");
//	        System.out.println(total_amount+"閲戦");
//	        System.out.println(out_trade_no+"璁㈠崟鍙�");
//	        System.out.println(subject+"鍐呭");
//
//	        //鍟嗘埛璁㈠崟鍙凤紝鍟嗘埛缃戠珯璁㈠崟绯荤粺涓敮涓�璁㈠崟鍙凤紝蹇呭～
//	        //浠樻閲戦锛屽繀濉�
//	        //璁㈠崟鍚嶇О锛屽繀濉�
//	        
//	        AlipayVo vo=new AlipayVo();
//	        vo.setOut_trade_no(out_trade_no);
//	        vo.setSubject(subject);
//	        DecimalFormat df=new DecimalFormat("#.00");//瀹氫箟娴偣鏁版牸寮�
//	        String moneytoo=df.format(total_amount);//杞崲鎴恠tring绫诲瀷
//	        vo.setTotal_amount(Double.parseDouble(moneytoo));
//	        vo.setProduct_code("FAST_INSTANT_TRADE_PAY");//閿�鍞骇鍝佺爜
//
//	        String json =JSON.toJSONString(vo);
//
//	        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,AlipayConfig.app_id,AlipayConfig.merchant_private_key, "json",AlipayConfig.charset,AlipayConfig.alipay_public_key,AlipayConfig.sign_type);
//	        // 璁剧疆璇锋眰鍙傛暟
//	        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//	        alipayRequest.setReturnUrl(AlipayConfig.return_url);
//	        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
//	        alipayRequest.setBizContent(json);
//
//	        //鎵ц璇锋眰
//	       
//	      String result = alipayClient.pageExecute(alipayRequest).getBody();
//	      return result; //杩欓噷鐢熸垚涓�涓〃鍗曪紝浼氳嚜鍔ㄦ彁浜�
//	    }
//	    @GetMapping("ali2")
//	    public String a() {
//	    	return "ali2";
//	    }
//	    @RequestMapping("alipaySum")
//	    public Object alipayIumpSum(Model model, String payables, String subject, String body, HttpServletResponse response)
//	            throws Exception {
//	        // 鑾峰緱鍒濆鍖栫殑AlipayClient
//	        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
//	        		AlipayConfig.merchant_private_key, "json", AlipayConfig.charset,
//	        		AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
//	        // 璁剧疆璇锋眰鍙傛暟
//	        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//	        alipayRequest.setReturnUrl(AlipayConfig.return_url);
//	        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
//	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//	        // 鍟嗘埛璁㈠崟鍙凤紝鍟嗘埛缃戠珯璁㈠崟绯荤粺涓敮涓�璁㈠崟鍙凤紝蹇呭～
//	        String out_trade_no = sdf.format(new Date());
//	        // 浠樻閲戦锛屽繀濉�
//	        String total_amount = payables.replace(",", "");
//	        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
//	                + "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
//	                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
//	        // 璇锋眰
//	        String result = alipayClient.pageExecute(alipayRequest).getBody();
//	        // System.out.println(result);
//	        AlipayConfig.logResult(result);// 璁板綍鏀粯鏃ュ織
//	        response.setContentType("text/html; charset=gbk");
//	        PrintWriter out = response.getWriter();
//	        out.print(result);
//	        return null;
//	    }
//	    /**
//	     * 鏀粯瀹濇湇鍔″櫒寮傛閫氱煡
//	     * @param request
//	     * @param out_trade_no
//	     * @param trade_no
//	     * @param trade_status
//	     * @return
//	     * @throws AlipayApiException
//	     */
//	    @RequestMapping(value = "/notify_url",method = RequestMethod.POST)
//	    public String alipayNotify(HttpServletRequest request, String out_trade_no, String trade_no, String trade_status) throws AlipayApiException {
//	        Map<String, String> params = getParamsMap(request);
//	        // 楠岃瘉绛惧悕
//	        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
//
//	        if (signVerified) {
//	            //澶勭悊浣犵殑涓氬姟閫昏緫锛屾洿鏂拌鍗曠姸鎬佺瓑
//
//	            return ("success");
//	        } else {
//	            return ("fail");
//	        }
//	    }
//
//	    /**
//	     * 鏀粯瀹濇湇鍔″櫒鍚屾閫氱煡
//	     * @param request
//	     * @param out_trade_no
//	     * @param trade_no 鏀粯瀹濅氦鏄撳嚟璇佸彿
//	     * @param total_amount 浜ゆ槗鐘舵��
//	     * @return
//	     * @throws AlipayApiException
//	     */
//	    @RequestMapping(value = "/return_url",method = RequestMethod.GET)
//	    public String alipayReturn(HttpServletRequest request, String out_trade_no, String trade_no, String total_amount) throws AlipayApiException {
//	        Map<String, String> params = getParamsMap(request);
//	        // 楠岃瘉绛惧悕
//	        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
//
//	        if (signVerified) {
//	            //澶勭悊涓氬姟閫昏緫锛屾洿鏂拌鍗曠姸鎬佺瓑
//
//
//	            return "success";
//	        } else {
//	            return ("fail");
//	        }
//	    }
//
//	    private Map<String, String> getParamsMap(HttpServletRequest request) {
//	        Map<String,String> params = new HashMap<>();
//	        Map requestParams = request.getParameterMap();
//	        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
//	            String name = (String) iter.next();
//	            String[] values = (String[]) requestParams.get(name);
//	            String valueStr = "";
//	            for (int i = 0; i < values.length; i++) {
//	                valueStr = (i == values.length - 1) ? valueStr + values[i]
//	                        : valueStr + values[i] + ",";
//	            }
//	            //涔辩爜瑙ｅ喅锛岃繖娈典唬鐮佸湪鍑虹幇涔辩爜鏃朵娇鐢�
//	            try {
//	                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
//	                params.put(name, valueStr);
//	            } catch (UnsupportedEncodingException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        return params;
//	    }
//
//}
