package views;

import controllers.EmpleadoController;

public class EmpleadoView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String empleado;
		
		
		//----------METODO CreateEmpleado------------------
		/*empleado = new EmpleadoController().createEmpleado("Lopez","Braulio",25, "masculino", 1250);
		empleado = new EmpleadoController().createEmpleado("Berrios","Ray",20, "masculino", 1100);
		empleado = new EmpleadoController().createEmpleado("Quispe","Smith",35, "masculino", 1800);
		empleado = new EmpleadoController().createEmpleado("Valdemar","Miguel",18, "masculino", 1000);
		*/
		
		
		//------------METODO DeleteEmpleado-----------------
		//empleado = new EmpleadoController().deleteEmpleado(1);
		
		
		//------------METODO UpdateEmpleado-----------------
		//empleado = new EmpleadoController().updateEmpleado(4, "Benito");
		
		
		//------------METODO GetEmpleado-----------------
		empleado = new EmpleadoController().getEmpleado(4);
		
		System.out.println(empleado);

		
	}

}
