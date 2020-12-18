package com.Informatorio.Actividad.Final.controller;
import com.Informatorio.Actividad.Final.model.Post;
import com.Informatorio.Actividad.Final.repository.PostRepository;
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
 * PostController
 */
@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    //todos los post
    @GetMapping
    public ResponseEntity<?> getPosts() {
        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
    }

    //crear un post
    @PostMapping("/api/v1/post")
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.CREATED);
    }

    //modificar segun id post
    @PutMapping("/{postId}")
    public ResponseEntity<?> editPost(@PathVariable Long postId,@Valid @RequestBody Post post) {
        Post publicacion = postRepository.getOne(postId);
        publicacion.setTitulo(post.getTitulo());
        publicacion.setDescripcion(post.getDescripcion());
        publicacion.setContenido(post.getContenido());
        return new ResponseEntity<>(postRepository.save(publicacion), HttpStatus.OK);
    }
    //borrar segun id de post
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        Post eliminarPublicacion = postRepository.getOne(postId);
        postRepository.delete(eliminarPublicacion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

   
}