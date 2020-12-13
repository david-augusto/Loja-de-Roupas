
package lojaroupas.model;

public class Produto {
    
    private String nome;
    private float preco;
    private int qtd;
    private String marca;  
    private static final float DESCONTO = 10.0f;//6.1 Foi declarado a atributo Final DESCONTO na super classe Produto e usada para fornecer desconto em roupas femininas na classe CadastroProduto.
    
    /*Foi declarado a atributo Final DESCONTO na super classe Produto
    e usada para fornecer desconto em roupas femininas na classe CadastroProduto.*/
    
    public Produto() {
    }

    public Produto(String nome, float preco, int qtd) {
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
   
    public static float getDESCONTO() {
        return DESCONTO;
    }

    
}
