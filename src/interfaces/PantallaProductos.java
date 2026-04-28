package interfaces;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import data.DataProductos;
import entidades.Productos;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaProductos {

	public JFrame frmGestionProductos;
	private JTextField txtCodigoBarras;
	private JTextField txtNombre;
	private JTable tblProductos;
	private JSlider sldPrecioVenta;
	private JSlider sldStock;
	private JLabel lblValorPrecio;
	private JLabel lblValorStock;

	DefaultTableModel model = new DefaultTableModel();
	ArrayList<Productos> listaProductos = new ArrayList<Productos>();
	DataProductos dp = new DataProductos();
	Productos p=new Productos();
	int fila=-1;

	public static void main(String[] args) {

		PantallaProductos window = new PantallaProductos();
		window.frmGestionProductos.setVisible(true);

	}

	public PantallaProductos() {
		frmGestionProductos = new JFrame();
		frmGestionProductos.setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaProductos.class.getResource("/img/cecy.jpeg")));
		frmGestionProductos.setTitle("GESTION PRODUCTOS");
		frmGestionProductos.setBounds(100, 100, 676, 731);
		frmGestionProductos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGestionProductos.setLocationRelativeTo(null);
		frmGestionProductos.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("GESTION PRODUCTOS");

		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(93, 0, 286, 60);
		frmGestionProductos.getContentPane().add(lblNewLabel);
		JLabel lblCodigoBarras = new JLabel("Codigo Barras");
		lblCodigoBarras.setBounds(10, 54, 99, 12);
		frmGestionProductos.getContentPane().add(lblCodigoBarras);

		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setBounds(115, 51, 158, 18);
		frmGestionProductos.getContentPane().add(txtCodigoBarras);
		txtCodigoBarras.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 87, 99, 12);
		frmGestionProductos.getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(115, 84, 158, 18);
		frmGestionProductos.getContentPane().add(txtNombre);

		JLabel lblPrecioVenta = new JLabel("Precio Venta");
		lblPrecioVenta.setBounds(10, 134, 99, 12);
		frmGestionProductos.getContentPane().add(lblPrecioVenta);

		JLabel lblValorPrecio = new JLabel("0.0");
		lblValorPrecio.setBounds(324, 121, 44, 12);
		frmGestionProductos.getContentPane().add(lblValorPrecio);

		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(10, 183, 44, 12);
		frmGestionProductos.getContentPane().add(lblStock);
		JLabel lblValorStock = new JLabel("0.0");
		lblValorStock.setBounds(324, 170, 44, 12);
		frmGestionProductos.getContentPane().add(lblValorStock);
	 sldStock = new JSlider();
		sldStock.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblValorStock.setText("" + sldStock.getValue());
			}
		});
		sldStock.setBounds(115, 170, 200, 25);
		frmGestionProductos.getContentPane().add(sldStock);

		sldPrecioVenta = new JSlider();
		sldPrecioVenta.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblValorPrecio.setText("$ " + sldPrecioVenta.getValue());
			}
		});
		sldPrecioVenta.setBounds(115, 121, 200, 25);
		frmGestionProductos.getContentPane().add(sldPrecioVenta);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(redimensionar(40,40,"/img/add1.png"));
		btnAgregar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAgregar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAgregar.setVerticalAlignment(SwingConstants.CENTER);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Productos p = new Productos(txtCodigoBarras.getText(), txtNombre.getText(),
							sldPrecioVenta.getValue(), sldStock.getValue());
					if (!p.insertarProducto()) {
						JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR", "ERROR", JOptionPane.ERROR_MESSAGE);

					} else {
						limpiar();
						cargarProductos();

						JOptionPane.showMessageDialog(null, "SE INSERTO CORRECTAMENTE", "EXITO!!!!",
								JOptionPane.QUESTION_MESSAGE, redimensionar(32, 32,"/img/cecy.jpeg"));

					}

				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR");

				}
			}
		});
		btnAgregar.setBounds(34, 230, 84, 70);
		frmGestionProductos.getContentPane().add(btnAgregar);

		JScrollPane sclProductos = new JScrollPane();
		sclProductos.setBounds(142, 259, 459, 234);
		frmGestionProductos.getContentPane().add(sclProductos);

		tblProductos = new JTable();
		tblProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila=tblProductos.getSelectedRow();
				p=listaProductos.get(tblProductos.getSelectedRow());
				txtCodigoBarras.setText(p.getCodigoBarras());
				txtNombre.setText(p.getNombre());
				sldPrecioVenta.setValue((int)p.getPrecioVenta());
				sldStock.setValue(p.getStock());
			}
		});
		model.addColumn("CODIGO DE BARRAS");
		model.addColumn("NOMBRE");
		model.addColumn("PRECIO");
		model.addColumn("STOCK");
		sclProductos.setViewportView(tblProductos);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(redimensionar(40,40,"/img/delete1.png"));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(fila!=-1) {
						
						int opcion= JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar producto??","ELIMINAR PRODUCTO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,redimensionar(32, 32,"/png/cecy.jpeg"));
						if(opcion ==0) {
							if(p.eliminarProducto()) {
								JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE", "EXITO!!!!",
										JOptionPane.QUESTION_MESSAGE, redimensionar(32, 32,"/img/cecy.jpeg"));
							
							}else {
								JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR", "ERROR", JOptionPane.ERROR_MESSAGE);

								
							}
						}
					}else {

						JOptionPane.showMessageDialog(null, "FALTA SELECCIONAR PRODUCTO", "ERROR",
								JOptionPane.QUESTION_MESSAGE, redimensionar(32, 32,"/img/cecy.jpeg"));
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR", "ERROR", JOptionPane.ERROR_MESSAGE);

					
					
				}
			}
		});
		
		btnEliminar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEliminar.setVerticalAlignment(SwingConstants.CENTER);
		btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminar.setBounds(34, 329, 84, 84);
		frmGestionProductos.getContentPane().add(btnEliminar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(redimensionar(40,40,"/img/edit1.png"));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(fila!=-1) {
						if(txtCodigoBarras.getText().length()==0||txtNombre.getText().length()==0) {
							JOptionPane.showMessageDialog(null, "CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
							return;
						}
						p.setCodigoBarras(txtCodigoBarras.getText());
						p.setNombre(txtNombre.getText());
						p.setPrecioVenta(sldPrecioVenta.getValue());
						p.setStock(sldStock.getValue());
						
						if (p.actualizarProductos()) {
							JOptionPane.showMessageDialog(null, "PRODUCTO ACTUALIZADO CORRECTAMENTE","EXITOOO!!!!",
									JOptionPane.QUESTION_MESSAGE,redimensionar(32,32,"/img/cecy.jpeg"));
							txtCodigoBarras.setText("");
							txtNombre.setText("");
							sldPrecioVenta.setValue(1);
							sldStock.setValue(1);
							cargarProductos();
							fila=-1;
							
						}else {
							JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PRODUCTO","ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "FALTA SELECCIONAR PRODUCTO","ERROR",
								JOptionPane.QUESTION_MESSAGE,redimensionar(32,32,"/img/cecy.jpeg"));
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PRODUCTO");
					// TODO: handle exception
				}
				
			}
		});
		btnActualizar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnActualizar.setVerticalAlignment(SwingConstants.CENTER);
		btnActualizar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnActualizar.setBounds(34, 423, 84, 77);
		frmGestionProductos.getContentPane().add(btnActualizar);
		cargarProductos();

	}

	public void cargarProductos() {
		while (model.getRowCount() > 0)
			model.removeRow(0);
		listaProductos = dp.cargarProductos();
		for (Productos p : listaProductos) {

			model.addRow(new Object[] { p.getCodigoBarras(), p.getNombre(), p.getPrecioVenta(), p.getStock() });
		}
		tblProductos.setModel(model);
	}

	public ImageIcon redimensionar(int w, int h, String ruta) {
		ImageIcon icono = new ImageIcon(PantallaProductos.class.getResource(ruta));
		Image imagenOriginal = icono.getImage();
		Image imagenEscalada = imagenOriginal.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
		return iconoRedimensionado;
	}

	public void limpiar() {
		txtCodigoBarras.setText("");
		txtNombre.setText("");
		sldPrecioVenta.setValue(1);
		sldStock.setValue(1);

	}
}
