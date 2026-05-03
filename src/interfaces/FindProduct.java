package interfaces;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import data.DataProductos;
import entidades.Productos;

public class FindProduct {

	public JFrame frame;
	private JTextField txtFiltrar;
	public ArrayList<Productos>listaProductos=new ArrayList<Productos>();
	DataProductos dp=new DataProductos();
	private JTextField txtFiltrar1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindProduct window = new FindProduct();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FindProduct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 532, 619);
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(PantallaProductos.class.getResource("/img/cecy.jpeg")));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		listaProductos =dp.cargarProductos();
		DefaultListModel<String>listaModel=new DefaultListModel<String>();
		
		txtFiltrar1 = new JTextField();
		txtFiltrar1.setBounds(55, 48, 359, 36);
		frame.getContentPane().add(txtFiltrar1);
		txtFiltrar1.setColumns(10);
		
		//JScrollPane scrolPane=new JList();
		for(Productos p : listaProductos) {
		//	listaModel.addElement(p.getNombre()+" - "+moneda(p.getPrecioVenta()));
			
		}
		//lstProductos.setModel(listaModel);
	}
}
