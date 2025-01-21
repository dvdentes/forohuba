package challenge.forohub.curso;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_curso")
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(DatosRegistroCurso datosRegistroCurso) {

        this.nombre = datosRegistroCurso.nombre();
        this.categoria = datosRegistroCurso.categoria();
    }

    public void actualizarDatos(@Valid DatosActualizarCurso datosActualizarCurso) {
        if (datosActualizarCurso.nombre() != null){
            this.nombre = datosActualizarCurso.nombre();
        }
        if (datosActualizarCurso.categoria() != null){
            this.categoria = datosActualizarCurso.categoria()
            ;
        }

    }



}
