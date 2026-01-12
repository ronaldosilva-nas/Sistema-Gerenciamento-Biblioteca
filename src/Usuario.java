import java.time.LocalDateTime;

public class Usuario {
    private int matricula;
    private String nome;
    private String curso;
    private String telefone;
    private LocalDateTime dataCadastro;

    public Usuario(int matricula, String nome, String curso, String telefone) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.telefone = telefone;
        this.dataCadastro = LocalDateTime.now();
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
}
