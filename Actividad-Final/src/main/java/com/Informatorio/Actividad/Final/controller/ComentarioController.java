package com.Informatorio.Actividad.Final.controller;
import com.Informatorio.Actividad.Final.model.Comentario;
import com.Informatorio.Actividad.Final.repository.ComentarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

/**
 * ComentarioController
 */
@RestController
@RequestMapping("/api/v1/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    //todos los post
    @GetMapping
    public ResponseEntity<?> getComentario() {
        return new ResponseEntity<>(comentarioRepository.findAll(), HttpStatus.OK);
    }

    //crear un post
    @PostMapping
    public ResponseEntity<?> createComentario(@RequestBody Comentario comentario) {
        return new ResponseEntity<>(comentarioRepository.save(comentario), HttpStatus.CREATED);
    }

    //modificar segun id comentario
    @PutMapping("/{comentarioId}")
    public ResponseEntity<?> editComentario(@PathVariable Long comentarioId,@Valid @RequestBody Comentario comentario) {
        Comentario comentarios = comentarioRepository.getOne(comentarioId);
        comentarios.setComentario(comentario.getComentario());
        return new ResponseEntity<>(comentarioRepository.save(comentarios), HttpStatus.OK);
    }
    //borrar segun id de comentario
    @DeleteMapping("/{comentarioId}")
    public ResponseEntity<?> deleteComentario(@PathVariable Long comentarioId) {
        Comentario eliminarcomentarios = comentarioRepository.getOne(comentarioId);
        comentarioRepository.delete(eliminarcomentarios);
        return new ResponseEntity<>(HttpStatus.OK);
    }
       
}