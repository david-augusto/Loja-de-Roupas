
package lojaroupas.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class CupomFiscal { //13. Foi criado uma classe CupomFiscal que gera o arquivo
    
    private final String LOJA = "FASHION STAR \nCNPJ 15.263.926/0001-47 \nJardim José Figueira Ribeirão Preto SP";
    //1.5 Constante criada para mostrar o nome da loja no cupom fiscal 
    
    public void gerarCupom(String cliente, String vendedor,List<Produto> produtos, float totalVenda ) throws IOException {
        
        File arquivo = new File("cupomFiscal.txt");
        String produto =" ";       
        if(arquivo.exists()){
             System.out.println("Arquivo localizado com sucessso");
        }else{
             System.out.println("Arquivo não localizado, será criado outro");
             arquivo.createNewFile();
        } 
        
        for(Produto p: produtos){
            produto += " "+p.getQtd()+"         "+ p.getNome()+" "+p.getMarca()+"          "+ p.getPreco()+"\n ";
         }
        
      
        
        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        
        bw.write("              "+LOJA);
        bw.newLine();
        bw.write("---------------------------------------");
        bw.newLine();
        bw.write("CLIENTE              CPF");
        bw.newLine();
        bw.write(cliente);
        bw.newLine();
        bw.write("---------------------------------------");
        bw.newLine();
        bw.write(DateCustom.dataHora());
        bw.newLine();
        bw.write("             CUPOM FISCAL          ");
        bw.newLine();
        bw.write("QTD          DESCRIÇÃO           PREÇO");
        bw.newLine();
        bw.write(produto);
        bw.newLine();        
        bw.write("---------------------------------------");
        bw.newLine();
        bw.write("TOTAL                          R$ " + totalVenda);
        bw.newLine();
        bw.write("---------------------------------------");
        bw.newLine();
        bw.write("Vendedor " + vendedor);
        bw.newLine();
        bw.newLine();
        bw.close();
        fw.close();
    }
    
    public void lerCupom() throws FileNotFoundException, IOException{
        String linha;
        FileReader fr = new FileReader("cupomFiscal.txt");
        BufferedReader br = new BufferedReader(fr);
        
        while(br.ready()){
            linha = br.readLine();
            System.out.println(linha);
        }
        br.close();
        fr.close();
    }
    
}
