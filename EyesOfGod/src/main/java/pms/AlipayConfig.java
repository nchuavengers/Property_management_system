package pms;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092900627210";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCg6sf0z6g1EnIlC0SMjndFkgB/acHAIof0SyQYqJGLrCfECQDUpIXXgV+UDgu04i9H3UmGr0wfQNZMhFJvT/fWNuDPH/IIGccEz0mC7EeQcySvv/TlnlwuR5uYvtMCeBA+y9ilRt32qDzbdQ0KZ+Zl1PRQwxNJaBZGm0CY8k35KmvpGJpz0+4XW0MscfWE/aQdoIEglcj8U0k7/yrEFI5jdQCTxekeFsGxTWokFE0TPl8VyrZ+AE2M9IvkTPQDigt587Y5mda4ODyAjyT5yQYtAlhF/MNv0RfWfcii9TCoY0Dcler8Y+pbfWHq7IdCq69zjDHzNPJTeAlgXIxJPD9TAgMBAAECggEAApkHtVoM2x57HUH7T1GVd1gODgCFEjb8fuMfqA5Am0KiObXzf3tQddQu2NMJOVhVbxGReE0oK3D+hKm2MvnVhG3KX02iuKLB5b/67dQmq5xQQU4WBAb0cgLR7jtWaLnLeVgNHU3xk2PP57MSDNL0kzxG3W7oxsyZX3ZuKonu3FDeTQNnV0B3+ZrLUqeVircoBGE3h736RhEg5lFC9D+T1yPMMKAW/GurBnYjdJqHtcCG90R8pWn+OQg+11NSMdQbUEpRB1mwo3Ld++qOSd78u0BeNBLidrTZoSuGx94rRp06TPhYJXCwB26LuhRfiGQTYBmjdvEsQB9Z2TPMLpkYgQKBgQD7U5t/PBdlojszMD8nITpMI1LEGl5z3Pc6L6nUNW4sQpzNsZxF17DeWKRoI513nbA2NZQ4xJNwnyXEINmELXPFYU+Mxq1s/Lxqt1mkofQZZsHQAQJxsFSNc5tUcwH2YySoB/VGBnGNKula7Q5rvp0M5pLhiHC/2cuVqTa/BONp8wKBgQCj6Mvmy2G9rBt7jSiYmctkrBePTXkkt/FcIJ6WjgmRYUuJZ6kBhKq9kXuJzp9ogZih6JJ1hX1nkb9TPVzO5Ig0lCImJFpErZG70coE1lAuiAryoKlfZaQkRZGmLcjZS2nt9Gk0vZveXuWIDNhk43yLR4a6QfY8zvEtaVH9FJzNIQKBgHmYrfcVP8ywfSv6/9MSxH3p6TVv/JraIdNJFEXTxAYuBGeQsycngC9Te9fWw20IIiVYLup4UU1/8mm96v+EbirlNfPKfEXq0c5f/0MkCFHx4XudwWz3/zCg6loleqGWvjl+ADFtFKtUQ6r2Xq/KfXmsZQwxUzu/SDyUriQlXVH5AoGACG0KNlYUMzTqwMIz6QxW6VjzaRl5dcrC7JJ8tI6erUuMH4clp/9S66XT7PSjOzMWTpRvGv1+wdk7NaM85yHWYqWOz9kkjs1BZZ9WPENsIcg6j9h0fIP0GS0+XIWUAp+e1W2wDtcEcTz9na3TXfRXza0inuaPKvcUbNoyLclmeiECgYEA9GBd7v7SoUOC0dvW/YmKJ4Mi6QtaadMz6p955NO/vnaGksyw1+3ArPh0h3wVr939hlJQ+rHhYpwObm0gYgyiXgvOwE25+un978pf27rV6w/lrR/q84rtMIItFni+FxnmkxIgjlsNQJ1p0ckEOPWP9veQoZnwKu/0DwKmExUu5Xk=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxKOPD191jtk1OLTO2cEoAN+DODIku2BzGk3Z80OYNdB5iQYd9If6VA+6GfweMwVrhUmKT4gJU2ZSKtYYzD8PWMmhMwvrnUcBMdpLJayQNZlDBo2uAB6Jf8j2fccB9tFED3wXF2846J4UasyWQUUu5DEEZEhA/0EAmD+mQnf+HEsK9HZ7yy/wQvFVDRUjurVpkdVBQck6UxSLaQlb/H2PSUTX4G0RXvXCHLw1QU46cejTi0Hi62Bju/32r/hXAkNqovdzdnV9qQ6kVczSZs0VFMLWjApKRgGWMQ5uxJDEyO+FdmRgfqyj4kEiJCYoHDRsAofAAPJIx+kgksRilPS4WQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，！！！！必须外网可以正常访问！！！！
	//public static String notify_url = "http://59.52.52.57/index";
    
	 // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://qhd2ch.natappfree.cc/testalipay/aliPay/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://qhd2ch.natappfree.cc/testalipay/aliPay/return_url";
	// 签名方式 
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

