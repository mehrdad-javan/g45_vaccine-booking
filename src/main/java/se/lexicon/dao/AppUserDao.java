package se.lexicon.dao;

import se.lexicon.model.AppUser;

import java.util.List;

public interface AppUserDao {

  AppUser create(AppUser appUser);

  AppUser findByUsername(String username);

  List<AppUser> findAll();

}
