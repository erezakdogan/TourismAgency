package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Helper.DBConnector;

public class Reservations {
    int id, roomId,  personCount, price;
    String names, nationality, hotelId, pasportNo;
    LocalDate sDate, eDate;
    String contactName,contactNote,contactPhone,contactMail;

    public Reservations(int id, int roomId, String hotelId, int personCount, int price, String names, String nationality,
            String pasportNo, LocalDate sDate, LocalDate eDate, String contactName, String contactNote, String contactPhone, String contactMail) {
        this.id = id;
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.personCount = personCount;
        this.price = price;
        this.names = names;
        this.nationality = nationality;
        this.pasportNo = pasportNo;
        this.sDate = sDate;
        this.eDate = eDate;
        this.contactName = contactName;
        this.contactNote = contactNote;
        this.contactPhone = contactPhone;
        this.contactMail = contactMail;

   
    }

    public static void addReservation(int roomId, int hotelId, int personCount, int price, String names,
            String nationality, String pasportNo, LocalDate sDate, LocalDate eDate, String contactName, String contactNote, String contactPhone, String contactMail) {
        String query = "INSERT INTO reservations (room_id, hotel_id, person_count, price, names, nationality, pasaportno, sdate, edate, contact_name, contact_note, contact_phone, contact_mail) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, roomId);
            preparedStatement.setInt(2, hotelId);
            preparedStatement.setInt(3, personCount);
            preparedStatement.setInt(4, price);
            preparedStatement.setString(5, names);
            preparedStatement.setString(6, nationality);
            preparedStatement.setString(7, pasportNo);
            preparedStatement.setString(8, sDate.toString());
            preparedStatement.setString(9, eDate.toString());
            preparedStatement.setString(10, contactName);
            preparedStatement.setString(11, contactNote);
            preparedStatement.setString(12, contactPhone);
            preparedStatement.setString(13, contactMail);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Reservations> getReservations(){
        ArrayList<Reservations> reservationsList = new ArrayList<>();
        Reservations  reservations;
        String query = "SELECT * FROM reservations;";
       try {
        Statement statement = DBConnector.getInstance().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            int id1 = resultSet.getInt("id");       
            int roomId1 = resultSet.getInt("room_id");
            int hotelId1 = resultSet.getInt("hotel_id");
            int personCount1 = resultSet.getInt("person_count");
            String names1 = resultSet.getString("names");
            String nationality1 = resultSet.getString("nationality");
            String pasportNo1 = resultSet.getString("pasaportno");
            int price1 = resultSet.getInt("price");
            LocalDate sDate1 = LocalDate.parse(resultSet.getString("sdate"), DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate eDate1 = LocalDate.parse(resultSet.getString("edate"), DateTimeFormatter.ISO_LOCAL_DATE);
            String contactName1 = resultSet.getString("contact_name");
            String contactNote1 = resultSet.getString("contact_note");
            String contactPhone1 = resultSet.getString("contact_phone");
            String contactMail1 = resultSet.getString("contact_mail");
            String hotelName = null;
            for(Hotel h: Hotel.getHotels("all")){
                if(h.getId()==hotelId1){
                    hotelName=h.getName();
                }
            }
            reservations = new Reservations(id1, roomId1, hotelName, personCount1, price1, names1, nationality1, pasportNo1, sDate1, eDate1, contactName1, contactNote1, contactPhone1, contactMail1);
            System.out.println(price1);
            reservationsList.add(reservations);

        }
       } catch (SQLException e) {
           e.printStackTrace();
       }

        return reservationsList;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return this.roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getHotelId() {
        return this.hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public int getPersonCount() {
        return this.personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNames() {
        return this.names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPasportNo() {
        return this.pasportNo;
    }

    public void setPasportNo(String pasportNo) {
        this.pasportNo = pasportNo;
    }

    public LocalDate getSDate() {
        return this.sDate;
    }

    public void setSDate(LocalDate sDate) {
        this.sDate = sDate;
    }

    public LocalDate getEDate() {
        return this.eDate;
    }

    public void setEDate(LocalDate eDate) {
        this.eDate = eDate;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNote() {
        return this.contactNote;
    }

    public void setContactNote(String contactNote) {
        this.contactNote = contactNote;
    }

    public String getContactPhone() {
        return this.contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactMail() {
        return this.contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

}
