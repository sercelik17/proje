package yte.intern.data.project.asistan.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import yte.intern.data.project.akademisyen.entity.Akademisyen;
import yte.intern.data.project.akademisyen.service.AkademisyenService;
import yte.intern.data.project.asistan.entity.Asistan;
import yte.intern.data.project.asistan.repository.AsistanRepository;
import yte.intern.data.project.authentication.entity.Users;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.common.response.ResponseType;


import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AsistanService {
    private final AsistanRepository asistanRepository;
    private final AkademisyenService akademisyenService;

    public MessageResponse addAsistan(Asistan asistan) {
        Akademisyen akademisyen = akademisyenService.getById(asistan.getAkademisyen().getId());
        asistan.setAkademisyen(akademisyen);

        asistanRepository.save(asistan);

        return new MessageResponse(ResponseType.SUCCESS, "Asistan has been added successfully");
    }

    public List<Asistan> getAllAsistans() {

        return asistanRepository.findAll();
    }

    public Asistan getById(Long id) {
        return asistanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Asistan not found"));
    }

    public MessageResponse deleteAsistanById(Long id) {
        asistanRepository.deleteById(id);

        return new MessageResponse(ResponseType.SUCCESS, "Asistan has been deleted successfully");
    }


    public MessageResponse updateAsistan(Long id, Asistan updatedAsistan) {
        Asistan asistan = asistanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Asistan not found"));

        // student.update(updatedStudent);

        Akademisyen akademisyen = akademisyenService.getById(updatedAsistan.getAkademisyen().getId());
        updatedAsistan.setAkademisyen(akademisyen);

        asistan.update(updatedAsistan);

        asistanRepository.save(asistan);

        return new MessageResponse(ResponseType.SUCCESS, "Asistan has been updated successfully");
    }
    public Asistan getAsistanById(Long id) {
        return asistanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("kayıt bulunamadı"));
    }


}
