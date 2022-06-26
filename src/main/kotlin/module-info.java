module edu.mailman.kotlinjavafxpendulumplot {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens edu.mailman.kotlinjavafxpendulumplot to javafx.fxml;
    exports edu.mailman.kotlinjavafxpendulumplot;
}