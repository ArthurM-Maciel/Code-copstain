public class App {
    public static void main(String[] args) {
        DadoComHistorico dadoComHistorico = new DadoComHistorico(new Dado(6));

        for (int i = 0; i < 5; i++) {
            dadoComHistorico.rolar();

            System.out.println("valor: " + dadoComHistorico.getValor());
        }

        System.out.println("historico: " + dadoComHistorico.getHistorico());
    }
}
