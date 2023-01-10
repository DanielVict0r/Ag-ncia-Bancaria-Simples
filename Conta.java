

public class Conta{

	private static int counterContas = 1;
	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;
	
	public Conta(){}
	
	public Conta( Pessoa pessoa){
		
		this.numeroConta = counterContas;
		this.pessoa = pessoa;
		counterContas ++;
	}
	
	public int getNumeroConta(){
		return numeroConta;
	}
	public void setNumeroConta( int numeroConta){
		this.numeroConta = numeroConta;
	}
	
	public Pessoa getPessoa(){
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa){
		this.pessoa = pessoa;
	}
	
	public Double getSaldo(){
		return saldo;
	}
	public void setSaldo(Double saldo){
		this.saldo = saldo;
	}

	public String toString(){
		return "\nNumeror da Conta: "+getNumeroConta()       +
			  "\nNome: " +pessoa.getNome()                 +
			  "\nCpf: "  +pessoa.getCpf()                  +
			  "\nEmail: "+pessoa.getEmail()                +
			  "\nSaldo: "+Utils.doubleToString(getSaldo()) +
			  "\n";	  
	}
	
	
	public void depositar(Double valor){
		if(valor > 0){
			setSaldo(getSaldo() + valor);
			System.out.println("Déposito realizado com sucesso!!");
		}
		else{
			System.out.println("Déposito não realizado!!");
			
		}
	
	}
	
	public void sacar(Double valor){
		if(valor > 0 && this.getSaldo() >= valor)
		{
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com sucesso!!");

		}
		else
		{
			System.out.println("Saque não realizado!!");

		}
	}
	
	public void transferir(Conta contaParaDeposito, Double valor){
	
	if(valor > 0 && getSaldo() >= valor)
		{
			setSaldo(getSaldo() - valor);
			contaParaDeposito.setSaldo(contaParaDeposito.getSaldo() + valor);
			System.out.println("Transferência realizada com sucesso!!");

		}
		else
		{
			System.out.println("Transferência não foi realizada !!");

		}

	
	}
			

}