package projecto1;

import java.util.Random;

public class Lobo extends Animal {
    
    private final float probNasc = (float)0.05;
    private final int energiaInicial = 7;
    
    //Construtores
    public Lobo() {
        Random rand = new Random();
        this.energia = rand.nextInt(energiaInicial);
    }

    //Metodos
    @Override
    public void movimenta(Terreno mundo[][]) {
        
    }

    @Override
    public void alimentaSe(Terreno[][] mundo) {
        
    }
}
