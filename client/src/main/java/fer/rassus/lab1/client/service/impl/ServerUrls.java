package fer.rassus.lab1.client.service.impl;

import fer.rassus.lab1.client.properties.ServerProperties;

public class ServerUrls {

    private final String registerUrl;

    private final String neighbourUrl;

    private final String dataUrl;

    public ServerUrls(ServerProperties serverProperties) {
        this.registerUrl = serverProperties.getUrl() + "sensor";
        this.neighbourUrl = serverProperties.getUrl() + "%s/neighbour";
        this.dataUrl = serverProperties.getUrl() + "sensor/%s";
    }

    public String getRegisterUrl() {
        return registerUrl;
    }

    public String getNeighbourUrl() {
        return neighbourUrl;
    }

    public String getDataUrl() {
        return dataUrl;
    }
}