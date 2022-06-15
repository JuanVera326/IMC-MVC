package Views;

import java.awt.BorderLayout;
import Models.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Models.vo.PersonaVO;
import Controller.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;

public class Formulario extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Controlador miControlador;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtDocumento;
	private JTextField txtTalla;
	private JTextField txtPeso;
	private JTextArea textArea;
	private JButton btnCalcular,btnRegistrar, btnListarPersonas,btnLimpiar,btnCalcularPromedio;
	private JLabel label9;
	PersonaVO miPersonaVO;
	/**
	 * Create the frame.
	 */
	public Formulario() {
		setTitle("IMC_MVC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 785);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Calculo IMC");
		label1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		label1.setBounds(140, 193, 111, 43);
		contentPane.add(label1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 86, 150, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(121, 134, 150, 20);
		contentPane.add(txtEdad);
		
		txtDocumento = new JTextField();
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(239, 86, 150, 20);
		contentPane.add(txtDocumento);
		
		txtTalla = new JTextField();
		txtTalla.setColumns(10);
		txtTalla.setBounds(10, 258, 150, 20);
		contentPane.add(txtTalla);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(239, 258, 150, 20);
		contentPane.add(txtPeso);
		
		JLabel label2 = new JLabel("Nombre:");
		label2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label2.setBounds(56, 61, 48, 14);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("Documento:");
		label3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label3.setBounds(276, 61, 75, 14);
		contentPane.add(label3);
		
		JLabel label4 = new JLabel("Edad:");
		label4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label4.setBounds(177, 109, 48, 14);
		contentPane.add(label4);
		
		JLabel label5 = new JLabel("Talla (m):");
		label5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label5.setBounds(56, 233, 55, 14);
		contentPane.add(label5);
		
		JLabel label6 = new JLabel("Peso (Kg):");
		label6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label6.setBounds(276, 233, 67, 14);
		contentPane.add(label6);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(10, 422, 379, 313);
		contentPane.add(scroll);
		
		JLabel label7 = new JLabel("Lista De Registros");
		scroll.setColumnHeaderView(label7);
		
		JLabel label8 = new JLabel("Resultado:");
		label8.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 26));
		label8.setBounds(10, 357, 120, 54);
		contentPane.add(label8);
		
		label9 = new JLabel("");
		label9.setBackground(Color.WHITE);
		label9.setOpaque(true);
		label9.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
		label9.setBounds(140, 357, 249, 54);
		contentPane.add(label9);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(153, 323, 89, 23);
		contentPane.add(btnCalcular);
		btnCalcular.addActionListener(this);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(10, 323, 89, 23);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(this);
		
		btnCalcularPromedio = new JButton("Calcular Promedio");
		btnCalcularPromedio.setBounds(201, 289, 150, 23);
		contentPane.add(btnCalcularPromedio);
		btnCalcularPromedio.addActionListener(this);
		
		btnListarPersonas = new JButton("Listar Personas");
		btnListarPersonas.setBounds(41, 289, 150, 23);
		contentPane.add(btnListarPersonas);
		btnListarPersonas.addActionListener(this);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(300, 323, 89, 23);
		contentPane.add(btnLimpiar);
		
		JLabel label10 = new JLabel("Datos Personales");
		label10.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		label10.setBounds(121, 11, 155, 43);
		contentPane.add(label10);
		btnLimpiar.addActionListener(this);
	}
	
	public void setControlador(Controlador miControlador) {
		this.miControlador=miControlador;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnCalcular) {
			if (txtTalla.getText().equalsIgnoreCase("") || txtPeso.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null,"Para calcular IMC por favor Rellene los campos necesarios!!","ERROR",JOptionPane.ERROR_MESSAGE);
			}else {
				miPersonaVO = new PersonaVO();
				miPersonaVO.setDocumento(txtDocumento.getText());
				miPersonaVO.setNombre(txtNombre.getText());
				miPersonaVO.setEdad(txtEdad.getText());
				miPersonaVO.setTalla(Double.parseDouble(txtTalla.getText())); 
				miPersonaVO.setPeso(Double.parseDouble(txtPeso.getText()));
				String res = miControlador.calcularIMC(miPersonaVO);
				label9.setText(res);
			}
		}else if (e.getSource()==btnCalcularPromedio) {
			String prom = miControlador.calcularPromedioPersonas();
				miControlador.limpiarTxt(txtDocumento, txtEdad, txtNombre, txtTalla, txtPeso);
			label9.setText(prom);	
		}else if (e.getSource()==btnListarPersonas) {
			String	r = miControlador.listarPersonas();
			textArea.setText(r);
		}else if (e.getSource()==btnRegistrar) {
			if (miPersonaVO==null) {
				JOptionPane.showMessageDialog(null,"Para poder registrar un usuario primero debe calcular su IMC!!\nIntentelo nuevamente","ERROR",JOptionPane.ERROR_MESSAGE);
			}else {
				int i = miControlador.validarExistencia(txtDocumento);
				if (i==1) {
					JOptionPane.showMessageDialog(null,"El usuario que intenta ingresar ya EXISTE!!\nIngrese un usuario nuevo","ERROR",JOptionPane.ERROR_MESSAGE);
					miControlador.limpiarTxt(txtDocumento, txtEdad, txtNombre, txtTalla, txtPeso);
				}else {
					String res = miControlador.registrar(miPersonaVO,txtDocumento,txtNombre,txtEdad,txtTalla,txtPeso);
					textArea.setText(res);
					System.out.println("\n\n\n"+res+"\n*****************************************************************************");
				}
			}
		}else if (e.getSource()==btnLimpiar) {
			miControlador.limpiarTxt(txtDocumento, txtEdad, txtNombre, txtTalla, txtPeso);
		}	
	}
}
