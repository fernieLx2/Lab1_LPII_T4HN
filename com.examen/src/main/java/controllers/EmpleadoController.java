package controllers;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import models.Empleado;

public class EmpleadoController {

	//CREACION DE USUARIO
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

				//si sale mal la conexion	
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				return "Error al crear empleado";
			}
			
			//ELIMINAR USUARIO
			public String deleteEmpleado(int idEmpleado) {
				
				
				SessionFactory sessionFactory;
				sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
				
				
				Session session;
				session = sessionFactory.openSession();
				
				
				try {
					
					
					session.beginTransaction();
					
					
					Empleado empleado = session.get(Empleado.class, idEmpleado);
												 
					session.delete(empleado);
					
					//confirmar la data para eliminar
					session.getTransaction().commit();
					
					//cerramos la transaccion
					sessionFactory.close();
					
					return "empleado eliminado correctamente";
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
					return "Error al eliminar empleado";		
			}
			
			
			//ACTUALIZAR USUARIO
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
			
			
			//LEER U OBTENER USUARIO
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
