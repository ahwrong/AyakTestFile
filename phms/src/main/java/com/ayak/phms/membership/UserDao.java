package com.ayak.phms.membership;

import java.sql.*;
import java.util.*;

public class UserDao {
   
   private DataSource dataSource;
   
   public UserDao() {      
      NamingService namingService = NamingService.getInstance();
      dataSource = (DataSource)namingService.getAttribute("dataSource");
   }
   
   public void userUpload(User user){
      String sql = "INSERT INTO User(Username, UserBirth, Userage, Usergender, Userphone, Useremail, Userid, Userpw)" + " VALUES (?,?,?,?,?,?,?,?)";
      
       try {
          Connection con = null;
          PreparedStatement pstmt = null;
         try {
            con = dataSource.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getUserBirth());
            pstmt.setString(3, user.getUserage());
            pstmt.setString(4, user.getUsergender());
            pstmt.setString(5, user.getUserphone());
            pstmt.setString(6, user.getUseremail());
            pstmt.setString(7, user.getUserid());
            pstmt.setString(8, user.getUserpw());
            pstmt.executeUpdate();
            } finally {
               dataSource.close(pstmt,con);   
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public List<User> findAllUsers(){
      String sql = "SELECT * FROM User";
      List<User> userList = new ArrayList<>();
      
       try {
          Connection con = null;
          PreparedStatement pstmt = null;
          ResultSet rs = null;
         try {
            con = dataSource.getConnection();  //DriverManager.getConnection 코드를 바꿔도 상관없다?? DataSourceManager메소드에서 연결시키기 때문에?
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
               User c = new User();
               c.setUsername(rs.getString("Username"));
               c.setUserBirth(rs.getString("UserBirth"));
               c.setUsername(rs.getString("Username"));
               c.setUserage(rs.getString("Userage"));
               c.setUsergender(rs.getString("Usergender"));
               c.setUseremail(rs.getString("Useremail"));
               c.setUserid(rs.getString("Userid"));
               c.setUserpw(rs.getString("Userpw"));
               userList.add(c);
               }
            } finally {
               dataSource.close(rs,pstmt,con);   
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return userList;
   }
   
   public boolean isValidUser(String Userid, String Userpw) { //주민번호로 고객조회하는 메소드
      String sql = "SELECT * FROM User WHERE Userid= ? AND Userpw=? ";
      boolean boo = true;
      try {
          Connection con = null;
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          try {
             con = dataSource.getConnection();
               pstmt = con.prepareStatement(sql);
               pstmt.setString(1, Userid); //위 where?로 조회하는거임
               pstmt.setString(2, Userpw);
               rs = pstmt.executeQuery();  /*rs 객체의 값을 반환 , SELECT 구문을 수행*/
               if(!rs.next()) {
                  boo = false;
               }
         } finally {
            dataSource.close(rs,pstmt,con);   
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return boo;
   }
   
}