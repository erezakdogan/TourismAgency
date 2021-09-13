package Helper;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import Model.Pansiyon;
import Model.Room;

public class Calculator {
    final static double commission = 1.15;

    public static int calculate(Boolean inPeriod, Room room, LocalDate sDate, LocalDate eDate, int persons) {
        double roomClassChange = 1.0;

        Pansiyon pansiyon = room.getPansiyon();
        double roomBaseBrice = 500;
        double finalPrice;
        switch (pansiyon) {
            case ULTRA:
            roomClassChange =1.25;
            break;
            case EVERYTHING:
            roomClassChange =1.20;
            break;
            case BREAKFAST:
            roomClassChange =1.15;
            break;
            case FULL:
            roomClassChange =1.10;
            break;
            case HALF:
            roomClassChange =1.5;
            break;
            case BED:
            roomClassChange =1.0;
            break;
            case NO_ALCOHOL:
            roomClassChange =1.0;
            break;
        }
        
        if(inPeriod){
            finalPrice = (roomBaseBrice*roomClassChange*1.25*(ChronoUnit.DAYS.between(sDate, eDate)))*commission;
            System.out.println((ChronoUnit.DAYS.between(sDate, eDate)));
        }else{
            finalPrice = (roomBaseBrice*roomClassChange*(ChronoUnit.DAYS.between(sDate, eDate)))*commission;
            System.out.println((ChronoUnit.DAYS.between(sDate, eDate)));

        }
        Integer price = (int) finalPrice;
        return price;
    }
}
