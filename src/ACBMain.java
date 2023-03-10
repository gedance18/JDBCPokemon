import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public class ACBMain {

	public static void main(String[] args) throws IOException, SQLException, ParseException {
		ACBMenu menu = new ACBMenu();
		
		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection c = connectionFactory.connect();

		PokemonController pokemonController = new PokemonController(c);
		TableController tableController = new TableController(c);

		int option = menu.mainMenu();
		while (option > 0 && option < 12) {
			switch (option) {
			case 1:
				tableController.deleteTables();
				break;

			case 2:
				tableController.createTables();
				break;

			case 3:
				pokemonController.insertInfoToPokemon();
				pokemonController.insertInfoToTipo();
				pokemonController.insertInfoToMovimientos();
				break;

			case 4:
				pokemonController.showPokemons();
				break;

			case 5:
				pokemonController.showTableMovementsTipo();
				break;

			case 6:
				pokemonController.showTipoWithTipos();
				break;

			case 7:
				// dbaccessor.actualitzarTitolRevistes(conn);
				break;

			case 8:
				pokemonController.createPokemon();
				break;

			case 9:
				// dbaccessor.desassignaArticleARevista(conn);
				break;

			case 10:
				// dbaccessor.carregaAutors(conn);
				break;

			case 11:
				// dbaccessor.sortir();
				break;

			default:
				System.out.println("Introdueixi una de les opcions anteriors");
				break;

			}
			option = menu.mainMenu();
		}

	}

}
