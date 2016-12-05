package DAO;
import guitar.Guitar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Alex on 05.12.2016.
 */
public class GuitarDAO {
    private static GuitarDAO guitarDAO;

    private GuitarDAO(){};

    public static synchronized GuitarDAO getInstance(){
        if (guitarDAO == null){
            guitarDAO = new GuitarDAO();
        }
        return guitarDAO;
    }

    public void createGuitar(Guitar guitar, ResultSet result) throws SQLException{
        guitar.setId(result.getInt("id"));
        guitar.setColor(result.getString("color"));
        guitar.setDescription(result.getString("description"));
        guitar.setGuitarBrandId(result.getInt("guitarBrandId"));
        guitar.setGuitarTypeId(result.getInt("guitarTypeId"));
        guitar.setName(result.getString("name"));
        guitar.setPhoto(result.getString("photo"));
        guitar.setPrice(result.getInt("price"));
        guitar.setStringType(result.getString("stringType"));

    }

    public Guitar getGuitarWithID(int id) throws SQLException{
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE ID=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Guitar returnedGuitar = new Guitar();
        createGuitar(returnedGuitar,resultSet);

        preparedStatement.close();
        connection.close();
        return  returnedGuitar;
    }

    public Guitar getGuitarWithName(String name) throws SQLException{
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE NAME=?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Guitar returnedGuitar = new Guitar();
        createGuitar(returnedGuitar,resultSet);
        preparedStatement.close();
        connection.close();
        return  returnedGuitar;
    }

    public List<Guitar> getAllGuitars() throws SQLException{
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR ");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Guitar> returnedGuitarList = new ArrayList<Guitar>();
        while (resultSet.next()){
            Guitar nextGuitar = new Guitar();
            createGuitar(nextGuitar,resultSet);
            returnedGuitarList.add(nextGuitar);
        }
        preparedStatement.close();
        connection.close();
        return  returnedGuitarList;
    }

    public List<Guitar> getSpecificStringGuitars(boolean ismetal) throws SQLException{
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        if (ismetal) {
            preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE STRINGTYPE LIKE 'metal%'");
        } else{
            preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE STRINGTYPE LIKE 'nylon%'");
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Guitar> returnedGuitarList = new ArrayList<Guitar>();
        while (resultSet.next()){
            Guitar nextGuitar = new Guitar();
            createGuitar(nextGuitar,resultSet);
            returnedGuitarList.add(nextGuitar);
        }

        preparedStatement.close();
        connection.close();
        return  returnedGuitarList;
    }

    public List<Guitar> getGuitarsWithSpecificPrice(double low, double top) throws SQLException{
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE PRICE>=? AND PRICE <=?");
        preparedStatement.setDouble(1,low);
        preparedStatement.setDouble(2,top);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Guitar> returnedGuitarList = new ArrayList<Guitar>();
        while (resultSet.next()){
            Guitar nextGuitar = new Guitar();
            createGuitar(nextGuitar,resultSet);
            returnedGuitarList.add(nextGuitar);
        }

        preparedStatement.close();
        connection.close();
        return  returnedGuitarList;
    }

    public List<Guitar> getGuitarWithBrand(int brand) throws SQLException{
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE GUITARBRANDID =?");
        preparedStatement.setInt(1,brand);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Guitar> returnedGuitarList = new ArrayList<Guitar>();
        while (resultSet.next()){
            Guitar nextGuitar=new Guitar();
            createGuitar(nextGuitar,resultSet);
            returnedGuitarList.add(nextGuitar);
        }

        preparedStatement.close();
        connection.close();
        return  returnedGuitarList;
    }

    private Connection connect () throws SQLException{
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
