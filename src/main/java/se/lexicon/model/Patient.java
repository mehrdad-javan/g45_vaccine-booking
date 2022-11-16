package se.lexicon.model;

import java.time.LocalDate;

public class Patient {

  private String ssn;
  private String name;
  private String email;
  private LocalDate birthDate;
  private AppUser appUser;

  // constructors
  public Patient(String ssn, String name, String email, AppUser appUser) {
    setSsn(ssn);
    setName(name);
    this.email = email;
    setAppUser(appUser);
  }

  // getters & setters + methods


  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    if (ssn == null) throw new IllegalArgumentException("ssn was null");
    this.ssn = ssn;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null) throw new IllegalArgumentException("name was null");
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    if (email == null) throw new IllegalArgumentException("email was null");
    this.email = email;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    if (birthDate == null) throw new IllegalArgumentException("birthDate was null");
    this.birthDate = birthDate;
  }

  public AppUser getAppUser() {
    return appUser;
  }

  public void setAppUser(AppUser appUser) {
    if (appUser == null) throw new IllegalArgumentException("appUser was null");
    this.appUser = appUser;
  }

  @Override
  public String toString() {
    return "Patient{" +
            "ssn='" + ssn + '\'' +
            ", name='" + name + '\'' +
            '}';
  }
}
