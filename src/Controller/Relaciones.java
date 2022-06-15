package Controller;

import Models.*;
import Views.*;
import Models.logic.Almacenamiento;
import Models.logic.Procesos;

public class Relaciones {
	
	public void inicio() {
		
		//Instanciar clases
		Formulario miFormulario = new Formulario();
		Procesos misProcesos = new Procesos();
		Controlador miControlador = new Controlador();
		Almacenamiento miAlmacenamiento = new Almacenamiento();
		
		//Relacionar controlador con las clases
		miFormulario.setControlador(miControlador);
		misProcesos.setControlador(miControlador);
		miAlmacenamiento.setControlador(miControlador);
		
		//Relacionar clases con controlador
		miControlador.setFormulario(miFormulario);
		miControlador.setProcesos(misProcesos);
		miControlador.setAlmacenamiento(miAlmacenamiento);
		
		miControlador.iniciar();
	}
	
}
