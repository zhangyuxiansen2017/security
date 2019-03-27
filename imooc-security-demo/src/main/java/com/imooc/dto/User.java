/**
 * 
 */
package com.imooc.dto;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validator.MyConstraint;

import io.swagger.annotations.ApiModelProperty;

/**
 * @description 定义返回json时需要返回哪些数据，使用JsonView
 * 					：@JsonView(UserSimpleView.class)、@JsonView(UserDetailView.class)--标注需要给前端的值
 * 				  	：在Controller类方法上加上@JsonView(User.UserSimpleView.class)可返回被@JsonView(UserSimpleView.class)的字段
 * 				  	：UserDetailView extends UserSimpleView {} 继承了UserSimpleView注解锁标注的字段
 * @author Mr. Zhang
 * @date 2019-03-26 16:02
 * @website https://www.zhangguimin.cn
 */
public class User {
	
	public interface UserSimpleView {};
	public interface UserDetailView extends UserSimpleView {};
	
	private String id;
	
	@MyConstraint(message = "这是一个测试")
	@ApiModelProperty(value = "用户名")
	private String username;
	
	@NotBlank(message = "密码不能为空")
	private String password;
	
	@Past(message = "生日必须是过去的时间")
	private Date birthday;

	@JsonView(UserSimpleView.class)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonView(UserDetailView.class)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonView(UserSimpleView.class)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@JsonView(UserSimpleView.class)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
