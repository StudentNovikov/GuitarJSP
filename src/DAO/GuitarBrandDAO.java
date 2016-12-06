package DAO;

import guitar.GuitarBrand;
import guitar.GuitarType;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 05.12.2016.
 */
public class GuitarBrandDAO {
    private static GuitarBrandDAO guitarBrandDAO;

    private Map<Integer,String> guitarBrandMap = new HashMap<>();
    private GuitarBrandDAO(){}

    public static synchronized GuitarBrandDAO getInstance(){
        if (guitarBrandDAO == null){
            guitarBrandDAO = new GuitarBrandDAO();
        }
        return guitarBrandDAO;
    }
    private void createGuitarBrand(GuitarBrand guitarBrand, ResultSet result) throws SQLException{
        guitarBrand.setName(result.getString("name"));
        guitarBrand.setId(result.getInt("id"));
    }

    public List<GuitarBrand> getAllGuitarBrands() throws SQLException{
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITARBRAND ");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<GuitarBrand> returnedGuitarBrandList = new ArrayList<GuitarBrand>();
        while (resultSet.next()){
            GuitarBrand nextGuitarBrand = new GuitarBrand();
            createGuitarBrand(nextGuitarBrand,resultSet);
            returnedGuitarBrandList.add(nextGuitarBrand);
            addToMap(resultSet.getInt("id"),resultSet.getString("name"));
        }
        preparedStatement.close();
        connection.close();
        sendBrandMapToGuitar();
        return  returnedGuitarBrandList;
    }


    private void addToMap(int id,String value){
        guitarBrandMap.put(id,value);
    }

    private void sendBrandMapToGuitar(){
        GuitarDAO.getInstance().setGuitarBrandMap(guitarBrandMap);
    }

    private Connection connect () throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE", "ALEX","123qwe456asd");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return  connection;
    }

}
