package lojaroupas.control;


import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import lojaroupas.model.EnumMarcas;
import lojaroupas.model.Fornecedor;
import lojaroupas.model.FornecedorPF;
import lojaroupas.model.Produto;

public class CadastroProduto implements InterfaceCadastro, InterfaceVenda{ //12. As caixas de diálogos foram adicionadas nas classes CadastroCliente, CadastroProduto para inserir os dados.
//8. As classes CadastroVendedor, CadastroCliente, CadastroProduto implementam a interfaceCadastro e a classe CadastroProduto implementa também a interfaceVenda.
    
    private Produto produto;
    private String tipo;
    private final  JComboBox<EnumMarcas> comboMarca = new javax.swing.JComboBox<>();
    //1.3 Na classe CadastroProduto contém o atributo comboMarca que utiliza o Enum

    public CadastroProduto() {
         produto = new Produto();  
         //4. Na classe CadastroProduto existe a nossa associação por composição, 
         //no qual para cadastrar um produto é necessário existir um produto que é instanciado no construtor.
    }
    
    
    @Override
    public void cadastrar() {  
        
         produto.setNome(JOptionPane.showInputDialog("Informe o produto"));
        
        
           Object[] botoes = { "Feminina", "Masculina" };
		int resposta = JOptionPane.showOptionDialog(null,
				"Qual o tipo de roupa?",
				"Confirmação", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				botoes, botoes[0]);
		
		if(resposta == 0){
                    this.tipo = "F";
		}else if(resposta == 1){
                    this.tipo = "M";
		} 
       
        produto.setPreco(Float.parseFloat(JOptionPane.showInputDialog("Informe o preço")));
        produto.setQtd(Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade")));
        
       
        if(produto.getQtd() > 1){
            if(produto.getQtd() >= 4 && this.tipo.equals("F")){
               produto.setPreco(descontoRoupaFem());
            }else{
               produto.setPreco(totalItem(produto.getPreco(),produto.getQtd()));
            }
                         
        }
        
        for(EnumMarcas e: EnumMarcas.values()){
            comboMarca.addItem(e);
        }
        
        JOptionPane.showMessageDialog(null,comboMarca);
        produto.setMarca(comboMarca.getSelectedItem().toString());
        
    }
    
    public float descontoRoupaFem(){ //6.1 Foi declarado a atributo Final DESCONTO na super classe Produto e usada para fornecer desconto em roupas femininas na classe CadastroProduto.
       return totalItem(produto.getPreco(),produto.getQtd()) - Produto.getDESCONTO();
    }
    
    public static float totalVenda(Produto... produtos){ //2.1 criado o argumento variável para receber uma quantidade N de produtos e calcular o total da venda
        float soma = 0;
        for(Produto p: produtos){
            soma += p.getPreco();
        }        
        return soma;
    }
    
    public Produto getProduto() {
        return produto;
    }
    
    public String getListarProduto(){
        return " "+produto.getQtd()+"         "+ produto.getNome()+" "+produto.getMarca()+"          "+ produto.getPreco()+"\n "+"          "+this.tipo;
              
    }
    
    
    @Override
    public float totalItem(float valorItem, int qtd){
       return valorItem * qtd;  
    }

    @Override
    public void visualizar() {
        System.out.println("Nome: "+produto.getNome());
        System.out.println("Preço:  "+produto.getPreco());
        System.out.println("Quantidade: "+produto.getQtd());
       
        
    }

    @Override
    public void atualizar() {
       produto.setPreco(Float.parseFloat(JOptionPane.showInputDialog("Informe o preço")));
       
       produto.setQtd(Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade")));
    }

    @Override
    public void deletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
