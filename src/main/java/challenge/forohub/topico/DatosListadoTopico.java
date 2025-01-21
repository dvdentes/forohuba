package challenge.forohub.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String nombreUsuario,
        String nombreCurso

){
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus().toString(),
                topico.getUsuario().getNombre(), topico.getCurso().getCategoria().toString());

    }

}
