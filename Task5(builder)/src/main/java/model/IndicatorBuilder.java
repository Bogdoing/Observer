package model;

import javafx.scene.control.TextField;

public interface IndicatorBuilder {
    void buildLines();
    void buildCircles();

    void buildLines(TextField time);

    Indicator getIndicator();

 //   void clearPane();

    void buildRect();

    void buildText();

    void clearPane();
}
