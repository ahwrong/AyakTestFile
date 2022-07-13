package com.ayak.phms.membership;

import java.util.List;


public class UserService {
   public UserDao userDao;
   
   public UserService(UserDao userDao) {
      this.userDao = userDao;      
   }

   public void addUser(User user) {
      userDao.userUpload(user);
   }
   
   public List<User> findUser() {
      return userDao.findAllUsers();
   }


   public boolean isValidUser(String userid, String userpw) {
      return userDao.isValidUser(userid, userpw);
   }

}
