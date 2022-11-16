package se.lexicon;


import se.lexicon.dao.*;
import se.lexicon.model.AppUser;
import se.lexicon.model.Booking;
import se.lexicon.model.Patient;

import java.time.LocalDate;
import java.util.List;

public class App {
  public static void main(String[] args) {
    AppUserDao storage = new AppUserDaoImpl();
    PatientDao patientStorage = new PatientDaoImpl();
    BookingDao bookingStorage = new BookingDaoImpl();


    AppUser userData1 = new AppUser("user1", "password");
    AppUser userData2 = new AppUser("user2", "password");
    AppUser createdAppUser1 = storage.create(userData1);
    AppUser createdAppUser2 = storage.create(userData2);


    Patient patientData1 = new Patient("111111-1111", "patient1", "patient1.test@test.se", createdAppUser1);
    Patient patientData2 = new Patient("111111-2222", "patient2", "patient2.test@test.se", createdAppUser2);
    Patient registeredPatient1 = patientStorage.create(patientData1);
    Patient registeredPatient2 = patientStorage.create(patientData2);

    //System.out.println(patientStorage.findAll());
    bookingStorage.generateBookingTable(LocalDate.parse("2023-01-01"), 2);
    List<Booking> bookingList = bookingStorage.findByDateBetween(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-10"));
    String bookingId1 = bookingList.get(1).getId();
    String bookingId2 = bookingList.get(3).getId();

    for (Booking booking : bookingList) {
      System.out.println(booking);
    }

    boolean isBooking1 = bookingStorage.reserve(bookingId1, patientData1);
    boolean isBooking2 = bookingStorage.reserve(bookingId2, patientData1);
    //boolean isBooking3 = bookingStorage.cancel(bookingId1, patientData1);


    System.out.println("------------------------");
    for (Booking booking : bookingList) {
      System.out.println(booking);
    }

    System.out.println("------------------------");
    System.out.println(bookingStorage.findBookingBySsn("111111-1111"));

  }
}
