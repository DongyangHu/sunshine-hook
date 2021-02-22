package com.hudongyang.sunshinehook.common.bean.giteepayloads;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dongyang.hu
 * @date 2021/2/22 17:25
 */
@NoArgsConstructor
@Data
public class GiteePushEvent {
    @JSONField(name = "ref")
    private String ref;
    @JSONField(name = "before")
    private String before;
    @JSONField(name = "after")
    private String after;
    @JSONField(name = "created")
    private Boolean created;
    @JSONField(name = "deleted")
    private Boolean deleted;
    @JSONField(name = "compare")
    private String compare;
    @JSONField(name = "commits")
    private List<CommitsDTO> commits;
    @JSONField(name = "head_commit")
    private HeadCommitDTO headCommit;
    @JSONField(name = "total_commits_count")
    private Integer totalCommitsCount;
    @JSONField(name = "commits_more_than_ten")
    private Boolean commitsMoreThanTen;
    @JSONField(name = "repository")
    private RepositoryDTO repository;
    @JSONField(name = "project")
    private ProjectDTO project;
    @JSONField(name = "user_id")
    private Integer userId;
    @JSONField(name = "user_name")
    private String userName;
    @JSONField(name = "user")
    private UserDTO user;
    @JSONField(name = "pusher")
    private PusherDTO pusher;
    @JSONField(name = "sender")
    private SenderDTO sender;
    @JSONField(name = "enterprise")
    private EnterpriseDTO enterprise;
    @JSONField(name = "hook_name")
    private String hookName;
    @JSONField(name = "hook_id")
    private Integer hookId;
    @JSONField(name = "hook_url")
    private String hookUrl;
    @JSONField(name = "password")
    private String password;
    @JSONField(name = "timestamp")
    private String timestamp;
    @JSONField(name = "sign")
    private String sign;

    @NoArgsConstructor
    @Data
    public static class HeadCommitDTO {
        @JSONField(name = "id")
        private String id;
        @JSONField(name = "tree_id")
        private String treeId;
        @JSONField(name = "parent_ids")
        private List<String> parentIds;
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
        private Object added;
        @JSONField(name = "removed")
        private Object removed;
        @JSONField(name = "modified")
        private List<String> modified;

        @NoArgsConstructor
        @Data
        public static class AuthorDTO {
            @JSONField(name = "time")
            private String time;
            @JSONField(name = "id")
            private Integer id;
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "email")
            private String email;
            @JSONField(name = "username")
            private String username;
            @JSONField(name = "user_name")
            private String userName;
            @JSONField(name = "url")
            private String url;
        }

