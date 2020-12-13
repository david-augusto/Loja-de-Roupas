package lojaroupas.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import lojaroupas.control.CPFException;

import lojaroupas.control.CadastroCliente;
import lojaroupas.control.CadastroProduto;
import lojaroupas.control.CadastroVendedor;

public class Venda {
    
    private Produto[] p;
    private List<Produto> lista;
        
    public void realizarVenda() throws IOException, CPFException{
        
        lista = new ArrayList();
        
        CadastroCliente cc = new CadastroCliente();
        cc.cadastrar();
     
        
              Object[] botoes = { "Sim", "Não" };
		int resposta = JOptionPane.showOptionDialog(null,
				"Deseja atualizar o endereço do cliente?",
				"Confirmação", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				botoes, botoes[0]);
		
		if(resposta == 0){
			cc.atualizar();
		}else if(resposta == 1){			
                       ;
		}
        
        ItemProduto itemProduto = new ItemProduto();
        
       
        lista.addAll(itemProduto.addItemProduto());
      
        p = new Produto[lista.size()];
        
        for(int i=0;i<lista.size();i++){
            p[i] = lista.get(i);
        }
        
        float totalVenda = CadastroProduto.totalVenda(p);        
             
        CadastroVendedor cv = new CadastroVendedor();
        cv.cadastrarNome();
        
        CupomFiscal cupomFiscal = new CupomFiscal();
        cupomFiscal.gerarCupom(cc.getListarCliente(),cv.getListarVendedor(),lista,totalVenda);
    
    }
}
