package projecto1;

import java.util.Random;

public class Terreno {
    private int  estadoVegetacao;
    private Animal animal;
 
    //Construtores
    public Terreno(boolean vegetacao) {
        Random rand = new Random();
        if(rand.nextFloat() > 0.5) {
            estadoVegetacao = 30;
        } else {
            estadoVegetacao = rand.nextInt(30);
        }
    }
    
    public boolean isEstadoMax(){
        return this.estadoVegetacao == 30;
    }
    
    //Sets & Gets
    public Animal getAnimal() {
        return animal;
    }
 
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public int getEstadoVegetacao() {
        return estadoVegetacao;
    }

    public void setEstadoVegetacao(int estadoVegetacao) {
        this.estadoVegetacao = estadoVegetacao;
    }
}
