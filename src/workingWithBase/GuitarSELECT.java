package workingWithBase;
import guitar.Guitar;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Alex on 27.11.2016.
 */
public class GuitarSELECT {

    public static Guitar byID (int id, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE ID=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Guitar returnedGuitar = new Guitar(resultSet);
        preparedStatement.close();
        return  returnedGuitar;

    }

    public static Guitar byName(String name, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE NAME=?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Guitar returnedGuitar = new Guitar(resultSet);
        preparedStatement.close();
        return  returnedGuitar;
    }

    public static ArrayList<Guitar> all(Connection connection) throws SQLException{
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR ");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Guitar> returnedGuitarList = new ArrayList<Guitar>();
        while (resultSet.next()){
            returnedGuitarList.add(new Guitar(resultSet));
        }
        preparedStatement.close();
        return  returnedGuitarList;
    }

    public static ArrayList<Guitar> metalStrings(Connection connection) throws SQLException{
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE STRINGTYPE LIKE 'metal%'");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Guitar> returnedGuitarList = new ArrayList<Guitar>();
        while (resultSet.next()){
            returnedGuitarList.add(new Guitar(resultSet));
        }

        preparedStatement.close();
        return  returnedGuitarList;
    }

    public static ArrayList<Guitar> nylonStrings(Connection connection) throws SQLException{
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE STRINGTYPE LIKE 'nylon%'");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Guitar> returnedGuitarList = new ArrayList<Guitar>();
        while (resultSet.next()){
            returnedGuitarList.add(new Guitar(resultSet));
        }

        preparedStatement.close();
        return  returnedGuitarList;
    }

    public static ArrayList<Guitar> priceLimits(double low, double top, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE PRICE>=? AND PRICE <=?");
        preparedStatement.setDouble(1,low);
        preparedStatement.setDouble(2,top);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Guitar> returnedGuitarList = new ArrayList<Guitar>();
        while (resultSet.next()){
            returnedGuitarList.add(new Guitar(resultSet));
        }

        
        preparedStatement.close();
        return  returnedGuitarList;
    }

    public static ArrayList<Guitar> byBrand(int brand, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE GUITARBRANDID =?");
        preparedStatement.setInt(1,brand);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Guitar> returnedGuitarList = new ArrayList<Guitar>();
        while (resultSet.next()){
            returnedGuitarList.add(new Guitar(resultSet));
        }

        preparedStatement.close();
        return  returnedGuitarList;
    }

}
