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

public class BackupVendedores extends Backup {
    
   
    
    public BackupVendedores(){
        
    }
    
    public void cadastrados(String vendedor, String deficiente, float salarioLiquido,float inss, float transporte,float alimentacao) throws IOException {
        
      
        
        File arquivo = new File("vendedoresCadastrados.txt");
               
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
        bw.write("VENDEDOR              ");
        bw.newLine();
        bw.write(vendedor);
        bw.newLine(); 
        bw.write("DEFICIENTE?: " + deficiente);
        bw.newLine();
        bw.write("DESCONTOS:                          ");
        bw.newLine();
        bw.write("INSS:                R$ " + inss);
        bw.newLine();
        bw.write("VALE ALIMENTAÇÃO:    R$ " + alimentacao);
        bw.newLine();
        bw.write("VALE TRANSPORTE:     R$ " + transporte);
        bw.newLine();
        bw.write("SALÁRIO LIQUIDO      R$ " + salarioLiquido);
        bw.newLine();
        bw.write("---------------------------------------");
        bw.newLine();
        bw.newLine();
        bw.close();
        fw.close();
    }
    
    public void ler() throws FileNotFoundException, IOException{
        String linha;
        FileReader fr = new FileReader("vendedoresCadastrados.txt");
        BufferedReader br = new BufferedReader(fr);
        
        while(br.ready()){
            linha = br.readLine();
            System.out.println(linha);
        }
        br.close();
        fr.close();
    }

    @Override
    public void cadastrados(String fornecedor, String tipo) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

