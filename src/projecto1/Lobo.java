package projecto1;

import java.util.Random;
import java.util.ArrayList;

public class Lobo extends Animal {
    
    private final float probNasc = (float)0.05;
    private final int energiaInicial = 7;
    
    //Construtores
    public Lobo(int x,int y) {
        super(x,y);
        Random rand = new Random();
        this.energia = rand.nextInt(energiaInicial);
    }

    //Metodos
    @Override
    public void movimenta(Terreno mundo[][]) {
        
    }

    @Override
    public void alimentaSe(Terreno[][] mundo, Animal animais) {
        for (Animal a : animais){
            
        }
    }
}
