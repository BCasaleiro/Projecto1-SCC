package projecto1;

import java.util.Random;
import java.util.ArrayList;

public class Lobo extends Animal {
    
    private final float probNasc = (float) 0.06;
    private final int energiaInicial = 30;
    
    //Construtores
    public Lobo(int x,int y) {
        super(x,y);
        Random rand = new Random();
        this.energia = rand.nextInt(energiaInicial+1);
    }

    //Metodos
    @Override
    public boolean isOvelha(){
        return false;
    }
    
    @Override
    public void alimentaSe(Terreno[][] mundo, ArrayList<Animal> animais) {
        int auxX,auxY;     
        for (int i = 0; i < animais.size(); i++){
            if (animais.get(i).isOvelha()){
                if (this.distancia(animais.get(i))<= 0){
                    animais.get(i).morte(mundo, animais);
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
