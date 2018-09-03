package modelo;

// codigo que contiene los atributos y metodos de la calse principal clientes
// brillyth dayana lopez


/**
 *
 * @author Velasquez
 */
public class Clientes {
  private String nombre,apellido,cedula,telefono,correo,dirrección,genero,estado;

    public Clientes(String nombre, String apellido, String cedula, String telefono, String correo, String dirrección, String genero, String estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.dirrección = dirrección;
        this.genero = genero;
        this.estado = estado;
    }
    public Clientes(){ // CONSTRUCTOR SIN PARAMETROS MANUAL
    this.nombre="";
    this.apellido="";
    this.cedula="";
    this.telefono="";
    this.correo="";
    this.dirrección="";
    this.genero="";
    this.estado="";
    } 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDirrección() {
        return dirrección;
    }

    public void setDirrección(String dirrección) {
        this.dirrección = dirrección;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



}

