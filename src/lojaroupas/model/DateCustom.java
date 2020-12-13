
package lojaroupas.model;

import java.text.SimpleDateFormat;

public class DateCustom {
    
    public static String dataAtual(){ //2.2 método criado para informar a data e hora no cupom fiscal
        long data = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = simpleDateFormat.format(data);
        return dataString;
    }
    
    
     public static String dataHora(){ //2.2 método criado para informar a data e hora no cupom fiscal
        long data = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
        String dataString = simpleDateFormat.format(data);
        return dataString;
    }
    
    
}
