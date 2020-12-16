package com.Informatorio.Actividad.Final.controller;
import com.Informatorio.Actividad.Final.model.Usuario;
import com.Informatorio.Actividad.Final.model.Post;
import com.Informatorio.Actividad.Final.model.Comentario;
import com.Informatorio.Actividad.Final.repository.ComentarioRepository;
import com.Informatorio.Actividad.Final.repository.UsuarioRepository;
import com.Informatorio.Actividad.Final.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

/**
 * UsuarioController
 */
@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;

    @GetMapping
    public ResponseEntity<?> getusuarios() {
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createusuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }
    @PostMapping("/{id_usuario}/post")
    public ResponseEntity<?> createpost(@PathVariable long id_usuario,@RequestBody Post post) {
        Usuario usuario = usuarioRepository.getOne(id_usuario);
        usuario.addPost(post);
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.CREATED);
    }

    @PostMapping("/{id_usuario}/comentario")
    public ResponseEntity<?> createcomentario(@PathVariable long id_usuario,@RequestBody Comentario comentario) {
        Usuario usuario = usuarioRepository.getOne(id_usuario);
        usuario.addComentario(comentario);
        return new ResponseEntity<>(comentarioRepository.save(comentario), HttpStatus.CREATED);
    }

    @PutMapping("/{usuarioId}")
    public ResponseEntity<?> editusuario(@PathVariable Long usuarioId,@Valid @RequestBody Usuario usuario) {
        Usuario usuarios = usuarioRepository.getOne(usuarioId);
        usuarios.setNombre(usuario.getNombre());
        usuarios.setApellido(usuario.getApellido());
        usuarios.setCiudad(usuario.getCiudad());
        usuarios.setProvincia(usuario.getProvincia());
        usuarios.setPais(usuario.getPais());
        return new ResponseEntity<>(usuarioRepository.save(usuarios), HttpStatus.OK);
    }
        
    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<?> deleteusuario(@PathVariable Long usuarioId) {
        Usuario eliminarusuario = usuarioRepository.getOne(usuarioId);
        usuarioRepository.delete(eliminarusuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}