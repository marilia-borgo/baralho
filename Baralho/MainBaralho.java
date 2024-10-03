public class MainBaralho {
    public static void main(String[] args) {
        Baralho baralho = new Baralho();

        System.out.println(baralho.estadoAtual());

        baralho.embaralhar(10);

        for (int i = 0; i < 56; i++) {
            baralho.distribuir();
            System.out.println(baralho.possuiCartas());
        }

        System.out.println(baralho.estadoAtual());
    }
}
