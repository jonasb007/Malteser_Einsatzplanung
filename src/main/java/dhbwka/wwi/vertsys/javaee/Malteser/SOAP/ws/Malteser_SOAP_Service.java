/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.vertsys.javaee.Malteser.SOAP.ws;

/**
 *
 * @author Jonas
 *

@WebService(serviceName = "Malteser_SOAP_Service")
public class Malteser_SOAP_Service {

    @EJB
    private TaskBean taskBean;

    @EJB
    private UserBean userBean;
    
    public Malteser_SOAP_Service() {
    }

    @WebMethod
    @WebResult(name = "user")
    public List<User> findAllUser() {
        return this.userBean.findAll();
    }

    @WebMethod
    @WebResult(name = "task")
    public List<Task> findTaskByUser(@WebParam(name = "userId") long userId) {
        User user = this.userBean.findById(userId);
        return this.taskBean.findByUser(user);
    }

    @WebMethod
    @WebResult(name = "task")
    public Task saveNewTask(@WebParam(name = "task") Task task) {
        return this.taskBean.saveNew(task);
    }

    @WebMethod
    @WebResult(name = "task")
    public Task updateTask(@WebParam(name = "task") Task task) {
        return this.taskBean.update(task);
    }
}
*/