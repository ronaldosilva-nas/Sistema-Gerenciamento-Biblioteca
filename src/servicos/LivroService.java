package servicos;
import java.util.List;
import java.util.Optional;

import entidades.Livro;
import java.util.ArrayList;

public class LivroService {
    private List<Livro> livros;

    public LivroService() {
        this.livros = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public Optional<Livro> buscarPorCodigo(int codigo) {
        for(Livro l : livros) {
            if(l.getCodigoLivro() == codigo) {
                return Optional.of(l);
            }
        }
        return Optional.empty();
    }
}