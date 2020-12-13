package lojaroupas.control;

import javax.swing.JOptionPane;
import lojaroupas.model.Vendedor;

public class CadastroVendedor implements InterfaceCadastro{
//8. As classes CadastroVendedor, CadastroCliente, CadastroProduto implementam a interfaceCadastro e a classe CadastroProduto implementa também a interfaceVenda.   
    private Vendedor vendedor;

    public CadastroVendedor() {        
        vendedor = new Vendedor();
    }
    
    public String getListarVendedor() {
        return vendedor.getNome();
    }
        
    
    public void cadastrarNome() {
      
       vendedor.setNome(JOptionPane.showInputDialog("Informe o nome do vendedor"));
            
       if(!vendedor.getNome().isEmpty()){
             vendedor.setAtivo(true);
             JOptionPane.showMessageDialog(null,"Venda Realizada");
       }else{          
         JOptionPane.showMessageDialog(null,"Cadastro não realizado ");
       }
     
    
    }
   
    @Override
    public void cadastrar() {
       
       vendedor.setNome(JOptionPane.showInputDialog("Informe o nome do Vendedor"));
            
       if(!vendedor.getNome().isEmpty()){
             vendedor.setAtivo(true);
             vendedor.setDataNasc(JOptionPane.showInputDialog("Informe a data de nascimento"));
             
             String rua = JOptionPane.showInputDialog("Informe a rua");
             String bairro = JOptionPane.showInputDialog("Informe a Bairro");
             String cidade = JOptionPane.showInputDialog("Informe a Cidade");
             
             vendedor.endereco(rua,bairro,cidade);
         
             vendedor.setSalarioBruto(Float.parseFloat(JOptionPane.showInputDialog("Informe o salário bruto")));
             
            
            
       }else{          
         JOptionPane.showMessageDialog(null,"Cadastro não realizado ");
       }
     
    
    }
   
    
    @Override
    public void visualizar() {
      if(vendedor.isAtivo()){
        System.out.println("Nome: "+vendedor.getNome());              
      }else{          
         JOptionPane.showMessageDialog(null,"Vendedor não encontrado ");
       }
        
    }

    @Override
    public void atualizar() {
       if(vendedor.isAtivo()){
          vendedor.setNome(JOptionPane.showInputDialog("Informe o Nome"));  
       }
    }

    @Override
    public void deletar() {
        vendedor.setAtivo(false);
    }
    
    public String getListarVendedorCompleto(){
        return vendedor.getNome()+"   "+"\nRUA: "+vendedor.getEnd().getRua()+" BAIRRO: "+vendedor.getEnd().getBairro()+" CIDADE: "+vendedor.getEnd().getCidade()+
        "\nSALÁRIO BRUTO: \t"+vendedor.getSalarioBruto();
               
    }
    //Sobrecarga
        public  float calculoSalarioLiquido(){ //7.1 O item de sobrecarga está localizado na classe CadastroVendedor, no qual existe dois métodos com a mesma assinatura, chamado de calculoSalarioLiquido, que está sendo chamado em Menu
        return  vendedor.getSalarioBruto() - (vendedor.getSalarioBruto() * vendedor.getTAXAINSS()) - vendedor.getDESCONTOALIMENTACAO();
    }
     //Sobrecarga
    public float calculoSalarioLiquido(boolean valeTransporte){ //7.1 O item de sobrecarga está localizado na classe CadastroVendedor, no qual existe dois métodos com a mesma assinatura, chamado de calculoSalarioLiquido, que está sendo chamado em Menu
        return vendedor.getSalarioBruto() - (vendedor.getSalarioBruto() * vendedor.getTAXAINSS()) - (vendedor.getSalarioBruto() * vendedor.getTAXAVALETRANSPORTE())
         - vendedor.getDESCONTOALIMENTACAO() ;
    }

    public float INSS() {
        return vendedor.getSalarioBruto() * vendedor.getTAXAINSS();
    }

    public float DESCONTOALIMENTACAO() {
        return vendedor.getDESCONTOALIMENTACAO();
    }

    public float TAXAVALETRANSPORTE() {
        return vendedor.getSalarioBruto() * vendedor.getTAXAVALETRANSPORTE();
    }
    
    public String isdeficiente(){
        String resultado = "";
         Object[] botoes = { "Sim", "Não" };
                        int resposta = JOptionPane.showOptionDialog(null,
				"O vendedor possui alguma deficiencia?",
				"Confirmação", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				botoes, botoes[0]);
		
                        if(resposta == 0){
                         resultado =  vendedor.deficiencia(JOptionPane.showInputDialog("Qual deficiência?"));
                        }else if(resposta == 1){			
                         resultado =   vendedor.deficiencia();
                        }
                 return resultado;
                }
    }
   
