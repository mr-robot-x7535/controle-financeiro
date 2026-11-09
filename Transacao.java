import java.math.BigDecimal;
import java.time.LocalDate;

public class Transacao {
    private long id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;
    private TipoTransacao tipo;


    public Transacao(long id, String descricao, BigDecimal valor, LocalDate data, TipoTransacao tipo) {
        
        if (valor == null || valor.signum() <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
        
        this.valor = valor;
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public LocalDate getData() {
        return data;
    }
    public TipoTransacao getTipo() {
        return tipo;
    }
}
