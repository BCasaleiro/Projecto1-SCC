package projecto1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Simulacao {
    
    private final int tamanhoMundo = 51;
    private final int tempoMax = 5000;
    private final int nOvelhas = 100;
    private final int nLobos = 30;
    
    private ArrayList<Animal> animais = new ArrayList<Animal>();
    private Terreno[][] mundo = new Terreno[tamanhoMundo][tamanhoMundo];
    private int tempo = 1;

    public Simulacao() throws IOException {
        
        // Abrir escrita para ficheiros
        Ficheiros escLobos = new Ficheiros();
        Ficheiros escVeg = new Ficheiros();
        Ficheiros escOv = new Ficheiros();
        escLobos.abreEscrita("Lobos.txt");
        escOv.abreEscrita("Ovelhas.txt");
        escVeg.abreEscrita("Vegetacao estado maximo.txt");
        
        // Inicializar celulas do terreno
        for(int abc=0;abc<tamanhoMundo;abc++){
            for(int cba=0;cba<tamanhoMundo;cba++){
                mundo[abc][cba] = new Terreno();
            }
        }
        
        // Criar e colocar os animais
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
        for(int tempo=1;tempo<=tempoMax;tempo++){
            System.out.println("Tempo: " + tempo + " Ovelhas: " + nOvelhas() + " Lobos: " + nLobos() + " Vegetação no estado máximo: " + nTerreno());
            escLobos.escreveLinha(Integer.toString(nLobos()));
            escOv.escreveLinha(Integer.toString(nOvelhas()));
            escVeg.escreveLinha(Integer.toString(nTerreno()));
            for(int i = 0; i < animais.size(); i++){
                animais.get(i).movimenta(mundo,animais,tamanhoMundo);
                if(i < animais.size()) {    
                    if(animais.get(i).isMorto()){
                        animais.get(i).morte(mundo, animais);
                    }
                }
            }
            
            for(int loopX=0;loopX<tamanhoMundo;loopX++){
                for(int loopY=0;loopY<tamanhoMundo;loopY++){
                    if(mundo[loopX][loopY].isEstadoMax()) {
                        for(Animal a: mundo[loopX][loopY].getAnimal()){
                            if(a.isOvelha()){
                                a.alimentaSe(mundo,animais);
                                break;
                            }
                        }
                    } else {
                        mundo[loopX][loopY].incrementaEstado();
                    }
                }
            }
        }
        
        // Fechar escrita de ficheiros
        escLobos.fechaEscrita();
        escVeg.fechaEscrita();
        escOv.fechaEscrita();
    }
    
    // Funções auxiliares
    
    private int nTerreno() {
        int n = 0;
        
        for(int loopX=0;loopX<tamanhoMundo;loopX++){
                for(int loopY=0;loopY<tamanhoMundo;loopY++){
                    if(mundo[loopX][loopY].isEstadoMax()){
                        n++;
                    }
                }
            }
        return n;
    }
    
    private int nLobos() {
        int n = 0;
        for(Animal a: animais){
            if(!a.isOvelha()){
                n++;
            }
        }
        return n;
    }
    
    private int nOvelhas() {
        int n = 0;
        for(Animal a: animais){
            if(a.isOvelha()){
                n++;
            }
        }
        return n;
    }
}
