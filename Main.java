import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControleFinanceiro controle = new ControleFinanceiro();
        
        int opc = -1;

        do {
            System.out.println("\n===== CONTROLE FINANCEIRO =====");
            System.out.println("\n1 - Adicionar Transação");
            System.out.println("\n2 - Ver Receitas");
            System.out.println("\n3 - Ver Despesas");
            System.out.println("\n4 - Calcular Saldo");
            System.out.println("\n5 - Buscar Transação");
            System.out.println("\n6 - Remover Transação");
            System.out.println("\n0 - Sair");
            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Digite os Dados (Id, Descrição, Valor e Tipo): ");
                    Transacao t = scanner.next();
                    break;
                case 2:
                    System.out.println("Receitas: " + controle.calcularReceitas());
                    break;
                case 3:
                    System.out.println("Despesas: " + controle.calcularDespesas());
                    break;
                case 4:
                    System.out.println("Saldo: " + controle.calcularSaldo());
                    break;
                case 5:
                    System.out.println("Digite o id: ");
                    long id = scanner.nextLong();

                    Transacao encontrada = controle.buscarTransacao(id);
                    if (encontrada == null) {
                        System.out.println("Id inválido.");
                    } else {
                        System.out.println("ID: " + encontrada.getId());
                        System.out.println("Descrição: " + encontrada.getDescricao());
                        System.out.println("Valor: " + encontrada.getValor());
                        System.out.println("Data: " + encontrada.getData());
                        System.out.println("Tipo: " + encontrada.getTipo());
                        break;
                    }
                case 6:
                    System.out.println("Digite o Id: ");
                    id = scanner.nextLong();

                    if (controle.removerTransacao(id)) {
                        System.out.println("Transação removida!");
                    } else {
                        System.out.println("Transação não encontrada.");
                    }
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break
            }
        } while (opc != 0);
        scanner.close();
    }
}
