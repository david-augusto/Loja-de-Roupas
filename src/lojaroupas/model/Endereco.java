
package lojaroupas.model;

public class Endereco {
    
    private String rua;
    private String bairro;
    private String cidade;

    public Endereco() {
    }

    public Endereco(String rua, String bairro, String cidade) {//3. Na classe pessoa foi utilizado o construtor declarado da classe endereço.
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
    }


    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
       
    
    
}
