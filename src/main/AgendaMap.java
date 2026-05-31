import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AgendaMap implements Agenda {

    private Map<String, Contato> contatos;
    private GravadorDeDados gravador;

    public AgendaMap() {
        contatos = new HashMap<>();
        gravador = new GravadorDeDados();
    }

    @Override
    public boolean cadastraContato(String nome, int dia, int mes) {

        contatos.put(nome,
                new Contato(nome, dia, mes));

        return true;
    }

    @Override
    public Collection<Contato> pesquisaAniversariantes(
            int dia, int mes) {

        Collection<Contato> encontrados =
                new ArrayList<>();

        for (Contato c : contatos.values()) {
            if (c.getDia() == dia &&
                    c.getMes() == mes) {

                encontrados.add(c);
            }
        }

        return encontrados;
    }

    @Override
    public boolean removeContato(String nome)
            throws ContatoInexistenteException {

        if (!contatos.containsKey(nome)) {
            throw new ContatoInexistenteException(
                    "Contato não encontrado.");
        }

        contatos.remove(nome);
        return true;
    }

    @Override
    public void salvarDados() throws IOException {
        gravador.gravarDados(contatos);
    }

    @Override
    public void recuperarDados() throws IOException {
        contatos = gravador.recuperarDados();
    }
}