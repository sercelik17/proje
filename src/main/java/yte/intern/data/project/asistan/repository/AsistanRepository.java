package yte.intern.data.project.asistan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.data.project.asistan.entity.Asistan;

import java.util.Optional;

public interface AsistanRepository extends JpaRepository<Asistan, Long> {
    Optional<Asistan> findAsistanByName(String name);
}
