package yte.intern.data.project.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.data.project.admin.entity.Admin;
import yte.intern.data.project.admin.repository.AdminRepository;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.common.response.ResponseType;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    public MessageResponse addAdmin(Admin admin) {
        adminRepository.save(admin);
        return new MessageResponse(ResponseType.SUCCESS, "Student has been added successfully");
    }

    public List<Admin> getAllAdmins() {

        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin.js not found"));
    }

    public MessageResponse deleteAdminById(Long id) {
        adminRepository.deleteById(id);

        return new MessageResponse(ResponseType.SUCCESS, "Admin has been deleted successfully");
    }

    public MessageResponse updateAdmin(Long id, Admin updatedAdmin) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin not found"));

        adminRepository.save(admin);

        updatedAdmin.update(admin);
        return new MessageResponse(ResponseType.SUCCESS, "Admin has been updated successfully");
    }
}
