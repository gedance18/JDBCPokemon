import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACBMenu {
	private int option;

	public ACBMenu() {
		super();
	}

	public int mainMenu() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {

			System.out.println(" \nMENU PRINCIPAL \n");

			System.out.println("1. Borrar tablas");
			System.out.println("2. Crear tablas");
			System.out.println("3. Poblar masivamente la base de datos de pokemons");
			System.out.println("4. Seleccionar todos los pokemon de la tabla pokemon");
			System.out.println("5. Seleccionar todas los pokemon de la tabla movimientos que sean de tipo normal");
			System.out.println("6. Seleccionar los tipos de pokemons de la tabla tipo");
			System.out.println("7. Seleccionar un elemento y modificarlo");
			System.out.println("8. Modificar diferentes registros de información");
			System.out.println("9. Eliminar un registro concreto de información");
			System.out.println("10. Eliminar un conjunto de registros de información que cumplan una condición");
			System.out.println("0. Salir del programa");
			System.out.println("Escoge una opcion: ");
			try {
				option = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("valor no vàlid");
				e.printStackTrace();

			}

		} while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 7
				&& option != 8 && option != 9 && option != 10);

		return option;
	}

	public Identity authenticate(int tries) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("============================ACB=============================");
		System.out.println("============================================================");
		System.out.println("Avís: tens " + (3 - tries) + " intents per loginarte");
		System.out.println("============================================================");
		System.out.println("Inserta nom del usuari: ");
		String user = br.readLine();
		System.out.println("Inserta contrasenya: ");
		String password = br.readLine();

		Identity identity = new Identity(user, password);
		return identity;

	}

}
