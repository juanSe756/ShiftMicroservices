package co.edu.uptc.shiftservice.application.services;

import co.edu.uptc.shiftservice.domain.Shift;
import co.edu.uptc.shiftservice.infraestructure.query.ShiftQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShiftQueryService {
    @Autowired
    private ShiftQueryRepository shiftQueryRepository;

    public List<Shift> getAllShifts() {
        return shiftQueryRepository.findAll();
    }

    public Optional<Shift> getShiftById(String id) {
        return shiftQueryRepository.findById(id);
    }

}
