package com.Informatorio.Actividad.Final.model;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
/**
 * Comentario
 */
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "autor", nullable = false)
    private Usuario usuario;

    private Date fechaCreacion;
    
    @Size(max = 200)
    private String comentario;

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
     
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
}