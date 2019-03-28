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

import dhbwka.wwi.vertsys.javaee.Malteser.common.web.FormValues;
import dhbwka.wwi.vertsys.javaee.Malteser.tasks.ejb.CategoryBean;
import dhbwka.wwi.vertsys.javaee.Malteser.tasks.ejb.TaskBean;
import dhbwka.wwi.vertsys.javaee.Malteser.common.ejb.ValidationBean;
import dhbwka.wwi.vertsys.javaee.Malteser.tasks.jpa.Category;
import dhbwka.wwi.vertsys.javaee.Malteser.tasks.jpa.Task;
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



    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        HttpSession session = request.getSession();
        /*session.setAttribute("username", user.getUsername() )*/
        // Anfrage an dazugerhörige JSP weiterleiten
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tasks/useredit.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


  

}
