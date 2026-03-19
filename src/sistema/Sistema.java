package sistema;
import java.util.Optional;
import java.util.Scanner;
import entidades.Emprestimo;
import entidades.Livro;
import entidades.Usuario;
import servicos.LivroService;
import servicos.UsuarioService;
import servicos.EmprestimoService;

public class Sistema {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        LivroService livroService = new LivroService();
        UsuarioService usuarioService = new UsuarioService();
        EmprestimoService emprestimoService = new EmprestimoService(usuarioService, livroService);
        int op = 0;
        
        //Menu principal do sistema
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

                    //Submenu de opções da administração
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
                        System.out.println("Informe a opção desejada ou digite (9) para sair.");
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

                                System.out.println("Livro cadastrado com sucesso.");

                                break;
                            case 2:
                                //Listar livros cadastrados
                                int proximoLivro = 1;
                                for (Livro l : livroService.getLivros()) {
                                    System.out.println("================ Livro - " + proximoLivro++ + " ================");
                                    System.out.println();
                                    System.out.println("Código: " + l.getCodigoLivro()); 
                                    System.out.println("Título: " + l.getTitulo()); 
                                    System.out.println("Autor: " + l.getAutor());
                                    System.out.println("Ano de publicação: " + l.getAnoPublicacao());
                                    System.out.println();
                                    System.out.println("=========================================================");
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

                                System.out.println("Usuário cadastrado com sucesso. " + "data: " + usuario.getDataCadastro());

                                break;
                            case 4: 
                                //Listar usuários cadastrados
                                int proximoUsuario = 1;

                                for (Usuario l : usuarioService.getUsuarios()) {
                                    System.out.println("================ Usuário - " + proximoUsuario++ + " ================");
                                    System.out.println();
                                    System.out.println("Matrícula: " + l.getMatricula()); 
                                    System.out.println("Nome: " + l.getNome()); 
                                    System.out.println("Curso: " + l.getCurso());
                                    System.out.println("Telefone: " + l.getTelefone());
                                    System.out.println("Data de cadastro: " + l.getDataCadastro());
                                    System.out.println();
                                    System.out.println("=========================================================");
                                }                   
                                break;    
                            case 5: 
                                //Buscar usuário 
                                System.out.println("Para buscar usuário, informe a matrícula: ");
                                int buscarMatricula = scan.nextInt();
                                scan.nextLine();

                                Optional<Usuario> usuarioOptional = usuarioService.buscarPorMatricula(buscarMatricula);

                                if(usuarioOptional.isPresent()) {
                                    System.out.println("================ Usuário encontrado ================");
                                    System.out.println();
                                    System.out.println("Nome: " + usuarioOptional.get().getNome());
                                    System.out.println("Curso: " + usuarioOptional.get().getCurso());
                                    System.out.println("Telefone: " + usuarioOptional.get().getTelefone());
                                    System.out.println("Data de cadastro: " + usuarioOptional.get().getDataCadastro());
                                    System.out.println();
                                    System.out.println("=========================================================");
                                }
                                else {
                                    System.out.println("Usuário não encontrado.");
                                }

                                break;
                            case 6: 
                                //Listar empréstimos
                                if(emprestimoService.getEmprestimo().isEmpty()){
                                    System.out.println("Nenhum empréstimo realizado.");
                                }
                                else {
                                    int proximoEmprestimo = 1;
                                    for (Emprestimo e : emprestimoService.getEmprestimo()) {
                                        System.out.println("================ Empréstimo - " + proximoEmprestimo++ + " ================");
                                        System.out.println();
                                        System.out.println("Código de empréstimo: " + e.getCodigoEmprestimo());
                                        System.out.println("Código do livro: " + e.getCodigoLivro()); 
                                        System.out.println("Matrícula do usuário: " + e.getMatriculaUsuario());
                                        System.out.println("Data do empréstimo: " + e.getDataEmprestimo());
                                        System.out.println("Data de devolução: " + e.getDevolucaoPrevista());

                                        if(!e.isAtivo()) {
                                            System.out.println("Status: livro devolvido.");
                                        } 
                                        else {
                                            System.out.println("Status: empréstimo em andamento.");
                                        }
                                        System.out.println();
                                        System.out.println("=========================================================");
                                    }    
                                }       
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

                    //Submenu para opções de usuários
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
                                //Realizar empréstimos
                                System.out.println("Informe a matrícula do usuário:");
                                int matriculaUsuario = scan.nextInt();
                                scan.nextLine();

                                System.out.println("Informe o código do livro:");
                                int codigoLivro = scan.nextInt();
                                scan.nextLine();

                                emprestimoService.realizarEmprestimo(matriculaUsuario, codigoLivro);

                                break;
                            case 2:
                                //Realizar devolução
                                System.out.println("Informe o código do empréstimo:");
                                int codigoEmprestimo = scan.nextInt();
                                scan.nextLine();

                                emprestimoService.realizarDevolucao(codigoEmprestimo);

                                break;
                            case 3:
                                //Buscar livro
                                System.out.println("Para buscar livro, informe o código: ");
                                int buscarCodigo = scan.nextInt();
                                scan.nextLine();

                                Optional<Livro> livroOptional = livroService.buscarPorCodigo(buscarCodigo);

                                if(livroOptional.isPresent()) {
                                    System.out.println("================ Livro encontrado ================");
                                    System.out.println();
                                    System.out.println("Livro encontrado!");
                                    System.out.println("Título: " + livroOptional.get().getTitulo());
                                    System.out.println("Autor: " + livroOptional.get().getAutor());
                                    System.out.println("Editora: " + livroOptional.get().getEditora());
                                    System.out.println("Ano de publicação: " + livroOptional.get().getAnoPublicacao());
                                    System.out.println();
                                    System.out.println("=========================================================");
                                }
                                else {
                                    System.out.println("Livro não encontrado.");
                                }

                                break;
                            case 4:
                                //Renovar empréstimo
                                System.out.println("Informe o código do empréstimo:");
                                int codigoRenovarEmprestimo = scan.nextInt();
                                scan.nextLine();

                                System.out.println("Informe a quantidade de dias para renovação, limite máximo de 7 dias:");
                                int dias = scan.nextInt();
                                scan.nextLine();

                                if(dias > 0 && dias <= 7) {
                                    emprestimoService.renovarEmprestimo(codigoRenovarEmprestimo, dias);
                                }
                                else {
                                    System.out.println("Quantidade de dias não permitido, tente novamente.");
                                }

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