import java.util.List;

public class App {
    public static void main(String[] args) {
        VendasFachada fachada = new VendasEmMemoria();
        List<ItemVendavel> itens = fachada.buscarItens();

        Venda venda = fachada.iniciarVenda();
        // Registra produtos avulsos
        fachada.registrarVenda(venda, itens.get(0).getId(), 1);  // 1 Caneta
        fachada.registrarVenda(venda, itens.get(1).getId(), 2);   // 2 Borrachas
        // Registra um kit (id 4 = Kit Escolar, com 10% de desconto)
        fachada.registrarVenda(venda, itens.get(3).getId(), 1);   // 1 Kit Escolar

        System.out.println(fachada.emitirComprovante(venda));
    }
}
