package Model;

import java.util.ArrayList;
import Helper.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Hotel {
    private int id;
    private String name;
    private String adress;
    private String email;
    private String phone;
    private int star;
    private boolean carpark, wifi, pool, gym, concierge, spa, roomService;
    private LocalDate perStart, perEnd;

    public Hotel() {
    }

    public Hotel(int id, String name, String adress, String email, String phone, int star, LocalDate perStart, LocalDate perEnd, boolean carpark, boolean wifi,
            boolean pool, boolean gym, boolean concierge, boolean spa, boolean roomService) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.phone = phone;
        this.star = star;
        this.perStart = perStart;
        this.perEnd = perEnd;
        this.carpark = carpark;
        this.wifi = wifi;
        this.pool = pool;
        this.gym = gym;
        this.concierge = concierge;
        this.spa = spa;
        this.roomService = roomService;
    }

    public void addHotel(String name, String adress, String email, String phone, int star, LocalDate perStart, LocalDate perEnd, boolean carpark,
            boolean wifi, boolean pool, boolean gym, boolean concierge, boolean spa, boolean roomService) {
        String query = "INSERT INTO public.hotels (name,address,email,phone,star,park,wifi,pool,gym,spa,concierge,roomservice,per_start, per_end) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, adress);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone);
            preparedStatement.setInt(5, star);
            preparedStatement.setBoolean(6, carpark);
            preparedStatement.setBoolean(7, wifi);
            preparedStatement.setBoolean(8, pool);
            preparedStatement.setBoolean(9, gym);
            preparedStatement.setBoolean(10, spa);
            preparedStatement.setBoolean(11, concierge);
            preparedStatement.setBoolean(12, roomService);
            preparedStatement.setString(13, perStart.toString());
            preparedStatement.setString(14, perEnd.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Hotel> getHotels(String add) {
        ArrayList<Hotel> hotelArrayList = new ArrayList<>();
        String query = null;
        if(add!="all"){
        query = "SELECT * FROM hotels WHERE address = '"+add+"'";
        }else{
            query = "SELECT * FROM hotels;";

        }
        Hotel hotel;
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String adress = resultSet.getString("address");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                LocalDate perStart = LocalDate.parse(resultSet.getString("per_start"),DateTimeFormatter.ISO_LOCAL_DATE);
                LocalDate perEnd = LocalDate.parse(resultSet.getString("per_end"),DateTimeFormatter.ISO_LOCAL_DATE);
                int star = resultSet.getInt("star");
                boolean carpark = resultSet.getBoolean("park");
                boolean wifi = resultSet.getBoolean("wifi");
                boolean pool = resultSet.getBoolean("pool");
                boolean gym = resultSet.getBoolean("gym");
                boolean concierge = resultSet.getBoolean("concierge");
                boolean spa = resultSet.getBoolean("spa");
                boolean roomService = resultSet.getBoolean("roomservice");
                hotel = new Hotel(id, name, adress, email, phone, star, perStart, perEnd, carpark, wifi, pool, gym, concierge, spa,
                        roomService);
                hotelArrayList.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hotelArrayList;
    }


    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

   

    public boolean isCarpark() {
        return carpark;
    }

    public void setCarpark(boolean carpark) {
        this.carpark = carpark;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isGym() {
        return gym;
    }

    public void setGym(boolean gym) {
        this.gym = gym;
    }

    public boolean isConcierge() {
        return concierge;
    }

    public void setConcierge(boolean concierge) {
        this.concierge = concierge;
    }

    public boolean isSpa() {
        return spa;
    }

    public void setSpa(boolean spa) {
        this.spa = spa;
    }

    public boolean isRoomService() {
        return roomService;
    }

    public void setRoomService(boolean roomService) {
        this.roomService = roomService;
    }

    public LocalDate getPerStart() {
        return this.perStart;
    }

    public void setPerStart(LocalDate perStart) {
        this.perStart = perStart;
    }

    public LocalDate getPerEnd() {
        return this.perEnd;
    }

    public void setPerEnd(LocalDate perEnd) {
        this.perEnd = perEnd;
    }


    @Override
    public String toString() {
        return "Hotel{" + "name='" + name + '\'' + ", adress='" + adress + '\'' + ", email='" + email + '\''
                + ", phone='" + phone + '\'' + ", star=" + star + ", carpark=" + carpark + ", wifi=" + wifi + ", pool="
                + pool + ", gym=" + gym + ", concierge=" + concierge + ", spa=" + spa + ", roomService=" + roomService
                + '}';
    }
}