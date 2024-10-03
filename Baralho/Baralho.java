import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho {
    public List<Carta> cartas;
    public int topo;

    public Baralho() {
        this.cartas = new ArrayList<Carta>();
        this.topo = 56;
        String[] naipes = {"Espadas", "Copas", "Ouros", "Paus"};
        String[] nomes = {"Ás", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei"};

        for (String naipe : naipes) {
            for (String nome : nomes) {
                Carta carta = new Carta();
                carta.setNome(nome);
                carta.setNaipe(naipe);
                this.cartas.add(carta);
            }
        }

        for (int i = 0; i < 4; i++) {
            Carta coringa = new Carta();
            coringa.setNome("Coringa");
            coringa.setNaipe("Coringa");
            this.cartas.add(coringa);
        }
    }

    public String estadoAtual() {
        StringBuilder carta = new StringBuilder();
        for (int i = 0; i < this.topo; i++) {
            carta.append(this.cartas.get(i).getNome()).append(" de ").append(this.cartas.get(i).getNaipe()).append("\n");
        }
        return carta.toString();
    }

    public void embaralhar(int numTrocas) {
        Random random = new Random();
        for (int i = 0; i < numTrocas; i++) {
            int j = random.nextInt(this.topo);
            int k = random.nextInt(this.topo);
            Carta temp = this.cartas.get(j);
            this.cartas.set(j, this.cartas.get(k));
            this.cartas.set(k, temp);
        }
    }

    public Carta distribuir() {
        if (!this.possuiCartas()) {
            return null;
        }
        this.topo--;
        return this.cartas.remove(this.topo);
    }

    public boolean possuiCartas() {
        return !this.cartas.isEmpty();
    }
}
