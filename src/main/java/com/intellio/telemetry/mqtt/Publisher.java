package com.intellio.telemetry.mqtt;

import com.intellio.telemetry.enums.NotificationType;
import com.intellio.telemetry.notification.Notifiable;
import com.intellio.telemetry.qualifiers.Notify;
import com.intellio.telemetry.utils.NetworkUtils;
import org.eclipse.paho.client.mqttv3.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Startup;
import javax.ejb.Stateful;

@Startup
@Stateful
@Notify(NotificationType.MOBILE)
public class Publisher implements Notifiable {

    private static String BROKER_URL = "tcp://localhost:1883";

    private static final String TOPIC_BEATS = "app/beats";

    private String clientId;

    private MqttClient client;

    @PostConstruct
    public void init() {
        clientId = NetworkUtils.getMacAddress() + "-pub";
        try {
            client = new MqttClient(BROKER_URL, clientId);
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setCleanSession(false);
            client.connect(connectOptions);

            System.out.println("Connected");
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void destroy() {
        client = null;
    }

    @Override
    public void notify(String message)  {
        try {
            final MqttTopic topic = client.getTopic(TOPIC_BEATS);
            topic.publish(new MqttMessage(message.getBytes()));
            System.out.println("Published message");

        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
