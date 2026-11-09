import java.math.BigDecimal;
import java.util.ArrayList;

public class ControleFinanceiro {
    private ArrayList<Transacao> transacoes = new ArrayList<>();

    public ControleFinanceiro() {
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public boolean removerTransacao(long id) {
        return transacoes.removeIf(t -> t.getId() == id);
    }

    public Transacao buscarTransacao(long id) {
        return transacoes.stream()
            .filter(t -> t.getId() == id)
            .findFirst()
            .orElse(null);
    }

    public BigDecimal calcularReceitas() {
        return transacoes.stream()
            .filter(t -> t.getTipo() == TipoTransacao.RECEITA)
            .map(Transacao::getValor)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularDespesas() {
        return transacoes.stream()
        .filter(t -> t.getTipo() == TipoTransacao.DESPESA)
        .map(Transacao::getValor)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularSaldo() {
        return calcularReceitas().subtract(calcularDespesas());
    }

    public void listarTransacoes() {
        for (Transacao t : transacoes) {
            System.out.println("----- Transação -----");
            System.out.println("ID: " + t.getId());
            System.out.println("Descrição: " + t.getDescricao());
            System.out.println("Valor: R$ " + t.getValor());
            System.out.println("Data: " + t.getData());
            System.out.println("Tipo: " + t.getTipo());
        }
    }
}
