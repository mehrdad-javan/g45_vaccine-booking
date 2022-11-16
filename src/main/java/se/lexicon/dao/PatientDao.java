package se.lexicon.dao;

import se.lexicon.model.Patient;

import java.util.List;

public interface PatientDao {

  Patient create(Patient patient);

  Patient findBySsn(String ssn);

  List<Patient> findAll();

}
