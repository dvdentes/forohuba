package challenge.forohub.topico;

import challenge.forohub.curso.CursoRepository;
import challenge.forohub.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico registrar(DatosRegistroTopico datos) {
        var usuario = usuarioRepository.findById(datos.idUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        var curso = cursoRepository.findById(datos.idCurso())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

        var topico = new Topico(datos, usuario, curso);
        return topicoRepository.save(topico);

    }

}
