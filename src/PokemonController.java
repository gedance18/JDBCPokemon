
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PokemonController {

	private Connection connection;

	public PokemonController(Connection connection) {
		this.connection = connection;
	}

	public void showPokemons() throws SQLException, IOException {

		Statement st = connection.createStatement();
		ResultSet rs;

		rs = st.executeQuery("SELECT * FROM pokemon");
		while (rs.next()) {
			System.out.println("Id_Pokemon" + rs.getInt("id_pokemon") + " " +
							   "Nombre: " + rs.getString("nombre") + " " +
							   "Generacion: " + rs.getString("generacion") + " " +
							   "Tipo: " + rs.getString("tipo") + " " +
							   "Categoría: " + rs.getString("categoría") + " " +
							   "Habilidad: " + rs.getString("habilidad") + " " +
							   "Peso: " + rs.getString("peso") + " " +
							   "Altura: " + rs.getString("altura") + " " +
							   "Habitat: " + rs.getString("habitat"));
		}

		rs.close();
		st.close();
	}
}
