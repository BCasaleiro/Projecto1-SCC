/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Rui Mendes
 */
public class Ficheiros {  
    private String nomeDoFicheiro;
    private BufferedWriter fW;
    private FileWriter fwt;

    Ficheiros() throws IOException{
    }
    // ESCRITA
    public void abreEscrita(String nomeDoFicheiro) throws IOException{
        fwt = new FileWriter(nomeDoFicheiro);
        fW = new BufferedWriter(fwt);
    }
    public void escreveLinha(String linha) throws IOException{
        fW.write(linha);
        fW.newLine();
    }
    public void fechaEscrita() throws IOException {
        fW.close();
    }
}
