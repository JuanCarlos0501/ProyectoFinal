import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class sueldoEmpleados {
    public static void main(String[] args) throws IOException {
        Scanner sn = new Scanner(System.in); //Es para obtener lo que el usuario escribe
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        String dni;
        final ArrayList<Empleado> empleados = new ArrayList();
        
        empleados.add(new Empleado("75963258","Juan Carlos","Galvez Paredes", 27, 1235.5, "Administrativo", 4));
        empleados.add(new Empleado("43256985","Enzo","Acha ", 22, 1500.5, "Administrativo",3));
        empleados.add(new Empleado("45258965","Jose Carlos","Galvez Paredes", 35, 2150.0, "Administrativo",5));
        empleados.add(new Empleado("45258965","Jose Carlos","Galvez Paredes", 35, 2150.0, "Administrativo",5));
        empleados.add(new Empleado("78596523","ANDREA LILIANA","CRUZ GARCIA", 27, 3250.0, "Administrativo",6));
        empleados.add(new Empleado("25242125","CAMILO ALBERTO","CORTÉS MONTEJO", 30, 1250.5, "Operario",7));
        empleados.add(new Empleado("78965412","CARLOS FELIPE","MOGOLLÓN PACHÓN", 25, 1250.5, "Operario",8));
        empleados.add(new Empleado("36589654","José Alexander","Vasquez Caruajulca", 27, 1235.5, "Operario",9));
        empleados.add(new Empleado("58965874","GABRIEL MAURICIO","NIETO BUSTOS", 22, 1450.5, "Operario",6));
        empleados.add(new Empleado("45874589","JUAN SEBASTIAN","ROMERO ESCOBAR ", 23, 1235.5, "Operario",4));
        empleados.add(new Empleado("73186835","LAURA CATALINA","VARON BUITRAGO", 38, 1235.5, "Administrativo",5));


        while (!salir) {
            System.out.println("*****MENU DE OPCIONES*****");

            System.out.println("1. Listar Empleados");
            System.out.println("2. Calcular sueldo");
            System.out.println("3. Salir");

            try {

                System.out.print("Escribe una de las opciones: ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        listEmployees(empleados);
                        break;
                    case 2:
                        System.out.print("Ingrese el número de dni: ");
                        dni = sn.next();
                        System.out.println(searchEmployee(empleados,dni)); ;

                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    private static String searchEmployee(ArrayList<Empleado> arr, String dni) {
        for(Empleado e: arr) {
            if(dni.equals(e.getDni())) return calculateSalary(e);
        }
        return "Persona no encontrada\n";
    }

    private static String calculateSalary(Empleado e){
        Scanner sn = new Scanner(System.in);
        int yearsWorking;
        double sueldoTotal= 0.00;

        if(e.getTypeEmployee().equals("Administrativo")){
            System.out.print("Ingresar los años trabajados del empleado: ");
            yearsWorking = sn.nextInt();
            if(yearsWorking <= e.getYearsWork()){
                int resultadoAnios = yearsWorking /3, aniosNormal;

                aniosNormal = yearsWorking -resultadoAnios;

                sueldoTotal = (resultadoAnios * (0.15 * e.getSueldo())) + (aniosNormal*(0.10*e.getSueldo())) + (e.getSueldo() * yearsWorking);

            }
            return "El empleado buscado es: "+e.toString() + " \nSueldo total a pagar es de: " + sueldoTotal;

        }else if(e.getTypeEmployee().equals("Operario")){
            System.out.print("Ingresar los años trabajados del empleado: ");
            yearsWorking = sn.nextInt();
            if(yearsWorking <= e.getYearsWork()){
                int resultadoAnios = yearsWorking /3, aniosNormal;

                aniosNormal = yearsWorking -resultadoAnios;

                sueldoTotal = (resultadoAnios * (0.10 * e.getSueldo())) + (aniosNormal*(0.05*e.getSueldo())) + (e.getSueldo() * yearsWorking);

            }
            return "El empleado buscado es: "+e.toString() + " \nSueldo total a pagar es de: " + sueldoTotal;

        }else{
            return "Volver a ingresar un empleado";
        }

    }

    public static void listEmployees(ArrayList<Empleado> arr){
        System.out.println("*****LISTA DE EMPLEADOS*****");
        for(int i=0;i<arr.size();i++){
            System.out.println(i+1 + ". "+ arr.get(i));
        }
    }
}
