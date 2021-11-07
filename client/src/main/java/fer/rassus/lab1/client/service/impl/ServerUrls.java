package fer.rassus.lab1.client.service.impl;

import fer.rassus.lab1.client.properties.ServerProperties;

public class ServerUrls {

    private final String registerUrl;

    public ServerUrls(ServerProperties serverProperties) {
        this.registerUrl = serverProperties.getUrl() + "/sensor";
    }

    public String getRegisterUrl() {
        return registerUrl;
    }
}
