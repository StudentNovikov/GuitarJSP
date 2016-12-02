package workingWithBase;
import guitar.guitar;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Alex on 27.11.2016.
 */
public class guitarSELECT {

    public static guitar byID (int id,Connection connection) throws SQLException{
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE ID=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        guitar returnedGuitar = new guitar(resultSet);
        preparedStatement.close();
        return  returnedGuitar;

    }

    public static guitar byName(String name,Connection connection) throws SQLException{
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE NAME=?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        guitar returnedGuitar = new guitar(resultSet);
        preparedStatement.close();
        return  returnedGuitar;
    }

    public static ArrayList<guitar> all(Connection connection) throws SQLException{
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR ");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<guitar> returnedGuitarList = new ArrayList<guitar>();
        while (resultSet.next()){
            returnedGuitarList.add(new guitar(resultSet));
        }
        preparedStatement.close();
        return  returnedGuitarList;
    }

    public static ArrayList<guitar> metalStrings(Connection connection) throws SQLException{
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE STRINGTYPE LIKE 'metal%'");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<guitar> returnedGuitarList = new ArrayList<guitar>();
        while (resultSet.next()){
            returnedGuitarList.add(new guitar(resultSet));
        }

        preparedStatement.close();
        return  returnedGuitarList;
    }

    public static ArrayList<guitar> nylonStrings(Connection connection) throws SQLException{
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE STRINGTYPE LIKE 'nylon%'");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<guitar> returnedGuitarList = new ArrayList<guitar>();
        while (resultSet.next()){
            returnedGuitarList.add(new guitar(resultSet));
        }

        preparedStatement.close();
        return  returnedGuitarList;
    }

    public static ArrayList<guitar> priceLimits(double low,double top,Connection connection) throws SQLException{
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE PRICE>=? AND PRICE <=?");
        preparedStatement.setDouble(1,low);
        preparedStatement.setDouble(2,top);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<guitar> returnedGuitarList = new ArrayList<guitar>();
        while (resultSet.next()){
            returnedGuitarList.add(new guitar(resultSet));
        }

        
        preparedStatement.close();
        return  returnedGuitarList;
    }

    public static ArrayList<guitar> byBrand(int brand,Connection connection) throws SQLException{
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITAR WHERE GUITARBRANDID =?");
        preparedStatement.setInt(1,brand);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<guitar> returnedGuitarList = new ArrayList<guitar>();
        while (resultSet.next()){
            returnedGuitarList.add(new guitar(resultSet));
        }

        preparedStatement.close();
        return  returnedGuitarList;
    }

}
