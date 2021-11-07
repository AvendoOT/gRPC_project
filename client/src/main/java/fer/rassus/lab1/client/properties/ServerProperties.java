package fer.rassus.lab1.client.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rassus.server")
public class ServerProperties {

    private String url;

    public String getUrl() {
        return url;
    }
}
