package com.example.task4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import Builders.ImageCollection;
import Builders.Iterator;
import javafx.event.ActionEvent;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    public ImageView pleer;

    public File[] images_paths;
    @FXML
    public ImageCollection imgs = new ImageCollection(images_paths);
    //public ImageCollection imgs = new ImageCollection();
    @FXML
    public Iterator iter_main = imgs.getIterator();

    @FXML
    public Iterator iterator;
    @FXML
    public TextField textField1;

    Timeline timeline = new Timeline();


    public void onNext(ActionEvent actionEvent) {
        if (iter_main.hasNext()) {
            Image name = (Image) iter_main.next();
            pleer.setImage(name);
        }
    }

    public void onBack(ActionEvent event) {
        if (iter_main.hasPreview()) {
            Image name = (Image) iter_main.preview();
            pleer.setImage(name);
        } else {
            Image name = (Image) iter_main.returnone();
            pleer.setImage(name);
        }
    }

    public void onStop(ActionEvent event) {
        timeline.stop();
        timeline.getKeyFrames().clear();
    }

    public void onPlay(ActionEvent event) {
        timeline.play();
    }

    public void onStart(ActionEvent event) {
        int timerint = Integer.parseInt(textField1.getText());
        timeline.setCycleCount(Timeline.INDEFINITE);
        System.out.println(timerint);
        timeline.getKeyFrames().add(new KeyFrame(new Duration(timerint), new EventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println(timerint);
                if (iter_main.hasNext()) {
                    Image name = (Image) iter_main.next();
                    pleer.setImage(name);
                }
            }
        }));
    }

    public void onChoseDirectory(ActionEvent actionEvent) {

        /*
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранение файла....");
        fileChooser.ExtensionFilter("Изображение", "*.bmp"));
        File file = fileChooser.showSaveDialog(canva.getScene().getWindow());
        * */

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        //File file = fileChooser.showSaveDialog(pleer.getScene().getWindow());
        File file = fileChooser.showOpenDialog(pleer.getScene().getWindow());
        System.out.println(file);

        pleer.setImage(new Image(file.toString().replace("\\", "/")));

        Image name =  new Image(String.valueOf(file)); // new Image("/" + (current + 1) + ".JPG");
        pleer.setImage(name);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}

/*
public void onChoseDirectory(ActionEvent actionEvent) {
final DirectoryChooser directoryChooser = new DirectoryChooser();
    final File selectedDirectory =  directoryChooser.showDialog(new Stage());

        if (selectedDirectory != null) {

                images_paths = selectedDirectory.listFiles(new FilenameFilter() {
@Override
public boolean accept(File dir, String name) {

        if(name.endsWith(".jpg")){
        return name.endsWith(".jpg");
        }else if(name.endsWith(".png")){
        return name.endsWith(".png");
        }else if(name.endsWith(".gif")){
        return name.endsWith(".gif");
        }else if(name.endsWith(".jpeg")){
        return name.endsWith(".jpeg");
        }
        return false;
        }
        });

        if(images_paths.length > 0) {

        pleer.setImage(new Image(images_paths[0].toString().replace("\\", "/")));

        imgs = new ImageCollection(images_paths);
        iterator = imgs.getIterator();

        System.out.println(Arrays.toString(images_paths));

        }else{
        System.out.println("В данной папке нет картинок");
        }
        }

        }
* */