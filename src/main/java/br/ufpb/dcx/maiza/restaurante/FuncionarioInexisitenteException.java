package br.ufpb.dcx.maiza.restaurante;

public class FuncionarioInexisitenteException extends Exception{
    public FuncionarioInexisitenteException(String mensagem){
        super(mensagem);
    }
}
