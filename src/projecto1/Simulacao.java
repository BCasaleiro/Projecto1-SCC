package projecto1;

import java.util.ArrayList;
import java.util.Random;

public class Simulacao {
    
    private final int tamanhoMundo = 51;
    private final int tempoMax = 5000;
    private final int nOvelhas = 100;
    private final int nLobos = 30;
    
    private ArrayList<Animal> animais = new ArrayList<Animal>();
    private Terreno[][] mundo = new Terreno[tamanhoMundo][tamanhoMundo];
    private int tempo = 0;

    public Simulacao() {
        // Inicializar celulas do terreno
        for(int abc=0;abc<tamanhoMundo;abc++){
            for(int cba=0;cba<tamanhoMundo;cba++){
                mundo[abc][cba] = new Terreno();
            }
        }
        
        // Criar e colocar os casaleiros/animais
        int x,y;
        Random rand = new Random();
        for(int i=0;i<(nOvelhas);i++){
            x = rand.nextInt(tamanhoMundo);
            y = rand.nextInt(tamanhoMundo);
            Ovelha ovelha = new Ovelha(x,y);
            mundo[x][y].getAnimal().add(ovelha);
            animais.add(ovelha);
        }
        for(int i=0;i<(nLobos);i++){
            x = rand.nextInt(tamanhoMundo);
            y = rand.nextInt(tamanhoMundo);
            Lobo lobo = new Lobo(x,y);
            mundo[x][y].getAnimal().add(lobo);
            animais.add(lobo);
        }
        
        // Simular os turnos
        for(int tempo=0;tempo<tempoMax;tempo++){
            System.out.println("Tempo: " + tempo + " Ovelhas: " + nOvelhas() + " Lobos: " + nLobos());
            // Acho que o erro tem a ver com quando os lobos comem uma ovelha porque é apagada...
            // do ArrayList e causa um erro de modificação concurrente e quando o iterador tenta aceder
            // a ela, a ovelha ja nao existe
            // Exception in thread "main" java.util.ConcurrentModificationException
            for(int i = 0; i < animais.size(); i++){
                animais.get(i).movimenta(mundo,animais,tamanhoMundo);
            }
            
            for(int loopX=0;loopX<tamanhoMundo;loopX++){
                for(int loopY=0;loopY<tamanhoMundo;loopY++){
                    if(mundo[loopX][loopY].isEstadoMax()==true){
                        for(Animal a: mundo[loopX][loopY].getAnimal()){
                            if(a.isOvelha()){
                                a.alimentaSe(mundo,animais);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    private int nLobos(){
        int n = 0;
        for(Animal a: animais){
            if(!a.isOvelha()){
                n++;
            }
        }
        return n;
    }
    
    private int nOvelhas(){
        int n = 0;
        for(Animal a: animais){
            if(a.isOvelha()){
                n++;
            }
        }
        return n;
    }
}
