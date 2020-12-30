package staticClass;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class estaticos {

	private String nome_arq;
	private List<String> list_arq = new ArrayList<String>();
	private String local_arq;
	Scanner input = new Scanner(System.in);
	
	public void enumciado1() {
		
		int num;
		
		do {
	
		if (this.list_arq.isEmpty()) {
				
				System.out.println("1. Registrar notas");
				System.out.println("9.Sair");
				System.out.print("Digite a opção: ");
				num = input.nextInt(); input.nextLine();
				
				if(num == 1) {
					
					nomeArquivo();
					
				}
				
		} else {
			
				
				System.out.println("1.Registrar notas");
				System.out.println("2. Arquivos salvos");
				System.out.println("9. Sair");
				System.out.print("Digite a opção: ");
				num = input.nextInt(); input.nextLine();
				
				if(num == 1) {
					
					this.nomeArquivo();
					
				}
				if(num == 2) {
					
					this.mostrarArquivosSalvos();
					
				}
				
				if(num != 1 && num != 2 && num != 9) {
					
					System.out.println("Opção inválida");
					
				}
				
			} 
			
		} while (num != 9);
		

			
	}
	
	private void nomeArquivo() {
		
		System.out.println("Digite um nome para o arquivo:");
		this.nome_arq  = input.nextLine();
		this.local_arq = String.format("//home//derekwillyan//Área de Trabalho//%s.txt", this.nome_arq);
		list_arq.add(this.nome_arq);
		this.registrarNotas();
		
	}
	
	private void registrarNotas() {
		
		double soma = 0;
		System.out.println("Digite o nome do aluno:");
		String name = input.nextLine();
		System.out.println("Digite a quantidade de notas para registro:");
		int quant = input.nextInt();
		double[] notas = new double[quant]; 
		for(int cont = 0; cont < notas.length; cont++) {
			
			System.out.printf("Digite a nota %d: ", cont+1);
			notas[cont] = input.nextDouble();
			soma += notas[cont];
		}
		
		double media = soma/notas.length;
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(this.local_arq, true))){
		
			bw.write(String.format("%s, %.2f", name, media));
			bw.newLine();
			
		}
		catch (IOException e) {
			
			System.out.println("ERROR");
		
		}
				
	}
	
	private void mostrarArquivosSalvos() {
		
		if (this.list_arq.isEmpty()) {
			
			System.out.println("Nenhum arquivo salvo");
			
		} else {
		
			String[] arqs = new String[this.list_arq.size()];
			for(int cont = 0; cont < arqs.length; cont++) {
				
				arqs[cont] = this.list_arq.get(cont);
				
			}
			
			for(int cont = 0; cont < arqs.length; cont++) {

				System.out.printf("%d %s\n", cont+1, arqs[cont]);
				
			}
			
			System.out.println("Deseja registrar em um arquivo salvo? (s/n):");
			char op = input.next().charAt(0);
			
			switch(op) {
				
				case 's':
					
					System.out.print("Digite a opção: ");
					int numop = input.nextInt(); input.nextLine();
					
					for(int cont = 0; cont < this.list_arq.size(); cont++) {
						
						if (numop - 1 == this.list_arq.indexOf(this.list_arq.get(cont))) {
							
							this.nome_arq  = this.list_arq.get(cont);
							this.local_arq = String.format("//home//derekwillyan//Área de Trabalho//%s.txt", this.nome_arq);
							
							this.registrarNotas();
							
							
						}
						
					}
					
					break;
				case 'n':
					break;
					
				default:
					break;
			
			}
			
			
		}
		
	}

}
