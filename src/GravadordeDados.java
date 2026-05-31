import java.io.*;
import java.util.Map;

public class GravadorDeDados {

    private String arquivo = "agenda.dat";

    public void gravarDados(Map<String, Contato> contatos)
            throws IOException {

        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream(arquivo));

        out.writeObject(contatos);
        out.close();
    }

    @SuppressWarnings("unchecked")
    public Map<String, Contato> recuperarDados()
            throws IOException {

        try {
            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(arquivo));

            Map<String, Contato> contatos =
                    (Map<String, Contato>) in.readObject();

            in.close();
            return contatos;

        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }
}