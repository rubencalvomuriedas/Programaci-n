import java.time.LocalDate;

    public class Persona {
        private String nombre;
        private LocalDate FechaNacimiento;
        private String DNI;
        private String direccion;
        private String numeroContrto;

        public Persona(String nombre, LocalDate fechaNacimiento, String DNI, String direccion, String numeroContrto) {
            this.nombre = nombre;
            FechaNacimiento = fechaNacimiento;
            this.DNI = DNI;
            if (!DNI.matches("\\d{8}[A-Za-z]")){
                throw new IllegalArgumentException("DNI incorrecto. Debe tener 8 números y una letra mayúscula.");
            }
            this.direccion = direccion;
            this.numeroContrto = numeroContrto;
        }

        public String getNombre() {
            return nombre;
        }

        public String getDNI() {
            return DNI;
        }

        public String getNumeroContrto() {
            return numeroContrto;
        }

        public void setNumeroContrto(String numeroContrto) {
            this.numeroContrto = numeroContrto;
        }
        @Override
        public String toString() {
            return "Persona{" +
                    "nombre='" + nombre + '\'' +
                    ", DNI='" + DNI + '\'' +
                    ", direccion='" + direccion + '\'' +
                    ", numeroContrto='" + numeroContrto + '\'' +
                    '}';
        }
    }

