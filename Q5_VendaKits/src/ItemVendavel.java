/**
 * Componente do padrão Composite.
 * Representa um item que pode ser vendido: produto unitário (folha) ou kit (composto).
 */
public interface ItemVendavel {

    int getId();
    String getNome();
    double getPreco();
}
