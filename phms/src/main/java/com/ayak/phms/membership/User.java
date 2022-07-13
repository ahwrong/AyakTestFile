package com.ayak.phms.membership;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
   private static final long serialVersionUID = 1L;
   private String Username;
   private String UserBirth;
   private String Userage;
   private String Usergender;
   private String Userphone;
   private String Useremail;
   private String Userid;
   private String Userpw;
   
   private List<User> userList; 
   
   public User() {
      
   }
   
   public List<User> getUserList() {
      return userList;
   }


   public void setUserList(List<User> userList) {
      this.userList = userList;
   }
   
   public String getUsername() {
	   return Username;
   }

   public void setUsername(String username) {
	   Username = username;
   }

   public String getUserBirth() {
	   return UserBirth;
   }

   public void setUserBirth(String userBirth) {
	   UserBirth = userBirth;
   }

   public String getUserage() {
	   return Userage;
   }

   public void setUserage(String userage) {
	   Userage = userage;
   }

   public String getUsergender() {
	   return Usergender;
   }

   public void setUsergender(String usergender) {
	   Usergender = usergender;
   }

   public String getUserphone() {
	   return Userphone;
   }

   public void setUserphone(String userphone) {
	   Userphone = userphone;
   }

   public String getUseremail() {
	   return Useremail;
   }

	public void setUseremail(String useremail) {
		Useremail = useremail;
	}
	
	public String getUserid() {
		return Userid;
	}
	
	public void setUserid(String userid) {
		Userid = userid;
	}
	
	public String getUserpw() {
		return Userpw;
	}
	
	public void setUserpw(String userpw) {
		Userpw = userpw;
	}
	
}