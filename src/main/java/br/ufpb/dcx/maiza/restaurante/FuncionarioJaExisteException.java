package br.ufpb.dcx.maiza.restaurante;

public class FuncionarioJaExisteException extends Exception {
    public FuncionarioJaExisteException(String mensagem) {
        super(mensagem); // Corrigido aqui (apenas um ponto e vírgula)
    }
}