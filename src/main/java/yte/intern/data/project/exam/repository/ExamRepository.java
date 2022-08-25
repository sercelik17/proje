package yte.intern.data.project.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.data.project.exam.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam,Long> {
}
