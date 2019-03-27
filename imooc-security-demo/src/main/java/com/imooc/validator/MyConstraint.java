/**
 * 
 */
package com.imooc.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @description 注解的山歌方法必须实现，才能实现自定义验证
 * @author Mr. Zhang
 * @date 2019-03-26 15:59
 * @website https://www.zhangguimin.cn
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {
	
	String message();

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
