package com.hudongyang.sunshinehook.common.bean.githubpayloads;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Generated("com.robohorse.robopojogenerator")
public class Owner{

	@JSONField(name="gists_url")
	private String gistsUrl;

	@JSONField(name="repos_url")
	private String reposUrl;

	@JSONField(name="following_url")
	private String followingUrl;

	@JSONField(name="starred_url")
	private String starredUrl;

	@JSONField(name="login")
	private String login;

	@JSONField(name="followers_url")
	private String followersUrl;

	@JSONField(name="type")
	private String type;

	@JSONField(name="url")
	private String url;

	@JSONField(name="subscriptions_url")
	private String subscriptionsUrl;

	@JSONField(name="received_events_url")
	private String receivedEventsUrl;

	@JSONField(name="avatar_url")
	private String avatarUrl;

	@JSONField(name="events_url")
	private String eventsUrl;

	@JSONField(name="html_url")
	private String htmlUrl;

	@JSONField(name="name")
	private String name;

	@JSONField(name="site_admin")
	private boolean siteAdmin;

	@JSONField(name="id")
	private int id;

	@JSONField(name="gravatar_id")
	private String gravatarId;

	@JSONField(name="email")
	private String email;

	@JSONField(name="node_id")
	private String nodeId;

	@JSONField(name="organizations_url")
	private String organizationsUrl;
}