package projecto1;

import java.util.Random;
import java.util.ArrayList;

public class Lobo extends Animal {
    
    private final float probNasc = (float)0.05;
    private final int energiaInicial = 7;
    
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
    public void movimenta(Terreno mundo[][]) {
        
    }
    
    @Override
    public void alimentaSe(Terreno[][] mundo, ArrayList<Animal> animais) {
        int auxX,auxY;     
        for (Animal a : animais){
            if (isOvelha()){
                if (this.distancia(a)<= 1){
                    auxX = a.getX();
                    auxY = a.getY();
                    a.morte(mundo, animais);
                    this.energia--;
                    mundo[auxX][auxY].setAnimal(null);
                    this.setX(auxX);
                    this.setY(auxY);
                    mundo[auxX][auxY].setAnimal(this);
                    if((this.energia + 20) >= 30){
                        this.setEnergia(30);
                    }
                    else{
                        this.setEnergia(energia + 20);
                    }
                    
                }
            }
        }
    }



}
