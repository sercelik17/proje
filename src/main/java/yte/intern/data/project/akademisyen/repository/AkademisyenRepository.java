package yte.intern.data.project.akademisyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.data.project.akademisyen.entity.Akademisyen;

import java.util.List;
import java.util.Optional;

public interface AkademisyenRepository extends JpaRepository<Akademisyen,Long> {

    Optional<Akademisyen> findAkademisyenById(Long id);
    List<Akademisyen> findAll();
}
