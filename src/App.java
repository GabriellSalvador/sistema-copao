import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    // DEFININDO AS VARIAVEIS //
    static Scanner teclado = new Scanner(System.in);
    static double totalValorPedidos = 0;
    static double valorTotal = 0;
    static int estoqueMorango = 10;
    static int estoqueGoiaba = 10;
    static int estoqueAbacaxi_Hortela = 10;
    static int estoqueKiwi = 10;
    static int estoqueLaranja = 10;
    static int estoqueCajá = 10;
    static int estoqueCupuacu = 10;
    static int estoqueBacuri = 10;
    static int estoqueMelancia = 10;
    static int estoqueAcerola = 10;

    static double precoMorango = 10.0;
    static double precoGoiaba = 10.0;
    static double precoAbacaxi_Hortela = 10.0;
    static double precoKiwi = 10.0;
    static double precoLaranja = 10.0;
    static double precoCajá = 10.0;
    static double precoCupuacu = 10.0;
    static double precoBacuri = 10.0;
    static double precoMelancia = 10.0;
    static double precoAcerola = 10.0;

    // LOGIMN //
    public static void main(String[] args) {
        int login, senha;
        do {
            System.out.println("\nDigite o seu login: ");
            login = teclado.nextInt();
            System.out.println("Digite a sua senha: ");
            senha = teclado.nextInt();
            if (login != 111 || senha != 111) {
                System.out.println("\nLogin ou senha inválidos");
            }
        } while (login != 111 || senha != 111);
        cadastrarClientes();
    }

    static void cadastrarClientes() {
        String continuarCadastro;
        int contadorCliente = 1;
        do {
            System.out.println("\nCliente " + contadorCliente);
            List<String> pedidos = fazerPedidos(); // FAZ O CODIGO INTEIRO//
            imprimirPedidos(contadorCliente, pedidos);
            System.out.print("\nDeseja cadastrar um novo cliente? (1-S e 2-N): "); // DEPOIS PERGUNTA SE QUER CADASTRAR UM NOVO CLIENTE // 
            continuarCadastro = teclado.next();
            contadorCliente++;
        } while (!continuarCadastro.equals("2"));
    }

    // REALIZAÇÃO DO PEDIDO //
    static List<String> fazerPedidos() {
        List<String> pedidosCliente = new ArrayList<>();
        String continuarPedido = "";
        int totalSabores = 0;
    
        do {
            System.out.println("\nMenu de Sabores:");
            System.out.println("1 - Morango");
            System.out.println("2 - Goiaba");
            System.out.println("3 - Abacaxi com hortelã");
            System.out.println("4 - Kiwi");
            System.out.println("5 - Laranja");
            System.out.println("6 - Cajá");
            System.out.println("7 - Cupuaçu");
            System.out.println("8 - Bacuri");
            System.out.println("9 - Melancia");
            System.out.println("10 - Acerola");
            System.out.println("0 - Finalizar pedido");
    
            System.out.print("\nEscolha o sabor (ou 0 para finalizar o pedido): ");
            int op = teclado.nextInt();
    
            if (op == 0) {
                if (totalSabores == 0) {
                    System.out.println("Você não selecionou nenhum sabor.");
                    continue;
                }
                System.out.print("Confirmar pedido? (1-S e 2-N): ");
                continuarPedido = teclado.next();
                if (!continuarPedido.equals("1")) {
                    System.out.println("Pedido cancelado.");
                    continue;
                }
                break;
            }
    
            String nomeSabor = obterNomeSabor(op);
            System.out.println("Sabor do Suco: " + nomeSabor);
    
            if (totalSabores < 2) {
                System.out.print("Deseja adicionar mais um sabor? (1-S e 2-N): ");
                continuarPedido = teclado.next();
                if (!continuarPedido.equals("1")) {
                    System.out.println("Pedido cancelado.");
                    break;
                }
            }

            if (totalSabores >= 3) {
                System.out.println("Você já selecionou o máximo de sabores permitidos (3).");
                break;
            }
    
            String pedido = nomeSabor;
            pedidosCliente.add(pedido);
    
            totalSabores++;
        } while (true);
    
        valorTotal = totalSabores * 10.0;
        pedidosCliente.add("Total de sabores: " + totalSabores);
        pedidosCliente.add("Valor total: " + valorTotal);
        return pedidosCliente;
    }
    
    
    
    static boolean verificarEstoque(int opcao, int quantidade) {
        switch (opcao) {
            case 1:
                return estoqueMorango >= quantidade;
            case 2:
                return estoqueGoiaba >= quantidade;
            case 3:
                return estoqueAbacaxi_Hortela >= quantidade;
            case 4:
                return estoqueKiwi >= quantidade;
            case 5:
                return estoqueLaranja >= quantidade;
            case 6:
                return estoqueCajá >= quantidade;
            case 7:
                return estoqueCupuacu >= quantidade;
            case 8:
                return estoqueBacuri >= quantidade;
            case 9:
                return estoqueMelancia >= quantidade;
            case 10:
                return estoqueAcerola >= quantidade;
            default:
                return false;
        }
    }

    static void atualizarEstoque(int opcao, int quantidade) {
        switch (opcao) {
            case 1:
                estoqueMorango -= quantidade;
                valorTotal = quantidade * precoMorango;
                break;
            case 2:
                estoqueGoiaba -= quantidade;
                valorTotal = quantidade * precoGoiaba;
                break;
            case 3:
                estoqueAbacaxi_Hortela -= quantidade;
                valorTotal = quantidade * precoAbacaxi_Hortela;
                break;
            case 4:
                estoqueKiwi -= quantidade;
                valorTotal = quantidade * precoKiwi;
                break;
            case 5:
                estoqueLaranja -= quantidade;
                valorTotal = quantidade * precoLaranja;
                break;
            case 6:
                estoqueCajá -= quantidade;
                valorTotal = quantidade * precoCajá;
                break;
            case 7:
                estoqueCupuacu -= quantidade;
                valorTotal = quantidade * precoCupuacu;
                break;
            case 8:
                estoqueBacuri -= quantidade;
                valorTotal = quantidade * precoBacuri;
                break;
            case 9:
                estoqueMelancia -= quantidade;
                valorTotal = quantidade * precoMelancia;
                break;
            case 10:
                estoqueAcerola -= quantidade;
                valorTotal = quantidade * precoAcerola;
                break;
        }
    }

    static String obterNomeSabor(int opcao) {
        switch (opcao) {
            case 1:
                return "Morango";
            case 2:
                return "Goiaba";
            case 3:
                return "Abacaxi com Hortelã";
            case 4:
                return "Kiwi";
            case 5:
                return "Laranja";
            case 6:
                return "Cajá";
            case 7:
                return "Cupuaçu";
            case 8:
                return "Bacuri";
            case 9:
                return "Melancia";
            case 10:
                return "Acerola";
            default:
                return "Opção inválida";
        }
    }

    static void imprimirPedidos(int numeroCliente, List<String> pedidos) {
        System.out.println("\nCliente: " + numeroCliente);
        for (String pedido : pedidos) {
            System.out.println("Sabor do Suco: " + pedido);
            System.out.println("Valor total: "+ valorTotal);
        }
    }
}
