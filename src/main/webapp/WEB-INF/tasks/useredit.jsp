<%-- 
    Copyright © 2019 Paula Sollner, Justin Hollmann, Jonas Beuth

    Dieser Quellcode ist lizenziert unter einer
    Creative Commons Namensnennung 4.0 International Lizenz.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Profil bearbeiten
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/dashboard.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/app/dashboard/"/>">Dashboard</a>
        </div>
        
        <div class="menuitem">
            <a href="<c:url value="/app/tasks/list/"/>">Liste</a>
        </div>

        <div class="menuitem">
            <a href="<c:url value="/app/tasks/task/new/"/>">Einsatz anlegen</a>
        </div>

        <div class="menuitem">
            <a href="<c:url value="/app/tasks/categories/"/>">Kategorien bearbeiten</a>
        </div>
        
        <div class="menuitem">
            <a href="<c:url value="/app/tasks/useredit/"/>">Profil bearbeiten</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="container">
            <form method="post" class="stacked">
                <div class="column">
                    <%-- CSRF-Token --%>
                    <input type="hidden" name="csrf_token" value="${csrf_token}">

                    <%-- Eingabefelder --%>
                    <label for="signup_vorname">
                        Vorname:
                        <span class="required">*</span>
                    </label>
                    <div class="side-by-side">
                        <input type="text" name="signup_vorname" value="${task_form.values["signup_vorname"][0]}">
                    </div>
                    
                    <label for="signup_nachname">
                        Nachname:
                        <span class="required">*</span>
                    </label>
                    <div class="side-by-side">
                        <input type="text" name="signup_nachname" value="${task_form.values["signup_nachname"][0]}">
                    </div>                    
                    

                    <label for="signup_password1">
                        Passwort:
                        <span class="required">*</span>
                    </label>
                    <div class="side-by-side">
                        <input type="password" name="signup_password1" value="${task_form.values["signup_password1"][0]}">
                    </div>

                    <label for="signup_password2">
                        Passwort (wdh.):
                        <span class="required">*</span>
                    </label>
                    <div class="side-by-side">
                        <input type="password" name="signup_password2" value="${task_form.values["signup_password2"][0]}">
                    </div>

                    <%-- Button zum Abschicken --%>
                    <div class="side-by-side">
                        <button type="submit">
                            Änderungen speichern
                        </button>
                    </div>
                </div>

                <%-- Fehlermeldungen --%>
                <c:if test="${!empty requestScope.eingabeError}">
                    <ul class="errors">
                        <c:forEach items="${requestScope.eingabeError}" var="error">
                            <li>${error}</li>
                        </c:forEach>
                    </ul>
                </c:if>
            </form>
        </div>
    </jsp:attribute>
</template:base>
