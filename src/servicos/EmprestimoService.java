package servicos;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import entidades.Emprestimo;
import entidades.Livro;
import entidades.Usuario;

public class EmprestimoService {
    private UsuarioService usuarioService;
    private LivroService livroService;
    private List<Emprestimo> emprestimo;
    private int proximoCodigo = 1;

    public EmprestimoService(UsuarioService usuarioService, LivroService livroService) {
        this.usuarioService = usuarioService;
        this.livroService = livroService;
        this.emprestimo = new ArrayList<>();
    }

    public void realizarEmprestimo(int matricula, int codigo) {
        
        Optional<Usuario> usuarioOptional = usuarioService.buscarPorMatricula(matricula);

        if(!usuarioOptional.isPresent()) {
            System.out.println("Usuário não encontrado");
            return;
        } 

        Usuario usuario = usuarioOptional.get();

        Optional<Livro> livroOptional = livroService.buscarPorCodigo(codigo);

        if(!livroOptional.isPresent()) {
            System.out.println("Livro não encontrado");
            return;
        }

        Livro livro = livroOptional.get();

        if (!livro.isDisponivel()) {
            System.out.println("Livro indisponível para empréstimo");
            return;
        }

        Emprestimo emprestimo = new Emprestimo(proximoCodigo++, usuario.getMatricula(), livro.getCodigoLivro());
        this.emprestimo.add(emprestimo);

        livro.setDisponivel(false);

        emprestimo.setAtivo(true);

        System.out.println("Empréstimo realizado com sucesso!");
    }
}
