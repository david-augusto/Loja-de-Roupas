

package lojaroupas.model;

public class FornecedorPJ extends Pessoa {
    
    
    private String telefone;
    private String CNPJ;
    private String IE;

    public FornecedorPJ() {
        //5. Na classe FornecedorPJ existe a nossa associação por agregação, no qual um fornecedor Pessoa jurídica pode não ser uma pessoa e não é instanciado no construtor.
    }
    
    public FornecedorPJ(String telefone, String CNPJ, String IE) {
        this.telefone = telefone;
        this.CNPJ = CNPJ;
        this.IE = IE;
    }
    

    public FornecedorPJ(String telefone, String CNPJ, String IE, String nome, String dataNasc, Endereco end) {
        super(nome, dataNasc, end);
        this.telefone = telefone;
        this.CNPJ = CNPJ;
        this.IE = IE;
    }

     public void endereco(String r, String b, String c){
        super.setEnd(r,b,c);
    }
    
    public String getCNPJ() {
        return CNPJ;
    }

    public String getIE() {
        return IE;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

 
    
   

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}

