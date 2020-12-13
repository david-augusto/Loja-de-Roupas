




package interfaceGrafica;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;


public class LerArquivo {
    
    LerArquivo(String link) throws IOException{
    Path caminho =  Paths.get(link);
   
    byte[] texto = Files.readAllBytes(caminho);
    String leitura = new String(texto);
 
    JOptionPane.showMessageDialog(null, leitura);
    
        }
}
