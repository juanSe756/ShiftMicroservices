package co.edu.uptc.shiftservice.application.services;

import co.edu.uptc.shiftservice.domain.model.Shift;
import co.edu.uptc.shiftservice.infrastructure.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserShiftServices {

    @Autowired
    ShiftRepository shiftRepository;

    public List<Shift> getAllShifts() {
        return shiftRepository.findAll();
    }

    public Optional<Shift> getShiftById(String id) {
        return shiftRepository.findById(id);
    }

    public Shift createShift(Shift shift) {
        return shiftRepository.save(shift);
    }


    public Optional<Shift> updateShift(String id, Shift shiftDetails) {
        return shiftRepository.findById(id).map(shift -> {
            shift.setCodigo(shiftDetails.getCodigo());
            shift.setNumeroTurno(shiftDetails.getNumeroTurno());
            shift.setDependencia(shiftDetails.getDependencia());
            shift.setHoraAsignacion(shiftDetails.getHoraAsignacion());
            shift.setEstado(shiftDetails.getEstado());
            return shiftRepository.save(shift);
        });
    }

    public void deleteShiftById(String id) {
        shiftRepository.deleteById(id);
    }
}
