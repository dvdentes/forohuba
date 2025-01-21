package challenge.forohub.usuario;

import jakarta.validation.constraints.*;

public record DatosRegistroUsuario(

        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        //@Pattern(regexp = "\\{4,6}")
        @Size(min = 6)
        String contrasena,
        @NotNull
        Perfil perfil) {
}
