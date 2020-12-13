
package lojaroupas.model;
import lojaroupas.control.CPFException;

public abstract class Pessoa{ //10. Foi implementado duas classes abstract Backup e Pessoa que não precisavam ser instanciadas e ambas possuem métodos abstratos.
    
    private String nome; //1.2 Na classe pessoa contém o atributo String nome que é importante para outras classes.
    private String dataNasc;
    private Endereco end; 

    public Pessoa() {
    }
    
    
    public Pessoa(String nome, String dataNasc, Endereco end) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.end = end;
    }

    public Endereco getEnd() { //6.2. O item do acoplamento dinâmico está na classe CadastroCliente no método atualizar, no qual ele chama o objeto cliente no método getEnd e em tempo de execução é escolhido o método na super classe Pessoa.
        return end;
    }

    public void setEnd(String rua,String bairro,String cidade) {    
        end = new Endereco(rua,bairro,cidade); //3. Na classe pessoa foi utilizado o construtor declarado da classe endereço.          
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    
    public String deficiencia(){ // 7.3 O item de subtipagem está sendo utilizado na classe Vendedor que sobrescreve o método deficiencia da classe Pessoa.
        return "NÃO";
    }
    
    public abstract void endereco(String r, String b, String c);
    
}
