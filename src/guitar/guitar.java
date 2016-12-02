package guitar;
import java.sql.*;
/**
 * Created by Alex on 27.11.2016.
 */
public class guitar {
    private int id;
    private String name;
    private String description;
    private double price;
    private String color;
    private String stringType;
    private String photo;
    private int guitarBrandId;
    private int guitarTypeId;

    public guitar(ResultSet result) throws SQLException{
        this.id= result.getInt("id");
        this.name=result.getString("name");
        this.description=result.getString("description");
        this.price=result.getDouble("price");
        this.color=result.getString("color");
        this.stringType=result.getString("stringType");
        this.photo=result.getString("photo");
        this.guitarBrandId=result.getInt("guitarBrandId");
        this.guitarTypeId=result.getInt("guitarTypeId");
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

    public void print(){
        System.out.println(id+" | "+name+" | "+description+" | "+ price+" | "+ color+ " | "+ stringType+" | "+photo+" | "+guitarBrandId+" | "+guitarTypeId);

    }
}
