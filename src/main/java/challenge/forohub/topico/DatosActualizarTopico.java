package challenge.forohub.topico;


import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        Long idUsuario


) {
}
