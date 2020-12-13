
package lojaroupas.model;

import lojaroupas.control.CPFException;

public class Cliente extends Pessoa {
           
    private String telefone; //1.1 atributo private garantindo que somente a própria classe visualize  
    private String CPF;

    
    public Cliente(){
        
    }
    public Cliente(String telefone, String nome, String CPF, String dataNasc,Endereco e) {
        super(nome, dataNasc, e);
        this.CPF = CPF;
        this.telefone = telefone;
    }

    public void endereco(String r, String b, String c){
        super.setEnd(r,b,c);
    }
 
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) throws CPFException {
        CalculoCPF verificarCPF = new CalculoCPF(CPF); //3. Na classe Cliente foi utilizado o construtor declarado da classe CalculoCPF.
        if (verificarCPF.isCPF()){
        this.CPF = CPF;
        }else{
            throw new CPFException(); //11. Foi criada a CPFException no qual ele chama a exceção na classe Cliente e faz o tratamento na classe CadastroCliente.
        }
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

   
   
   
    
    
}
