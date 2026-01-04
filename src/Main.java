import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
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
                        System.out.println("2 - Cadastrar usuário");
                        System.out.println("3 - Pesquisar usuário");
                        System.out.println("4 - Listar empréstimos");
                        System.out.println("5 - Relatórios");
                        System.out.println("6 - Busca avançada");
                        System.out.println("7 - Sair");
                        System.out.println("Informe a opção desejada ou digite (7) para sair");
                        opAdmin = scan.nextInt();

                        switch(opAdmin) {
                            case 1:
                                System.out.println("Livro cadastrado");
                                break;
                            case 2:
                                System.out.println("Usuário cadastrado");
                                break;
                            case 3: 
                                System.out.println("Pesquisando usuário");
                                break;
                            case 4: 
                                System.out.println("Listando empréstimos");
                                break;
                            case 5: 
                                System.out.println("Exibindo relatório");
                                break;
                            case 6: 
                                System.out.println("Realizando busca avançada");
                                break;                    
                        }

                    }
                    while(opAdmin != 7);


                    break;

                case 2:
                    System.out.println("Entrou na opção 2, Usuário");
                    break; 
            }
        } 
        while (op != 3); 
        scan.close();  
    }
}
