package com.intellio.telemetry.qualifiers;

import com.intellio.telemetry.enums.NotificationType;

import javax.enterprise.util.AnnotationLiteral;

public class NotificationQualifier extends AnnotationLiteral<Notify> implements Notify {

    private NotificationType type;

    public NotificationQualifier(NotificationType type) {
        this.type = type;
    }

    @Override
    public NotificationType value() {
        return type;
    }
}
