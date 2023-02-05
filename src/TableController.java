import org.postgresql.util.PSQLException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TableController {

    private Connection connection;

    public TableController(Connection connection){
        this.connection = connection;
    }

    public void altaPokemon() throws SQLException, IOException {

        Scanner reader = new Scanner(System.in);
        System.out.println("Introduce el id del pokemon");
        int id = reader.nextInt();
        System.out.println("Introduce el nombre");
        reader.nextLine();
        String nombre = reader.nextLine();
        System.out.println("Introduce la generacion");
        String generacion = reader.nextLine();
        System.out.println("Introduce el tipo");
        String tipo = reader.nextLine();
        System.out.println("Introduce la categoría");
        String categoria = reader.nextLine();
        System.out.println("Introduce la habilidad");
        String habilidad = reader.nextLine();
        System.out.println("Introduce el peso");
        int peso = reader.nextInt();
        System.out.println("Introduce la altura");
        reader.nextLine();
        int altura = reader.nextInt();
        reader.nextLine();
        System.out.println("Introduce el habitat");
        String habitat = reader.nextLine();

    }

    public void insertInfo() throws  SQLException, IOException {

    }

    public void deleteTables() throws SQLException, IOException, PSQLException {
        String createTableSQL = "DROP TABLE Users";
        PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL);
        preparedStatement.executeUpdate();

    }

    public void createTables() throws SQLException, IOException, PSQLException {
        String createTableSQL = "CREATE TABLE Users (id INT PRIMARY KEY, name VARCHAR(255), age INT)";

        PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL);

        // execute create SQL statement
        preparedStatement.executeUpdate();
        System.out.println("Tablas creadas");

    }
}
