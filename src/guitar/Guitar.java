package guitar;
import java.sql.*;
/**
 * Created by Alex on 27.11.2016.
 */
public class Guitar {
    private int id;
    private String name;
    private String description;
    private double price;
    private String color;
    private String stringType;
    private String photo;
    private int guitarBrandId;
    private int guitarTypeId;
    public Guitar(){};

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

    public void setGuitarBrandId(int guitarBrandId) {
        this.guitarBrandId = guitarBrandId;
    }

    public void setGuitarTypeId(int guitarTypeId) {
        this.guitarTypeId = guitarTypeId;
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

    public int getGuitarBrandId() {
        return guitarBrandId;
    }

    public int getGuitarTypeId() {
        return guitarTypeId;
    }

}
