

import java.util.ArrayList;
import java.util.Scanner;


public class Main{
   static  Scanner ls = new Scanner(System.in);
   static	ArrayList<Conta> contasBancarias;
	

	public static void main(String[] args)
	{
		System.out.println("Bem vindo \n");

		contasBancarias = new ArrayList<Conta>();	
		operacoes();
		
		
	
	}

	private static void operacoes()
	/*operacoes*/{
		System.out.println("Selecione uma operacão");
		System.out.println("Digite 1 para Criar conta");
		System.out.println("Digite 2 para Depositar");
		System.out.println("Digite 3 para Sacar");
		System.out.println("Digite 4 para Transferir");
		System.out.println("Digite 5 para Listar");
		System.out.println("Digite 6 para Sair");
		System.out.println("");
		
		int operacao =  ls.nextInt();
		
		switch(operacao)
		{
		
			case 1: criarConta(); break;
			case 2: depositar(); break;
			case 3: sacar(); break;
			case 4: transferir(); break;
			case 5: listar(); break;
			case 6: System.out.println("Vlw pela preferencia"); System.exit(0);
			default: System.out.println("Opção inválida");operacoes();
			

		}
		
	}/*operacoes*/
	
	
	public static void criarConta(){
		System.out.println("\n Digite um nome");
		String nome = ls.next();
		

		System.out.println("\n Digite um Cpf");
		String cpf = ls.next();


		System.out.println("\n Digite um Email");
		String email = ls.next();
		
		Pessoa pessoa = new Pessoa(nome, cpf, email);
		
		Conta conta = new Conta(pessoa);
		
		contasBancarias.add(conta);
		System.out.println("\n Conta criada!!\n\n");
		

	
		operacoes();
	
	}
	
	public static Conta encontrarConta (int numeroConta)/*encontrar conta*/{
		Conta conta = null;
		if(contasBancarias.size()>0)
		{
			for(Conta c : contasBancarias)
			{
				if(c.getNumeroConta() == numeroConta)
				{
				
					conta = c;
				}
			}
		}
		return conta;
	}/*encontrar conta*/
	
	
	public static void depositar()
	{/*depositar*/
		System.out.println("Digite o numero da conta que você quer depositar: ");
		int numeroConta = ls.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		if(conta != null){
			System.out.println("Qual valor deseja depositar ?");
			Double valorDeposito = ls.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println("Valor depositado com sucesso!!");
		}
		else
		{
			System.out.println("Conta não encontrada");
		}
		
		operacoes();
	
	}/*depositar*/
	
	
	public static void sacar ()
	{/*sacar*/
		
		System.out.println("Digite o numero da conta que você quer sacar: ");
		int numeroConta = ls.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		if(conta != null){
			System.out.println("Qual valor deseja sacar ?");
			Double valorSaque = ls.nextDouble();
			conta.sacar(valorSaque);
			//System.out.println("Valor sacado com sucesso!!");
		}
		else
		{
			System.out.println("Conta não encontrada");
		}
		
		operacoes();
	

		
		
	
	}/*sacar*/
	
	
	public static void transferir()
	
	{/*transferencia*/
	
		System.out.println("Digite o numero da conta que você deseja sacar para fazer a transferencia: ");
		int numeroContaRemetente = ls.nextInt();
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		
		if(contaRemetente!= null)
		{
		
			System.out.println("Numero da conta que irá receber a transferencia ");
			int numeroContaDestinatario = ls.nextInt();
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if(contaDestinatario!=null)
			{
				System.out.println("Digite o valor da transfêrencia: ");
				Double valor = ls.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valor);
			}
		}
		
		operacoes();
	}/*transferencia*/
		
	public static void listar()
	{
		if(contasBancarias.size()>0)
		{
			for(Conta conta : contasBancarias)
			{
				System.out.println(conta);
			}
		}
		else
		{
			System.out.println("Não há contas cadastradas!");
		}
		operacoes();
	
	}
}
























