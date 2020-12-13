
package lojaroupas.model;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Backup { //10. Foi implementado duas classes abstract Backup e Pessoa que não precisavam ser instanciadas e ambas possuem métodos abstratos.
     private final String LOJA = "FASHION STAR \nCNPJ 15.263.926/0001-47 \nJardim José Figueira Ribeirão Preto SP";
     
     public abstract void cadastrados(String fornecedor, String tipo) throws IOException;
     
      public abstract void ler() throws FileNotFoundException, IOException;

    public String getLOJA() {
        return LOJA;
    }
      
      
     
}
