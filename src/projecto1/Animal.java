package projecto1;

import java.util.ArrayList;
import java.util.Random;

public abstract class Animal {
    
    protected float energia;
    protected int x, y;
    
    //Constructores
    public Animal(int x, int y) {
       this.x = x;
       this.y = y;
    }
    
    public Animal(){
        
    }
    
    //Metodos
    public abstract boolean isOvelha();
    public abstract void movimenta(Terreno mundo[][]);
    public abstract void alimentaSe(Terreno mundo[][]);
    public abstract void alimentaSe(Terreno mundo[][], ArrayList<Animal> animais);
    
    public void decrementaEnergia() {
        this.energia--;
    }
    
    public boolean nascimento(float prob){
        Random rand = new Random();
        return rand.nextFloat() < prob;
    }
    
    public boolean isMorto() {
        return this.energia <= 0; 
    }
    
    public void morte(Terreno mundo[][], ArrayList<Animal> animais) {
        mundo[this.x - 1][this.y - 1].setAnimal(null);
        animais.remove(this);
    }
    
    //Sets & Gets
    public float getEnergia() {
        return energia;
    }

    public void setEnergia(float energia) {
        this.energia = energia;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
