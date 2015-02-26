package projecto1;

import java.util.ArrayList;
import java.util.Random;

public class Ovelha extends Animal {
    
    private final float probNasc = (float)0.04;
    private final int energiaInicial = 7;
    
    //Construtores
    public Ovelha(){
        Random rand = new Random();
        this.energia = rand.nextInt(energiaInicial);
    }

    
    //Metodos
    @Override
    public boolean isOvelha(){
        return true;
    }
    
    @Override
    public void movimenta(Terreno mundo[][]) {
        
    }

    @Override
    public void alimentaSe(Terreno[][] mundo, ArrayList<Animal> animais) {
        int nOvelhas = nOvelhasNoTerreno(mundo[this.x][this.y]);
        
        if(nOvelhas > 1){
            for(Animal a: mundo[this.x][this.y].getAnimal()) {
                if(a.isOvelha()){
                    a.adicionaEnergia(4/nOvelhas);
                }
            }
            mundo[this.x][this.y].vegetacaoComida();
        } else {
            this.energia += 4;
            mundo[this.x][this.y].vegetacaoComida();
        }
    }
    
    @Override
    public void nascimento(Terreno[][] mundo, ArrayList<Animal> animais) {
        
    }
    
    private int nOvelhasNoTerreno(Terreno terreno){
        int nOvelhas = 0;
        for(Animal a: terreno.getAnimal()) {
            if(a.isOvelha()){
                nOvelhas++;
            }
        }
        
        return nOvelhas;
    }
}
