package se.lexicon;


import se.lexicon.dao.AppUserDao;
import se.lexicon.dao.AppUserDaoImpl;
import se.lexicon.dao.PatientDao;
import se.lexicon.dao.PatientDaoImpl;
import se.lexicon.model.AppUser;
import se.lexicon.model.Patient;

public class App {
  public static void main(String[] args) {
    AppUserDao storage = new AppUserDaoImpl();
    PatientDao patientStorage = new PatientDaoImpl();


    AppUser userData1 = new AppUser("user1", "password");
    AppUser userData2 = new AppUser("user2", "password");


    AppUser createdAppUser1 = storage.create(userData1);
    AppUser createdAppUser2 = storage.create(userData2);

    System.out.println(storage.findAll());
    System.out.println(storage.findByUsername("user2"));

    Patient patientData1 = new Patient("111111-1111", "patient1", "patient1.test@test.se", createdAppUser1);
    Patient patientData2 = new Patient("111111-2222", "patient2", "patient2.test@test.se", createdAppUser2);

    Patient registeredPatient1 = patientStorage.create(patientData1);
    Patient registeredPatient2 = patientStorage.create(patientData2);

    System.out.println(patientStorage.findAll());


  }
}
