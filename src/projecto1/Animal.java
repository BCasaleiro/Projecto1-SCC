package projecto1;

import java.util.Random;

public abstract class Animal {
    
    protected float energia;
    
    //Constructores
    public Animal(float energia) {
       this.energia = energia;
    }
    
    public Animal(){
        
    }
    
    //Metodos
    public abstract void movimenta(Terreno mundo[][]);
    
    public abstract void alimentaSe(Terreno mundo[][]);
    
    public void decrementaEnergia() {
        this.energia--;
    }
    
    public boolean nascimento(float prob){
        Random rand = new Random();
        return rand.nextFloat() < prob;
    }
    
    public boolean morre() {
        return this.energia <= 0; 
    }
    
    //Sets & Gets
    public float getEnergia() {
        return energia;
    }

    public void setEnergia(float energia) {
        this.energia = energia;
    }
}
