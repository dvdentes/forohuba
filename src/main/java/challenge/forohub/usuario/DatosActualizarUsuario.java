package challenge.forohub.usuario;


import jakarta.validation.constraints.NotNull;


public record DatosActualizarUsuario(
        @NotNull
        Long id,
        String nombre,
        String email,
        Perfil perfil) {
}
