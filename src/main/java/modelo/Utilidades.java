/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Juanjo Cortés
 */
public class Utilidades {

    public static List<Empleado> getEmpleados() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_CRUDEmpleados_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM Empleado";
        Query q = manager.createNativeQuery(sql, Empleado.class);
        List<Empleado> empleadosBD = q.getResultList();
        return empleadosBD;
    }
    public static Empleado getEmpleado(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_CRUDEmpleados_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT e FROM Empleado e WHERE e.id = " + id;
        Query q = manager.createQuery(sql, Empleado.class);
        Empleado e = (Empleado) q.getSingleResult();

        return e;
    }
        
    public static void insertaEmpleado(Empleado empleado) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_CRUDEmpleados_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(empleado);
        manager.getTransaction().commit();
    }
    
    public static int insertarEmpleado(Empleado empleado) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_CRUDEmpleados_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "INSERT INTO Empleado e VALUES(e.id=:id,e.nombre = :nombre, e.apellidos = :apellidos, e.edad = :edad, e.puesto = :puesto";
        Query q = manager.createQuery(sql, Empleado.class);
        q.setParameter("id", null);
        q.setParameter("nombre", empleado.getNombre());
        q.setParameter("apellidos", empleado.getApellidos());
        q.setParameter("edad", empleado.getEdad());
        q.setParameter("puesto", empleado.getPuesto());
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();
        return filasAfectadas;
    }
    public static int borrarEmpleado(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_CRUDEmpleados_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "DELETE from Empleado WHERE id = " + id;
        Query q = manager.createNativeQuery(sql);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate(); //para las consultas de modif. datos se usa el método executeUpdate
        manager.getTransaction().commit();
        return filasAfectadas;
    }
    
       public static int actualizaEmpleado(Empleado empleado) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_CRUDEmpleados_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Empleado e SET e.nombre = :nombre, e.apellidos = :apellidos, e.edad = :edad, e.puesto = :puesto WHERE e.id = :id";
        Query q = manager.createQuery(sql, Empleado.class);
        q.setParameter("id", empleado.getId());
        q.setParameter("nombre", empleado.getNombre());
        q.setParameter("apellidos", empleado.getApellidos());
        q.setParameter("edad", empleado.getEdad());
        q.setParameter("puesto", empleado.getPuesto());
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();
        return filasAfectadas;
    }
}
