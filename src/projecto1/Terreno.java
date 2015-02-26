package projecto1;

import java.util.Random;
import java.util.ArrayList;

public class Terreno {
    private int estadoVegetacao;
    private ArrayList<Animal> animal;
 
    //Construtores
    public Terreno() {
        Random rand = new Random();
        if(rand.nextFloat() > 0.5) {
            estadoVegetacao = 30;
        } else {
            estadoVegetacao = rand.nextInt(30);
        }
    }
    
    //Metodos
    public boolean isEstadoMax() {
        return this.estadoVegetacao == 30;
    }
    
    public int incrementaEstado() {
        return (++this.estadoVegetacao);
    }
    
    public void vegetacaoComida() {
        this.estadoVegetacao = 0;
    } 
    
    //Sets & Gets
    public ArrayList<Animal> getAnimal() {
        return animal;
    }
 
    public void setAnimal(ArrayList<Animal> animal) {
        this.animal = animal;
    }
    
    public void removeAnimal(Animal an){
        animal.remove(animal.indexOf(an));
    }

    public int getEstadoVegetacao() {
        return estadoVegetacao;
    }

    public void setEstadoVegetacao(int estadoVegetacao) {
        this.estadoVegetacao = estadoVegetacao;
    }
}
