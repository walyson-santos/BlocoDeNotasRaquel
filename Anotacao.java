import java.time.LocalDate;

public class Anotacao {

    private String texto;
    private int id;
    private LocalDate data = LocalDate.now();
    private boolean deletar = false;

    public Anotacao(String texto, int id, LocalDate data) {
        this.texto = texto;
        this.id = id;

    }

    public Anotacao(String texto, int id) {
        this.texto = texto;
        this.id = id;
        this.deletar = false;
    }

    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDeletar() {
        return deletar;
    }

    public void setDeletar(boolean deletar) {
        this.deletar = deletar;
    }
    public void deletar (){
        this.deletar = true;
    }

    @Override
    public String toString() {
        return "Anotacao{" +
                "texto='" + texto + '\'' +
                ", id=" + id +
                ", data=" + data +
                ", deletar=" + deletar +
                '}';
    }

    public Anotacao(String texto) {
        this.texto = texto;
    }
}