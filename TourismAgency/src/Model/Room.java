package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnector;

public class Room {
    private int ids;
    private int bedCount;
    private int squareMeter;
    private int quantity;
    private boolean safe, projection, television, miniBar, gameConsole;
    private Pansiyon pansiyon;

    public Room(int ids, int bedCount, int squareMeter, boolean safe, boolean projection, boolean television,
            boolean miniBar, boolean gameConsole, Model.Pansiyon pansiyon, int quantity) {
        this.ids = ids;
        this.bedCount = bedCount;
        this.squareMeter = squareMeter;
        this.safe = safe;
        this.projection = projection;
        this.television = television;
        this.miniBar = miniBar;
        this.gameConsole = gameConsole;
        this.pansiyon = pansiyon;
        this.quantity = quantity;
    }

    public static void addRooms(String name, ArrayList<Room> rooms) {
        String query1 = "SELECT id FROM hotels WHERE name = '" + name + "' ;";
        int id = 0;
        try {
            Statement statement1 = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement1.executeQuery(query1);
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        String query = "INSERT INTO public.rooms(hotel_id, bed_count, square_meter, safe, projection, television, minibar, game_console, pansiyon,quantity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?); ";

        for (Room room : rooms) {
            try {
                PreparedStatement statement = DBConnector.getInstance().prepareStatement(query);
                statement.setInt(1, id);
                statement.setInt(2, room.getBedCount());
                statement.setInt(3, room.getSquareMeter());
                statement.setBoolean(4, room.isSafe());
                statement.setBoolean(5, room.isProjection());
                statement.setBoolean(6, room.isTelevision());
                statement.setBoolean(7, room.isMiniBar());
                statement.setBoolean(8, room.isGameConsole());
                statement.setString(9, room.getPansiyon().toString());
                statement.setInt(10, room.getQuantity());
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public static ArrayList<Room> getRooms(int id) {
        ArrayList<Room> roomArrayList = new ArrayList<>();
        Room room;
        String query = "SELECT * FROM rooms WHERE hotel_id = " + id;
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println(statement.toString());
            while (resultSet.next()) {
                int ids = resultSet.getInt("id");
                int bedCount = resultSet.getInt("bed_count");
                int squareMeter = resultSet.getInt("square_meter");
                boolean safe = resultSet.getBoolean("safe");
                boolean projection = resultSet.getBoolean("projection");
                boolean television = resultSet.getBoolean("television");
                boolean miniBar = resultSet.getBoolean("minibar");
                boolean gameConsole = resultSet.getBoolean("game_console");
                Model.Pansiyon pansiyon = Model.Pansiyon.valueOf(resultSet.getString("pansiyon"));
                int quantity = resultSet.getInt("quantity");
                room = new Room(ids, bedCount, squareMeter, safe, projection, television, miniBar, gameConsole,
                        pansiyon, quantity);
                roomArrayList.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomArrayList;
    }

    public static int getHotelId(int roomId) {
        String query = "SELECT hotel_id FROM rooms WHERE id = " + roomId;
        int hotelId = 0;
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                hotelId = resultSet.getInt("hotel_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hotelId;
    }

    public int getBedCount() {
        return bedCount;
    }

    public int getId() {
        return ids;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public int getSquareMeter() {
        return squareMeter;
    }

    public void setSquareMeter(int squareMeter) {
        this.squareMeter = squareMeter;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public boolean isProjection() {
        return projection;
    }

    public void setProjection(boolean projection) {
        this.projection = projection;
    }

    public boolean isTelevision() {
        return television;
    }

    public void setTelevision(boolean television) {
        this.television = television;
    }

    public boolean isMiniBar() {
        return miniBar;
    }

    public void setMiniBar(boolean miniBar) {
        this.miniBar = miniBar;
    }

    public boolean isGameConsole() {
        return gameConsole;
    }

    public void setGameConsole(boolean gameConsole) {
        this.gameConsole = gameConsole;
    }

    @Override
    public String toString() {
        return bedCount + " yataklı oda";
    }

    public Pansiyon getPansiyon() {
        return pansiyon;
    }

    public void setPansiyon(Pansiyon pansiyon) {
        this.pansiyon = pansiyon;
    }
}