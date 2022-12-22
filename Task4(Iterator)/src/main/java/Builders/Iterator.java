package Builders;

public interface Iterator {
    public boolean hasNext();
    public Object next();
    public Object preview();
    public Object returnone();
    boolean hasPreview();
}
