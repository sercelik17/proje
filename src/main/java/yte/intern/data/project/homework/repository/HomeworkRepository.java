package yte.intern.data.project.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.data.project.homework.entity.Homework;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {
}
