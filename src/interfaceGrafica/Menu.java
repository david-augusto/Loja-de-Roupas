




package interfaceGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lojaroupas.control.CPFException;
import lojaroupas.control.CPFException;
import interfaceGrafica.Menu;
import interfaceGrafica.LerArquivo;
import javax.swing.JOptionPane;
import lojaroupas.control.CadastroFornecedor;
import lojaroupas.control.CadastroVendedor;
import lojaroupas.model.CupomFiscal;
import lojaroupas.model.FornecedorPF;
import lojaroupas.model.BackupFornecedores;
import lojaroupas.model.Venda;
import lojaroupas.model.BackupVendedores;

public class Menu extends JFrame {
    
    //Criação da barra de menu
    JMenuBar barra = new JMenuBar();
    
    //Criação das opções de menu
    JMenu menu3 = new JMenu("Vendedor");
    JMenu menu1 = new JMenu("Venda");
    JMenu menu4 = new JMenu("Fornecedor");
    JMenu menu2 = new JMenu("Sair");
    
    //Criação dos itens de menu   
    JMenuItem itemVenda = new JMenuItem("Efetuar Venda");
    JMenuItem itemNotasFiscal = new JMenuItem("NotasFiscais");
    JMenuItem itemSair = new JMenuItem("Exit");
    JMenuItem itemCadastrarVendedor = new JMenuItem("Cadastrar");
    JMenuItem itemVisualizarVendedor = new JMenuItem("Visualizar");
    JMenuItem itemCadastrarFornecedor = new JMenuItem("Cadastrar");
    JMenuItem itemVisualizarFornecedor = new JMenuItem("Visualizar");
    
    
    
    //Construtor
    public Menu()throws IOException, CPFException{
       //Adicionando barra de menu
       setJMenuBar(barra);
       
       // //Adicionando os menu na barra criada
       barra.add(menu3);
       barra.add(menu1);
       barra.add(menu4);
       barra.add(menu2);
       
       //Adicionando os itens em cada menu
       menu1.add(itemVenda);
       menu1.add(itemNotasFiscal);
       menu2.add(itemSair);
       menu3.add(itemCadastrarVendedor);
       menu3.add(itemVisualizarVendedor);
       menu4.add(itemCadastrarFornecedor);
       menu4.add(itemVisualizarFornecedor);
        
       //Ação do item Cadastrar Vendedor
       itemCadastrarVendedor.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                CadastroVendedor cv = new CadastroVendedor();                   
                     cv.cadastrar();
                     String vend = cv.getListarVendedorCompleto();
                        Object[] botoes = { "Sim", "Não" };
                            int resposta = JOptionPane.showOptionDialog(null,
				"O Vendedor precisará de Vale Transporte?",
				"Confirmação", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				botoes, botoes[0]);
		
                        if(resposta == 0){
                            BackupVendedores vc = new BackupVendedores();
                            try { //7.1 O item de sobrecarga está localizado na classe CadastroVendedor, no qual existe dois métodos com a mesma assinatura, chamado de calculoSalarioLiquido, que está sendo chamado em Menu                  
                                vc.cadastrados(vend,cv.isdeficiente(), cv.calculoSalarioLiquido(true), cv.INSS(),cv.TAXAVALETRANSPORTE(),cv.DESCONTOALIMENTACAO());
                                } catch (IOException ex) {
                                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                                }
                        }else if(resposta == 1){
                        BackupVendedores vc = new BackupVendedores();
                            try { //7.1 O item de sobrecarga está localizado na classe CadastroVendedor, no qual existe dois métodos com a mesma assinatura, chamado de calculoSalarioLiquido, que está sendo chamado em Menu
                                vc.cadastrados(vend,cv.isdeficiente(), cv.calculoSalarioLiquido(), cv.INSS(),0,cv.DESCONTOALIMENTACAO());
                            } catch (IOException ex) {
                     Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
                    }
                 }
            });
       //Ação do item visualizar vendedor
           itemVisualizarVendedor.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               try {
                   LerArquivo ler = new LerArquivo("vendedoresCadastrados.txt");
               } catch (IOException ex) {
                   Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
    });
       
       //Ação do item sair
       itemSair.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
             System.exit(0);
           }
    });
       
       //Ação do item Venda
       itemVenda.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
             Venda v = new Venda();
               try {
                   v.realizarVenda();
               } catch (IOException ex) {
                   Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
               } catch (CPFException ex) {
                   Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
               }
      
                CupomFiscal cupomFiscal = new CupomFiscal();
               try {
                   cupomFiscal.lerCupom();
               } catch (IOException ex) {
                   Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
    });
       
       //Ação do item Nota Fiscal
          itemNotasFiscal.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               try {
                   LerArquivo ler = new LerArquivo("cupomFiscal.txt");
               } catch (IOException ex) {
                   Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
    });
          
          //Ação do item Cadastrar Fornecedor
          itemCadastrarFornecedor.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               CadastroFornecedor cf = new CadastroFornecedor();
               try {
                   cf.verificar();
               } catch (CPFException ex) {
                   Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
               }
               String forn = cf.getFornecedorCompleto();
               String tipo = cf.getTipo();
               
               BackupFornecedores fc = new BackupFornecedores();
               try {
                   fc.cadastrados(forn, tipo);
               } catch (IOException ex) {
                   Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
    });
          
           //Ação do item visualizar fornecedor
           itemVisualizarFornecedor.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               try {
                   LerArquivo ler = new LerArquivo("fornecedoresCadastrados.txt");
               } catch (IOException ex) {
                   Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
    });
       
       //Configurações da tela
       setTitle("Menu");
       setSize(600,400);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       setVisible(true);
    }
    
}
