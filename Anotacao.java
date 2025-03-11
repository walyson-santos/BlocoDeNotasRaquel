import java.time.LocalDate;
import java.util.Objects;

public class Anotacao {

    private String nota;
    private int id;
    private LocalDate data = LocalDate.now();
    private boolean deletado = false;

    public Anotacao(String nota, int id) throws Exception {
        if(nota == null || nota.trim().isEmpty()) {
            throw new Exception("Valor invalido");
        }
        this.nota = nota;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota)throws Exception {
        if(nota == null || nota.trim().isEmpty()) {
            throw new Exception("Valor invalido");
        }
    }

    public LocalDate getData() {
        return data;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }

    @Override
    public String toString() {
        return "Anotacao{" +
                "nota='" + nota + '\'' +
                ", id=" + id +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Anotacao anotacao = (Anotacao) o;
        return id == anotacao.id && Objects.equals(nota, anotacao.nota) && Objects.equals(data, anotacao.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nota, id, data);
    }
}