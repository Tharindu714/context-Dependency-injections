package com.deltacodex.ee.web;

import com.deltacodex.ee.ejb.remote.UserRegistration;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.deltacodex.ee.ejb.remote.AppSetting;

import java.io.IOException;

@WebServlet("/cdi-test")
public class CDITest extends HttpServlet {

    @EJB
    AppSetting appSetting;

    @EJB
    UserRegistration userRegistration;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(appSetting.getAppName() + ":" + appSetting.getAppVersion());
        userRegistration.Register("Tharindu", "Chanaka","tharinduchanaka6@gmail.com","tharindu@8754");
    }
}
