package aplicativos;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("DIGITE 0 PARA FINALIZAR O PROGAMA!");
        int MAX_ELEMENTOS = 2;
        int opcao, qtdCadastrados = 0; int x;String BuscaCPF;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        //Pessoa[] holdpilotos = new Pessoa[];
        Scanner in = new Scanner(System.in);

        do {
            Integer y = 1;
            Integer flag = 1;
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }
        //ArrayList<Pessoa> contatos = new ArrayList<Pessoa>();
                    
                    System.out.println("Digite o seu nome e depois seu cpf: ");
                    Pessoa people = new Pessoa(in.nextLine(),in.nextLine());
                    
                    for(x=0;x<qtdCadastrados;x++){
                        if(qtdCadastrados==pilotos.length){
                            Pessoa[] holdpilotos =Arrays.copyOf(pilotos,MAX_ELEMENTOS ); 
                            pilotos = holdpilotos;
                        }
                    }
                    pilotos[qtdCadastrados] = people;       
                    qtdCadastrados++;
                
                

                //Cadastre seu piloto aqui

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);
            }
             else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    
                    }
                    for(x = 0;x < qtdCadastrados;x++){
                        System.out.println("Nome e cpf da pessoa cadastrada: "+x);
                      System.out.println("nome: "+pilotos[x].getNome());
                      System.out.println("cpf: "+pilotos[x].getCpf());
                    }
                    voltarMenu(in);
                    continue;
                    

                // Exiba os pilotos aqui

            
            } else if (opcao == 3) {
                System.out.println("Digite o cpf do cadastrado: ");
                BuscaCPF=in.nextLine();
                for(x=0;x < qtdCadastrados;x++){
                    if(BuscaCPF.equals(pilotos[x].getCpf())){
                        System.out.println("nome: "+pilotos[x].getNome());
                        flag=0;
                    break;
                    
                }}
                if(flag.equals(y)){
                    System.out.println("Cpf invalido!");
                    
                }
                
                    voltarMenu(in);
                
               
            } else if (opcao == 4) {
                MAX_ELEMENTOS++;
                System.out.println("\nArmazenamento aumentado com sucesso!.");
                voltarMenu(in);
                
                
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }
    
    

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
    }

      
