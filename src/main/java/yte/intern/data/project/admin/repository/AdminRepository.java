package yte.intern.data.project.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.data.project.admin.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findAdminById(Long id);

    List<Admin> findAll();

}
