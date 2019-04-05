/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.javaee.Malteser.tasks.web;

import dhbwka.wwi.vertsys.javaee.Malteser.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.Malteser.common.ejb.ValidationBean;
import dhbwka.wwi.vertsys.javaee.Malteser.common.jpa.User;
import dhbwka.wwi.vertsys.javaee.Malteser.common.web.FormValues;
import dhbwka.wwi.vertsys.javaee.Malteser.common.web.WebUtils;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Seite zum Anzeigen und Bearbeiten der Kategorien. Die Seite besitzt ein
 * Formular, mit dem ein neue Kategorie angelegt werden kann, sowie eine Liste,
 * die zum Löschen der Kategorien verwendet werden kann.
 */
@WebServlet(urlPatterns = {"/app/tasks/useredit/"})
public class UserEditServlet extends HttpServlet {

@EJB
private UserBean userBean;

@EJB
private ValidationBean validationBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        HttpSession session = request.getSession();
        User user = this.userBean.getCurrentUser();
        session.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tasks/useredit.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User aktuellerUser = this.userBean.getCurrentUser();
        
        String vorname = request.getParameter("signup_vorname");
        //if (vorname != null && )
        String nachname = request.getParameter("signup_nachname");
        String password1 = request.getParameter("signup_password1");
        String password2 = request.getParameter("signup_password2");
        
        User user = new User(vorname, nachname, aktuellerUser.getUsername(), password1);
        List<String> errors = this.validationBean.validate(user);
        this.validationBean.validate(user.getPassword(), errors);
        
        if (password1 != null && password2 != null && !password1.equals(password2)) {
            errors.add("Die beiden Passwörter stimmen nicht überein.");
        }
        
        if (errors.isEmpty()) {
            try {
                aktuellerUser.setVorname(vorname);
                aktuellerUser.setNachname(nachname);
                aktuellerUser.setPassword(password2);
                //aktuellerUser.addToGroup("app-user");
                this.userBean.update(aktuellerUser);
                
            } catch (Exception ex) {
                errors.add(ex.getMessage());
            }
        }
        
        if (errors.isEmpty()) {
            response.sendRedirect(WebUtils.appUrl(request, "/app/dashboard/"));
        } else {            
            response.sendRedirect(WebUtils.appUrl(request, "/app/dashboard/"));
        }
   
    }


  

}
