package model;

public class ComputadorRede {
	private String ip, nomeComputador,bloco;
	private int andar, sala;

public ComputadorRede() {
	
}

public ComputadorRede(String ip, String nomeComputador) {
	super();
	this.ip = ip;
	this.nomeComputador = nomeComputador;
}

public ComputadorRede(String ip, String nomeComputador, String bloco, int andar, int sala) {
	super();
	this.ip = ip;
	this.nomeComputador = nomeComputador;
	this.bloco = bloco;
	this.andar = andar;
	this.sala = sala;
}

public String getIp() {
	return ip;
}

public void setIp(String ip) {
	this.ip = ip;
}

public String getNomeComputador() {
	return nomeComputador;
}

public void setNomeComputador(String nomeComputador) {
	this.nomeComputador = nomeComputador;
}

public String getBloco() {
	return bloco;
}

public void setBloco(String bloco) {
	this.bloco = bloco;
}

public int getAndar() {
	return andar;
}

public void setAndar(int andar) {
	this.andar = andar;
}

public int getSala() {
	return sala;
}

public void setSala(int sala) {
	this.sala = sala;
}



}

