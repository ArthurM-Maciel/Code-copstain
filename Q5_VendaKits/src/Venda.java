import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private LocalDateTime data;
    private List<ItemDeVenda> itens;

    public Venda(LocalDateTime data) {
        this.data = data;
        itens = new ArrayList<>();
    }

    public List<ItemDeVenda> getItens() {
        return itens;
    }

    public LocalDateTime getData() {
        return data;
    }

    public double getTotal() {
        double total = 0.0;
        for(ItemDeVenda item : itens){
            total += item.getSubTotal();
        }
        return total;
    }

    public void registrarVenda(ItemVendavel item, int quantidade) {
        itens.add(new ItemDeVenda(item, quantidade));
    }

    public String emitirComprovante() {
        StringBuilder nota = new StringBuilder();
        nota.append(String.format("COMPROVANTE DE VENDA%n"));
        nota.append(data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        nota.append("\n");
        for (ItemDeVenda item : itens) {
            nota.append(item.toString());
        }
        nota.append(String.format("Total: %.2f", getTotal()));
        return nota.toString();
    }
}
