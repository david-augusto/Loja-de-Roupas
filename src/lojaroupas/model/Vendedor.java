package lojaroupas.model;

public class Vendedor extends Pessoa{

    private boolean ativo;
    private float salarioBruto;
    private final double TAXAINSS = 0.075F;
    private final double DESCONTOALIMENTACAO = 20;
    private final double TAXAVALETRANSPORTE = 0.06f;

    
    public Vendedor() {
        this.ativo = false;
    }

    public Vendedor(boolean ativo, String nome, String dataNasc, Endereco end, float salarioBruto) {
        super(nome, dataNasc, end);
        this.ativo = ativo;
        this.salarioBruto = salarioBruto;
    }
    
   public void endereco(String r, String b, String c){
        super.setEnd(r,b,c);
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public float getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(float salarioBruto) {
        this.salarioBruto = salarioBruto;
    }
 //polimosfismo de Coeção
    public float getTAXAINSS() { //7.2 O item polimorfismo de coesão na classe Vendedor está sendo usado no método getTAXAINSS que retorno um float usando um Casting num constante Double.
        return (float)TAXAINSS;
    }
 //polimosfismo de Coeção
    public float getDESCONTOALIMENTACAO() {
        return (float)DESCONTOALIMENTACAO;
    }
 //polimosfismo de Coeção
    public float getTAXAVALETRANSPORTE() {
        return (float)TAXAVALETRANSPORTE;
    }

    
    
     public String deficiencia(String descricaoDef){ //7.3 O item de subtipagem está sendo utilizado na classe Vendedor que sobrescreve o método deficiencia da classe Pessoa.
        return "SIM - " + descricaoDef;
    }
    
    
    
    
    

    
    
}
