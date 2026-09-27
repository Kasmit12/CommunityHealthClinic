package controller;

import org.junit.Test;
import static org.junit.Assert.*;

import view.MainMenuView;
import view.RegisterPatientView;
import view.RegisterDoctorView;
import view.AppointmentView;
import view.TreatmentView;

public class ControllerTest {

    @Test
    public void testControllerCreation() {
        MainController controller = new MainController();
        assertNotNull(controller);
    }

    @Test
    public void testMainMenuCreation() {
        MainMenuView view = new MainMenuView();
        assertNotNull(view);
        view.dispose();
    }

    @Test
    public void testPatientViewCreation() {
        RegisterPatientView view = new RegisterPatientView();
        assertNotNull(view);
        view.dispose();
    }

    @Test
    public void testDoctorViewCreation() {
        RegisterDoctorView view = new RegisterDoctorView();
        assertNotNull(view);
        view.dispose();
    }

    @Test
    public void testAppointmentViewCreation() {
        AppointmentView view = new AppointmentView();
        assertNotNull(view);
        view.dispose();
    }

    @Test
    public void testTreatmentViewCreation() {
        TreatmentView view = new TreatmentView();
        assertNotNull(view);
        view.dispose();
    }
}
