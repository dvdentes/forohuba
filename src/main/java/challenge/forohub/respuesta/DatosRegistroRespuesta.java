package challenge.forohub.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(

        @NotBlank
        String mensaje,
        @NotNull
        Long idTopico,
        @NotNull
        Long idUsuario

) {
}

