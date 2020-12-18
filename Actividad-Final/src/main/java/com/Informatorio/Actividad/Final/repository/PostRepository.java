package com.Informatorio.Actividad.Final.repository;
import com.Informatorio.Actividad.Final.model.Post;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
