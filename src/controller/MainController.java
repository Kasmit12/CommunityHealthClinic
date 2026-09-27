package controller;

import view.MainMenuView;
import view.RegisterPatientView;
import view.RegisterDoctorView;
import view.AppointmentView;
import view.TreatmentView;
import view.ReportsView;
import javax.swing.JOptionPane;

public class MainController {

    private MainMenuView mainMenu;

    public MainController() {
        mainMenu = new MainMenuView();

        mainMenu.getBtnRegisterPatient().addActionListener(e -> {
            openRegisterPatient();
        });

        mainMenu.getBtnExit().addActionListener(e -> {
            System.exit(0);
        });
        
        mainMenu.getBtnRegisterDoctor().addActionListener(e -> {
            openRegisterDoctor();
});
        mainMenu.getBtnBookAppointment().addActionListener(e -> {
    openAppointment();
});
        mainMenu.getBtnTreatmentEntry().addActionListener(e -> {
    openTreatment();
});
        mainMenu.getBtnReports().addActionListener(e -> {
    openReports();
});
    }

private void openRegisterPatient() {
    RegisterPatientView patientView = new RegisterPatientView();

    patientView.setLocationRelativeTo(null);

    patientView.getBtnBack().addActionListener(e -> {
        patientView.dispose();
        mainMenu.setVisible(true);
    });
    patientView.getBtnClear().addActionListener(e -> {
    patientView.getTxtPatientName().setText("");
    patientView.getTxtPatientId().setText("");
    patientView.getTxtDateOfBirth().setText("");
    patientView.getCmbGender().setSelectedIndex(0);
    patientView.getTxtPhone().setText("");
    patientView.getTxtAddress().setText("");
});
    patientView.getBtnRegister().addActionListener(e -> {

    String name = patientView.getTxtPatientName().getText().trim();
    String patientId = patientView.getTxtPatientId().getText().trim();
    String dateOfBirth = patientView.getTxtDateOfBirth().getText().trim();
    String phone = patientView.getTxtPhone().getText().trim();
    String address = patientView.getTxtAddress().getText().trim();

    if (name.isEmpty() || patientId.isEmpty() ||
        dateOfBirth.isEmpty() || phone.isEmpty() ||
        address.isEmpty() ||
        patientView.getCmbGender().getSelectedIndex() == 0) {

        JOptionPane.showMessageDialog(
            patientView,
            "Please fill in all patient details.",
            "Validation Error",
            JOptionPane.ERROR_MESSAGE
        );

        return;
    }
    if (!patientId.matches("[a-zA-Z0-9]+")) {
    JOptionPane.showMessageDialog(
        patientView,
        "Patient ID must contain letters or numbers only.",
        "Validation Error",
        JOptionPane.ERROR_MESSAGE
    );

    return;
}
     if (!phone.matches("\\d+")) {
    JOptionPane.showMessageDialog(
        patientView,
        "Phone number must contain numbers only.",
        "Validation Error",
        JOptionPane.ERROR_MESSAGE
    );

    return;
}
    JOptionPane.showMessageDialog(
        patientView,
        "Patient details are valid.",
        "Success",
        JOptionPane.INFORMATION_MESSAGE
    );
});
    patientView.setVisible(true);
    mainMenu.setVisible(false);
}
private void openRegisterDoctor() {
    RegisterDoctorView doctorView = new RegisterDoctorView();

    doctorView.setLocationRelativeTo(null);

    doctorView.getBtnBack().addActionListener(e -> {
        doctorView.dispose();
        mainMenu.setVisible(true);
    });
    doctorView.getBtnClear().addActionListener(e -> {
    doctorView.getTxtDoctorName().setText("");
    doctorView.getTxtDoctorId().setText("");
    doctorView.getTxtSpecialisation().setText("");
    doctorView.getTxtDoctorPhone().setText("");
    doctorView.getTxtAvailability().setText("");
});
    
    doctorView.getBtnRegister().addActionListener(e -> {

    String name = doctorView.getTxtDoctorName().getText().trim();
    String doctorId = doctorView.getTxtDoctorId().getText().trim();
    String specialisation = doctorView.getTxtSpecialisation().getText().trim();
    String phone = doctorView.getTxtDoctorPhone().getText().trim();
    String availability = doctorView.getTxtAvailability().getText().trim();

    // Check for empty fields
    if (name.isEmpty() || doctorId.isEmpty() ||
        specialisation.isEmpty() || phone.isEmpty() ||
        availability.isEmpty()) {

        JOptionPane.showMessageDialog(
            doctorView,
            "Please fill in all doctor details.",
            "Validation Error",
            JOptionPane.ERROR_MESSAGE
        );

        return;
    }

    // Check Doctor ID
    if (!doctorId.matches("[a-zA-Z0-9]+")) {
        JOptionPane.showMessageDialog(
            doctorView,
            "Doctor ID must contain letters or numbers only.",
            "Validation Error",
            JOptionPane.ERROR_MESSAGE
        );

        return;
    }

    // Check phone number
    if (!phone.matches("\\d+")) {
        JOptionPane.showMessageDialog(
            doctorView,
            "Phone number must contain numbers only.",
            "Validation Error",
            JOptionPane.ERROR_MESSAGE
        );

        return;
    }

    JOptionPane.showMessageDialog(
        doctorView,
        "Doctor details are valid.",
        "Success",
        JOptionPane.INFORMATION_MESSAGE
    );
});
    doctorView.setVisible(true);
    mainMenu.setVisible(false);
}
    public void start() {
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setVisible(true);
    }

