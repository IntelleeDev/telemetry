package com.intellio.telemetry.enums;


public enum NotificationType {
    MOBILE("Mobile Push Notifications"),
    WEB("Web Push Notifications");

    private String content;

    NotificationType(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
