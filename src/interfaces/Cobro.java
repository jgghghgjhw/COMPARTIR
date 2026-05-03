package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cobro {
	double total=0.0;
	double monto=0.0;
	boolean validar=false;

	public JFrame frmCobrar;
	public JTextField txtMonto;
	public JLabel lblTotalPagar;
	public JLabel lblTotalPagar1;
	PantallaVentas ventas=null;
	private JLabel lblCambio;
	

	
	public PantallaVentas getVentas() {
		return ventas;
	}
	public void setVentas(PantallaVentas ventas) {
		this.ventas = ventas;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cobro window = new Cobro();
					window.frmCobrar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total=total;
	}

	
	public Cobro() {
		initialize();
		
	}

	
	private void initialize() {
		frmCobrar = new JFrame();
		frmCobrar.setTitle("COBRAR");
		frmCobrar.setBounds(100, 100, 450, 401);
		frmCobrar.setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaProductos.class.getResource("/img/cecy.jpeg")));
		frmCobrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCobrar.getContentPane().setLayout(null);
		frmCobrar.setLocationRelativeTo(null);
		
		JToggleButton tglEfectivo = new JToggleButton("Efectivo");
		tglEfectivo.setIcon(redimensionar(40,40,"/img/efect1.png"));
		tglEfectivo.setVerticalTextPosition(SwingConstants.BOTTOM);
		tglEfectivo.setHorizontalTextPosition(SwingConstants.CENTER);
		tglEfectivo.setVerticalAlignment(SwingConstants.CENTER);
		tglEfectivo.setBounds(32, 51, 115, 78);
		frmCobrar.getContentPane().add(tglEfectivo);
		
		JToggleButton tglTransferencia = new JToggleButton("Tranferencia");
		tglTransferencia.setIcon(redimensionar(40,40,"/img/trans.png"));
		tglTransferencia.setVerticalTextPosition(SwingConstants.BOTTOM);
		tglTransferencia.setHorizontalTextPosition(SwingConstants.CENTER);
		tglTransferencia.setVerticalAlignment(SwingConstants.CENTER);
		tglTransferencia.setBounds(159, 51, 115, 78);
		frmCobrar.getContentPane().add(tglTransferencia);
		
		JToggleButton tglTarjeta = new JToggleButton("Tarjeta");
		tglTarjeta.setIcon(redimensionar(40,40,"/img/tarje.png"));
		tglTarjeta.setVerticalTextPosition(SwingConstants.BOTTOM);
		tglTarjeta.setHorizontalTextPosition(SwingConstants.CENTER);
		tglTarjeta.setVerticalAlignment(SwingConstants.CENTER);
		tglTarjeta.setBounds(284, 51, 115, 78);
		frmCobrar.getContentPane().add(tglTarjeta);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(validar) {
						ventas.guardarVenta();
						total=0;
						txtMonto.setText("");
						frmCobrar.setVisible(false);
						mensaje("PAGO EXITOSO","EXITO");
					}else {
						mensaje("MONTO A PAGAR INVALIDO","ERROR");
					}
				} catch (Exception e2) {
					
				}
			}
		});
		btnPagar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPagar.setForeground(new Color(0, 0, 0));
		btnPagar.setBounds(143, 312, 115, 42);
		frmCobrar.getContentPane().add(btnPagar);
		
		JLabel lblTotal = new JLabel("TOTAL A PAGAR");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal.setBounds(169, 139, 129, 20);
		frmCobrar.getContentPane().add(lblTotal);
		
		tglEfectivo.setSelected(true);
		
		lblTotalPagar1 = new JLabel("$0.00");
		lblTotalPagar1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalPagar1.setForeground(new Color(255, 0, 0));
		lblTotalPagar1.setBounds(179, 160, 65, 29);
		frmCobrar.getContentPane().add(lblTotalPagar1);
		
		JLabel lblMonto = new JLabel("MONTO");
		lblMonto.setBounds(29, 202, 44, 12);
		frmCobrar.getContentPane().add(lblMonto);
		
		txtMonto = new JTextField();
		txtMonto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					if(txtMonto.getText().length()>0) {
						
					
				 monto=Double.parseDouble(txtMonto.getText());
					if(total<=monto) {
						lblCambio.setText(aMoneda(monto-total));
						
						validar=true;
						
					}else {
						validar=false;
					}
					}
				} catch (Exception e2) {
					
				}
			}
		});
		txtMonto.setBounds(83, 199, 304, 20);
		frmCobrar.getContentPane().add(txtMonto);
		txtMonto.setColumns(10);
		
		lblCambio = new JLabel("0.0");
		lblCambio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCambio.setBounds(193, 276, 91, 26);
		frmCobrar.getContentPane().add(lblCambio);
		
		JLabel lblCambioTitulo = new JLabel("CAMBIO");
		lblCambioTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCambioTitulo.setBounds(169, 234, 117, 46);
		frmCobrar.getContentPane().add(lblCambioTitulo);
	}
	public ImageIcon redimensionar(int w, int h, String ruta) {
		ImageIcon icono = new ImageIcon(PantallaProductos.class.getResource(ruta));
		Image imagenOriginal = icono.getImage();
		Image imagenEscalada = imagenOriginal.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
		return iconoRedimensionado;
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
}
