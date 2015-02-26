package projecto1;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

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
    public abstract void nascimento(Terreno mundo[][]);
    public abstract void alimentaSe(Terreno mundo[][], ArrayList<Animal> animais);
    
    public void adicionaEnergia(int energia) {
        this.energia += energia;
    }
    
    public void decrementaEnergia() {
        this.energia--;
    }
    
    public boolean nasce(float prob){
        Random rand = new Random();
        return rand.nextFloat() < prob;
    }
    
    public boolean isMorto() {
        return this.energia <= 0; 
    }
    
    public void morte(Terreno mundo[][], ArrayList<Animal> animais) {
        mundo[this.x][this.y].setAnimal(null);
        animais.remove(this);
    }
    
    public float distancia(Animal animal){
        return (float)Math.sqrt(Math.pow(this.x - animal.getX(), 2) + Math.pow(this.y - animal.getY(), 2));
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
