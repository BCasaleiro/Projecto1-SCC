package projecto1;

import java.util.ArrayList;

public class Simulacao {
    
    private final int tamanhoMundo = 51;
    private final int tempoMax = 5000;
    private final int nOvelhas = 100;
    private final int nLobos = 30;
    
    private ArrayList<Animal> animais = new ArrayList<Animal>();
    private Terreno[][] mundo = new Terreno[tamanhoMundo][tamanhoMundo];
    private int tempo = 0;

    public Simulacao() {
    }
}
