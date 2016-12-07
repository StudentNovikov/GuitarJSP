package DAO;

import guitar.GuitarType;
import java.sql.*;
import java.util.*;


/**
 * Created by Alex on 05.12.2016.
 */
public class GuitarTypeDAO {
    private static GuitarTypeDAO guitarTypeDAO;
    private Map<Integer,String> guitarTypeMap = new HashMap<>();
    private GuitarTypeDAO(){}

    public static synchronized GuitarTypeDAO getInstance(){
        if (guitarTypeDAO == null){
            guitarTypeDAO = new GuitarTypeDAO();
        }
        return guitarTypeDAO;
    }
    private void createGuitarType(GuitarType guitarType, ResultSet result) throws SQLException{
     guitarType.setName(result.getString("name"));
     guitarType.setId(result.getInt("id"));
    }

    public List<GuitarType> getAllGuitarTypes() throws SQLException{
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM GUITARTYPE ");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<GuitarType> returnedGuitarTypeList = new ArrayList<GuitarType>();
        while (resultSet.next()){
            GuitarType nextGuitarType = new GuitarType();
            createGuitarType(nextGuitarType,resultSet);
            returnedGuitarTypeList.add(nextGuitarType);
            addToMap(resultSet.getInt("id"),resultSet.getString("name"));
        }
        preparedStatement.close();
        connection.close();
        sendTypeMapToGuitar();
        return  returnedGuitarTypeList;
    }


    private void addToMap(int id,String value){
        guitarTypeMap.put(id,value);
    }

    private void sendTypeMapToGuitar(){
        GuitarDAO.getInstance().setGuitarTypeMap(guitarTypeMap);
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
