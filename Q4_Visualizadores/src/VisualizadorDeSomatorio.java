import java.util.List;

public class VisualizadorDeSomatorio implements Visualizador {
    private List<Integer> valores;

    public VisualizadorDeSomatorio(List<Integer> valores) {
        this.valores = valores;
    }

    public void defineValores(List<Integer> valores) {
        this.valores = valores;
    }

    @Override
    public void update(List<Integer> valores) {
        this.valores = valores;
        exibeSomatorio();
    }

    public void acrescentaValor(Integer valor) {
        this.valores.add(valor);
    }

    public void exibeSomatorio() {
        Integer soma = valores.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Somatorio: " + soma + ", quantidade de elementos analisados: " + valores.size());
    }
}
