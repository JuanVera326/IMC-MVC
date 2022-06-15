package Controller;

import java.util.ArrayList;

import javax.swing.JTextField;

import Models.*;
import Models.logic.Procesos;
import Models.vo.PersonaVO;
import Views.*;
import Models.logic.Almacenamiento;

public class Controlador {

	private Formulario miFormulario;
	private Procesos misProcesos;
	private Almacenamiento miAlmacenamiento;

	public void setFormulario(Formulario miFormulario) {
		this.miFormulario=miFormulario;
	}

	public void setProcesos(Procesos misProcesos) {
		this.misProcesos=misProcesos;
	}

	public void setAlmacenamiento(Almacenamiento miAlmacenamiento) {
		this.miAlmacenamiento=miAlmacenamiento;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	public void iniciar() {
		miFormulario.setVisible(true);	
	}

	public String calcularIMC(PersonaVO miPersonaVO) {
		return misProcesos.calcularIMC(miPersonaVO);
	}

	public String calcularPromedioPersonas() {
		return misProcesos.calcularPromedioPersonas();	
	}

	public String listarPersonas() {
		return miAlmacenamiento.toString();
		
	}

	public String registrar(PersonaVO miPersonaVO, JTextField txtDocumento, JTextField txtNombre, JTextField txtEdad, JTextField txtTalla, JTextField txtPeso) {
		return miAlmacenamiento.registrar(miPersonaVO, txtPeso, txtPeso, txtPeso, txtPeso, txtPeso);
	}

	public void limpiarTxt(JTextField txtDocumento, JTextField txtEdad, JTextField txtNombre, JTextField txtTalla,JTextField txtPeso) {
		misProcesos.limpiar(txtDocumento,txtEdad,txtNombre,txtTalla,txtPeso);
	}

	public ArrayList<PersonaVO> getListaPersonas() {
		return miAlmacenamiento.returnLista();
	}

	public int validarExistencia(JTextField txtDocumento) {
		return misProcesos.validarExistencia(txtDocumento,miAlmacenamiento.returnLista());
	}
}
