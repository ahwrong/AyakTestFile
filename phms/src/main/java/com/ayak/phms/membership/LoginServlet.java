package com.ayak.phms.membership;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/membership/login")
public class LoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   private UserService userService;
   
   public void init() {
      userService = new UserService(new UserDao());
   }


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //로그페이지를 보냄?
      request.getRequestDispatcher("login.jsp").forward(request, response);
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String Userid = request.getParameter("Userid");
      String Userpw = request.getParameter("Userpw");
      System.out.println(Userid);
      System.out.println(Userpw);
      
      //요청 파라메터 검증
      //....
      if(!userService.isValidUser(Userid, Userpw)) {
         request.getRequestDispatcher("login.jsp").forward(request, response);
         return;
      }
      
      HttpSession session = request.getSession(true);
      session.setAttribute("Userid", Userid);
      response.sendRedirect("mypage"); //sendRedirect 컨테이너 호출을 한번 더 해서 주소 바뀜?
   }

}