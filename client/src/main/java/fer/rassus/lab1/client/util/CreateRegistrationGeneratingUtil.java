package fer.rassus.lab1.client.util;

import fer.rassus.lab1.client.properties.ServerProperties;
import fer.rassus.lab1.client.service.request.CreateRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public final class CreateRegistrationGeneratingUtil {

    @Value("${rassus.server.url-path}")
    private int port;

    public CreateRegistrationRequest generateRegistrationRequest() {
        CreateRegistrationRequest sensorInfo = new CreateRegistrationRequest();

        sensorInfo.setLatitude(generateLatitude());
        sensorInfo.setLongitude(generateLongitude());
        sensorInfo.setIp("127.0.0.1");
        sensorInfo.setPort(port);

        return sensorInfo;
    }

    private static double generateLatitude() {
        double min = 45.75;
        double toAdd = Math.random() / 10;
        return min + toAdd;
    }

    private static double generateLongitude() {
        double min = 15.87;
        double toAdd = (int)(Math.random() * 13) / (double)100;
        return min + toAdd;
    }
}
