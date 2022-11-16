package se.lexicon.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Booking {

  private final String id;
  private final LocalDateTime dateTime;
  private final double price;
  private final String vaccineType;
  private boolean vacant;
  private Premises premises;
  private Patient patient;

  public Booking(LocalDateTime dateTime, double price, String vaccineType){
    this.id = UUID.randomUUID().toString();
    this.dateTime = dateTime;
    this.price = price;
    this.vaccineType = vaccineType;
    this.vacant = true;
  }

  public String getId() {
    return id;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public double getPrice() {
    return price;
  }

  public String getVaccineType() {
    return vaccineType;
  }

  public boolean isVacant() {
    return vacant;
  }

  public Premises getPremises() {
    return premises;
  }

  public void setPremises(Premises premises) {
    this.premises = premises;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
    this.vacant = (patient == null);
    /*if (patient == null){
      this.vacant = true;
    }else {
      this.vacant = false;
    }*/
  }

  @Override
  public String toString() {
    return "Booking{" +
            "id='" + id + '\'' +
            ", dateTime=" + dateTime +
            ", vaccineType='" + vaccineType + '\'' +
            ", vacant=" + vacant +
            '}';
  }

}
