import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FonteDeDados {
    private List<Integer> lst;
    private List<Visualizador> visualizadores = new ArrayList<>();

    public FonteDeDados() {
        lst = new LinkedList<>();
    }

    public void adicionarVisualizador(Visualizador v) {
        visualizadores.add(v);
    }

    public void removerVisualizador(Visualizador v) {
        visualizadores.remove(v);
    }

    public void add(Integer value) {
        if (value < 0)
            throw new IllegalArgumentException("Valor invalido");
        lst.add(value);
        for (Visualizador v : visualizadores) {
            v.update(getValores());
        }
    }

    public int quantidade() {
        return lst.size();
    }

    public List<Integer> getValores() {
        return new ArrayList<>(lst);
    }
}