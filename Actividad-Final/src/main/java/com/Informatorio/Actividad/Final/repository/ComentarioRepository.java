package com.Informatorio.Actividad.Final.repository;
import com.Informatorio.Actividad.Final.model.Comentario;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
