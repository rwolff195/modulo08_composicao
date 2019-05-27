package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enumeracao.NivelTrabalhador;

public class Trabalhador {
	
	private String nome;
	private NivelTrabalhador nivel;
	private Double salario;
	//Associacoes
	private Departamento departamento;
	private List<HorasContrato> contrato = new ArrayList<>();
	
	// Contrutores
	
	public Trabalhador() {
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double salario, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salario = salario;
		this.departamento = departamento;
	}
	
	// Getters e Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HorasContrato> getContratos() {
		return contrato;
	}

	// Métodos
	// Adiciona Contrato
	public void addContrato(HorasContrato contratos) {
		contrato.add(contratos);
	}
	
	// Remove Contrato
	public void removeContrato(HorasContrato contratos) {
		contrato.remove(contratos);
	}
	
	// Calcula valor a receber do cliente
	
	public double renda (int ano, int mes) {
		
		double soma = salario;
		
		Calendar cal = Calendar.getInstance(); // necessário instaciar o calendar para trabalhar com datas
		
		for (HorasContrato c : contrato) {
			
			cal.setTime(c.getData()); // setei a data da minha lista, para ser a data do calendar
			
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			
			if (ano == c_ano && mes == c_mes) {
				soma += c.totalValor();
			}
		}
		
		return soma;
	}
}
