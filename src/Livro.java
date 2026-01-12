public class Livro {
    private int codigoLivro;
    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;
    private boolean disponivel = true;

    public Livro(int codigoLivro, String titulo, String autor, String editora, int anoPublicacao) {
        this.codigoLivro = codigoLivro;
        this.titulo = titulo;
        this.autor = autor;  
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;        
    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
