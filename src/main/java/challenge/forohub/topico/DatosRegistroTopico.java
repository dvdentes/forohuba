package challenge.forohub.topico;

import challenge.forohub.respuesta.Respuesta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Long idUsuario,//usuario o autor
        @NotNull
        Long idCurso
       // List<Respuesta>;
) {
}
