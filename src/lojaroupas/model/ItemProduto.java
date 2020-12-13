
package lojaroupas.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import lojaroupas.control.CadastroProduto;

public class ItemProduto extends Produto {
    
   
    private ArrayList listaItem; //1.4 ArrayList criado para armazenar os podutos escolhidos pelo cliente

    public ItemProduto() {
    }

    public ItemProduto(ArrayList listaItem, String nome, float preco, int qtd) {
        super(nome, preco, qtd);
        this.listaItem = listaItem;
    }

    public ArrayList getListaItem() {
        return listaItem;
    }
      
  
    
    public String adicionarItemProduto(){
         String add = "s";        
         String produtos = " ";       

         while(add.equalsIgnoreCase("s")){
             
              CadastroProduto cp = new CadastroProduto();
              cp.cadastrar();
              produtos += cp.getListarProduto(); 
             
              Object[] botoes = { "Sim", "Não" };
		int resposta = JOptionPane.showOptionDialog(null,
				"Deseja adiconar novo produto?",
				"Confirmação", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				botoes, botoes[0]);
		
		if(resposta == 0){
			add = "s";
		}else if(resposta == 1){			
                        add = "n";
		}
         }
         return produtos;
                
    }
    
    public Produto item(){
         CadastroProduto cp = new CadastroProduto();
         cp.cadastrar();
         return cp.getProduto();
                 
    }
    
    public List<Produto> addItemProduto(){
           String add = "s";        
        
        List<Produto> produtos = new ArrayList<>();

         while(add.equals("s")){
             
              CadastroProduto cp = new CadastroProduto();
              cp.cadastrar();
              produtos.add(cp.getProduto());
             // produtos += cp.getListarProduto(); 
             
              Object[] botoes = { "Sim", "Não" };
		int resposta = JOptionPane.showOptionDialog(null,
				"Deseja adiconar novo produto?",
				"Confirmação", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				botoes, botoes[0]);
		
		if(resposta == 0){
			add = "s";
		}else if(resposta == 1){			
                        add = "n";
		}
         }
        
         return produtos;
    }
    
  
   
}
