import java.time.LocalDate;
import java.time.LocalDateTime;

public class Emprestimo {
    private int codigoEmprestimo;
    private int matriculaUsuario;
    private int codigoLivro;
    private LocalDateTime dataEmprestimo;
    private LocalDate devolucaoPrevista;
    private boolean ativo = true;

    public Emprestimo(int codigoEmprestimo, int matriculaUsuario, int codigoLivro) {
        this.codigoEmprestimo = codigoEmprestimo;
        this.matriculaUsuario = matriculaUsuario;
        this.codigoLivro = codigoLivro;
        this.dataEmprestimo = LocalDateTime.now();
        this.devolucaoPrevista = LocalDate.now().plusDays(7);
    }

    public int getCodigoEmprestimo() {
        return codigoEmprestimo;
    }

    public int getMatriculaUsuario() {
        return matriculaUsuario;
    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDevolucaoPrevista() {
        return devolucaoPrevista;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}