/**
 * 
 */
package com.imooc.security.core.validate.code.sms;

/**
 * @author zhailiang
 *
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

	/**
	 *
	 * @param mobile
	 * @param code
	 */
	@Override
	public void send(String mobile, String code) {
		System.out.println("向手机"+mobile+"发送短信验证码"+code);
	}

}
