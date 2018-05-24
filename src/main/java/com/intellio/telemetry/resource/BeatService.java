package com.intellio.telemetry.resource;

import com.intellio.telemetry.enums.NotificationType;
import com.intellio.telemetry.model.Beat;
import com.intellio.telemetry.notification.Notifiable;
import com.intellio.telemetry.qualifiers.NotificationQualifier;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class BeatService implements BeatResource {

    private static List<Beat> beats;

    @Inject @Any
    private Instance<Notifiable> notifiables;

    private Notifiable notifiable;

    @PostConstruct
    public void init() {
        beats = new ArrayList<>();
        beats.add(new Beat("Mikey", 899494));
        beats.add(new Beat("Jake", 893034));
        beats.add(new Beat("Smiggle", 899034));

        notifiable = notifiables.select(new NotificationQualifier(NotificationType.MOBILE)).get();
    }

    @Override
    public Response getAll() {
        notifiable.notify("Retrieved All Beats");
        return Response.ok(beats).build();
    }
}
