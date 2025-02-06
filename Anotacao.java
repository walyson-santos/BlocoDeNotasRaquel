import java.time.LocalDate;

public class Anotacao {

    private String nota;
    private int id;
    private LocalDate data;

    public Anotacao(String nota, int id, LocalDate data) {
        this.nota = nota;
        this.id = id;
        this.data = LocalDate.now();
    }

    public Anotacao(String nota, int id) {
        this.nota = nota;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}