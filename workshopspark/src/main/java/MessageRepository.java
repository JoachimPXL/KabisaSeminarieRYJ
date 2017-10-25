import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MessageRepository {

//TODO: database connectie.

    public Account create(String username, String password) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO account (name, password) VALUES (?, ?)")) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            return new Account(resultSet.getInt(1), username, password);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public Account get(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, password FROM account WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
                return new Account(id, resultSet.getString("name"), resultSet.getString("password"));

            return null;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public Account update(int id, String username, String password) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE account SET name = ?, password = ? WHERE id = ?")) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();

            return new Account(id, username, password);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
