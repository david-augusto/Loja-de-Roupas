package lojaroupas.control;

import javax.swing.JOptionPane;
import lojaroupas.model.Cliente;
import lojaroupas.model.CalculoCPF;
import lojaroupas.control.CPFException;

public class CadastroCliente implements InterfaceCadastro { //12. As caixas de diálogos foram adicionadas nas classes CadastroCliente, CadastroProduto para inserir os dados.
//8. As classes CadastroVendedor, CadastroCliente, CadastroProduto implementam a interfaceCadastro e a classe CadastroProduto implementa também a interfaceVenda.
    private Cliente cliente;

    public CadastroCliente() {
        cliente = new Cliente();
    }
        
    @Override
    public void cadastrar() throws CPFException { //11. Foi criada a CPFException no qual ele chama a exceção na classe Cliente e faz o tratamento na classe CadastroCliente.
       int controle = 0;
       cliente.setNome(JOptionPane.showInputDialog("Informe o nome do cliente"));
            while(controle == 0){
                try{
                    cliente.setCPF(JOptionPane.showInputDialog("Informe um CPF válido"));
                    controle = 1;
                }catch(CPFException e){
                controle = 0;    
                }
            }
       if(!cliente.getNome().isEmpty() && !cliente.getCPF().isEmpty()){
           
             cliente.setDataNasc(JOptionPane.showInputDialog("Informe a data de nascimento"));
             
             String rua = JOptionPane.showInputDialog("Informe a rua");
             String bairro = JOptionPane.showInputDialog("Informe a Bairro");
             String cidade = JOptionPane.showInputDialog("Informe a Cidade");
             
                      
             cliente.endereco(rua,bairro,cidade);
             
             
        
            
       }else{          
         JOptionPane.showMessageDialog(null,"Cadastro não realizado ");
       }
    }
    
     public String getListarCliente(){
        return cliente.getNome()+"   "+cliente.getCPF()+"\n"+cliente.getEnd().getRua()+" "+cliente.getEnd().getBairro()+" "+cliente.getEnd().getCidade();
               
    }
  
    @Override
    public void atualizar() { //6.2. O item do acoplamento dinâmico está na classe CadastroCliente no método atualizar, no qual ele chama o objeto cliente no método getEnd e em tempo de execução é escolhido o método na super classe Pessoa.       
             cliente.getEnd().setRua(JOptionPane.showInputDialog("Informe a rua"));
             cliente.getEnd().setBairro(JOptionPane.showInputDialog("Informe a Bairro"));
             cliente.getEnd().setCidade(JOptionPane.showInputDialog("Informe a Cidade"));
    }

    @Override
    public void deletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
