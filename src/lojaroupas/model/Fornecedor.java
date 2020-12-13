
package lojaroupas.model;

public  class Fornecedor<G> extends Pessoa { //7.4 O item paramétrico está sendo utilizado na classe Genérica Fornecedor que é instanciada na classe CadastroFornecedor, podendo ser fornecedor física ou jurídica.
    
    
    private G fornecedor;

    public Fornecedor(G fornecedor) {
        this.fornecedor = fornecedor;
        
    }

    public G getFornecedor() {
        return fornecedor;
    } 
    
    public void endereco(String r, String b, String c){
        super.setEnd(r,b,c);
    }
}
