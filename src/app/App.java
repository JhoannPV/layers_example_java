package app;

import app.presentation.Menu;
import app.repository.EstudianteRepositoryImpl;
import app.service.EstudianteService;

public class App {
    public void start(){
        EstudianteRepositoryImpl repo = new EstudianteRepositoryImpl();
        EstudianteService service = new EstudianteService(repo);
        Menu menu = new Menu(service);
        menu.mostrar();
    }
}

