package Builders;

import javafx.scene.image.Image;

import java.io.File;

public class ImageCollection implements Aggregate {
    private Image bi;
    private File[] img_list;
    public ImageCollection(File[] img_list) {
        this.img_list = img_list;
    }

    private class ImageIterator implements Iterator {
        private int current = 0;

        @Override
        public boolean hasNext() {
            String filename = "/" + (current + 1) + ".JPG";
            System.out.println(filename + " next");
            try {
                bi = new Image(filename);
                return true;
            } catch (Exception ex) {
                current = 0;
                bi = new Image("/" + (current + 1) + ".JPG");
                return true;
            }
        }

        @Override
        public Object next() {
            current++;
            return bi;
        }

        public boolean hasPreview() {
            String filename = null;
            System.out.println(current + "prew");

            if (current >= 2) {
                filename = "/" + (current - 1) + ".JPG";
            }
            System.out.println(filename);
            try {
                bi = new Image(filename);
                return true;
            } catch (Exception ex) {
                System.err.println("Не удалось загрузить картинку! " + filename);
                return false;
            }
        }

        @Override
        public Object preview() {
            current--;
            return bi;
        }

        @Override
        public Object returnone() {
            if ((current - 1) == 0) {
                current = current + 4;
            } else {
                current--;
            }
            return bi;
        }
    }

    @Override
    public Iterator getIterator() {
        return new ImageIterator();
    }
}

