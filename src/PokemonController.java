
import org.postgresql.util.PSQLException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class PokemonController {
	Scanner scanner = new Scanner(System.in);

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
							   "Categoría: " + rs.getString("categoría") + " " +
							   "Habilidad: " + rs.getString("habilidad") + " " +
							   "Peso: " + rs.getString("peso") + " " +
							   "Altura: " + rs.getString("altura") + " " +
							   "Generacion: " + rs.getString("generacion") + " " +
							   "Evoluciones: " + rs.getString("evoluciones") + " " +
							   "Tipo: " + rs.getString("tipo") + " ");
		}
		rs.close();
		st.close();
	}

	public void showTableMovementsTipo(){
		ResultSet rs = null;
		System.out.println("Inserta una de estos tipos: ");
		System.out.println("Tipo Normal");
		System.out.println("Tipo Volador");
		System.out.println("Tipo Planta");
		String tipo_movimiento = scanner.nextLine();

		String sql = "select * from movimientos WHERE tipo = '" + tipo_movimiento + "'";
		try{
			Statement st = connection.createStatement();

			rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println("------------------------------------------------" +
						"\nId_pokemon: " + rs.getInt("id_pokemon") +
						"\nNivel: " + rs.getString("nivel") +
						"\nNombre: " + rs.getString("nombre") +
						"\nTipo: " + rs.getString("tipo") +
						"\nClase: " + rs.getString("clase")
						+ "\n------------------------------------------------");
			}
			rs.close();
			st.close();

		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void showTipoWithTipos() throws SQLException, IOException {

		Statement st = connection.createStatement();
		ResultSet rs;

		rs = st.executeQuery("SELECT tipo FROM tipo");
		while (rs.next()) {
			System.out.println("Tipo: " + rs.getString("tipo") + " ");
		}
		rs.close();
		st.close();
	}

	public void createPokemon(){
		try{
			System.out.println("CREAR UN POKEMON");
			System.out.println("-------------------");

			System.out.println("ID del pokemon: ");
			int id = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Inserta su nombre: ");
			String nombre = scanner.nextLine();

			System.out.println("Inserta su categoria: ");
			String categoria = scanner.nextLine();

			System.out.println("Inserta su habilidad: ");
			String habilidad = scanner.nextLine();

			System.out.println("Inserta su peso: ");
			String peso = scanner.nextLine();

			System.out.println("Inserta su altura: ");
			String altura = scanner.nextLine();

			System.out.println("Inserta su generacion: ");
			String generacion = scanner.nextLine();

			System.out.println("Inserta su evolucion: ");
			String evoluciones = scanner.nextLine();

			System.out.println("Inserta su tipo: ");
			String tipo = scanner.nextLine();


			String sql = "INSERT INTO pokemon" + "(Id_pokemon, Nombre, Categoría, Habilidad, Peso, ALtura, Generacion, Evoluciones, Tipo" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pst = connection.prepareCall(sql);
			pst.setInt(1,id);
			pst.setString(2,nombre);
			pst.setString(3,categoria);
			pst.setString(4,habilidad);
			pst.setString(5,peso);
			pst.setString(6,altura);
			pst.setString(7,generacion);
			pst.setString(8,evoluciones);
			pst.setString(9,tipo);

			pst.executeUpdate();
			pst.close();

		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void insertInfoToPokemon() throws  SQLException, IOException, PSQLException, ArrayIndexOutOfBoundsException {
		FileReader fr = new FileReader("infoPokemon/caracteristicas_pokemon.csv");
		BufferedReader br = new BufferedReader(fr);

		String sql = "INSERT INTO pokemon (Id_pokemon, Nombre, Categoría, Habilidad, Peso, ALtura, Generacion, Evoluciones, Tipo) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pr = connection.prepareStatement(sql);
		String line;
		while ((line = br.readLine()) != null) {
			String[] data = line.split(",");
			pr.setInt(1, Integer.parseInt(data[0].replace("\"", "")));
			pr.setString(2, data[1].replace("\"", ""));
			pr.setString(3, data[3].replace("\"", ""));
			pr.setString(4, data[5].replace("\"", ""));
			pr.setString(5, data[7].replace("\"", ""));
			pr.setString(6, data[9].replace("\"", ""));
			pr.setString(7, data[11].replace("\"", ""));
			pr.setString(8, data[13].replace("\"", ""));
			pr.setString(9, data[14].replace("\"", ""));
			pr.executeUpdate();
			System.out.println(line);
		}
		br.close();
	}

	public void insertInfoToTipo() throws  SQLException, IOException, PSQLException, ArrayIndexOutOfBoundsException {
		FileReader fr = new FileReader("infoPokemon/pokemon.csv");
		BufferedReader br = new BufferedReader(fr);

		String sql = "INSERT INTO tipo (Id_pokemon, Tipo) " + "VALUES (?, ?)";
		PreparedStatement pr = connection.prepareStatement(sql);
		String line;
		while ((line = br.readLine()) != null) {
			String[] data = line.split(",");
			pr.setInt(1, Integer.parseInt(data[0].replace("\"", "")));
			pr.setString(2, data[2].replace("\"", ""));
			pr.executeUpdate();
			System.out.println(line);
		}
		br.close();
	}

	public void insertInfoToMovimientos() throws  SQLException, IOException {
		FileReader fr = new FileReader("infoPokemon/caracteristicas_pokemon.csv");
		BufferedReader br = new BufferedReader(fr);


		String sql = "INSERT INTO movimientos (Id_pokemon, Nivel, Nombre, Tipo, Clase) " + "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pr = connection.prepareStatement(sql);
		String line;
		while ((line = br.readLine()) != null) {
			String[] data = line.split(",");
			pr.setInt(1, Integer.parseInt(data[0].replace("\"", "")));
			pr.setString(2, data[21].replace("\"", ""));
			pr.setString(3, data[22].replace("\"", ""));
			pr.setString(4, data[23].replace("\"", ""));
			pr.setString(5, data[24].replace("\"", ""));
			pr.executeUpdate();
			System.out.println(line);
		}
		br.close();
	}
}
