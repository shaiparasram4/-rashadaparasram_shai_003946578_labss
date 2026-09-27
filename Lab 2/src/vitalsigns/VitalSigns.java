/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vitalsigns;

/**
 * Info 5100
 * Shai Rashada Parasram
 * Lab 2
 * 9/26/2026
 * @author shai8
 */


public class VitalSigns {

    private String date;
    private float temperature;
    private double bloodPressure;
    private int pulse;

    public VitalSigns() {
    }

    public VitalSigns(String date, float temperature,
                      double bloodPressure, int pulse) {
        this.date = date;
        this.temperature = temperature;
        this.bloodPressure = bloodPressure;
        this.pulse = pulse;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }
}
