package app.service;

import app.interfaces.EstudianteRepository;
import app.model.Estudiante;

import java.util.List;

public class EstudianteService {
    private final EstudianteRepository repo;

    public EstudianteService(EstudianteRepository repo) {
        this.repo = repo;
    }

    public boolean registrar(Estudiante estudiante) {
        if (estudiante.getCodigo() == null || estudiante.getCodigo().trim().isEmpty()) {
            return false; // código obligatorio
        }
        if (estudiante.getEdad() <= 0) {
            return false; // edad debe ser positiva
        }
        if (existeCodigo(estudiante.getCodigo())) {
            return false; // no permitir código repetido
        }
        return repo.guardar(estudiante);
    }

    public List<Estudiante> listar() {
        return repo.listar();
    }

    public boolean eliminar(String codigo) {
        return repo.eliminar(codigo);
    }

    private boolean existeCodigo(String codigo) {
        return repo.listar().stream()
                .anyMatch(e -> e.getCodigo().equalsIgnoreCase(codigo));
    }
}

