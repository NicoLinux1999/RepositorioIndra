import java.util.*;

public class PrincipalApp {
	
	static ArrayList<HashMap<String, String>> eventos = new ArrayList<>();
	static ArrayList<String> usuarios = new ArrayList<>();
	static HashMap<String, String> organizadores = new HashMap<>();
		
	public static void main (String [] args) {
		
		System.out.println("Bienvenido a la aplicación de Rockeventos");
		
		Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();  
            
            switch (opcion) {
                case 1:
                    menuEventos();
                    break;
                case 2:
                    menuUsuarios();
                    break;
                case 3:
                    menuOrganizadores();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
		
	}
	
	public static void mostrarMenu() {
        System.out.println("Gestión de Eventos");
        System.out.println("1. Gestionar eventos");
        System.out.println("2. Gestionar usuarios");
        System.out.println("3. Gestionar organizadores");
        System.out.println("4. Salir");
    }
	
	public static void menuEventos() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n--- Menú de Gestión ---");
            System.out.println("1. Mostrar eventos");
            System.out.println("2. Crear evento");
            System.out.println("3. Cancelar evento");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();  
            
            switch (opcion) {
                case 1:
                    mostrarEventos();
                    break;
                case 2:
                    crearEvento();
                    break;
                case 3:
                    cancelarEvento();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }
	
	public static void mostrarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos.");
        } else {
            System.out.println("Eventos:");
            for (HashMap<String, String> evento : eventos) {
                System.out.println("Evento: " + evento.get("nombre"));
                System.out.println("Fecha: " + evento.get("fecha"));
                System.out.println("Lugar: " + evento.get("lugar"));
                System.out.println("Tipo: " + evento.get("tipo"));
                System.out.println("Aforo máximo: " + evento.get("aforo"));
                System.out.println("Estado: " + evento.get("estado"));
                System.out.println();
            }
        }
    }

    
    public static void crearEvento() {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> evento = new HashMap<>();

        System.out.print("Ingrese el nombre del evento: ");
        evento.put("nombre", sc.nextLine());

        System.out.print("Ingrese la fecha del evento (dd/mm/yyyy): ");
        evento.put("fecha", sc.nextLine());

        System.out.print("Ingrese el lugar del evento: ");
        evento.put("lugar", sc.nextLine());

        System.out.print("Ingrese el tipo de evento (conferencia, taller, etc.): ");
        evento.put("tipo", sc.nextLine());

        System.out.print("Ingrese el aforo máximo: ");
        evento.put("aforo", sc.nextLine());

        System.out.print("Ingrese el estado del evento (activo, cancelado, etc.): ");
        evento.put("estado", sc.nextLine());

        eventos.add(evento);
        System.out.println("Evento '" + evento.get("nombre") + "' creado con éxito.");
    }

    
    private static void cancelarEvento() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del evento a cancelar: ");
        String nombreEvento = sc.nextLine();
        
        boolean encontrado = false;
        for (HashMap<String, String> evento : eventos) {
            if (evento.get("nombre").equalsIgnoreCase(nombreEvento)) {
                evento.put("estado", "cancelado");
                System.out.println("Evento '" + nombreEvento + "' cancelado.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Evento no encontrado.");
        }
    }
    
    public static void menuUsuarios() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n--- Menú de Gestión de Usuarios ---");
            System.out.println("1. Mostrar usuarios");
            System.out.println("2. Inscribir usuario");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();  
            
            switch (opcion) {
                case 1:
                    mostrarUsuarios();
                    break;
                case 2:
                    inscribirUsuario();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }

    
    public static void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios inscritos.");
        } else {
            System.out.println("Usuarios:");
            for (String usuario : usuarios) {
                System.out.println("- " + usuario);
            }
        }
    }

    
    public static void inscribirUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del usuario a inscribir: ");
        String usuario = sc.nextLine();
        usuarios.add(usuario);
        System.out.println("Usuario '" + usuario + "' inscrito.");
    }

	
	
	
}
