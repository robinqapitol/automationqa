
package com.qapitol.automationqa.api.pojo;

import java.util.HashMap;
import java.util.Map;

public class Preferences {

    private Boolean enableAutoAway;
    private Integer idleTimeLimit;
    private Integer desktopNotificationDuration;
    private String audioNotifications;
    private String desktopNotifications;
    private String mobileNotifications;
    private Boolean unreadAlert;
    private Boolean useEmojis;
    private Boolean convertAsciiEmoji;
    private Boolean autoImageLoad;
    private Boolean saveMobileBandwidth;
    private Boolean collapseMediaByDefault;
    private Boolean hideUsernames;
    private Boolean hideRoles;
    private Boolean hideFlexTab;
    private Boolean hideAvatars;
    private Boolean sidebarGroupByType;
    private String sidebarViewMode;
    private Boolean sidebarHideAvatar;
    private Boolean sidebarShowUnread;
    private Boolean sidebarShowFavorites;
    private String sendOnEnter;
    private Integer messageViewMode;
    private String emailNotificationMode;
    private Boolean roomCounterSidebar;
    private String newRoomNotification;
    private String newMessageNotification;
    private Boolean muteFocusedConversations;
    private Integer notificationsSoundVolume;
    private Boolean sidebarShowDiscussion;

    public Boolean getEnableAutoAway() {
        return enableAutoAway;
    }

    public void setEnableAutoAway(Boolean enableAutoAway) {
        this.enableAutoAway = enableAutoAway;
    }

    public Integer getIdleTimeLimit() {
        return idleTimeLimit;
    }

    public void setIdleTimeLimit(Integer idleTimeLimit) {
        this.idleTimeLimit = idleTimeLimit;
    }

    public Integer getDesktopNotificationDuration() {
        return desktopNotificationDuration;
    }

    public void setDesktopNotificationDuration(Integer desktopNotificationDuration) {
        this.desktopNotificationDuration = desktopNotificationDuration;
    }

    public String getAudioNotifications() {
        return audioNotifications;
    }

    public void setAudioNotifications(String audioNotifications) {
        this.audioNotifications = audioNotifications;
    }

    public String getDesktopNotifications() {
        return desktopNotifications;
    }

    public void setDesktopNotifications(String desktopNotifications) {
        this.desktopNotifications = desktopNotifications;
    }

    public String getMobileNotifications() {
        return mobileNotifications;
    }

    public void setMobileNotifications(String mobileNotifications) {
        this.mobileNotifications = mobileNotifications;
    }

    public Boolean getUnreadAlert() {
        return unreadAlert;
    }

    public void setUnreadAlert(Boolean unreadAlert) {
        this.unreadAlert = unreadAlert;
    }

    public Boolean getUseEmojis() {
        return useEmojis;
    }

    public void setUseEmojis(Boolean useEmojis) {
        this.useEmojis = useEmojis;
    }

    public Boolean getConvertAsciiEmoji() {
        return convertAsciiEmoji;
    }

    public void setConvertAsciiEmoji(Boolean convertAsciiEmoji) {
        this.convertAsciiEmoji = convertAsciiEmoji;
    }

    public Boolean getAutoImageLoad() {
        return autoImageLoad;
    }

    public void setAutoImageLoad(Boolean autoImageLoad) {
        this.autoImageLoad = autoImageLoad;
    }

    public Boolean getSaveMobileBandwidth() {
        return saveMobileBandwidth;
    }

    public void setSaveMobileBandwidth(Boolean saveMobileBandwidth) {
        this.saveMobileBandwidth = saveMobileBandwidth;
    }

    public Boolean getCollapseMediaByDefault() {
        return collapseMediaByDefault;
    }

    public void setCollapseMediaByDefault(Boolean collapseMediaByDefault) {
        this.collapseMediaByDefault = collapseMediaByDefault;
    }

    public Boolean getHideUsernames() {
        return hideUsernames;
    }

    public void setHideUsernames(Boolean hideUsernames) {
        this.hideUsernames = hideUsernames;
    }

    public Boolean getHideRoles() {
        return hideRoles;
    }

    public void setHideRoles(Boolean hideRoles) {
        this.hideRoles = hideRoles;
    }

    public Boolean getHideFlexTab() {
        return hideFlexTab;
    }

    public void setHideFlexTab(Boolean hideFlexTab) {
        this.hideFlexTab = hideFlexTab;
    }

    public Boolean getHideAvatars() {
        return hideAvatars;
    }

    public void setHideAvatars(Boolean hideAvatars) {
        this.hideAvatars = hideAvatars;
    }

    public Boolean getSidebarGroupByType() {
        return sidebarGroupByType;
    }

    public void setSidebarGroupByType(Boolean sidebarGroupByType) {
        this.sidebarGroupByType = sidebarGroupByType;
    }

    public String getSidebarViewMode() {
        return sidebarViewMode;
    }

    public void setSidebarViewMode(String sidebarViewMode) {
        this.sidebarViewMode = sidebarViewMode;
    }

    public Boolean getSidebarHideAvatar() {
        return sidebarHideAvatar;
    }

    public void setSidebarHideAvatar(Boolean sidebarHideAvatar) {
        this.sidebarHideAvatar = sidebarHideAvatar;
    }

    public Boolean getSidebarShowUnread() {
        return sidebarShowUnread;
    }

    public void setSidebarShowUnread(Boolean sidebarShowUnread) {
        this.sidebarShowUnread = sidebarShowUnread;
    }

    public Boolean getSidebarShowFavorites() {
        return sidebarShowFavorites;
    }

    public void setSidebarShowFavorites(Boolean sidebarShowFavorites) {
        this.sidebarShowFavorites = sidebarShowFavorites;
    }

    public String getSendOnEnter() {
        return sendOnEnter;
    }

    public void setSendOnEnter(String sendOnEnter) {
        this.sendOnEnter = sendOnEnter;
    }

    public Integer getMessageViewMode() {
        return messageViewMode;
    }

    public void setMessageViewMode(Integer messageViewMode) {
        this.messageViewMode = messageViewMode;
    }

    public String getEmailNotificationMode() {
        return emailNotificationMode;
    }

    public void setEmailNotificationMode(String emailNotificationMode) {
        this.emailNotificationMode = emailNotificationMode;
    }

    public Boolean getRoomCounterSidebar() {
        return roomCounterSidebar;
    }

    public void setRoomCounterSidebar(Boolean roomCounterSidebar) {
        this.roomCounterSidebar = roomCounterSidebar;
    }

    public String getNewRoomNotification() {
        return newRoomNotification;
    }

    public void setNewRoomNotification(String newRoomNotification) {
        this.newRoomNotification = newRoomNotification;
    }

    public String getNewMessageNotification() {
        return newMessageNotification;
    }

    public void setNewMessageNotification(String newMessageNotification) {
        this.newMessageNotification = newMessageNotification;
    }

    public Boolean getMuteFocusedConversations() {
        return muteFocusedConversations;
    }

    public void setMuteFocusedConversations(Boolean muteFocusedConversations) {
        this.muteFocusedConversations = muteFocusedConversations;
    }

    public Integer getNotificationsSoundVolume() {
        return notificationsSoundVolume;
    }

    public void setNotificationsSoundVolume(Integer notificationsSoundVolume) {
        this.notificationsSoundVolume = notificationsSoundVolume;
    }

    public Boolean getSidebarShowDiscussion() {
        return sidebarShowDiscussion;
    }

    public void setSidebarShowDiscussion(Boolean sidebarShowDiscussion) {
        this.sidebarShowDiscussion = sidebarShowDiscussion;
    }
}
