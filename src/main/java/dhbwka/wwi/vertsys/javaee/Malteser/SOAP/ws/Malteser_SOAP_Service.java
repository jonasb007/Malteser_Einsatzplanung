
package dhbwka.wwi.vertsys.javaee.Malteser.SOAP.ws;

import dhbwka.wwi.vertsys.javaee.Malteser.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.Malteser.tasks.ejb.TaskBean;
import dhbwka.wwi.vertsys.javaee.Malteser.tasks.jpa.Task;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;



@WebService(serviceName = "Malteser_SOAP_Service")
public class Malteser_SOAP_Service {

    @EJB
    private TaskBean taskBean;
    
    @EJB
    private UserBean userBean;
    
    public Malteser_SOAP_Service() {
    }

   
    
    @WebMethod
    @WebResult(name = "einsatz")
    public List<Task> findAllTasks(
            @WebParam(name = "username", header = true) String username,
            @WebParam(name = "password", header = true) String password)
            throws UserBean.InvalidCredentialsException,
                   UserBean.AccessRestrictedException {

        // Wirft eine Exception, wenn der Benutzer nicht berechtigt ist
        this.userBean.validateUser(username, password, "app-user"); //soap-user

        // Der geschützte Code, den nicht jeder ausführen darf
        return taskBean.findAll();
    }

    
}