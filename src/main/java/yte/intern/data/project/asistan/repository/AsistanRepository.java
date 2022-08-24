package yte.intern.data.project.asistan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.data.project.asistan.entity.Asistan;

import java.util.List;
import java.util.Optional;

public interface AsistanRepository extends JpaRepository<Asistan, Long> {
    Optional<Asistan> findAsistanById(Long id);

    List<Asistan> findAll();
}
