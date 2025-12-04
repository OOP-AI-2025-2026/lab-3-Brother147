package ua.opnu;

/**
 * Прямокутний паралелепіпед (Box) із довжиною, шириною та висотою.
 * Сторона не може бути нульовою або від'ємною.
 */
public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    /**
     * Повна площа поверхні:
     * S = 2(lw + lh + wh)
     */
    public double getSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }

    /**
     * Площа бічної поверхні:
     * S_бічна = 2h(l + w)
     */
    public double getLateralSurfaceArea() {
        return 2 * height * (length + width);
    }

    /**
     * Обʼєм:
     * V = l * w * h
     */
    public double getVolume() {
        return length * width * height;
    }
}
