package br.ufpb.dcx.maiza.restaurante;

import java.util.List;

public interface SistemaFuncionarios {
    public void cadastrarFuncionario(String cpf, String nome, TipoFuncionario tipo, double salario) throws FuncionarioJaExisteException;
    public int contarFuncionariosDoTipo(TipoFuncionario tipo);
    public boolean funcionarioJaExiste(String cpfFuncionario);
    public List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor);
    public void cadastrarFuncionario(Funcionario f) throws FuncionarioJaExisteException;
    List<Funcionario> pesquisarFuncionariosPorTipo(TipoFuncionario tipo);
    void alterarSalarioDeFuncionario(String cpfFuncionario, double novoSalario) throws FuncionarioInexistenteException;
    Funcionario pesquisarFuncionario(String cpfFuncionario) throws FuncionarioInexistenteException;

}