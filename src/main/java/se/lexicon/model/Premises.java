package se.lexicon.model;

public enum Premises {
  PLACE_1("Address1"), PLACE_2("Address2");

  private String address;

  Premises(String address) {
    this.address = address;
  }

  private String getAddress() {
    return address;
  }

}
