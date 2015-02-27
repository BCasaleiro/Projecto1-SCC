package projecto1;

import java.util.Random;
import java.util.ArrayList;

public class Lobo extends Animal {
    
    private final float probNasc = (float)0.05;
    private final int energiaInicial = 30;
    
    //Construtores
    public Lobo(int x,int y) {
        super(x,y);
        Random rand = new Random();
        this.energia = rand.nextInt(energiaInicial);
    }

    //Metodos
    @Override
    public boolean isOvelha(){
        return false;
    }
    
    @Override
    public void alimentaSe(Terreno[][] mundo, ArrayList<Animal> animais) {
        int auxX,auxY;     
        for (Animal a : animais){
            if (isOvelha()){
                if (this.distancia(a)<= 0){
                    a.morte(mundo, animais);
                    if((this.energia + 20) >= 30){
                        this.energia = 30;
                    }
                    else{
                        this.energia += 20;
                    }
                    return;
                }
            }
        }
    }

    @Override
    public void nascimento(Terreno[][] mundo, ArrayList<Animal> animais) {
        if (nasce(probNasc)){
            Lobo item = new Lobo(this.x,this.y);
            animais.add(item);
            mundo[this.x][this.y].getAnimal().add(item);
        }
    }



}
