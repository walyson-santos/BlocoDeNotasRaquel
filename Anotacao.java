import java.time.LocalDate;
import java.util.Objects;

public class Anotacao {
    private String texto;
    private int id;
    private LocalDate data = LocalDate.now();
    private boolean deletado = false;

    public Anotacao(int id, String texto) throws Exception
    {
        this.id = id;
        if(texto == null || texto.trim().isEmpty())
        {
            throw new Exception("Anotação vazia");
        }
        else {
            this.texto = texto;
        }
    }

    public String getTexto() {
        return texto;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setTexto(String texto) throws Exception {
        if(texto == null || texto.trim().isEmpty())
        {
            throw new Exception("Anotação vazia");
        }
        this.texto = texto;
    }

    public boolean getDeletado() {
        return deletado;
    }

    public void setDeletado() {
        this.deletado = true;
    }

    public boolean contemTexto(String texto) {
        return this.texto.contains(texto);
    }

    @Override
    public String toString() {
        return "Anotacao{" +
                "texto='" + texto + '\'' +
                ", id=" + id +
                ", data=" + data +
                ", deletado=" + deletado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anotacao anotacao = (Anotacao) o;
        return id == anotacao.id && deletado == anotacao.deletado && Objects.equals(texto, anotacao.texto) && Objects.equals(data, anotacao.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(texto, id, data, deletado);
    }
}