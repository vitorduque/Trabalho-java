import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Funcionarios {

    public void createTable() {
        try (Statement statement = BancoDeDados.connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Funcionario(ID INTEGER PRIMARY KAY , nome VARCHAR,Telefone,Data VARCHAR");
            BancoDeDados.connection.commit();
            System.out.println("Tabela criada ou já existe.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }


    public void inserirFuncionario(List<String[]> lista) {
        try (PreparedStatement insertStatement = BancoDeDados.connection.prepareStatement("INSERT INTO Funcionario(Nome,Telefone,Data) VALUES(?,?,?)")) {

            for (String[] s : lista) {
                insertStatement.setString(1, s[0]);
                insertStatement.setString(2, s[1]);
                insertStatement.setString(3, s[2]);
                insertStatement.executeUpdate();
            }
            BancoDeDados.connection.commit();
            System.out.println("Funcionario inserido.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Funcionario: " + e.getMessage());
        }
    }

    public void lerFuncionario(String nomeQuery) {
        try (PreparedStatement selectStatement = BancoDeDados.connection.prepareStatement("SELECT * FROM Funcionario... //Insira seu código aqui ")) {

            selectStatement.setString(1, nomeQuery);
            ResultSet resultSet = selectStatement.executeQuery();
            System.out.println("Professor");
            String telefone = resultSet.getString("Telefone");
            String nome = resultSet.getString("Nome");
            String data = resultSet.getString("Data");
            System.out.println("Nome: " + nome + ", Telefone: "+ telefone + " , Data: "+ data);

        } catch (SQLException e) {
            System.out.println("Erro ao consultar Funcionario: " + e.getMessage());
        }
    }

    public void deleteFuncionario(String nome) {
        try (PreparedStatement deleteStatement = BancoDeDados.connection.prepareStatement("DELETE FROM Funcionario... //Insira seu código aqui")) {
            deleteStatement.setString(1, nome);
            deleteStatement.executeUpdate();
            BancoDeDados.connection.commit();
            System.out.println("Funcionario deletado.");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Funcionario: " + e.getMessage());
        }
    }
}
