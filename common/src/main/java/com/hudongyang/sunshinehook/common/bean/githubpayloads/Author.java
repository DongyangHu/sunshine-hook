package com.hudongyang.sunshinehook.common.bean.githubpayloads;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Generated("com.robohorse.robopojogenerator")
public class Author{

	@JSONField(name="name")
	private String name;

	@JSONField(name="email")
	private String email;
}