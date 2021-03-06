package dao;

import conexao.FabricaConexaoPadrao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Funcionario;

public class FuncionarioDAO {

    private Connection conectar;

    public List<Funcionario> listar() {
        conectar = FabricaConexaoPadrao.getConnection();
        List<Funcionario> funcionarios = new ArrayList();

        String sql = "select * from employees";
        try {
            Statement stm = conectar.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setId(rs.getInt("id"));
                func.setFirstName(rs.getString("first_name"));
                func.setLastName(rs.getString("last_name"));
                func.setDepartamento(rs.getString("department"));
                func.setSalario(rs.getDouble("salary"));
                func.setEmail(rs.getString("email"));
                funcionarios.add(func);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    public void cadastrar(Funcionario funcionario) {
        conectar = FabricaConexaoPadrao.getConnection();
        try {
            String sql = "insert into employees (first_name, last_name, email, department, salary)"
                    + " values (?, ?, ?, ?, ?)";
            PreparedStatement pstm = conectar.prepareStatement(sql);
            pstm.setString(1, funcionario.getFirstName());
            pstm.setString(2, funcionario.getLastName());
            pstm.setString(3, funcionario.getEmail());
            pstm.setString(4, funcionario.getDepartamento());
            pstm.setDouble(5, funcionario.getSalario());

            int linhaAfetada = pstm.executeUpdate();
            if (linhaAfetada != 1) {
                System.out.println("Erro ao cadastrar funcionario!");
            } else {
                System.out.println("Funcionario Cadastrado com sucesso!");
            }

            pstm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Funcionario buscarPorId(int id) {
        conectar = FabricaConexaoPadrao.getConnection();
        Funcionario func = new Funcionario();
        String sql = "select * from employees where id = ?";

        try {
            PreparedStatement pstm = conectar.prepareStatement(sql);
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                func.setId(rs.getInt("id"));
                func.setFirstName(rs.getString("first_name"));
                func.setLastName(rs.getString("last_name"));
                func.setEmail(rs.getString("email"));
                func.setSalario(rs.getDouble("salary"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return func;
    }

    public Funcionario excluirPorId(int id) {
        conectar = FabricaConexaoPadrao.getConnection();
        String sql = "delete from employees where id = ?";

        try {
            PreparedStatement pstm = conectar.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.execute();
            System.out.println("Funcionario id:" + id + " ecluido com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(Funcionario func) {
        conectar = FabricaConexaoPadrao.getConnection();
        String sql = "update employees set first_name = ?, "
                + "last_name = ?, email = ?,  "
                + "department = ?, salary = ? where id = ?";
        try {
            PreparedStatement pstm = conectar.prepareStatement(sql);
            pstm.setString(1, func.getFirstName());
            pstm.setString(2, func.getLastName());
            pstm.setString(3, func.getEmail());
            pstm.setString(4, func.getDepartamento());
            pstm.setDouble(5, func.getSalario());
            pstm.setInt(6, func.getId());
            pstm.executeUpdate();
            System.out.println("Funcionario alterado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

}
