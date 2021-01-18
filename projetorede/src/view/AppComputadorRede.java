package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.ComputadorRede;
import model.ComputadorRedeDAO;

public class AppComputadorRede extends JFrame implements WindowListener,
ActionListener, FocusListener{
	private JTextField txtIp, txtNomeComputador, txtBloco, txtAndar, txtSala;
	private JLabel lblIp, lblNomeComputador, lblBloco, lblAndar, lblSala;
	private JButton btnAdicionar,btnLimpar;
	
	public static void main(String[] args) {
        new AppComputadorRede();		
	}
	
	public AppComputadorRede() {
		super("Cadastro de Computador na Rede");
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setSize(400,400); // seta o tamanho da janela pixel
		//setLocation(10,10); // seta localização da janela no monitor
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // fechar a janela.
		
		addWindowListener(this); // adicionando a escuta da janela a classe
		
		addElements(null);
		
		setVisible(true); // tornar a janela visivel pois o padrão é invisivel
	}
	
	
	
	
	
	public AppComputadorRede(ComputadorRede computadorRede) {
		super("Cadastro de Computador na Rede");
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setSize(400,400); // seta o tamanho da janela pixel
		//setLocation(10,10); // seta localização da janela no monitor
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // fechar a janela.
		
		addWindowListener(this); // adicionando a escuta da janela a classe
		
		addElements(computadorRede);
		
		setVisible(true); // tornar a janela visivel pois o padrão é invisivel
		
	}
	
	public void addElements(ComputadorRede computadorRede) {
		if (computadorRede==null) {
		    txtIp = new JTextField(30);
		    txtNomeComputador = new JTextField(21);
		    txtBloco = new JTextField(28);
		    txtAndar = new JTextField(28);
		    txtSala = new JTextField(29);
		    btnAdicionar = new JButton("Adicionar");
		    btnLimpar = new JButton("Limpar");
		}
		
		lblIp = new JLabel("Ip");
		lblNomeComputador = new JLabel("Nome Computador");
		txtNomeComputador.addFocusListener(this);
		lblBloco = new JLabel("Bloco");
		lblAndar = new JLabel("Andar");
		lblSala = new JLabel("Sala");
		
		btnAdicionar.addActionListener(this);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				limparDados();				
			}
		});
		
		
		add(lblIp);add(txtIp);
		add(lblNomeComputador);add(txtNomeComputador);
		add(lblBloco);add(txtBloco);
		add(lblAndar);add(txtAndar);
		add(lblSala);add(txtSala);
		add(btnAdicionar);add(btnLimpar);
	}
	
	public void limparDados() {
		txtIp.setText(null);
		txtNomeComputador.setText(null);
		txtBloco.setText(null);
		txtAndar.setText(null);
		txtSala.setText(null);
		txtIp.requestFocus(); // posiciona o foco do teclado na caixa Nome
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ComputadorRede computadorRede = new ComputadorRede();
		if (btnAdicionar == e.getSource()) {
			//JOptionPane.showMessageDialog(null, "Rotina em manutenção");
			computadorRede.setIp(txtIp.getText());
			computadorRede.setNomeComputador(txtNomeComputador.getText());
			computadorRede.setBloco(txtBloco.getText());
			computadorRede.setAndar(Integer.parseInt(txtAndar.getText()));
			computadorRede.setSala(Integer.parseInt(txtSala.getText()));
			
			try {
				ComputadorRedeDAO dao = new ComputadorRedeDAO(); // responsável pelo crud
				if (btnAdicionar.getText().equals("Adicionar")) {
				    dao.insert(computadorRede);
				    JOptionPane.showMessageDialog(null, "Adicionado com sucesso!!!");
				}
				
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(null,"Error no driver");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Erro no SQL");
			    e1.printStackTrace();
			} 
			
			
			
			
		}
		
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
	}

}

