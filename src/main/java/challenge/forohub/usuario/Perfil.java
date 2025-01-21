package challenge.forohub.usuario;

public enum Perfil {

    ADMINISTRADOR("administrador"),
    ESTUDIANTE("Estudiante"),
    INSTRUCTOR("Instructor");

    private String nombre;
    Perfil(String nombre){
        this.nombre = nombre;
    }
}
