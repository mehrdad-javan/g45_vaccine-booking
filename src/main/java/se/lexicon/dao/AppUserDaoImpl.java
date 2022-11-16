package se.lexicon.dao;

import se.lexicon.model.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserDaoImpl implements AppUserDao {

  private List<AppUser> userStorage;

  public AppUserDaoImpl() {
    userStorage = new ArrayList<>();
  }

  @Override
  public AppUser create(AppUser appUser) {
    if (appUser == null) throw new IllegalArgumentException("appUser was null");
    AppUser result = findByUsername(appUser.getUsername());
    if (result != null) throw new IllegalArgumentException("username was duplicate");
    userStorage.add(appUser);
    return appUser;
  }

  @Override
  public AppUser findByUsername(String username) {
    if (username == null) throw new IllegalArgumentException("username was null");
    for (AppUser appUser : userStorage)
      if (appUser.getUsername().equalsIgnoreCase(username)) return appUser;
    return null;
  }

  @Override
  public List<AppUser> findAll() {
    return new ArrayList<>(userStorage);
  }
}