    public static void main(String[] args) {
        MainController controller = new MainController();
        controller.start();
    }
   
    private void openAppointment() {
    AppointmentView appointmentView = new AppointmentView();

    appointmentView.setLocationRelativeTo(null);
    appointmentView.getBtnBack().addActionListener(e -> {
    appointmentView.dispose();
    mainMenu.setVisible(true);
});

appointmentView.getBtnClear().addActionListener(e -> {

    appointmentView.getTxtAppointmentId().setText("");
    appointmentView.getTxtAppointmentDate().setText("");
    appointmentView.getTxtAppointmentTime().setText("");
    appointmentView.getTxtReason().setText("");
    appointmentView.getCmbPatient().setSelectedIndex(0);
    appointmentView.getCmbDoctor().setSelectedIndex(0);
});
 appointmentView.getBtnBookAppointment().addActionListener(e -> {

    String appointmentId =
        appointmentView.getTxtAppointmentId().getText().trim();

    String date =
        appointmentView.getTxtAppointmentDate().getText().trim();

    String time =
        appointmentView.getTxtAppointmentTime().getText().trim();

    String reason =
        appointmentView.getTxtReason().getText().trim();

    // Check for empty fields
    if (appointmentId.isEmpty() || date.isEmpty() ||
        time.isEmpty() || reason.isEmpty()) {

        JOptionPane.showMessageDialog(
            appointmentView,
            "Please fill in all appointment details.",
            "Validation Error",
            JOptionPane.ERROR_MESSAGE
        );

        return;
    }

    // Check Appointment ID
    if (!appointmentId.matches("[a-zA-Z0-9]+")) {

        JOptionPane.showMessageDialog(
            appointmentView,
            "Appointment ID must contain letters or numbers only.",
            "Validation Error",
            JOptionPane.ERROR_MESSAGE
        );

        return;
    }

    JOptionPane.showMessageDialog(
        appointmentView,
        "Appointment details are valid.",
        "Success",
        JOptionPane.INFORMATION_MESSAGE
    );
});
    appointmentView.setVisible(true);
    mainMenu.setVisible(false);
}
  private void openTreatment() {
    TreatmentView treatmentView = new TreatmentView();

    treatmentView.setLocationRelativeTo(null);

    treatmentView.getBtnBack().addActionListener(e -> {
        treatmentView.dispose();
        mainMenu.setVisible(true);
    });
    treatmentView.getBtnClear().addActionListener(e -> {
    treatmentView.getTxtTreatmentId().setText("");
    treatmentView.getTxtDiagnosis().setText("");
    treatmentView.getTxtTreatment().setText("");
    treatmentView.getTxtPrescription().setText("");
    treatmentView.getTxtNotes().setText("");
    treatmentView.getCmbAppointment().setSelectedIndex(0);
});
    treatmentView.getBtnSaveTreatment().addActionListener(e -> {

    String treatmentId =
        treatmentView.getTxtTreatmentId().getText().trim();

    String diagnosis =
        treatmentView.getTxtDiagnosis().getText().trim();

    String treatment =
        treatmentView.getTxtTreatment().getText().trim();

    String prescription =
        treatmentView.getTxtPrescription().getText().trim();

    String notes =
        treatmentView.getTxtNotes().getText().trim();

    // Check for empty fields
    if (treatmentId.isEmpty() || diagnosis.isEmpty() ||
        treatment.isEmpty() || prescription.isEmpty() ||
        notes.isEmpty()) {

        JOptionPane.showMessageDialog(
            treatmentView,
            "Please fill in all treatment details.",
            "Validation Error",
            JOptionPane.ERROR_MESSAGE
        );

        return;
    }

    // Check Treatment ID
    if (!treatmentId.matches("[a-zA-Z0-9]+")) {

        JOptionPane.showMessageDialog(
            treatmentView,
            "Treatment ID must contain letters or numbers only.",
            "Validation Error",
            JOptionPane.ERROR_MESSAGE
        );

        return;
    }

    JOptionPane.showMessageDialog(
        treatmentView,
        "Treatment details are valid.",
        "Success",
        JOptionPane.INFORMATION_MESSAGE
    );
});
    treatmentView.setVisible(true);
    
    mainMenu.setVisible(false);
}  
  private void openReports() {
    ReportsView reportsView = new ReportsView();

    reportsView.setLocationRelativeTo(null);

    reportsView.getBtnBack().addActionListener(e -> {
        reportsView.dispose();
        mainMenu.setVisible(true);
    });

    reportsView.setVisible(true);
    mainMenu.setVisible(false);
}
}

