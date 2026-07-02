package br.ufpb.dcx.maiza.restaurante;

public class FuncionarioInexistenteException extends Exception{
    public FuncionarioInexistenteException(String mensagem){
        super(mensagem);
    }
}
