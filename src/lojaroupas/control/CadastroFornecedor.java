/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaroupas.control;

import javax.swing.JOptionPane;
import lojaroupas.model.Cliente;

import javax.swing.JOptionPane;
import lojaroupas.model.Cliente;
import lojaroupas.model.CalculoCPF;
import lojaroupas.control.CPFException;
import lojaroupas.model.Fornecedor;
import lojaroupas.model.FornecedorPF;
import lojaroupas.model.FornecedorPJ;

public class CadastroFornecedor {
    private String fornecedorCompleto;
    private String tipo;

      public void verificar() throws CPFException{
          Object[] botoes = { "Fisica", "Jurídica" };
		int resposta = JOptionPane.showOptionDialog(null,
				"O Fornecedor é Pessoa Fisica ou Jurídica?",
				"Confirmação", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				botoes, botoes[0]);
		
		if(resposta == 0){ //7.4 O item paramétrico está sendo utilizado na classe Genérica Fornecedor que é instanciada na classe CadastroFornecedor, podendo ser fornecedor física ou jurídica.
			  Fornecedor<FornecedorPF> fornecedor = new Fornecedor(new FornecedorPF());
                          int controle = 0;
                          while(controle == 0){
                            try{
                            fornecedor.getFornecedor().setCPF(JOptionPane.showInputDialog("Informe um CPF válido"));
                            controle = 1;
                            }catch(CPFException e){
                            controle = 0;    
                            }}                        
                          cadastrar(fornecedor);
                          this.tipo = "PESSOA FISICA - CPF: " + fornecedor.getFornecedor().getCPF();
                          this.fornecedorCompleto = ListarFornecedorCompleto(fornecedor);
		}else if(resposta == 1){			
                        Fornecedor<FornecedorPJ> fornecedor = new Fornecedor(new FornecedorPJ()); //7.4 O item paramétrico está sendo utilizado na classe Genérica Fornecedor que é instanciada na classe CadastroFornecedor, podendo ser fornecedor física ou jurídica.
                        fornecedor.getFornecedor().setCNPJ(JOptionPane.showInputDialog("Informe um CNPJ válido"));
                        cadastrar(fornecedor);
                        this.tipo = "PESSOA JURÍDICA - CNPJ: " + fornecedor.getFornecedor().getCNPJ();
                        this.fornecedorCompleto = ListarFornecedorCompleto(fornecedor);
		}
     }
  
    
    public void cadastrar(Fornecedor fornecedor){
        
       fornecedor.setNome(JOptionPane.showInputDialog("Informe o nome do cliente"));
       

            
       if(!fornecedor.getNome().isEmpty()){
           
             fornecedor.setDataNasc(JOptionPane.showInputDialog("Informe a data de nascimento"));
             
             String rua = JOptionPane.showInputDialog("Informe a Rua");
             String bairro = JOptionPane.showInputDialog("Informe a Bairro");
             String cidade = JOptionPane.showInputDialog("Informe a Cidade");
             
             fornecedor.endereco(rua, bairro, cidade);
        
            
       }else{          
         JOptionPane.showMessageDialog(null,"Cadastro não realizado ");
       }
    }
    
    
    public String ListarFornecedorCompleto(Fornecedor fornecedor){
        return fornecedor.getNome()+"   "+"\nRUA: "+fornecedor.getEnd().getRua()+" BAIRRO: "+fornecedor.getEnd().getBairro()+" CIDADE: "+fornecedor.getEnd().getCidade();
               
    }

    public String getFornecedorCompleto() {
        return fornecedorCompleto;
    }

    public String getTipo() {
        return tipo;
    }
    
    
    
    
    
    
}

