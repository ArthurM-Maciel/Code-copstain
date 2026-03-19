import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendasEmMemoria implements VendasFachada {
	private List<ItemVendavel> itens;

	public VendasEmMemoria() {
		itens = new ArrayList<>();
		Produto caneta = new Produto(1, "Caneta", 1.55);
		Produto borracha = new Produto(2, "Borracha", 1.15);
		Produto caderno = new Produto(3, "Caderno", 32.99);
		itens.add(caneta);
		itens.add(borracha);
		itens.add(caderno);

		// Kit com os três produtos: preço = (1.55 + 1.15 + 32.99) * 0.90
		Kit kitEscolar = new Kit(4, "Kit Escolar");
		kitEscolar.adicionar(caneta);
		kitEscolar.adicionar(borracha);
		kitEscolar.adicionar(caderno);
		itens.add(kitEscolar);
	}

	@Override
	public Venda iniciarVenda() {
		return new Venda(LocalDateTime.now());
	}

	@Override
	public void registrarVenda(Venda umaVenda, int codigoProduto, int quantidade) {
		ItemVendavel item = itens.stream()
				.filter(p -> p.getId() == codigoProduto)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Item não encontrado: " + codigoProduto));
		umaVenda.registrarVenda(item, quantidade);
	}

	@Override
	public String emitirComprovante(Venda umaVenda) {
		return umaVenda.emitirComprovante();
	}

	@Override
	public List<ItemVendavel> buscarItens() {
		return Collections.unmodifiableList(itens);
	}
}
