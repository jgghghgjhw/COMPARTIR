package interfaces;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import data.DataVentas;
import entidades.DetalleVentas;
import entidades.Productos;
import entidades.Ventas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class PantallaVentas {

	private JFrame frmSistemaCecyPos;
	
PantallaProductos pp=new PantallaProductos();
private JButton btnAgregarProducto;
private JButton btnBuscarProducto;
private JTextField txtCodigoBarras;
private JTable tblDetalle;
private JFrame frmCobrar;

DefaultTableModel model=new DefaultTableModel();{
	
	Productos p=new Productos();
	
	
	
	
}
double total=0.0;
String codigoBarras="";
ArrayList<DetalleVentas>detalleVenta=new ArrayList<DetalleVentas>();
private JLabel lblMxn;
private JButton btnCobrar;
private JLabel lblFechaHora;
private JTextField txtNombreCliente;
private JLabel lblTotalPagar1;
FindProduct fp=new FindProduct();
Cobro c=new Cobro();

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
		btnProductos.setBounds(681, 10, 97, 80);
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
		btnSalir.setBounds(788, 10, 109, 80);
		frmSistemaCecyPos.getContentPane().add(btnSalir);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtCodigoBarras.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					agregarProducto();
				}
			}
		});
		txtCodigoBarras.setBounds(109, 99, 428, 38);
		frmSistemaCecyPos.getContentPane().add(txtCodigoBarras);
		txtCodigoBarras.setColumns(10);
		
		
		
		JLabel lblCodigoBarras = new JLabel("Codigo Barras");
		lblCodigoBarras.setBounds(10, 111, 109, 12);
		frmSistemaCecyPos.getContentPane().add(lblCodigoBarras);
		
		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				agregarProducto();
				}
		});
		btnAgregarProducto.setIcon(redimensionar(25,25,"/img/add1.png"));
		btnAgregarProducto.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAgregarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		btnAgregarProducto.setVerticalTextPosition(SwingConstants.CENTER);
		btnAgregarProducto.setVerticalAlignment(SwingConstants.CENTER);
		btnAgregarProducto.setBounds(547, 98, 170, 38);
		frmSistemaCecyPos.getContentPane().add(btnAgregarProducto);
		
		JButton btnBuscarProducto = new JButton("Buscar Producto");
		btnBuscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fp.frame.setVisible(true);
			}
		});
		btnBuscarProducto.setIcon(redimensionar(25,25,"/img/buscar.png"));
		btnBuscarProducto.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnBuscarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		btnBuscarProducto.setVerticalTextPosition(SwingConstants.CENTER);
		btnBuscarProducto.setVerticalAlignment(SwingConstants.CENTER);
		btnBuscarProducto.setBounds(727, 99, 170, 38);
		frmSistemaCecyPos.getContentPane().add(btnBuscarProducto);
		
		JScrollPane sclDetalle = new JScrollPane();
		sclDetalle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		sclDetalle.setBounds(22, 147, 875, 211);
		frmSistemaCecyPos.getContentPane().add(sclDetalle);
		
		tblDetalle = new JTable();
		tblDetalle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int fila=tblDetalle.getSelectedRow();
				if(fila !=-1) {
					if(e.getKeyCode()==KeyEvent.VK_PLUS || e.getKeyCode()== KeyEvent.VK_ADD) {
						cambiarCantidad(fila,1);
						
					}else if (e.getKeyCode()== KeyEvent.VK_MINUS || e.getKeyCode()==KeyEvent.VK_SUBTRACT) {
						cambiarCantidad(fila,-1);
					}
				}
			}
		});
		model.addColumn("CODIGO");
		model.addColumn("NOMBRE");
		model.addColumn("PRECIO");
		model.addColumn("CANTIDAD");
		model.addColumn("IMPORTE");
		tblDetalle.setModel(model);
		tblDetalle.setDefaultEditor(Object.class, null);
		sclDetalle.setViewportView(tblDetalle);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTotal.setBounds(549, 372, 124, 60);
		frmSistemaCecyPos.getContentPane().add(lblTotal);
		
		 lblMxn = new JLabel("$ 0.00 MXN");
		lblMxn.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblMxn.setBounds(696, 368, 276 , 60);
		frmSistemaCecyPos.getContentPane().add(lblMxn);
		
		JButton btnCobrar_1 = new JButton("Cobrar");
		btnCobrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(total>0 && detalleVenta.size()>0) {
				c.setTotal(total);
			    c.lblTotalPagar1.setText(aMoneda(total));
				c.frmCobrar.setVisible(true);
				c.txtMonto.setRequestFocusEnabled(true);
				c.setVentas(PantallaVentas.this);
				}else {
					mensaje("HEY BRO!!!\n NO HAS AGREGADO PRODUCTOS","ERROR");
				}
			}
		});
		btnCobrar_1.setIcon(redimensionar(40,40,"/img/cobrar1.png"));
		btnCobrar_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCobrar_1.setVerticalAlignment(SwingConstants.CENTER);
		btnCobrar_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCobrar_1.setBounds(523, 442, 130, 92);
		frmSistemaCecyPos.getContentPane().add(btnCobrar_1);
		
		JLabel lblFechaHora = new JLabel("");
		lblFechaHora.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaHora.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFechaHora.setBounds(467, 44, 206, 24);
		frmSistemaCecyPos.getContentPane().add(lblFechaHora);
		
		JLabel lblNombreCliente = new JLabel("Cliente");
		lblNombreCliente.setBounds(29, 44, 44, 12);
		frmSistemaCecyPos.getContentPane().add(lblNombreCliente);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtNombreCliente.setColumns(10);
		txtNombreCliente.setBounds(73, 30, 384, 38);
		frmSistemaCecyPos.getContentPane().add(txtNombreCliente);
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LocalDateTime ahora = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
				String fechaHoraFormateada = ahora.format(formatter);
				lblFechaHora.setText(fechaHoraFormateada);
			}
		});
		timer.start();
	}
	public void cambiarCantidad(int index,int incremento) {
		
			if(incremento==-1){
				if(detalleVenta.get(index).getCantidad()==1) {
					int op= JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar producto??","ELIMINAR PRODUCTO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
							 redimensionar(32, 32,"/img/cecy.jpeg"));
				if(op==0) {
					detalleVenta.remove(index);
					actualizarDetalleVentas();
					return;
				}
			}else {
				detalleVenta.get(index).setCantidad(detalleVenta.get(index).getCantidad() - 1);
				
			}
		}else {
			if((detalleVenta.get(index).getCantidad()+1)>buscarProducto(detalleVenta.get(index).getIdProducto()).getStock()) {
				mensaje("YA NO SE PUEDE AGREGAR MAS CANTIDAD","ERROR");
			}else {
				detalleVenta.get(index).setCantidad(detalleVenta.get(index).getCantidad() + 1);
			}
			
		}
		actualizarDetalleVentas();
		tblDetalle.setRowSelectionInterval(index, index);
		tblDetalle.scrollRectToVisible(tblDetalle.getCellRect(index, 0, true));
		tblDetalle.requestFocusInWindow();
		
	}
	
	public ImageIcon redimensionar(int w, int h, String ruta) {
		ImageIcon icono = new ImageIcon(PantallaProductos.class.getResource(ruta));
		Image imagenOriginal = icono.getImage();
		Image imagenEscalada = imagenOriginal.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
		return iconoRedimensionado;
	}
	
	public void agregarProducto() {
		codigoBarras=txtCodigoBarras.getText();
		if(codigoBarras.length()==0) {
			mensaje("NO HAS INGRESADO CODIGO DE BARRAS","ERROR");
			
			return;
		}
		int id=-1;
		for(Productos p : pp.listaProductos) {
			if(p.getCodigoBarras().equals(codigoBarras)) {
				id=p.getIdProducto();
			}
		}
		if(id==-1) {
			mensaje("NO EXISTE PRODUCTO","ERROR");
			
			return;
		}
		if(!siEsta(id)) {
			if(buscarProducto(id).getStock()>0) {
				detalleVenta.add(new DetalleVentas(id,1));
			}else {
				mensaje("PRODUCTO SIN STOCK","ERROR");
				
			}
		}else {
			incrementaCantidad(id);
		}
		
		actualizarDetalleVentas();
		
	
		}
	public void actualizarDetalleVentas() {
		while (model.getRowCount()>0)
			model.removeRow(0);
		total=0;
		for (DetalleVentas d : detalleVenta) {
			Productos p=buscarProducto(d.getIdProducto());
			model.addRow(new Object[] { p.getCodigoBarras(), p.getNombre(),p.getPrecioVenta(),d.getCantidad(),
					(p.getPrecioVenta()*d.getCantidad())});
			total +=(p.getPrecioVenta()*d.getCantidad());
			}
		tblDetalle.setModel(model);
		lblMxn.setText(""+ aMoneda(total));
		
	}
	public Productos buscarProducto(int idProducto) {
		
		for(Productos p:pp.listaProductos) {
			if(p.getIdProducto()==idProducto) {
				return p;
			}
		}
		return null;
	}
	public void incrementaCantidad(int idProducto) {
		for(DetalleVentas d : detalleVenta) {
			if(idProducto==d.getIdProducto()) {
				if((d.getCantidad()+1)>buscarProducto(idProducto).getStock()) {
					mensaje("YA NO SE PUEDE AGREGAR MAS CANTIDAD","ERROR");
				}else {
					d.setCantidad(d.getCantidad()+1);
				}
			}
		}
	
	}
	public boolean siEsta(int idProducto) {
		boolean si=false;
		for(DetalleVentas d : detalleVenta) {
			if(d.getIdProducto()==idProducto) {
				return true;
			}
		}
		return false;
	}
	public static String aMoneda(double cantidad) {
		Locale localeMexico=new Locale("es", "MX");
		NumberFormat formatoMoneda=NumberFormat.getCurrencyInstance(localeMexico);
		return formatoMoneda.format(cantidad);
	}
	public void mensaje(String msj,String titulo) {
		JOptionPane.showMessageDialog(null,msj, titulo,JOptionPane.QUESTION_MESSAGE,
				redimensionar(32,32,"/img/cecy.jpeg"));
	}
	public void guardarVenta() {
		
		//INSERTAR REGISTROS EN BASE DE DATOS
		
		Ventas v=new Ventas(txtNombreCliente.getText(),"EFECTIVO",total);
		int idVentas=v.insertarVentas();
		System.out.println("ID VENTA: "+idVentas);
		for(DetalleVentas d : detalleVenta) {
			d.setIdVenta(idVentas);
			d.insertarDetalleVenta();
		}
		
		pp.cargarProductos();
		txtCodigoBarras.setText("");
		txtNombreCliente.setText("");
		lblMxn.setText(aMoneda(0));
		while (model.getRowCount()>0)
			model.removeRow(0);
		detalleVenta.clear();
		tblDetalle.setModel(model);
	}
}
