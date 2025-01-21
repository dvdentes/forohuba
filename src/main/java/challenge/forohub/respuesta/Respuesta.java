package challenge.forohub.respuesta;


import challenge.forohub.topico.DatosActualizarTopico;
import challenge.forohub.topico.Topico;
import challenge.forohub.topico.TopicoRepository;
import challenge.forohub.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "respuestas")
@Entity(name = "respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    @ManyToOne(fetch = FetchType.LAZY)
    private Topico topico;

    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    private boolean isSolucion = false;//set solucion por parte del usuario


    public Respuesta(DatosRegistroRespuesta datos, Topico topico, Usuario usuario) {
        this.mensaje = datos.mensaje();
        this.topico = topico;
        this.usuario = usuario;
        this.isSolucion = false;
        this.fechaCreacion = LocalDateTime.now();
    }

    public void actualizarDatos(@Valid DatosActualizarRespuesta datosActualizarRespuesta, TopicoRepository topicoRepository) {
        if (datosActualizarRespuesta.mensaje() != null){
            this.mensaje = datosActualizarRespuesta.mensaje();
        }

        if (datosActualizarRespuesta.idTopico() != null) {
            this.topico = topicoRepository.findById(datosActualizarRespuesta.idTopico())
                    .orElseThrow(() -> new EntityNotFoundException("Topico no encontrado"));
        }
        if (datosActualizarRespuesta.isSolucion()) {
            this.isSolucion = true;
        }
    }

    public void marcarSoluccion (){
        this.isSolucion = true;

    }



}



