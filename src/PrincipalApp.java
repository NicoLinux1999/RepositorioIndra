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
    
    public static void menuOrganizadores() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n--- Menú de Gestión de Organizadores ---");
            System.out.println("1. Mostrar organizadores");
            System.out.println("2. Añadir organizador");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();  
            
            switch (opcion) {
                case 1:
                    mostrarOrganizadores();
                    break;
                case 2:
                    anadirOrganizador();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }

    
    public static void mostrarOrganizadores() {
        if (organizadores.isEmpty()) {
            System.out.println("No hay organizadores.");
        } else {
            System.out.println("Organizadores:");
            for (String organizador : organizadores.keySet()) {
                System.out.println("- " + organizador + ": " + organizadores.get(organizador));
            }
        }
    }

    
    public static void anadirOrganizador() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del organizador: ");
        String nombreOrganizador = sc.nextLine();
        System.out.print("Ingrese el evento que organiza: ");
        String evento = sc.nextLine();
        organizadores.put(nombreOrganizador, evento);
        System.out.println("Organizador '" + nombreOrganizador + "' añadido al evento '" + evento + "'.");
    }

    static {
        HashMap<String, String> evento1 = new HashMap<>();
        evento1.put("nombre", "Summer Fest");
        evento1.put("fecha", "12/06/2025");
        evento1.put("lugar", "Madrid");
        evento1.put("tipo", "Clasico");
        evento1.put("aforo", "20000");
        evento1.put("estado", "activo");
        eventos.add(evento1);
        
        HashMap<String, String> evento2 = new HashMap<>();
        evento2.put("nombre", "80's Rock");
        evento2.put("fecha", "25/07/2025");
        evento2.put("lugar", "Barcelona");
        evento2.put("tipo", "Tematico");
        evento2.put("aforo", "15000");
        evento2.put("estado", "activo");
        eventos.add(evento2);
        
        HashMap<String, String> evento3 = new HashMap<>();
        evento3.put("nombre", "Rock indie");
        evento3.put("fecha", "22/08/2025");
        evento3.put("lugar", "Galicia");
        evento3.put("tipo", "Indie");
        evento3.put("aforo", "8000");
        evento3.put("estado", "activo");
        eventos.add(evento3);
        
        HashMap<String, String> evento4 = new HashMap<>();
        evento4.put("nombre", "Future Rock");
        evento4.put("fecha", "28/04/2025");
        evento4.put("lugar", "Granada");
        evento4.put("tipo", "Tematico");
        evento4.put("aforo", "12000");
        evento4.put("estado", "activo");
        eventos.add(evento4);
        
        HashMap<String, String> evento5 = new HashMap<>();
        evento5.put("nombre", "Viva el Rock");
        evento5.put("fecha", "15/05/2025");
        evento5.put("lugar", "Madrid");
        evento5.put("tipo", "Clasico");
        evento5.put("aforo", "14000");
        evento5.put("estado", "cancelado");
        eventos.add(evento5);
    }

	
	
	
}
