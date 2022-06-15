package Models.logic;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import Controller.*;
import Models.*;
import Models.vo.PersonaVO;
public class Procesos {

	private Controlador miControlador;
	private double sumImc;
	int cont = 0;

	public void setControlador(Controlador miControlador) {
		this.miControlador=miControlador;
	}

	public String calcularIMC(PersonaVO miPersonaVO) {
		
		double prom = miPersonaVO.getPeso()/(miPersonaVO.getTalla()*miPersonaVO.getTalla());
		String o = null;
		if (prom<18) {
			o = "Anorexia ";
		}else if (prom>=18 && prom<20) {
			o = "Delgadez ";
		}else if (prom>=20 && prom<27) {
			o = "Normalidad ";
		}else if (prom>=27 && prom<30) {
			o = "Obesidad Grado 1 ";
		}else if (prom>=30 && prom<35) {
			o = "Obesidad Grado 2 ";
		}else if (prom>=35 && prom<40) {
			o = "Obesidad Grado 3 ";
		}else if (prom>=40) {
			o = "Obesidad Morbida ";
		}
		
		miPersonaVO.setImc(prom);
		miPersonaVO.setCondicion(o);
		
		setSumImc(sumImc+=prom);
		cont ++;
		System.out.println(miPersonaVO.getCondicion());
		System.out.println(miPersonaVO.getImc());
		
		return o += ": "+"Su indice IMC es: "+prom;
	}

	public void limpiar(JTextField txtDocumento, JTextField txtEdad, JTextField txtNombre, JTextField txtTalla,JTextField txtPeso) {
		txtDocumento.setText("");
		txtEdad.setText("");
		txtNombre.setText("");
		txtTalla.setText("");
		txtPeso.setText("");
		
	}

	public int validarExistencia(JTextField txtDocumento, ArrayList<PersonaVO> listPersonas) {
		int i = 0;
		for (PersonaVO personaVO : listPersonas) {
			if (personaVO.getDocumento().equals(txtDocumento.getText())) {
				i = 1;
			}else {
				break;
			}
		}
		return i;
	}

	public String calcularPromedioPersonas() {
		double i = getSumImc()/cont;
		String msj = "Vacio!!";
		if (i<1 || cont==0) {
			JOptionPane.showMessageDialog(null,"No hay datos a procesar!!","ERROR",JOptionPane.ERROR_MESSAGE);
		}else {
			msj = operacionesPromedio(i);
		}
		return msj;
	}

	private String operacionesPromedio(double i) {
		String msj = null;
		if (i<18) {
			msj = "Anorexia ";
		}else if (i>=18 && i<20) {
			msj = "Delgadez ";
		}else if (i>=20 && i<27) {
			msj = "Normalidad ";
		}else if (i>=27 && i<30) {
			msj = "Obesidad Grado 1 ";
		}else if (i>=30 && i<35) {
			msj = "Obesidad Grado 2 ";
		}else if (i>=35 && i<40) {
			msj = "Obesidad Grado 3 ";
		}else if (i>=40) {
			msj = "Obesidad Morbida ";
		}
		return msj += ": "+"Promedio IMC es: "+i;
	}

	public double getSumImc() {
		return sumImc;
	}

	public void setSumImc(double sumImc) {
		this.sumImc = sumImc;
	}
}
