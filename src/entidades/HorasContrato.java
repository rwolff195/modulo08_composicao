package entidades;

import java.util.Date;

public class HorasContrato {
	
	private Date data; //Data do contrato
	private Double valorPorHora; // Valor por hora
	private Integer horas; // Quantidade de horas do contrato
	
	// Construtores
	
	public HorasContrato() {
	}
	
	public HorasContrato(Date data, Double valorPorHora, Integer horas) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.horas = horas;
	}

	// Getters e Setters
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	// Métodos
	// Calcula valor hora * quantidade de horas trabalhadas
	
	public double totalValor() {
		return valorPorHora * horas;
	}
	

}
