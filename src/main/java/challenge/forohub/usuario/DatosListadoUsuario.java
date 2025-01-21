package challenge.forohub.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DatosListadoUsuario (

        Long id,
        String nombre,
        String email,
        String perfil
){
    public DatosListadoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail(),usuario.getPerfil().toString());
    }

}
