import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;

public class AgendaMapTest {

    @Test
    public void testaCadastroContato() {

        AgendaMap agenda = new AgendaMap();

        assertTrue(
                agenda.cadastraContato(
                        "Ayla",
                        15,
                        5));
    }

    @Test
    public void testaPesquisaAniversariantes() {

        AgendaMap agenda = new AgendaMap();

        agenda.cadastraContato(
                "Ayla",
                15,
                5);

        Collection<Contato> lista =
                agenda.pesquisaAniversariantes(
                        15,
                        5);

        assertEquals(1, lista.size());
    }

    @Test
    public void testaRemocaoContato()
            throws ContatoInexistenteException {

        AgendaMap agenda = new AgendaMap();

        agenda.cadastraContato(
                "Ayla",
                15,
                5);

        assertTrue(
                agenda.removeContato("Ayla"));
    }
}