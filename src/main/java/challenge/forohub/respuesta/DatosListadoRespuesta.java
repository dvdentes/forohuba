package challenge.forohub.respuesta;

import java.time.LocalDateTime;

public record DatosListadoRespuesta(
        Long id,
        String mensaje,
        LocalDateTime fechaCreacion,
        String nombreUsuario


) {

    public DatosListadoRespuesta(Respuesta respuesta){
        //this(respuesta.getId(), respuesta.getMensaje(), respuesta.getFechaCreacion());
        this(respuesta.getId(), respuesta.getMensaje(), respuesta.getFechaCreacion(), respuesta.getUsuario().getNombre());
    }

}

