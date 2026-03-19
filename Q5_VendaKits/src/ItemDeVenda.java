public class ItemDeVenda {
    private ItemVendavel item;
    private int quantidade;

    public ItemDeVenda(ItemVendavel item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public ItemVendavel getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubTotal() {
        return item.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return String.format("%d %s %d x %.2f = %.2f%n", item.getId(), item.getNome(), quantidade, item.getPreco(), getSubTotal());
    }
}
