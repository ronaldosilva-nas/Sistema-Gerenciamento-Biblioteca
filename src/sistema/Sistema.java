package sistema;
import java.util.Optional;
import java.util.Scanner;
import entidades.Livro;
import entidades.Usuario;
import servicos.LivroService;
import servicos.UsuarioService;

public class Sistema {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        LivroService livroService = new LivroService();
        UsuarioService usuarioService = new UsuarioService();
        int op = 0;
        
        // Menu principal do sistema
        do {
            System.out.println("BEM VINDO AO SISTEMA DE GERENCIAMENTO DE BIBLIOTECA");
            System.out.println("================ Menu Principal ================");
            System.out.println("1 - Administração");
            System.out.println("2 - Usuário");
            System.out.println("3 - Encerrar");
            System.out.println("Informe a opção desejada ou digite (3) para encerrar");
            op = scan.nextInt();

            switch (op) {
                case 1:
                    
                int opAdmin = 0;

                    // Submenu de opções da administração
                    do {
                        System.out.println("================ Menu administração ================");
                        System.out.println("1 - Cadastrar livro");
                        System.out.println("2 - Listar livros");
                        System.out.println("3 - Cadastrar usuário");
                        System.out.println("4 - Listar usuarios");
                        System.out.println("5 - Pesquisar usuário");
                        System.out.println("6 - Listar empréstimos");
                        System.out.println("7 - Relatórios");
                        System.out.println("8 - Busca avançada");
                        System.out.println("9 - Sair");
                        System.out.println("Informe a opção desejada ou digite (9) para sair");
                        opAdmin = scan.nextInt();

                        switch(opAdmin) {
                            case 1:
                                //Obter dados de usuário para cadastrar livro
                                System.out.println("Código do livro: ");
                                int codigo = scan.nextInt();
                                scan.nextLine();

                                System.out.println("Titulo: ");
                                String titulo = scan.nextLine();

                                System.out.println("Autor: ");
                                String autor = scan.nextLine();

                                System.out.println("Editora: ");
                                String editora = scan.nextLine();

                                System.out.println("Ano publicação: ");
                                int ano = scan.nextInt();

                                Livro livro = new Livro(codigo, titulo, autor, editora, ano);

                                livroService.cadastrarLivro(livro);

                                System.out.println("Livro cadastrado com sucesso!");

                                break;
                            case 2:
                                //Listar livros cadastrados
                                for (Livro l : livroService.getLivros()) {
                                    System.out.println("Código: " + l.getCodigoLivro() + " - " + 
                                                       "Título: " + l.getTitulo() + " - " + 
                                                       "Autor: " + l.getAutor() + " - " +
                                                       "Ano de publicação: " + l.getAnoPublicacao());
                                }
                                break;
                            case 3:
                                //Obter dados para cadastrar usuário
                                System.out.println("Informe a matrícula do usuário: ");
                                int matricula = scan.nextInt();
                                scan.nextLine();

                                System.out.println("Informe o nome do usuário: ");
                                String nome = scan.nextLine();

                                System.out.println("Informe o curso: ");
                                String curso = scan.nextLine();

                                System.out.println("Informe o número de telefone: ");
                                String telefone = scan.nextLine();

                                Usuario usuario = new Usuario(matricula, nome, curso, telefone);

                                usuarioService.cadastrarUsuario(usuario);

                                System.out.println("Usuário cadastrado com sucesso! " + "data: " + usuario.getDataCadastro());

                                break;
                            case 4: 
                                //Listar usuários cadastrados
                                for (Usuario l : usuarioService.getUsuarios()) {
                                    System.out.println("Matrícula: " + l.getMatricula() + " - " + 
                                                       "Nome: " + l.getNome() + " - " + 
                                                       "Curso: " + l.getCurso() + " - " +
                                                       "Telefone: " + l.getTelefone() + " - " +
                                                       "Data de cadastro: " + l.getDataCadastro());
                                }                   
                                break;    
                            case 5: 
                                //Buscar usuário 
                                System.out.println("Para buscar usuário, informe a matrícula: ");
                                int buscarMatricula = scan.nextInt();
                                scan.nextLine();

                                Optional<Usuario> usuarioOptional = usuarioService.buscarPorMatricula(buscarMatricula);

                                if(usuarioOptional.isPresent()) {
                                    System.out.println("Usuário encontrado!");
                                    System.out.println("Nome: " + usuarioOptional.get().getNome() + " - " +
                                                       "Curso: " + usuarioOptional.get().getCurso() + " - " +
                                                       "Telefone: " + usuarioOptional.get().getTelefone() + " - " +
                                                       "Data de cadastro: " + usuarioOptional.get().getDataCadastro());

                                }
                                else {
                                    System.out.println("Usuário não encontrado!");
                                }

                                break;
                            case 6: 
                                System.out.println("Listando empréstimos");
                                break;
                            case 7: 
                                System.out.println("Exibindo relatório");
                                break;
                            case 8: 
                                System.out.println("Realizando busca avançada");
                                break;                    
                        }

                    }
                    while(opAdmin != 9);
                    break;

                case 2:
                    int opUsuario = 0;

                    // Submenu para opções de usuários
                    do {
                        
                        System.out.println("================ Menu usuário ================");
                        System.out.println("1 - Realizar empréstimo");
                        System.out.println("2 - Realizar devolução");
                        System.out.println("3 - Buscar livros");
                        System.out.println("4 - Renovar empréstimo");
                        System.out.println("5 - Busca avançada");
                        System.out.println("6 - Sair");
                        System.out.println("Informe a opção desejada ou digite (6) para sair");
                        opUsuario = scan.nextInt();

                        switch(opUsuario) {
                            case 1:
                                System.out.println("Empréstismo realizado");
                                break;
                            case 2:
                                System.out.println("Devolução realizada");
                                break;
                            case 3:
                                //Bucar livro
                                System.out.println("Para buscar livro, informe o código: ");
                                int buscarCodigo = scan.nextInt();
                                scan.nextLine();

                                Optional<Livro> livroOptional = livroService.buscarPorCodigo(buscarCodigo);

                                if(livroOptional.isPresent()) {
                                    System.out.println("Livro encontrado!");
                                    System.out.println("Título: " + livroOptional.get().getTitulo() + " - " +
                                                       "Autor: " + livroOptional.get().getAutor() + " - " +
                                                       "Editora: " + livroOptional.get().getEditora() + " - " +
                                                       "Ano de publicação: " + livroOptional.get().getAnoPublicacao()); 
                                }
                                else {
                                    System.out.println("Livro não encontrado!");
                                }

                                break;
                            case 4:
                                System.out.println("Empréstimo renovado");
                                break;
                            case 5:
                                System.out.println("Executando busca avançada");
                                break;                
                        }
                    } while (opUsuario != 6);
                    break; 
            }
        } 
        while (op != 3); 
        scan.close();  
    }
}