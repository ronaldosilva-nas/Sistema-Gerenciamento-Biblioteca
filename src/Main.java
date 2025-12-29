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
                    System.out.println("Entrou na opção 1, Administração");
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
