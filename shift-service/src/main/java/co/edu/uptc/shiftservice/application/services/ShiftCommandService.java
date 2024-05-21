package co.edu.uptc.shiftservice.application.services;

import co.edu.uptc.shiftservice.domain.Shift;
import co.edu.uptc.shiftservice.infraestructure.command.ShiftCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiftCommandService {
    @Autowired
    private ShiftCommandRepository shiftCommandRepository;

    public Shift createShift(Shift shift) {
        return shiftCommandRepository.save(shift);
    }

    public Shift updateShift(String id, Shift newShift) {
        return shiftCommandRepository.findById(id)
                .map(shift -> {
                    shift.setCodigo(newShift.getCodigo());
                    shift.setNumeroTurno(newShift.getNumeroTurno());
                    shift.setDependencia(newShift.getDependencia());
                    shift.setHoraAsignacion(newShift.getHoraAsignacion());
                    shift.setEstado(newShift.getEstado());
                    return shiftCommandRepository.save(shift);
                })
                .orElse(null);
    }

    public void deleteShift(String id) {
        shiftCommandRepository.deleteById(id);
    }
}
