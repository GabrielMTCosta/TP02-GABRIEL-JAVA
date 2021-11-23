package tp1;

import java.util.Scanner;

public class Principal {
	public static void main(String args[]) {
		final int TAMAN = 100;
		int escolha;
		int contador;
		float av1 = 0;
		float av2 = 0;
		contador = 0;
		String nomecaps = null;
		Alunos[] aluns = new Alunos[TAMAN];
		
		do { 	
			escolha = menu();
			switch(escolha) {
				case 1:
					registrosAluno(aluns,contador++,TAMAN, nomecaps, av1, av2);
					break;
				case 2:
					escolherAluno(aluns,contador);
					break;
				case 3:
					mostrarTodos(aluns,contador);
					break;
				case 4:
					return;
				default:
					System.out.println("Erro opção não encontrada.");
					break;
			}
		} while(true);
	}
	
	public static int menu() {
		int escolha;
		Scanner escolhaUsu = new Scanner(System.in);
		
		System.out.println("\r\n[1] Registrar as notas de um novo aluno.\r\n"
				+ "[2] Consultar boletim de um aluno.\r\n"
				+ "[3] Consultar notas da turma.\r\n"
				+ "[4] Sair.");		
		escolha = escolhaUsu.nextInt();
		return escolha;
	}
	
	public static void registrosAluno(Alunos[] aluns, int contador, int TAMAN,String nomecaps,float av1,float av2) {
		if (contador >= TAMAN) {
			System.out.println("Vetor Cheio.");
		} else {
			registro(aluns,contador,nomecaps,av1,av2);
		}
	}

	public static void escolherAluno(Alunos[] aluns,int contador) {
		Scanner escolhaID = new Scanner(System.in);
		float av1;
		float av2;
		float media;
		String result;
		
		System.out.println("Insira o ID do Aluno para ser consultado.");
		int id = escolhaID.nextInt();
		
		if (id <= contador && id >= 0) {
			System.out.println("Nome do aluno: " + aluns[id].pegaAluno() + "\r\n");
			System.out.println("AV1: " + aluns[id].pegaAv1() + "\r\n");
			System.out.println("AV2: " + aluns[id].pegaAv2() + "\r\n");
			av1 = aluns[id].pegaAv1();
			av2 = aluns[id].pegaAv2();
			media = (av1+av2)/2;
			System.out.println("Media: " + media + "\r\n");
			result = situacaoAluno(media);
			System.out.println(result);
		}	
		else {
			System.out.println("ID nao encontrado.");
		}
	}
	
	public static void mostrarTodos(Alunos[] aluns, int contador) {
		System.out.println("NOME | AV1 | AV2 | ID");
		for (int i = 0; i < contador; i++) {
			System.out.println(aluns[i].pegaAluno()  + " | " + aluns[i].pegaAv1() + " | " + aluns[i].pegaAv2() + " | " + i);	
		}
	}
	
	public static String situacaoAluno(float media){ 
		String result = null;
		
		if (media < 4) {
			result = "REPROVADO";
		}else if (media >= 4 && media < 7) {
			result = "PROVA FINAL";
		}else {
			result = "APROVADO";
		} 
		return result;
	}
	
	public static void registro(Alunos[] aluns, int contador, String nomecaps, float av1, float av2) {
		
		String nome = entradaNome();
		float num = entradaNota();
		float num2= entradaNota();
		Alunos novo = new Alunos(nome,num,num2);
		
		aluns[contador] = novo;
		
	}
	
	public static float entradaNota() {
		float nota;
		Scanner inputnum = new Scanner(System.in);
		
		do {
			System.out.println("Insira nota: " );
			nota = inputnum.nextFloat();
			if (nota > 10 || nota < 0) {
				System.out.println("Erro nota invalida.");
			}		
		}while(nota > 10 || nota < 0);
		return nota;
	}	
	
	public static String entradaNome() {
		Scanner inputnom = new Scanner(System.in);
		
		System.out.println("Insira o nome:");
		String nome= inputnom.nextLine();
		String nomecaps = nome.toUpperCase();
		return nomecaps;
	}
}
