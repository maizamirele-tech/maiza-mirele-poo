package br.ufpb.dcx.maiza.restaurante;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class SistemaFuncionariosBomPrato implements SistemaFuncionarios {
    private Map<String, Funcionario> funcionarios;

    public SistemaFuncionariosBomPrato() {
        this.funcionarios = new HashMap<String, Funcionario>();
    }

    @Override
    public void cadastrarFuncionario(String cpf, String nome, TipoFuncionario tipo, double salario) throws FuncionarioJaExisteException {
        if (this.funcionarios.containsKey(cpf)) {
            throw new FuncionarioJaExisteException("Já existe funcionário com o cpf " + cpf);
        } else {
            this.funcionarios.put(cpf, new Funcionario(cpf, nome, tipo, salario));
        }
    }

    @Override
    public boolean funcionarioJaExiste(String cpfFuncionario) {
        return this.funcionarios.containsKey(cpfFuncionario);
    }

    @Override
    public Funcionario pesquisarFuncionario(String cpfFuncionario) throws FuncionarioInexistenteException {
        Funcionario f = this.funcionarios.get(cpfFuncionario);
        if (f == null) {
            throw new FuncionarioInexistenteException("Funcionário não encontrado.");
        }
        return f;
    }

    @Override
    public List<Funcionario> pesquisarFuncionariosPorTipo(TipoFuncionario tipo) {
        List<Funcionario> porTipo = new ArrayList<>();
        for (Funcionario f : this.funcionarios.values()) {
        }
        return porTipo;
    }

    // --- QUESTÃO 1 ---
    @Override
    public List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor) {
        List<Funcionario> resultado = new ArrayList<>();
        for (Funcionario f : this.funcionarios.values()) {
            if (f.getSalario() > valor) {
                resultado.add(f);
            }
        }
        return resultado;
    }

    // --- QUESTÃO 2 ---
    @Override
    public int contarFuncionariosDoTipo(TipoFuncionario tipo) {
        int contador = 0;
        for (Funcionario f : this.funcionarios.values()) {
            if (f.getTipo() == tipo) {
                contador++;
            }
        }
        return contador;
    }
    @Override
    public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException {
        if (this.funcionarios.containsKey(funcionario.getCpf())) {
            throw new FuncionarioJaExisteException("J� existe funcion�rio com o cpf " + funcionario.getCpf());
        }
        this.funcionarios.put(funcionario.getCpf(), funcionario);
    }

    // --- QUESTÃO 3 ---
    @Override
    public void alterarSalarioDeFuncionario(String cpfFuncionario, double novoSalario) throws FuncionarioInexistenteException {
        Funcionario f = this.funcionarios.get(cpfFuncionario);
        if (f == null) {
            throw new FuncionarioInexistenteException("Funcionário não encontrado com o CPF: " + cpfFuncionario);
        }
        f.setSalario(novoSalario);
    }
}