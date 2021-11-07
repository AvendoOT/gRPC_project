package fer.rassus.lab1.client.service.impl;

import fer.rassus.lab1.client.SensorReadingResponse;
import fer.rassus.lab1.client.properties.ServerProperties;
import fer.rassus.lab1.client.service.SensorReadingFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class SensorReadingFileServiceImpl implements SensorReadingFileService {

    private final ServerProperties serverProperties;

    @Autowired
    public SensorReadingFileServiceImpl(ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }

    private interface FieldSetter {
        void setField(Float value);
    }

    @Override
    public SensorReadingResponse getSensorReading() {
        String randomLine = "";
        try {
            randomLine = getRandomLine();
        } catch (IOException e) {
            System.out.println("Error");
        }

        if (Objects.equals(randomLine, "")) {
            return SensorReadingResponse.newBuilder().build();
        }

        return parseLine(randomLine);
    }

    private SensorReadingResponse parseLine(String line) {
        String[] splited = line.split(",", -1);

        SensorReadingResponse.Builder responseBuilder = SensorReadingResponse.newBuilder();
        setFieldValueIfValid(splited[0], responseBuilder::setTemperature);
        setFieldValueIfValid(splited[1], responseBuilder::setPressure);
        setFieldValueIfValid(splited[2], responseBuilder::setHumidity);
        setFieldValueIfValid(splited[3], responseBuilder::setCo);
        setFieldValueIfValid(splited[4], responseBuilder::setNo2);
        setFieldValueIfValid(splited[4], responseBuilder::setSo2);

        return responseBuilder.build();
    }

    private String getRandomLine() throws IOException {
        Stream<String> lines = Files.lines(Paths.get(serverProperties.getPath()));
        int line = ((int)(Math.random() * 100)) + 1;
        return lines.skip(line - 1).findFirst().get();
    }

    private void setFieldValueIfValid(String value, FieldSetter fieldSetter) {
        if (!Objects.equals(value, "")) {
            fieldSetter.setField(Float.parseFloat(value));
        }
    }
}
