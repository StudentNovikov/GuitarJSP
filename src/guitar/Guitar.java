package guitar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 27.11.2016.
 */
public class Guitar {

    public Guitar(){};
    private int id;
    private String name;
    private String description;
    private double price;
    private String color;
    private String stringType;
    private String photo;
    private String guitarBrand;
    private String guitarType;

    public String getGuitarBrand() {
        return guitarBrand;
    }

    public void setGuitarBrand(String guitarBrand) {
        this.guitarBrand = guitarBrand;
    }

    public String getGuitarType() {
        return guitarType;
    }

    public void setGuitarType(String guitarType) {
        this.guitarType = guitarType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setStringType(String stringType) {
        this.stringType = stringType;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getStringType() {
        return stringType;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return "Guitar name: " + getName() + " , price is " +getPrice()+" $";
    }
}
