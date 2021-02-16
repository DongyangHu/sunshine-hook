package com.hudongyang.sunshinehook.common.bean.githubpayloads;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.annotation.Generated;
import java.util.List;

@Data
@Generated("com.robohorse.robopojogenerator")
public class PushEvent{

	@JSONField(name="pusher")
	private Pusher pusher;

	@JSONField(name="compare")
	private String compare;

	@JSONField(name="head_commit")
	private HeadCommit headCommit;

	@JSONField(name="before")
	private String before;

	@JSONField(name="created")
	private boolean created;

	@JSONField(name="forced")
	private boolean forced;

	@JSONField(name="repository")
	private Repository repository;

	@JSONField(name="base_ref")
	private Object baseRef;

	@JSONField(name="ref")
	private String ref;

	@JSONField(name="deleted")
	private boolean deleted;

	@JSONField(name="sender")
	private Sender sender;

	@JSONField(name="commits")
	private List<CommitsItem> commits;

	@JSONField(name="after")
	private String after;
}