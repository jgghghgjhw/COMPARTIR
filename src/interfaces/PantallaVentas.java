package interfaces;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class PantallaVentas {

	private JFrame frmSistemaCecyPos;
PantallaProductos pp=new PantallaProductos();
private JTextField txtCodigoBarras;
private JTable table;
DefaultTableModel model=new DefaultTableModel();	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaVentas window = new PantallaVentas();
					window.frmSistemaCecyPos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaVentas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaCecyPos = new JFrame();
		frmSistemaCecyPos.setTitle("SISTEMA CECY POS 2026");
		frmSistemaCecyPos.setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaProductos.class.getResource("/img/cecy.jpeg")));
		frmSistemaCecyPos.setBounds(100, 100, 954, 598);
		frmSistemaCecyPos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaCecyPos.setLocationRelativeTo(null);
		frmSistemaCecyPos.getContentPane().setLayout(null);
		
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pp.frmGestionProductos.setVisible(true);
			}
		});
		btnProductos.setIcon(redimensionar(40,40,"/img/productos.png"));
		btnProductos.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnProductos.setVerticalAlignment(SwingConstants.CENTER);
		btnProductos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProductos.setBounds(10, 10, 97, 80);
		frmSistemaCecyPos.getContentPane().add(btnProductos);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Estas seguro de salir","Salir",JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, redimensionar(32,32, "/img/cecy.jpeg"))==0) {
					
					JOptionPane.showMessageDialog(null, "ADIOS","BYE",JOptionPane.QUESTION_MESSAGE,
							redimensionar(50,50, "/img/BYE1.png"));
					System.exit(0);
					
				}
			}
		});
		btnSalir.setIcon(redimensionar(40,40,"/img/salir.png"));
		btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalir.setVerticalAlignment(SwingConstants.CENTER);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setBounds(697, 10, 109, 80);
		frmSistemaCecyPos.getContentPane().add(btnSalir);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setBounds(109, 99, 428, 38);
		frmSistemaCecyPos.getContentPane().add(txtCodigoBarras);
		txtCodigoBarras.setColumns(10);
		
		JLabel lblCodigoBarras = new JLabel("Codifo Barras");
		lblCodigoBarras.setBounds(10, 111, 109, 12);
		frmSistemaCecyPos.getContentPane().add(lblCodigoBarras);
		
		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.setIcon(redimensionar(25,25,"/img/add1.png"));
		btnAgregarProducto.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAgregarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		btnAgregarProducto.setVerticalTextPosition(SwingConstants.CENTER);
		btnAgregarProducto.setVerticalAlignment(SwingConstants.CENTER);
		btnAgregarProducto.setBounds(547, 98, 170, 38);
		frmSistemaCecyPos.getContentPane().add(btnAgregarProducto);
		
		JButton btnBuscarProducto = new JButton("Buscar Producto");
		btnBuscarProducto.setIcon(redimensionar(25,25,"/img/buscar.png"));
		btnBuscarProducto.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnBuscarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		btnBuscarProducto.setVerticalTextPosition(SwingConstants.CENTER);
		btnBuscarProducto.setVerticalAlignment(SwingConstants.CENTER);
		btnBuscarProducto.setBounds(727, 99, 170, 38);
		frmSistemaCecyPos.getContentPane().add(btnBuscarProducto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 147, 875, 211);
		frmSistemaCecyPos.getContentPane().add(scrollPane);
		
		table = new JTable();
		model.addColumn("CODIGO");
		model.addColumn("NOMBRE");
		model.addColumn("PRECIO");
		model.addColumn("CANTIDAD");
		model.addColumn("IMPORTE");
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Total");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(549, 372, 124, 60);
		frmSistemaCecyPos.getContentPane().add(lblNewLabel);
		
		JLabel lblMxn = new JLabel("$ 0.00 MXN");
		lblMxn.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblMxn.setBounds(696, 368, 276, 60);
		frmSistemaCecyPos.getContentPane().add(lblMxn);
		
		JButton btnCobrar = new JButton("Cobrar");
		btnCobrar.setIcon(redimensionar(40,40,"/img/cobrar1.png"));
		btnCobrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCobrar.setVerticalAlignment(SwingConstants.CENTER);
		btnCobrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCobrar.setBounds(523, 442, 130, 92);
		frmSistemaCecyPos.getContentPane().add(btnCobrar);
	}
	
	public ImageIcon redimensionar(int w, int h, String ruta) {
		ImageIcon icono = new ImageIcon(PantallaProductos.class.getResource(ruta));
		Image imagenOriginal = icono.getImage();
		Image imagenEscalada = imagenOriginal.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
		return iconoRedimensionado;
	}
}
