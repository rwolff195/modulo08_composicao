package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Departamento;
import entidades.HorasContrato;
import entidades.Trabalhador;
import entidades.enumeracao.NivelTrabalhador;

public class ProgPrincipal {

	public static void main(String[] args) throws ParseException {
		/*
		Ler os dados de um trabalhador com N contratos (N fornecido pelo usuário). Depois, solicitar
		do usuário um męs e mostrar qual foi o salário do funcionário nesse męs.
		*/
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		
		System.out.println("Dados do trabalhador:");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		
		System.out.print("Nivel: ");
		String nivel = sc.nextLine();
		
		System.out.print("Salario base: ");
		double salarioBase = sc.nextDouble();
		
		// instanciando o metodo Trabalhador
		// NivelTrabalhador.valueOf(nivel) - Transforma a string em enumeração
		//new Departamento(nomeDepartamento) - instancia o metodo departamento - para fazer a acossiação entre as diasa classes
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivel), salarioBase, new Departamento(nomeDepartamento));
		
		System.out.print("Entre com o numero de cadastro de contratos do Trabalhador: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Contrato #" + i + " data:");
			System.out.print("Data Do Contrato (DD/MM/YYYY): ");
			Date datacontrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração do contrato (Horas): ");
			int horas = sc.nextInt();
			HorasContrato contrato = new HorasContrato(datacontrato, valorPorHora, horas);
			trabalhador.addContrato(contrato);// faz o contrato se relacionar com o metodo Tabalhador
		}
		
		System.out.println();
		System.out.print("Entre com mês e ano para o Calculo (MM/YYYY): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0,2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Valor a receber: " + mesAno + " : " + String.format("%.2f", trabalhador.renda(ano, mes)));
		
		
		sc.close();
	}

}
