package Models.logic;
import Models.logic.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.*;
import Models.vo.PersonaVO;

public class Almacenamiento {
	
	ArrayList<PersonaVO> listPersonas;
	private Controlador miControlador;
	
	public Almacenamiento() {
		listPersonas = new ArrayList<PersonaVO>();
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador=miControlador;
		
	}

	public String registrar(PersonaVO miPersonaVO, JTextField txtDocumento, JTextField txtNombre, JTextField txtEdad, JTextField txtTalla, JTextField txtPeso) {
		String msj = null;
		if (miPersonaVO == null) {
			JOptionPane.showMessageDialog(null,"Debe calcular antes de Registrar!!","ERROR",JOptionPane.ERROR_MESSAGE);
		}else if (txtDocumento.getText().equalsIgnoreCase("") || txtDocumento.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null,"Llene todos los campos antes de Registrar!!","ERROR",JOptionPane.ERROR_MESSAGE);
		}else {
			listPersonas.add(miPersonaVO);
			msj = miPersonaVO.toString();
			
			/*
			for (PersonaVO personaVO : listPersonas) {
				msj += personaVO;
			}*/
		}
		return msj;
	}

	public ArrayList<PersonaVO> returnLista() {
		return listPersonas;
	}

	@Override
	public String toString() {
		String msj = "Vacio!!";
		if (listPersonas.size()==0) {
			JOptionPane.showMessageDialog(null,"No hay personas registradas!!","ERROR",JOptionPane.ERROR_MESSAGE);
		}else {
			msj = "//////////////PERSONAS ENLISTADAS/////////////\n\n" + listPersonas +"\n";
		}
		return msj;
	}
}
