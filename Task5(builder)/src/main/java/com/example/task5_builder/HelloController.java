package com.example.task5_builder;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.Director;
import model.SimpleIndicatorBuilder;
import model.Indicator;


public class HelloController {
    public Pane indPane;

    @FXML
    public TextField time;
    Director direct = new Director();
    Indicator indicator = new Indicator();

    public void indicator(){
        SimpleIndicatorBuilder sib = new SimpleIndicatorBuilder(indicator);
        direct.clear(sib, indicator);
        indicator.getChildren().clear();

        indPane.getChildren().clear();
        direct.build(sib, time);
        indPane.getChildren().add(indicator);
    }
    public void clearindicator(){
        indPane.getChildren().clear();
        indicator.getChildren().removeAll();

    }
}
