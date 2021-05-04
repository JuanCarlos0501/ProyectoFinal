import java.util.Objects;

public class Empleado {
    private String dni;
    private String firstName;
    private String lastName;
    private int edad;
    private double sueldo;
    private String typeEmployee;
    private int yearsWork;

    public Empleado(String dni, String firstName, String lastName, int edad, double sueldo, String typeEmployee, int yearsWork) {
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.edad = edad;
        this.sueldo = sueldo;
        this.typeEmployee = typeEmployee;
        this.yearsWork = yearsWork;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getTypeEmployee() {
        return typeEmployee;
    }

    public void setTypeEmployee(String typeEmployee) {
        this.typeEmployee = typeEmployee;
    }

    public int getYearsWork() {
        return yearsWork;
    }

    public void setYearsWork(int yearsWork) {
        this.yearsWork = yearsWork;
    }


    @Override
    public String toString() {
        return
                "DNI= " + dni + '\'' +
                ", Nombres= " + firstName + '\'' +
                ", Apellidos= " + lastName + '\'' +
                ", Edad= " + edad +
                ", Sueldo= " + sueldo +
                ", Tipo de empleado= " + typeEmployee + '\'' +
                ", Años de trabajo=" + yearsWork  ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return edad == empleado.edad && Double.compare(empleado.sueldo, sueldo) == 0 && yearsWork == empleado.yearsWork && Objects.equals(dni, empleado.dni) && Objects.equals(firstName, empleado.firstName) && Objects.equals(lastName, empleado.lastName) && Objects.equals(typeEmployee, empleado.typeEmployee);
    }


}
