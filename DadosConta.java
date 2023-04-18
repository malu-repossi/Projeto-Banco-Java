import java.util.Scanner;

public class DadosConta {
    double valorConta = 0;
    double transacaoAnterior = 0;
    String nomeDono;
    long identidadeDono;

    DadosConta(String nome, long id) {
        nomeDono = nome;
        identidadeDono = id;
    }

    void deposito(double montante){
        if(montante > 0){
            valorConta += montante;
            transacaoAnterior = montante;
        }
    }

    void saque(double montante){
        if(montante > 0){
            valorConta -= montante;
            transacaoAnterior = montante;
        }
    }

    void transacao(){
        if(transacaoAnterior > 0){
            System.out.print("Transacao anterior foi um deposito de R$" + transacaoAnterior);
        }
        else if(transacaoAnterior < 0){
            System.out.print("Transacao anterior foi um saque de R$" + transacaoAnterior);
        }
        else{
            System.out.print("Nao houve transacao");
        }
    }

    void investir(long ano){
        double taxaJuros = .0876;
        double novoValorConta = (valorConta * taxaJuros * ano) + valorConta;
        System.out.print("A taxa de juros e de " + taxaJuros*100 + "% e o valor final apos " + ano +
        " anos e de R$" + novoValorConta);
    }

    void menuOpcoes(){
        char opcao = '\0';
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bem vindo " + nomeDono + "!");
            System.out.println("Sua identidade e: " + identidadeDono);
            System.out.println();
            System.out.println("O que gostaria de fazer?");
            System.out.println();
            System.out.println("A. Visualizar valor atual da conta");
            System.out.println("B. Fazer um deposito");
            System.out.println("C. Fazer um saque");
            System.out.println("D. Ver transacao anterior");
            System.out.println("E. Investir");
            System.out.println("F. Sair");
            
            do{
                System.out.println();
                System.out.println("Digite sua opcao:");
                char opcaoSemFormatar = scanner.next().charAt(0);
                opcao = Character.toUpperCase(opcaoSemFormatar);
                System.out.println();

                switch(opcao){
                    case 'A': 
                        System.out.println("====================================");
                        System.out.println("Valor atual: R$" + valorConta);
                        System.out.println();
                        break;
                    case 'B':
                        System.out.println("====================================");
                        System.out.println("Digite abaixo o valor do deposito:");
                        
                        double montante = scanner.nextFloat();
                        deposito(montante);

                        System.out.println();
                        break;
                    case 'C':
                        System.out.println("====================================");
                        System.out.println("Digite abaixo o valor do saque:");
                        
                        double montante2 = scanner.nextFloat();
                        saque(montante2);
                        
                        System.out.println();
                        break;
                    case 'D':
                        System.out.println("====================================");
                        transacao();
                        System.out.println();
                        break;
                    case 'E':
                        System.out.println("====================================");
                        System.out.println("Quantos anos pretende investir?");
                        
                        long ano = scanner.nextInt();
                        investir(ano);
                        
                        System.out.println();
                        break;
                    case 'F':
                        System.out.println("====================================");
                        break;
                    default:
                        System.out.println("====================================");
                        System.out.println("Invalido!");
                        System.out.println("====================================");

                        break;
                } 
            }while(opcao != 'F');
        }

        System.out.println("Obrigado por confiar no nosso banco!");
        System.out.println("Saindo...");
    }
}


