package servicos;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;
import java.util.HashMap;

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

    public List<Emprestimo> getEmprestimo() { 
        return emprestimo;
    }

    public void realizarEmprestimo(int matricula, int codigo) {
        
        Optional<Usuario> usuarioOptional = usuarioService.buscarPorMatricula(matricula);

        if(!usuarioOptional.isPresent()) {
            System.out.println("Usuário não encontrado.");
            return;
        } 

        Usuario usuario = usuarioOptional.get();

        Optional<Livro> livroOptional = livroService.buscarPorCodigo(codigo);

        if(!livroOptional.isPresent()) {
            System.out.println("Livro não encontrado.");
            return;
        }

        Livro livro = livroOptional.get();

        if (!livro.isDisponivel()) {
            System.out.println("Livro indisponível para empréstimo.");
            return;
        }

        Emprestimo emprestimo = new Emprestimo(proximoCodigo++, usuario.getMatricula(), livro.getCodigoLivro());
        this.emprestimo.add(emprestimo);

        livro.setDisponivel(false);

        emprestimo.setAtivo(true);

        System.out.println("Empréstimo realizado com sucesso.");
    }

    public void realizarDevolucao(int codigoEmprestimo) {

        for (Emprestimo e : emprestimo) {

            if (e.getCodigoEmprestimo() == codigoEmprestimo) {

                if (!e.isAtivo()) {
                    System.out.println("Esse empréstimo já foi finalizado.");
                    return;
                }

                e.setAtivo(false);

                Optional<Livro> livroOptional = livroService.buscarPorCodigo(e.getCodigoLivro());

                if (livroOptional.isPresent()) {
                    livroOptional.get().setDisponivel(true);
                }

                System.out.println("Devolução realizada com sucesso.");
                return;
            }
        }

        System.out.println("Empréstimo não encontrado.");
    }

    public void renovarEmprestimo(int codigoEmprestimo, int dias) {
        
        if (emprestimo.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }

        for (Emprestimo e : emprestimo) {
            
            if(e.getCodigoEmprestimo() == codigoEmprestimo) {

                if(!e.isAtivo()) {
                    System.out.println("Esse empréstimo já foi devolvido. Não pode ser renovado.");
                    return;
                }
                
                e.renovar(dias);

                System.out.println("Empréstimo renovado com sucesso.");
                return;
            }
        }

        System.out.println("Empréstimo não encontrado.");
    }

    public void relatorioLivroMaisEmprestado() {

        if(livroService.getLivros().isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        if(emprestimo.isEmpty()) {
            System.out.println("Nenhum empréstimo realizado.");
            return;
        }

        Map<Integer, Integer> contador = new HashMap<>();

        for (Emprestimo e : emprestimo) {
            int codigo = e.getCodigoLivro();
            contador.put(codigo, contador.getOrDefault(codigo, 0) + 1);
        }

        int maiorQuantidade = 0;
        int codigoMaisEmprestado = -1;

        for(Map.Entry<Integer, Integer> entry : contador.entrySet()) {
            if(entry.getValue() > maiorQuantidade) {
                maiorQuantidade = entry.getValue();
                codigoMaisEmprestado = entry.getKey();
            }
        }

        Optional<Livro> livro = livroService.buscarPorCodigo(codigoMaisEmprestado);

        if(livro.isPresent()) {
            System.out.println("============== Livro mais emprestado ==============");
            System.out.println();
            System.out.println("Título: " + livro.get().getTitulo());
            System.out.println("Autor: " + livro.get().getAutor());
            System.out.println("Total de empréstimos: " + maiorQuantidade);
            System.out.println();
            System.out.println("===================================================");
        }
        else {
            System.out.println("Nenhum livro encontrado.");
        }    
    }
}
