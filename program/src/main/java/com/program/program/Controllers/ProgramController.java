package com.program.program.Controllers;

import com.program.program.Services.ProgramService;
import com.program.program.entities.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/programs")
public class ProgramController {

    private final ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping("/")
    public List<Program> getAllPrograms() {
        return programService.getAllPrograms();
    }

    @GetMapping("/{id}")
    public Optional<Program> getProgramById(@PathVariable Long id) {
        return programService.getProgramById(id);
    }

    @PostMapping("/")
    public Program createProgram(@RequestBody Program program) {
        return programService.createProgram(program);
    }

    @PutMapping("/{id}")
    public Program updateProgram(@PathVariable Long id, @RequestBody Program program) {
        return programService.updateProgram(id, program);
    }

    @DeleteMapping("/{id}")
    public void deleteProgram(@PathVariable Long id) {
        programService.deleteProgram(id);
    }
}
