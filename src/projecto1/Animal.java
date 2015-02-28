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
    public abstract void nascimento(Terreno mundo[][], ArrayList<Animal> animais);
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
    
    public void movimenta(Terreno mundo[][], ArrayList<Animal> animais, int tamanhoMundo) {
        boolean valido = false;
        int dir;
        while(valido == false) {
            dir = direcao();
            if(dir == 0) {
                if(mundo[(this.x + 1) % tamanhoMundo][this.y].getAnimal() != null) {
                    mundo[this.x][this.y].getAnimal().remove(this);
                    this.x = (this.x + 1) % tamanhoMundo;
                    mundo[this.x][this.y].getAnimal().add(this);
                }
            } else if (dir == 1) {
                if(mundo[(this.x + 1) % tamanhoMundo][Math.round((this.y - 1) % tamanhoMundo)].getAnimal() != null) {
                    mundo[this.x][this.y].getAnimal().remove(this);
                    this.x = (this.x + 1) % tamanhoMundo;
                    this.y = Math.round((this.y - 1) % tamanhoMundo);
                    mundo[this.x][this.y].getAnimal().add(this);
                }
            } else if (dir == 2) {
                if(mundo[this.x % tamanhoMundo][Math.round((this.y - 1) % tamanhoMundo)].getAnimal() != null) {
                    mundo[this.x][this.y].getAnimal().remove(this);
                    this.y = Math.round((this.y - 1) % tamanhoMundo);
                    mundo[this.x][this.y].getAnimal().add(this);
                }
            } else if (dir == 3) {
                if(mundo[Math.round((this.x - 1) % tamanhoMundo)][Math.round((this.y - 1) % tamanhoMundo)].getAnimal() != null) {
                    mundo[this.x][this.y].getAnimal().remove(this);
                    this.x = Math.round((this.x - 1) % tamanhoMundo);
                    this.y = Math.round((this.y - 1) % tamanhoMundo);
                    mundo[this.x][this.y].getAnimal().add(this);
                }
            } else if (dir == 4) {
                if(mundo[Math.round((this.x - 1) % tamanhoMundo)][this.y].getAnimal() != null) {
                    mundo[this.x][this.y].getAnimal().remove(this);
                    this.x = Math.round((this.x - 1) % tamanhoMundo);
                    mundo[this.x][this.y].getAnimal().add(this);
                }
            } else if (dir == 5) {
                if(mundo[Math.round((this.x - 1) % tamanhoMundo)][(this.y + 1) % tamanhoMundo].getAnimal() != null) {
                    mundo[this.x][this.y].getAnimal().remove(this);
                    this.x = Math.round((this.x - 1) % tamanhoMundo);
                    this.y = (this.y + 1) % tamanhoMundo;
                    mundo[this.x][this.y].getAnimal().add(this);
                }
            } else if (dir == 6) {
                if(mundo[this.x][(this.y + 1) % tamanhoMundo].getAnimal() != null) {
                    mundo[this.x][this.y].getAnimal().remove(this);
                    this.y = (this.y + 1) % tamanhoMundo;
                    mundo[this.x][this.y].getAnimal().add(this);
                }
            } else if (dir == 7) {
                if(mundo[(this.x + 1) % tamanhoMundo][(this.y + 1) % tamanhoMundo].getAnimal() != null) {
                    mundo[this.x][this.y].getAnimal().remove(this);
                    this.x = (this.x + 1) % tamanhoMundo;
                    this.y = (this.y + 1) % tamanhoMundo;
                    mundo[this.x][this.y].getAnimal().add(this);
                }
            }
        }
        this.nascimento(mundo, animais);
        this.alimentaSe(mundo, animais);
    }
    
    private int direcao() {
        Random rand = new Random();
        return rand.nextInt(8);
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
