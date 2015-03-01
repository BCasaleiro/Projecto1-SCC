package projecto1;

import java.util.ArrayList;
import java.util.Random;

public class Ovelha extends Animal {
    
    private final float probNasc = (float) 0.05;
    private final int energiaInicial = 7;
    
    //Construtores
    public Ovelha(int x, int y){
        super(x,y);
        Random rand = new Random();
        this.energia = rand.nextInt(energiaInicial+1);
    }

    
    //Metodos
    @Override
    public boolean isOvelha(){
        return true;
    }

    @Override
    public void alimentaSe(Terreno[][] mundo, ArrayList<Animal> animais) {
        int nOvelhas = nOvelhasNoTerreno(mundo[this.x][this.y]);
        
        if(nOvelhas > 1){
            for(Animal a: mundo[this.x][this.y].getAnimal()) {
                if(a.isOvelha()){
                    if((this.energia + (4/nOvelhas)) >= 7){
                        this.energia = 7;
                    } else{
                        this.energia += 4/nOvelhas;
                    }
                }
            }
            mundo[this.x][this.y].vegetacaoComida();
        } else {
            this.energia += 4;
            
            if((this.energia + 4) >= 7){
                this.energia = 7;
            } else{
                this.energia += 4;
            }
            
            mundo[this.x][this.y].vegetacaoComida();
        }
    }
    
    @Override
    public void nascimento(Terreno[][] mundo, ArrayList<Animal> animais) {
        if (nasce(probNasc)){
            Ovelha item = new Ovelha(this.x,this.y);
            animais.add(item);
            mundo[this.x][this.y].getAnimal().add(item);
        }
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
