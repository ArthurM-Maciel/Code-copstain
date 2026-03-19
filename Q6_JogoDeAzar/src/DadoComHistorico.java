import java.util.ArrayList;
import java.util.List;

public class DadoComHistorico implements IDado {
    private final List<Integer> historico = new ArrayList<>();
    private final IDado dado;

    public DadoComHistorico(IDado dado) {
        this.dado = dado;
    }

    @Override
    public void rolar() {
        dado.rolar();
        historico.add(getValor());
    }

    @Override
    public int getValor() {
        return dado.getValor();
    }

    public List<Integer> getHistorico() {
        return historico;
    }
}
