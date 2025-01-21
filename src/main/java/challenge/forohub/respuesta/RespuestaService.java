package challenge.forohub.respuesta;

import challenge.forohub.topico.Topico;
import challenge.forohub.topico.TopicoRepository;
import challenge.forohub.usuario.Usuario;
import challenge.forohub.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RespuestaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    public Respuesta registrar(DatosRegistroRespuesta datos){
        Topico topico = topicoRepository.getReferenceById(datos.idTopico());
        Usuario usuario = usuarioRepository.getReferenceById(datos.idUsuario());
        var respuesta = new Respuesta(datos, topico, usuario);
        respuestaRepository.save(respuesta);

        List <Respuesta> listaRepuesta = new ArrayList<>();
        listaRepuesta.add(respuesta);
        topico.setRespuesta(listaRepuesta);
        topicoRepository.save(topico);
        return respuesta;

    }

}
//@Service
//public class TopicoService {//
//    @Autowired
//    private UsuarioRepository usuarioRepository;//
//    @Autowired
//    private CursoRepository cursoRepository;//
//    @Autowired
//    private TopicoRepository topicoRepository;
//
//    public Topico registrar(DatosRegistroTopico datos) {
//        var usuario = usuarioRepository.findById(datos.idUsuario())
//                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
//        var curso = cursoRepository.findById(datos.idCurso())
//                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
//
//        var topico = new Topico(datos, usuario, curso);
//        return topicoRepository.save(topico);
//
//    }
//
//}



