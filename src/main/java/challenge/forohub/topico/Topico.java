package challenge.forohub.topico;

import challenge.forohub.curso.Curso;
import challenge.forohub.respuesta.Respuesta;
import challenge.forohub.usuario.Usuario;
import challenge.forohub.usuario.UsuarioRepository;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)//muchos topicos para un usuario
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Curso curso;

    @OneToMany (mappedBy = "topico")//un topico tiene mucha muchas respuestas
    private List<Respuesta> respuesta = new ArrayList<>();


    public Topico(DatosRegistroTopico datosRegistroTopico, Usuario usuario, Curso curso) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = Status.ACTIVO;
        this.usuario = usuario;
        this.curso = curso;

    }

    public void actualizarDatos(@Valid DatosActualizarTopico datosActualizarTopico, UsuarioRepository usuarioRepository) {

        if (datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.idUsuario() != null) {
            this.usuario = usuarioRepository.findById(datosActualizarTopico.idUsuario())
                    .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        }

    }

    public void setRespuesta(List<Respuesta> respuesta) {
        this.respuesta = respuesta;
    }
}

