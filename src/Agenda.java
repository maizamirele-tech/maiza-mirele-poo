import java.io.IOException;
import java.util.Collection;

/**
 * Interface que representa uma agenda de contatos.
 */
public interface Agenda {

    /**
     * Cadastra um novo contato.
     *
     * @param nome Nome do contato
     * @param dia Dia do aniversário
     * @param mes Mês do aniversário
     * @return true se o cadastro for realizado
     */
    boolean cadastraContato(String nome, int dia, int mes);

    /**
     * Pesquisa aniversariantes de uma determinada data.
     *
     * @param dia Dia procurado
     * @param mes Mês procurado
     * @return Coleção de contatos encontrados
     */
    Collection<Contato> pesquisaAniversariantes(int dia, int mes);

    /**
     * Remove um contato da agenda.
     *
     * @param nome Nome do contato
     * @return true se removido
     * @throws ContatoInexistenteException caso o contato não exista
     */
    boolean removeContato(String nome)
            throws ContatoInexistenteException;

    /**
     * Salva os dados da agenda.
     *
     * @throws IOException erro de gravação
     */
    void salvarDados() throws IOException;

    /**
     * Recupera os dados da agenda.
     *
     * @throws IOException erro de leitura
     */
    void recuperarDados() throws IOException;
}