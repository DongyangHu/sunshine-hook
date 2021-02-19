package com.hudongyang.sunshinehook.common.bean.githubpayloads;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.annotation.Generated;
import java.util.List;

@Data
@Generated("com.robohorse.robopojogenerator")
public class CommitsItem{

	@JSONField(name="committer")
	private Committer committer;

	@JSONField(name="removed")
	private List<Object> removed;

	@JSONField(name="tree_id")
	private String treeId;

	@JSONField(name="added")
	private List<Object> added;

	@JSONField(name="author")
	private Author author;

	@JSONField(name="distinct")
	private boolean distinct;

	@JSONField(name="modified")
	private List<String> modified;

	@JSONField(name="id")
	private String id;

	@JSONField(name="message")
	private String message;

	@JSONField(name="url")
	private String url;

	@JSONField(name="timestamp")
	private String timestamp;
}