import java.util.Scanner;
// ...existing code...

public class App {
    public static void main(String[] args) throws Exception {
        var dados = new FonteDeDados();
        var cm = new VisualizadorDeMedia(new java.util.ArrayList<>());
        var cs = new VisualizadorDeSomatorio(new java.util.ArrayList<>());

        dados.adicionarVisualizador(cm);
        dados.adicionarVisualizador(cs);

        Scanner s = new Scanner(System.in);
        int valor = 0;
        while (true) {
            System.out.println("\nEntre um valor positivo maior que zero (0=fim):");
            valor = Integer.parseInt(s.nextLine());
            if (valor == 0) {
                break;
            }
            dados.add(valor);
            // Não adicionar visualizadores dentro do loop!
        }
        System.out.println("Fim");
    }
}
