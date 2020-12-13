
package lojaroupas.model;

import lojaroupas.control.CPFException;

public class FornecedorPF extends Pessoa{
    
    private String telefone;
    private String CPF;
    private String IE;

    public FornecedorPF() {
       
    }
    
    public FornecedorPF(String telefone, String CPF, String IE) {
        this.telefone = telefone;
        this.CPF = CPF;
        this.IE = IE;
    }

    public FornecedorPF(String telefone, String CPF, String IE, String nome, String dataNasc, Endereco end) {
        super(nome, dataNasc, end);
        this.telefone = telefone;
        this.CPF = CPF;
        this.IE = IE;
    }
    
       public void endereco(String r, String b, String c){
        super.setEnd(r,b,c);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCPF(String CPF) throws CPFException {
        CalculoCPF verificarCPF = new CalculoCPF(CPF);
        if (verificarCPF.isCPF()){
        this.CPF = CPF;
        }else{
            throw new CPFException();
        }
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public String getCPF() {
        return CPF;
    }

   
    
 
    
    
}
