import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Composite do padrão Composite: agrupa itens vendáveis com desconto de 10%.
 */
public class Kit implements ItemVendavel {
    private static final double DESCONTO_KIT = 0.10;

    private int id;
    private String nome;
    private List<ItemVendavel> itens;

    public Kit(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void adicionar(ItemVendavel item) {
        itens.add(item);
    }

    public List<ItemVendavel> getItens() {
        return Collections.unmodifiableList(itens);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        double soma = 0.0;
        for (ItemVendavel item : itens) {
            soma += item.getPreco();
        }
        return soma * (1.0 - DESCONTO_KIT);
    }
}
