// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: readings.proto

package fer.rassus.lab1.client;

public interface SensorReadingResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:fer.rassus.lab1.SensorReadingResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>float temperature = 1;</code>
   * @return The temperature.
   */
  float getTemperature();

  /**
   * <code>float pressure = 2;</code>
   * @return The pressure.
   */
  float getPressure();

  /**
   * <code>float humidity = 3;</code>
   * @return The humidity.
   */
  float getHumidity();

  /**
   * <code>float co = 4;</code>
   * @return The co.
   */
  float getCo();

  /**
   * <code>float so2 = 5;</code>
   * @return The so2.
   */
  float getSo2();

  /**
   * <code>float no2 = 6;</code>
   * @return The no2.
   */
  float getNo2();
}
