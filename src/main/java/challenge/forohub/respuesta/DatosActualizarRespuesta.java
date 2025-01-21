package challenge.forohub.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarRespuesta (
        @NotNull
        Long id,
        String mensaje,
        Long idTopico,
        boolean isSolucion
){


}
