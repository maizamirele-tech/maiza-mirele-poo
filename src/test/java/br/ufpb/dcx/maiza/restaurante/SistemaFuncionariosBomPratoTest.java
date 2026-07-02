package br.ufpb.dcx.maiza.restaurante;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class SistemaFuncionariosBomPratoTest {

    @Test
    public void testaCadastroEPesquisa() {
        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();
        try {
            sistema.cadastrarFuncionario(new Funcionario("333.333.333-33", "Ayla Rebouças",
                    TipoFuncionario.GERENTE, 3000));
            assertTrue(sistema.funcionarioJaExiste("333.333.333-33"));
            Funcionario f1 = sistema.pesquisarFuncionario("333.333.333-33");

            // a) Cadastra o funcionário João Paulo Silva, cozinheiro, R$5000
            sistema.cadastrarFuncionario(new Funcionario("222.222.222-22", "João Paulo Silva",
                    TipoFuncionario.COZINHEIRO, 5000));

            // b) Pesquisa funcionários com salário > 2000 e verifica se são 2
            List<Funcionario> maioresQue2000 = sistema.pesquisarFuncionariosComSalarioMaiorQue(2000);
            assertEquals(2, maioresQue2000.size());

            // c) Conta quantos são cozinheiros e verifica se é 1
            int qtdCozinheiros = sistema.contarFuncionariosDoTipo(TipoFuncionario.COZINHEIRO);
            assertEquals(1, qtdCozinheiros);

        } catch (FuncionarioJaExisteException | FuncionarioInexistenteException e) {
            fail("Não deveria lançar exceção");
        }
    }
}