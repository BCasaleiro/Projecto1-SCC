package projecto1;

import java.util.ArrayList;
import java.util.Random;

public class Ovelha extends Animal {
    
    private final float probNasc = (float)0.04;
    private final int energiaInicial = 7;
    
    //Construtores
    public Ovelha(){
        Random rand = new Random();
        this.energia = rand.nextInt(energiaInicial);
    }

    
    //Metodos
    @Override
    public boolean isOvelha(){
        return true;
    }
    
    @Override
    public void movimenta(Terreno mundo[][]) {
        
    }

    @Override
    public void alimentaSe(Terreno[][] mundo, ArrayList<Animal> animais) {
        
    }
}
