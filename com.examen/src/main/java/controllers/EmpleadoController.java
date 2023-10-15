package controllers;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import models.Empleado;

public class EmpleadoController {

	//CREACION DE EMPLEADO
			public String createEmpleado(String apellidos, String nombres, int edad, String sexo, double salario) {
				
				SessionFactory sessionFactory;
				sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			
				Session session;
				session = sessionFactory.openSession();
				
				
				try {
					
					Empleado empleado;
					empleado = new Empleado(apellidos,nombres,edad,sexo,salario);
					session.beginTransaction();
					session.save(empleado);
					session.getTransaction().commit();
					
					sessionFactory.close();
					return "empleado creado";

				
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				return "Error al crear empleado";
			}
			
			//ELIMINAR EMPLEADO
			public String deleteEmpleado(int idEmpleado) {
				
				
				SessionFactory sessionFactory;
				sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
				
				
				Session session;
				session = sessionFactory.openSession();
				
				
				try {
					
					
					session.beginTransaction();
					
					
					Empleado empleado = session.get(Empleado.class, idEmpleado);
												 
					session.delete(empleado);
					
					
					session.getTransaction().commit();
					
					
					sessionFactory.close();
					
					return "empleado eliminado correctamente";
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
					return "Error al eliminar empleado";		
			}
			
			
			//ACTUALIZAR EMPLEADO
			public String updateEmpleado(int idEmpleado, String apellidos) {
										
			
			SessionFactory sessionFactory;
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			
			Session session;
			session = sessionFactory.openSession();
			
			try {
			
				session.beginTransaction();
				Empleado empleado = session.get(Empleado.class, idEmpleado);
								 
				empleado.setApellidos(apellidos);
				
				session.update(empleado);
				session.getTransaction().commit();
		
				
				sessionFactory.close();
				
				return "empleado actualizado correctamente";

			} catch (Exception e) {
				
				e.printStackTrace();
			
				}
			
				return "Error al actualizar usuario";
			}
			
			
			//LEER U OBTENER EMPLEADO
			public String getEmpleado(int idEmpleado) {
				
				SessionFactory sessionFactory;
				sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
				
				
				Session session;
				session = sessionFactory.openSession();
				
				try {
				
					session.beginTransaction();
					Empleado empleado = session.get(Empleado.class, idEmpleado);
					session.getTransaction().commit();
					sessionFactory.close();
					
					return empleado.toString();
					
				} catch (Exception e) {
				
					e.printStackTrace();
					
					}
				
					return "empleado no existe";
				
			}
}
