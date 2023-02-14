import org.postgresql.util.PSQLException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class TableController {
    private Connection connection;

    public TableController(Connection connection){
        this.connection = connection;
    }
    public void deleteTables() throws SQLException, IOException, PSQLException {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Movimientos");
            statement.executeUpdate("DROP TABLE Tipo");
        statement.executeUpdate("DROP TABLE Pokemon");
            statement.close();
    }

    public void createTables() throws SQLException, IOException, PSQLException {
        Statement st = connection.createStatement();
        st.executeUpdate("CREATE TABLE Pokemon (Id_pokemon INT, Nombre VARCHAR(4000), Categoría VARCHAR(4000), Habilidad VARCHAR(4000), Peso VARCHAR(4000), Altura VARCHAR(4000), Generacion VARCHAR(4000), Evoluciones VARCHAR(4000), Tipo VARCHAR(4000));");
        st.executeUpdate("CREATE TABLE Tipo (Id_pokemon INT, Tipo VARCHAR(4000));");
        st.executeUpdate("CREATE TABLE Movimientos (Id_pokemon INT, Nivel VARCHAR(4000), Nombre VARCHAR(4000), Tipo VARCHAR(4000), Clase VARCHAR(4000));");

        System.out.println("Tablas creadas");

    }
}
