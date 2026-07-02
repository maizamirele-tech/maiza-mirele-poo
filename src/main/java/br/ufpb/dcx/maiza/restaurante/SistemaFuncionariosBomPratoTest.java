package br.ufpb.dcx.maiza.restaurante;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaFuncionariosBomPratoTest {

    @Test
    public void testaCadastroEPesquisa() {
        // Correção do 's' maiúsculo
        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();

        try {
            // Correção da chamada e do Enum (GERENTE)
            // Nota: assumindo que a classe Funcionario tenha um construtor com esses parâmetros
            sistema.cadastrarFuncionario("333.333.333-33", "Ayla Rebouças", TipoFuncionario.GERENTE, 3000);

            assertTrue(sistema.funcionarioJaExiste("333.333.333-33"));

            Funcionario f1 = sistema.pesquisarFuncionario("333.333.333-33");
            assertEquals("Ayla Rebouças", f1.getNome()); // Testa se o objeto retornado está correto

        } catch (FuncionarioJaExisteException | FuncionarioInexistenteException e) {
            fail("Não deveria lançar exceção: " + e.getMessage());
        }
    }
}