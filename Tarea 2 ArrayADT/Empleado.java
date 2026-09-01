package NominaEmpleados;

public class Empleado {
    private int numeroTrabajador;
    private String nombres;
    private String paterno;
    private String materno;
    private int horasExtra;
    private double sueldoBase;
    private int fechaIngreso; // Funciona como el año de ingreso


    public Empleado() {
    }

    public Empleado(int numeroTrabajador, String nombres, String paterno, String materno, int horasExtra, double sueldoBase, int fechaIngreso) {
        this.numeroTrabajador = numeroTrabajador;
        this.nombres = nombres;
        this.paterno = paterno;
        this.materno = materno;
        this.horasExtra = horasExtra;
        this.sueldoBase = sueldoBase;
        this.fechaIngreso = fechaIngreso;
    }

    public int getNumeroTrabajador() {
        return numeroTrabajador;
    }

    public void setNumeroTrabajador(int numeroTrabajador) {
        this.numeroTrabajador = numeroTrabajador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(int fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int CalcularAntiguedad (int fechaactual){
        return Math.max(0, fechaactual - this.fechaIngreso);
    }

    public double calcularHorasExtras(int fechaactual){
        int antiguedad = CalcularAntiguedad(fechaactual);
        double pagoPorHorasExtras = this.horasExtra * 276.5;
        double bonoAntiguedad = this.sueldoBase * (0.03 * antiguedad);

        return this.sueldoBase + pagoPorHorasExtras + bonoAntiguedad;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "numeroTrabajador=" + numeroTrabajador +
                ", nombres='" + nombres + '\'' +
                ", paterno='" + paterno + '\'' +
                ", materno='" + materno + '\'' +
                ", horasExtra=" + horasExtra +
                ", sueldoBase=" + sueldoBase +
                ", fechaIngreso=" + fechaIngreso +
                ", sueldoMensualTotal=" + calcularHorasExtras(2026)+
                '}';
    }
}