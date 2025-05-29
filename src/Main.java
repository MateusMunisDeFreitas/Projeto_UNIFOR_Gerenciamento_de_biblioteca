import DAO.EmprestimoDAO;
import View.View;

public class Main {
    public static void main(String[] args) {
        new EmprestimoDAO().devolverEmprestimo();
        new View().janelaPrincipal();
    }
}
