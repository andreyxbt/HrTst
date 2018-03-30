package com.test.here.heretest.domain.entities;

import io.reactivex.annotations.Nullable;

public interface Repository {
    
    long getId();

    String getName();
    
    String getFullName();
    
    Owner getOwner();

    boolean isPrivate();
    
    String getHtmlUrl();
    
    String getDescription();
    
    boolean isFork();

    String getUrl();

    String getCreatedAt();

    String getUpdatedAt();

    String getPushedAt();

    String getGitUrl();

    String getSshUrl();
    
    String getCloneUrl();

    @Nullable
    String getSvnUrl();

    @Nullable
    String getHomepage();
    
    long getSize();

    @Nullable
    String getLanguage();

    /*String getForksUrl();

    String getKeysUrl();

    String getCollaboratorsUrl();

    String getTeamsUrl();

    String getHooksUrl();

    String getIssueEventsUrl();

    String getEventsUrl();

    String getAssigneesUrl();

    String getBranchesUrl();

    String getTagsUrl();

    String getBlobsUrl();

    String getGitTagsUrl();

    String getGitRefsUrl();

    String getTreesUrl();

    String getStatusesUrl();

    String getLanguagesUrl();

    String getStargazersUrl();

    String getContributorsUrl();

    String getSubscribersUrl();

    String getSubscriptionUrl();

    String getCommitsUrl();

    String getGitCommitsUrl();

    String getCommentsUrl();

    String getIssueCommentUrl();

    String getContentsUrl();

    String getCompareUrl();

    String getMergesUrl();

    String getArchiveUrl();

    String getDownloadsUrl();

    String getIssuesUrl();

    String getPullsUrl();

    String getMilestonesUrl();

    String getNotificationsUrl();

    String getLabelsUrl();

    String getReleasesUrl();

    String getDeploymentsUrl();

    boolean hasIssues();

    boolean hasProjects();

    boolean hasDownloads();

    boolean hasWiki();

    boolean hasPages();

    long getForksCount();

    @Nullable
    String getMirrorUrl();

    boolean isArchived();

    long getOpenIssuesCount();

    License getLicense();

    long getForks();

    long getOpenIssues();

    long getWatchers();

    String getDefaultBranch();

    long getStargazersCount();

    long getWatchersCount();

    */
}
