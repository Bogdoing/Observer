package model;


import javafx.scene.control.TextField;

public class Director {
    public Indicator build(IndicatorBuilder builder, TextField time) {
        builder.buildRect();

        builder.buildText();

        builder.buildCircles();
        builder.buildLines(time);

        return builder.getIndicator();
    }
    public void clear(IndicatorBuilder builder, Indicator indicator){
        indicator.getChildren().clear();
    }
}
