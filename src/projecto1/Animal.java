package projecto1;

import java.util.Random;

public abstract class Animal {
    
    protected float energia;
    
    //Constructores
    public Animal(float energia) {
       this.energia = energia;
    }
    
    public abstract void movimenta(Terreno mundo[][]);

    public boolean nascimento(float prob){
        Random numero = new Random();
        return numero.nextFloat() < prob;
    }
    
    
    //Sets & Gets
    public float getEnergia() {
        return energia;
    }

    public void setEnergia(float energia) {
        this.energia = energia;
    }
}
