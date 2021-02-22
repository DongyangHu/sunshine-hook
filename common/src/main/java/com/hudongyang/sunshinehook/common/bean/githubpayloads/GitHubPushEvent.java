package com.hudongyang.sunshinehook.common.bean.githubpayloads;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dongyang.hu
 * @date 2021/2/22 17:26
 */
@NoArgsConstructor
@Data
public class GitHubPushEvent {
    @JSONField(name = "ref")
    private String ref;
    @JSONField(name = "before")
    private String before;
    @JSONField(name = "after")
    private String after;
    @JSONField(name = "repository")
    private RepositoryDTO repository;
    @JSONField(name = "pusher")
    private PusherDTO pusher;
    @JSONField(name = "sender")
    private SenderDTO sender;
    @JSONField(name = "created")
    private Boolean created;
    @JSONField(name = "deleted")
    private Boolean deleted;
    @JSONField(name = "forced")
    private Boolean forced;
    @JSONField(name = "base_ref")
    private Object baseRef;
    @JSONField(name = "compare")
    private String compare;
    @JSONField(name = "commits")
    private List<CommitsDTO> commits;
    @JSONField(name = "head_commit")
    private HeadCommitDTO headCommit;

    @NoArgsConstructor
    @Data
    public static class RepositoryDTO {
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "node_id")
        private String nodeId;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "full_name")
        private String fullName;
        @JSONField(name = "private")
        private Boolean privateX;
        @JSONField(name = "owner")
        private OwnerDTO owner;
        @JSONField(name = "html_url")
        private String htmlUrl;
        @JSONField(name = "description")
        private Object description;
        @JSONField(name = "fork")
        private Boolean fork;
        @JSONField(name = "url")
        private String url;
        @JSONField(name = "forks_url")
        private String forksUrl;
        @JSONField(name = "keys_url")
        private String keysUrl;
        @JSONField(name = "collaborators_url")
        private String collaboratorsUrl;
        @JSONField(name = "teams_url")
        private String teamsUrl;
        @JSONField(name = "hooks_url")
        private String hooksUrl;
        @JSONField(name = "issue_events_url")
        private String issueEventsUrl;
        @JSONField(name = "events_url")
        private String eventsUrl;
        @JSONField(name = "assignees_url")
        private String assigneesUrl;
        @JSONField(name = "branches_url")
        private String branchesUrl;
        @JSONField(name = "tags_url")
        private String tagsUrl;
        @JSONField(name = "blobs_url")
        private String blobsUrl;
        @JSONField(name = "git_tags_url")
        private String gitTagsUrl;
        @JSONField(name = "git_refs_url")
        private String gitRefsUrl;
        @JSONField(name = "trees_url")
        private String treesUrl;
        @JSONField(name = "statuses_url")
        private String statusesUrl;
        @JSONField(name = "languages_url")
        private String languagesUrl;
        @JSONField(name = "stargazers_url")
        private String stargazersUrl;
        @JSONField(name = "contributors_url")
        private String contributorsUrl;
        @JSONField(name = "subscribers_url")
        private String subscribersUrl;
        @JSONField(name = "subscription_url")
        private String subscriptionUrl;
        @JSONField(name = "commits_url")
        private String commitsUrl;
        @JSONField(name = "git_commits_url")
        private String gitCommitsUrl;
        @JSONField(name = "comments_url")
        private String commentsUrl;
        @JSONField(name = "issue_comment_url")
        private String issueCommentUrl;
        @JSONField(name = "contents_url")
        private String contentsUrl;
        @JSONField(name = "compare_url")
        private String compareUrl;
        @JSONField(name = "merges_url")
        private String mergesUrl;
        @JSONField(name = "archive_url")
        private String archiveUrl;
        @JSONField(name = "downloads_url")
        private String downloadsUrl;
        @JSONField(name = "issues_url")
        private String issuesUrl;
        @JSONField(name = "pulls_url")
        private String pullsUrl;
        @JSONField(name = "milestones_url")
        private String milestonesUrl;
        @JSONField(name = "notifications_url")
        private String notificationsUrl;
        @JSONField(name = "labels_url")
        private String labelsUrl;
        @JSONField(name = "releases_url")
        private String releasesUrl;
        @JSONField(name = "deployments_url")
        private String deploymentsUrl;
        @JSONField(name = "created_at")
        private Integer createdAt;
        @JSONField(name = "updated_at")
        private String updatedAt;
        @JSONField(name = "pushed_at")
        private Integer pushedAt;
        @JSONField(name = "git_url")
        private String gitUrl;
        @JSONField(name = "ssh_url")
        private String sshUrl;
        @JSONField(name = "clone_url")
        private String cloneUrl;
        @JSONField(name = "svn_url")
        private String svnUrl;
        @JSONField(name = "homepage")
        private Object homepage;
        @JSONField(name = "size")
        private Integer size;
        @JSONField(name = "stargazers_count")
        private Integer stargazersCount;
        @JSONField(name = "watchers_count")
        private Integer watchersCount;
        @JSONField(name = "language")
        private String language;
        @JSONField(name = "has_issues")
        private Boolean hasIssues;
        @JSONField(name = "has_projects")
        private Boolean hasProjects;
        @JSONField(name = "has_downloads")
        private Boolean hasDownloads;
        @JSONField(name = "has_wiki")
        private Boolean hasWiki;
        @JSONField(name = "has_pages")
        private Boolean hasPages;
        @JSONField(name = "forks_count")
        private Integer forksCount;
        @JSONField(name = "mirror_url")
        private Object mirrorUrl;
        @JSONField(name = "archived")
        private Boolean archived;
        @JSONField(name = "disabled")
        private Boolean disabled;
        @JSONField(name = "open_issues_count")
        private Integer openIssuesCount;
        @JSONField(name = "license")
        private Object license;
        @JSONField(name = "forks")
        private Integer forks;
        @JSONField(name = "open_issues")
        private Integer openIssues;
        @JSONField(name = "watchers")
        private Integer watchers;
        @JSONField(name = "default_branch")
        private String defaultBranch;
        @JSONField(name = "stargazers")
        private Integer stargazers;
        @JSONField(name = "master_branch")
        private String masterBranch;

        @NoArgsConstructor
        @Data
        public static class OwnerDTO {
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "email")
            private String email;
            @JSONField(name = "login")
            private String login;
            @JSONField(name = "id")
            private Integer id;
            @JSONField(name = "node_id")
            private String nodeId;
            @JSONField(name = "avatar_url")
            private String avatarUrl;
            @JSONField(name = "gravatar_id")
            private String gravatarId;
            @JSONField(name = "url")
            private String url;
            @JSONField(name = "html_url")
            private String htmlUrl;
            @JSONField(name = "followers_url")
            private String followersUrl;
            @JSONField(name = "following_url")
            private String followingUrl;
            @JSONField(name = "gists_url")
            private String gistsUrl;
            @JSONField(name = "starred_url")
            private String starredUrl;
            @JSONField(name = "subscriptions_url")
            private String subscriptionsUrl;
            @JSONField(name = "organizations_url")
            private String organizationsUrl;
            @JSONField(name = "repos_url")
            private String reposUrl;
            @JSONField(name = "events_url")
            private String eventsUrl;
            @JSONField(name = "received_events_url")
            private String receivedEventsUrl;
            @JSONField(name = "type")
            private String type;
            @JSONField(name = "site_admin")
            private Boolean siteAdmin;
        }
    }

    @NoArgsConstructor
    @Data
    public static class PusherDTO {
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "email")
        private String email;
    }

    @NoArgsConstructor
    @Data
    public static class SenderDTO {
        @JSONField(name = "login")
        private String login;
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "node_id")
        private String nodeId;
        @JSONField(name = "avatar_url")
        private String avatarUrl;
        @JSONField(name = "gravatar_id")
        private String gravatarId;
        @JSONField(name = "url")
        private String url;
        @JSONField(name = "html_url")
        private String htmlUrl;
        @JSONField(name = "followers_url")
        private String followersUrl;
        @JSONField(name = "following_url")
        private String followingUrl;
        @JSONField(name = "gists_url")
        private String gistsUrl;
        @JSONField(name = "starred_url")
        private String starredUrl;
        @JSONField(name = "subscriptions_url")
        private String subscriptionsUrl;
        @JSONField(name = "organizations_url")
        private String organizationsUrl;
        @JSONField(name = "repos_url")
        private String reposUrl;
        @JSONField(name = "events_url")
        private String eventsUrl;
        @JSONField(name = "received_events_url")
        private String receivedEventsUrl;
        @JSONField(name = "type")
        private String type;
        @JSONField(name = "site_admin")
        private Boolean siteAdmin;
    }

    @NoArgsConstructor
    @Data
    public static class HeadCommitDTO {
        @JSONField(name = "id")
        private String id;
        @JSONField(name = "tree_id")
        private String treeId;
        @JSONField(name = "distinct")
        private Boolean distinct;
        @JSONField(name = "message")
        private String message;
        @JSONField(name = "timestamp")
        private String timestamp;
        @JSONField(name = "url")
        private String url;
        @JSONField(name = "author")
        private AuthorDTO author;
        @JSONField(name = "committer")
        private CommitterDTO committer;
        @JSONField(name = "added")
        private List<?> added;
        @JSONField(name = "removed")
        private List<?> removed;
        @JSONField(name = "modified")
        private List<String> modified;

        @NoArgsConstructor
        @Data
        public static class AuthorDTO {
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "email")
            private String email;
        }

        @NoArgsConstructor
        @Data
        public static class CommitterDTO {
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "email")
            private String email;
        }
    }

    @NoArgsConstructor
    @Data
    public static class CommitsDTO {
        @JSONField(name = "id")
        private String id;
        @JSONField(name = "tree_id")
        private String treeId;
        @JSONField(name = "distinct")
        private Boolean distinct;
        @JSONField(name = "message")
        private String message;
        @JSONField(name = "timestamp")
        private String timestamp;
        @JSONField(name = "url")
        private String url;
        @JSONField(name = "author")
        private AuthorDTO author;
        @JSONField(name = "committer")
        private CommitterDTO committer;
        @JSONField(name = "added")
        private List<?> added;
        @JSONField(name = "removed")
        private List<?> removed;
        @JSONField(name = "modified")
        private List<String> modified;

        @NoArgsConstructor
        @Data
        public static class AuthorDTO {
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "email")
            private String email;
        }

        @NoArgsConstructor
        @Data
        public static class CommitterDTO {
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "email")
            private String email;
        }
    }
}
