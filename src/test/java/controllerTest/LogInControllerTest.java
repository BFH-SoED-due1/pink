/// *
// * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
// * Project Smart Reservation System.
// * Distributable under GPL license. See terms of license at gnu.org.
// */
// package controllerTest;
//
// import static org.junit.Assert.assertEquals;
//
// import java.util.ArrayList;
// import java.util.List;
//
// import org.junit.Test;
//
// import jpa.SystemUser;
// import service.implementation.LogInController;
// import service.implementation.exceptions.UserLoginFailedException;
//
// public class LogInControllerTest {
//
// @Test
// public void loginTest() {
// SystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111",
/// false);
// List<SystemUser> userList = new ArrayList<SystemUser>();
// userList.add(hans);
//
// LogInController lc = new LogInController(userList);
// lc.userLogin("hans@zimmer.ch", "111");
// assertEquals(true, hans.isLoggedIn());
// }
//
// @Test
// public void logoutTest() {
// SystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111",
/// false);
// List<SystemUser> userList = new ArrayList<SystemUser>();
// userList.add(hans);
//
// LogInController lc = new LogInController(userList);
// lc.userLogout("hans@zimmer.ch");
// assertEquals(false, hans.isLoggedIn());
// }
//
// @Test(expected = UserLoginFailedException.class)
// public void userNotExistsTest() {
// SystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111",
/// false);
// List<SystemUser> userList = new ArrayList<SystemUser>();
// userList.add(hans);
//
// LogInController lc = new LogInController(userList);
// lc.userLogin("not@exists.ch", "111");
// }
//
// @Test(expected = UserLoginFailedException.class)
// public void wrongPwTest() {
// SystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111",
/// false);
// List<SystemUser> userList = new ArrayList<SystemUser>();
// userList.add(hans);
//
// LogInController lc = new LogInController(userList);
// lc.userLogin("hans@zimmer.ch", "222");
// }
//
// @Test(expected = UserLoginFailedException.class)
// public void allreadyLoggedInTest() {
// SystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111",
/// false);
// List<SystemUser> userList = new ArrayList<SystemUser>();
// userList.add(hans);
//
// LogInController lc = new LogInController(userList);
// lc.userLogin("hans@zimmer.ch", "111");
//
// lc.userLogin("hans@zimmer.ch", "111");
// }
//
// @Test(expected = UserLoginFailedException.class)
// public void emptyUserLoginTest() {
// SystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111",
/// false);
// List<SystemUser> userList = new ArrayList<SystemUser>();
// userList.add(hans);
//
// LogInController lc = new LogInController(userList);
// lc.userLogin("", "");
// assertEquals(true, hans.isLoggedIn());
// }
//
// @Test(expected = UserLoginFailedException.class)
// public void emptyUserLogoutTest() {
// SystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111",
/// false);
// List<SystemUser> userList = new ArrayList<SystemUser>();
// userList.add(hans);
//
// LogInController lc = new LogInController(userList);
// lc.userLogout("");
// assertEquals(false, hans.isLoggedIn());
// }
// }
