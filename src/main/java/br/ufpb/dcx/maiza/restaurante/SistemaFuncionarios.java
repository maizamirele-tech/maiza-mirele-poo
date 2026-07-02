package br.ufpb.dcx.maiza.restaurante;

import java.util.List;

public interface SistemaFuncionarios {
    public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioInexisitenteException;
    public void cadastrarFuncionario (String cpf, String nome, TipoFuncionario tipo, double salario) throws FuncionarioJaExisteException;
    public void alterarSalarioDeFuncionario(String cpfFuncionario, double novoSalario) throws FuncionarioInexisitenteException;
    public int contarFuncionariosDoTipo (TipoFuncionario tipo);
    public boolean funcionarioJaExiste(String cpfFuncionario);
    public List<Funcionario> pesquisarFuncionarioPorTipo(TipoFuncionario tipo);
    public Funcionario pesqquisaeFuncionario(String cpfFuncionario) throws FuncionarioInexisitenteException;
    public List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor);
}
