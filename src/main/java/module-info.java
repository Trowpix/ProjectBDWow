module com.example.projectakhirbd {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectakhirbd to javafx.fxml;
    exports com.example.projectakhirbd;
    exports com.example.projectakhirbd.Auth;
    opens com.example.projectakhirbd.Auth to javafx.fxml;
    exports com.example.projectakhirbd.Siswa;
    opens com.example.projectakhirbd.Siswa to javafx.fxml;
    exports com.example.projectakhirbd.Admin;
    opens com.example.projectakhirbd.Admin to javafx.fxml;
    exports com.example.projectakhirbd.WaliKelas;
    opens com.example.projectakhirbd.WaliKelas to javafx.fxml;
    exports com.example.projectakhirbd.Guru;
    opens com.example.projectakhirbd.Guru to javafx.fxml;
}