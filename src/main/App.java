package main;

import dao.FuncionarioDAO;
import java.util.List;
import modelo.Funcionario;

public class App {

    public static void main(String[] args){

        FuncionarioDAO dao = new FuncionarioDAO();

//        listar
        List<Funcionario> funcionarios;
        funcionarios = dao.listar();
        System.out.println(funcionarios);

//        Cadastrar
//        Funcionario func = new Funcionario("Valentina", "Gomes Lima", "valentina@hotmail.com", "CEO", 70000.0);        
//        dao.cadastrar(func);

//        Buscar
//        Funcionario func = dao.buscarPorId(7);
//        System.out.println(func);

//          Excluir
//          Funcionario func = dao.excluirPorId(3);

//          Editar
//          Funcionario func = new Funcionario(5, "Jose", "da Silva", "jose@bol.com.br", "TECNOLOGIA", 4500.0);  
//          dao.editar(func);
          
    }

}
