package app.interfaces;

import app.model.Estudiante;
import java.util.List;

public interface EstudianteRepository {
    boolean guardar(Estudiante estudiante);
    List<Estudiante> listar();
    boolean eliminar(String codigo);
}

