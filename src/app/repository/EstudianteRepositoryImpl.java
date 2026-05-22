package app.repository;

import app.interfaces.EstudianteRepository;
import app.model.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class EstudianteRepositoryImpl implements EstudianteRepository {
    private final List<Estudiante> estudiantes = new ArrayList<>();

    public boolean guardar(Estudiante estudiante) {
        return estudiantes.add(estudiante);
    }

    public List<Estudiante> listar() {
        return new ArrayList<>(estudiantes);
    }

    public boolean eliminar(String codigo) {
        return estudiantes.removeIf(e -> e.getCodigo().equalsIgnoreCase(codigo));
    }
}

