import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Produtos {

    public void createTable() {
        try (Statement statement = BancoDeDados.connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Produto (ID INTEGER PRIMARY KEY, Nome VARCHAR,Valor INTEGER,Quantidade INTEGER");
            BancoDeDados.connection.commit();
            System.out.println("Tabela criada ou já existe.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }


    public void inserirProdutos(List<String[]> lista) {
        try (PreparedStatement insertStatement = BancoDeDados.connection.prepareStatement("INSERT INTO Produto(Nome,Valor,Quantidade)VALUES(?,?,?)")) {
            for (String[] s : lista) {
                insertStatement.setString(1, s[0]);
                insertStatement.setInt(2, Integer.parseInt(s[1]));
                insertStatement.setString(3, s[2]);
                insertStatement.executeUpdate();
            }
            BancoDeDados.connection.commit();
            System.out.println("Produto inseridos.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Produto: " + e.getMessage());
        }
    }



    public void lerProduto(String nomeQuery) {
        try (PreparedStatement selectStatement = BancoDeDados.connection.prepareStatement("SELECT * FROM Produto")) {
            selectStatement.setString(1, nomeQuery);
            ResultSet resultSet = selectStatement.executeQuery();
            System.out.println("Produto");
            int idade = resultSet.getInt("Quantidade");
            String nome = resultSet.getString("Nome");
            String valor= resultSet.getString("Valor");
            System.out.println("Nome: " + nome + ", Quantidade: "+ idade+ ", Valor: "+ valor);

        } catch (SQLException e) {
            System.out.println("Erro ao consultar produto: " + e.getMessage());
        }
    }

    public void deleteProduto(String nome) {
        try (PreparedStatement deleteStatement = BancoDeDados.connection.prepareStatement("DELETE FROM Produto... //Insira seu código aqui")) {
            deleteStatement.setString(1, nome);
            deleteStatement.executeUpdate();
            BancoDeDados.connection.commit();
            System.out.println("Produto deletado.");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar produtos: " + e.getMessage());
        }
    }
}
