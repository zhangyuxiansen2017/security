/**
 * 
 */
package com.imooc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.service.HelloService;

/**
 * @description 实现ConstraintValidator<MyConstraint, Object>接口，MyConstraint为注解类，Object为需要被标注的类型
 * @author Mr. Zhang
 * @date 2019-03-26 15:57
 * @website https://www.zhangguimin.cn
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

	@Autowired
	private HelloService helloService;

	/**
	 * 初始化验证规则
	 * @param constraintAnnotation
	 */
	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		System.out.println("my validator init");
	}

	/**
	 * 处理自定义验证规则，返回true为验证通过，返回false为验证失败
	 * @param value
	 * @param context
	 * @return
	 */
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		helloService.greeting("tom");
		System.out.println(value);
		return true;
	}

}
