package com.program.program.Services;

import com.program.program.Repositories.ProgramRepository;
import com.program.program.entities.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramService {

    private final ProgramRepository programRepository;

    @Autowired
    public ProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    public Optional<Program> getProgramById(Long id) {
        return programRepository.findById(id);
    }

    public Program createProgram(Program program) {
        return programRepository.save(program);
    }

    public Program updateProgram(Long id, Program program) {
        if (programRepository.existsById(id)) {
            program.setId(id);
            return programRepository.save(program);
        } else {
            throw new RuntimeException("Program not found with id " + id);
        }
    }

    public void deleteProgram(Long id) {
        programRepository.deleteById(id);
    }
}
