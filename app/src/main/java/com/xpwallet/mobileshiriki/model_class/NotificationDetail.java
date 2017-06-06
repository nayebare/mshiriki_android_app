package com.xpwallet.mobileshiriki.model_class;

/**
 * Created by Desktop on 05-Jan-17.
 */
public class NotificationDetail {
    String notification_content,notification_id;
    String created_at;

    public String getNotification_content() {
        return notification_content;
    }

    public void setNotification_content(String notification_content) {
        this.notification_content = notification_content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(String notification_id1) {
        this.notification_id = notification_id1;
    }
}
