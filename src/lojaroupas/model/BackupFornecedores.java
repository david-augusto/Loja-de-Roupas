/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaroupas.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class BackupFornecedores extends Backup {
    
   
    
    public BackupFornecedores(){
        
    }
    
    public void cadastrados(String fornecedor, String tipo) throws IOException {
        
      
        
        File arquivo = new File("fornecedoresCadastrados.txt");
               
        if(arquivo.exists()){
             System.out.println("Arquivo localizado com sucessso");
        }else{
             System.out.println("Arquivo não localizado, será criado outro");
             arquivo.createNewFile();
        } 
        
        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        
        bw.write("              "+super.getLOJA());
        bw.newLine();
        bw.write("---------------------------------------");
        bw.newLine();
        bw.write("FORNECEDOR              ");
        bw.newLine();
        bw.write(fornecedor);
        bw.newLine(); 
        bw.write("TIPO: " + tipo);
        bw.newLine();
        bw.write("---------------------------------------");
        bw.newLine();
        bw.newLine();
        bw.close();
        fw.close();
    }
    
    public void ler() throws FileNotFoundException, IOException{
        String linha;
        FileReader fr = new FileReader("fornecedoresCadastrados.txt");
        BufferedReader br = new BufferedReader(fr);
        
        while(br.ready()){
            linha = br.readLine();
            System.out.println(linha);
        }
        br.close();
        fr.close();
    }
    
}


