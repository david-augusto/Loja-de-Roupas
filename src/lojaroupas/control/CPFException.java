package lojaroupas.control;

public class CPFException extends Exception { //11. Foi criada a CPFException no qual ele chama a exceção na classe Cliente e faz o tratamento na classe CadastroCliente.

    public CPFException() {
    }

    public String getMensagem(){
        return "CPF Invalido";
    }
    public CPFException(String msg) {
        super(msg);
    }
}
