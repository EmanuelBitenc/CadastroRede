package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;


public class ComputadorRedeDAO {
	private Connection conexao;
	private String sql;
	private PreparedStatement prepararSQL;
	private ResultSet rs;
	
	public ComputadorRedeDAO() throws ClassNotFoundException, SQLException {
		this.conexao = new Conexao().getConexao();
	}
	
	public boolean insert(ComputadorRede computadorRede) throws SQLException {
		sql = "INSERT INTO tbcomputador (ip,nome,bloco,andar,sala) values (?,?,?,?,?)";
		prepararSQL = conexao.prepareStatement(sql);
		prepararSQL.setString(1, computadorRede.getIp());
		prepararSQL.setString(2, computadorRede.getNomeComputador());
		prepararSQL.setString(3, computadorRede.getBloco());
		prepararSQL.setDouble(4, computadorRede.getAndar());
		prepararSQL.setDouble(5, computadorRede.getSala());
		prepararSQL.execute();
		prepararSQL.close();
		return true;
	}
	
	public boolean delete(ComputadorRede computadorRede) throws SQLException {
		sql = "DELETE FROM tbcomputador where id=?";
		prepararSQL = conexao.prepareStatement(sql);
		prepararSQL.setString(1, computadorRede.getIp());
		prepararSQL.execute();
		prepararSQL.close();
		return true;
	}
		
	public boolean update(ComputadorRede computadorRede) throws SQLException {
		sql = "UPDATE tbcomputador set nome=?,bloco=?,andar=?,sala=? where ip=?";
		prepararSQL = conexao.prepareStatement(sql);
		prepararSQL.setString(1, computadorRede.getNomeComputador());
		prepararSQL.setString(2, computadorRede.getBloco());
		prepararSQL.setDouble(3, computadorRede.getAndar());
		prepararSQL.setInt(4,computadorRede.getSala());
		prepararSQL.executeUpdate();
		prepararSQL.close();
		return true;
	}
	
	public DefaultTableModel selectAll() throws SQLException {
		ComputadorRede computadorRede = new ComputadorRede();
		DefaultTableModel tabela = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==0) {
					return false;
				}else {
					return true;
				}
			}		
		};
		sql = "SELECT * FROM tbcomputador order by nome";
		prepararSQL = this.conexao.prepareStatement(sql);
		rs = prepararSQL.executeQuery(sql); // guardar o resultado do SQL
		
		
		// adiciona as colunas na tabela
		tabela.addColumn("IP");
		tabela.addColumn("Nome Computador");
		tabela.addColumn("Bloco");
		tabela.addColumn("Andar");
		tabela.addColumn("Sala");
		
		// adicinar a linha do cabeçalho da tabeal
		String cabecalho[] = {"IP","Nome Computador","Bloco","Andar","Sala"};
		tabela.addRow(cabecalho);
		
		// adicionar as linhas do select 
		while (rs.next()) {
			tabela.addRow(new String[] {rs.getString("ip"),
			                         rs.getString("nome"),
			                         rs.getString("bloco"),
			                         rs.getString("andar"),
			                         rs.getString("sala")});
		}
        prepararSQL.close();
		return tabela;
	}
	

}
