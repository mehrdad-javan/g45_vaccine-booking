package se.lexicon.dao;

import se.lexicon.model.Booking;
import se.lexicon.model.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl implements BookingDao {


  private List<Booking> bookingList;

  public BookingDaoImpl() {
    bookingList = new ArrayList<>();
  }

  @Override
  public void generateBookingTable(LocalDate localDate, int numberOfDays) {

  }

  @Override
  public List<Booking> findByDateBetween(LocalDate start, LocalDate end) {
    List<Booking> filteredList = new ArrayList<>();
    for (Booking booking : bookingList) {
      LocalDate bookingDate = booking.getDateTime().toLocalDate();
      if ((bookingDate.isAfter(start) || bookingDate.equals(start)) &&
              (bookingDate.isBefore(end) || bookingDate.equals(end))) {
        filteredList.add(booking);
      }

    }
    return filteredList;
  }

  @Override
  public List<Booking> findByDate(LocalDate date) {
    List<Booking> filteredList = new ArrayList<>();
    for (Booking booking : bookingList) {
      LocalDate bookingDate = booking.getDateTime().toLocalDate();
      if (bookingDate.equals(date)) {
        filteredList.add(booking);
      }

    }
    return filteredList;
  }

  @Override
  public boolean reserve(String bookingId, Patient patient) {
    for (Booking booking : bookingList) {
      if (booking.isVacant()  && booking.getId().equalsIgnoreCase(bookingId)){
        booking.setPatient(patient);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean cancel(String bookingId, Patient patient) {
    for (Booking booking : bookingList) {
      if (!booking.isVacant() && booking.getId().equalsIgnoreCase(bookingId)){
        booking.setPatient(null);
        return true;
      }
    }
    return false;
  }

  @Override
  public List<Booking> findBookingBySsn(String ssn) {
    return null;
  }
}
