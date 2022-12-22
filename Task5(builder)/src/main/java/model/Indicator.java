package model;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.util.Duration;

import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import static javafx.animation.Animation.INDEFINITE;

public class Indicator extends Pane {

    public void setLines(Lines lines) {
        getChildren().add(lines);
    }

    public void setCircles(Circles circles) {
        getChildren().add(circles);
    }

    RotateTransition rotateTransition = new RotateTransition();
    ScaleTransition scaleTransition = new ScaleTransition();
    PathTransition pathTransition = new PathTransition();

    public void update(Lines lines, TextField time) {
        lines.setFill(Color.BLUE);
        rotateTransition.setDuration(Duration.millis(1000));//Duration.millis(Double.parseDouble(String.valueOf(time)))
        rotateTransition.setNode(lines);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(5);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
        rotateTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                getChildren().remove(lines);
            }
        });
    }

    public void ubdate_circle(Circles circles) {
        scaleTransition.setDuration(Duration.millis(1000));
        scaleTransition.setNode(circles);
        scaleTransition.setByY(1.5);
        scaleTransition.setByX(1.5);
        scaleTransition.setCycleCount(50);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }

    public void ubdate_rect(Rectangle rectPath) {
        Stop[] stops = new Stop[]{
                new Stop(0, Color.DARKSLATEBLUE),
                new Stop(1, Color.DARKRED)};

        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        LinearGradient lg2 = new LinearGradient(125, 0, 225, 0, false, CycleMethod.NO_CYCLE, stops);
        LinearGradient lg3 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        rectPath.setFill(lg3);

        TranslateTransition ts = new TranslateTransition();
        ts.setDuration(Duration.millis(1));
        ts.setNode(rectPath);

        ts.setToX(200);
        ts.setToY(100);

        ScaleTransition st = new ScaleTransition();
        st.setDuration(Duration.seconds(3));
        st.setNode(rectPath);
        st.setCycleCount(3);
        st.setAutoReverse(true);

        st.setToX(3);
        st.setToY(3);

        RotateTransition rt = new RotateTransition();
        rt.setDuration(Duration.seconds(1));
        rt.setNode(rectPath);
        rt.setByAngle(360);
        rt.setCycleCount(12);
        rt.setAutoReverse(false);

        ts.play();
        st.play();
        rt.play();

        rt.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                try { Thread.sleep(1500); }
                catch (Exception e) { System.out.println(e); }
                getChildren().remove(rectPath);
            }
        });
        /*
        Path path = new Path();
        path.getElements().add(new MoveTo(50,50));
        pathTransition.setDuration(Duration.millis(2500));
        pathTransition.setPath(path);
        pathTransition.setNode(rectPath);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(10);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
        pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                getChildren().remove(rectPath);
            }
        });
*/
    }

    public void ubdate_text(Text text) {
        text.setText("0:0%");
        //Создание потока

        Thread myThready = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                try {
                    for (int i = 0; i < 100; i++) {
                        Thread.sleep(100);
                        System.out.println("Привет из побочного потока!" + i);
                        text.setText("" + i + ".0%");
                    }
                    Thread.sleep(1000);
                    text.setText("" + "100" + ".0%");
                    Thread.sleep(2000);
                    text.setText("");
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        });
        myThready.start();	//Запуск потока

        System.out.println("Главный поток завершён...");

    }

}