        @NoArgsConstructor
        @Data
        public static class CommitterDTO {
            @JSONField(name = "id")
            private Integer id;
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "email")
            private String email;
            @JSONField(name = "username")
            private String username;
            @JSONField(name = "user_name")
            private String userName;
            @JSONField(name = "url")
            private String url;
        }
    }

    @NoArgsConstructor
    @Data
    public static class RepositoryDTO {
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "path")
        private String path;
        @JSONField(name = "full_name")
        private String fullName;
        @JSONField(name = "owner")
        private OwnerDTO owner;
        @JSONField(name = "private")
        private Boolean privateX;
        @JSONField(name = "html_url")
        private String htmlUrl;
        @JSONField(name = "url")
        private String url;
        @JSONField(name = "description")
        private String description;
        @JSONField(name = "fork")
        private Boolean fork;
        @JSONField(name = "created_at")
        private String createdAt;
        @JSONField(name = "updated_at")
        private String updatedAt;
        @JSONField(name = "pushed_at")
        private String pushedAt;
        @JSONField(name = "git_url")
        private String gitUrl;
        @JSONField(name = "ssh_url")
        private String sshUrl;
        @JSONField(name = "clone_url")
        private String cloneUrl;
        @JSONField(name = "svn_url")
        private String svnUrl;
        @JSONField(name = "git_http_url")
        private String gitHttpUrl;
        @JSONField(name = "git_ssh_url")
        private String gitSshUrl;
        @JSONField(name = "git_svn_url")
        private String gitSvnUrl;
        @JSONField(name = "homepage")
        private Object homepage;
        @JSONField(name = "stargazers_count")
        private Integer stargazersCount;
        @JSONField(name = "watchers_count")
        private Integer watchersCount;
        @JSONField(name = "forks_count")
        private Integer forksCount;
        @JSONField(name = "language")
        private String language;
        @JSONField(name = "has_issues")
        private Boolean hasIssues;
        @JSONField(name = "has_wiki")
        private Boolean hasWiki;
        @JSONField(name = "has_pages")
        private Boolean hasPages;
        @JSONField(name = "license")
        private Object license;
        @JSONField(name = "open_issues_count")
        private Integer openIssuesCount;
        @JSONField(name = "default_branch")
        private String defaultBranch;
        @JSONField(name = "namespace")
        private String namespace;
        @JSONField(name = "name_with_namespace")
        private String nameWithNamespace;
        @JSONField(name = "path_with_namespace")
        private String pathWithNamespace;

        @NoArgsConstructor
        @Data
        public static class OwnerDTO {
            @JSONField(name = "login")
            private String login;
            @JSONField(name = "avatar_url")
            private String avatarUrl;
            @JSONField(name = "html_url")
            private String htmlUrl;
            @JSONField(name = "type")
            private String type;
            @JSONField(name = "site_admin")
            private Boolean siteAdmin;
            @JSONField(name = "id")
            private Integer id;
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "email")
            private String email;
            @JSONField(name = "username")
            private String username;
            @JSONField(name = "user_name")
            private String userName;
            @JSONField(name = "url")
            private String url;
        }
    }

    @NoArgsConstructor
    @Data
    public static class ProjectDTO {
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "path")
        private String path;
        @JSONField(name = "full_name")
        private String fullName;
        @JSONField(name = "owner")
        private OwnerDTO owner;
        @JSONField(name = "private")
        private Boolean privateX;
        @JSONField(name = "html_url")
        private String htmlUrl;
        @JSONField(name = "url")
        private String url;
        @JSONField(name = "description")
        private String description;
        @JSONField(name = "fork")
        private Boolean fork;
        @JSONField(name = "created_at")
        private String createdAt;
        @JSONField(name = "updated_at")
        private String updatedAt;
        @JSONField(name = "pushed_at")
        private String pushedAt;
        @JSONField(name = "git_url")
        private String gitUrl;
        @JSONField(name = "ssh_url")
        private String sshUrl;
        @JSONField(name = "clone_url")
        private String cloneUrl;
        @JSONField(name = "svn_url")
        private String svnUrl;
        @JSONField(name = "git_http_url")
        private String gitHttpUrl;
        @JSONField(name = "git_ssh_url")
        private String gitSshUrl;
        @JSONField(name = "git_svn_url")
        private String gitSvnUrl;
        @JSONField(name = "homepage")
        private Object homepage;
        @JSONField(name = "stargazers_count")
        private Integer stargazersCount;
        @JSONField(name = "watchers_count")
        private Integer watchersCount;
        @JSONField(name = "forks_count")
        private Integer forksCount;
        @JSONField(name = "language")
        private String language;
        @JSONField(name = "has_issues")
        private Boolean hasIssues;
        @JSONField(name = "has_wiki")
        private Boolean hasWiki;
        @JSONField(name = "has_pages")
        private Boolean hasPages;
        @JSONField(name = "license")
        private Object license;
        @JSONField(name = "open_issues_count")
        private Integer openIssuesCount;
        @JSONField(name = "default_branch")
        private String defaultBranch;
        @JSONField(name = "namespace")
        private String namespace;
        @JSONField(name = "name_with_namespace")
        private String nameWithNamespace;
        @JSONField(name = "path_with_namespace")
        private String pathWithNamespace;

        @NoArgsConstructor
        @Data
        public static class OwnerDTO {
            @JSONField(name = "login")
            private String login;
            @JSONField(name = "avatar_url")
            private String avatarUrl;
            @JSONField(name = "html_url")
            private String htmlUrl;
            @JSONField(name = "type")
            private String type;
            @JSONField(name = "site_admin")
            private Boolean siteAdmin;
            @JSONField(name = "id")
            private Integer id;
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "email")
            private String email;
            @JSONField(name = "username")
            private String username;
            @JSONField(name = "user_name")
            private String userName;
            @JSONField(name = "url")
            private String url;
        }
    }

    @NoArgsConstructor
    @Data
    public static class UserDTO {
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "email")
        private String email;
        @JSONField(name = "username")
        private String username;
        @JSONField(name = "user_name")
        private String userName;
        @JSONField(name = "url")
        private String url;
    }

    @NoArgsConstructor
    @Data
    public static class PusherDTO {
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "email")
        private String email;
        @JSONField(name = "username")
        private String username;
        @JSONField(name = "user_name")
        private String userName;
        @JSONField(name = "url")
        private String url;
    }

    @NoArgsConstructor
    @Data
    public static class SenderDTO {
        @JSONField(name = "login")
        private String login;
        @JSONField(name = "avatar_url")
        private String avatarUrl;
        @JSONField(name = "html_url")
        private String htmlUrl;
        @JSONField(name = "type")
        private String type;
        @JSONField(name = "site_admin")
        private Boolean siteAdmin;
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "email")
        private String email;
        @JSONField(name = "username")
        private String username;
        @JSONField(name = "user_name")
        private String userName;
        @JSONField(name = "url")
        private String url;
    }

    @NoArgsConstructor
    @Data
    public static class EnterpriseDTO {
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "url")
        private String url;
    }

    @NoArgsConstructor
    @Data
    public static class CommitsDTO {
        @JSONField(name = "id")
        private String id;
        @JSONField(name = "tree_id")
        private String treeId;
        @JSONField(name = "parent_ids")
        private List<String> parentIds;
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
        private Object added;
        @JSONField(name = "removed")
        private Object removed;
        @JSONField(name = "modified")
        private List<String> modified;

        @NoArgsConstructor
        @Data
        public static class AuthorDTO {
            @JSONField(name = "time")
            private String time;
            @JSONField(name = "id")
            private Integer id;
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "email")
            private String email;
            @JSONField(name = "username")
            private String username;
            @JSONField(name = "user_name")
            private String userName;
            @JSONField(name = "url")
            private String url;
        }

        @NoArgsConstructor
        @Data
        public static class CommitterDTO {
            @JSONField(name = "id")
            private Integer id;
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "email")
            private String email;
            @JSONField(name = "username")
            private String username;
            @JSONField(name = "user_name")
            private String userName;
            @JSONField(name = "url")
            private String url;
        }
    }
}
