package Model;

import Model.Acount.Player;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private static List<Player> playerList=new ArrayList<>();
    public String gameName;
    public DateFormat startEvent;
    public DateFormat endEvent;
    public String scoreEvent;
    public List<Event> list =new ArrayList<>();
    public Long eventId;

 /*************************************** constructor ******************************************/

    public Event(String gameName, DateFormat startEvent, DateFormat endEvent, String scoreEvent) {
        this.gameName = gameName;
        this.startEvent = startEvent;
        this.endEvent = endEvent;
        this.scoreEvent = scoreEvent;
    }

    public Event() {

    }

    /********* getter and setter ***************/
    public String getGameName() {
        return gameName;
    }

    public DateFormat getEventDate() {
        return eventDate;
    }

    public Long getEventId() {
        return eventId;
    }

    public Point getPoint() {
        return point;
    }


    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setEventDate(DateFormat eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public DateFormat getStartEvent() {
        return startEvent;
    }

    public DateFormat getEndEvent() {
        return endEvent;
    }

    public void setStartEvent(DateFormat startEvent) {
        this.startEvent = startEvent;
    }

    public void setEndEvent(DateFormat endEvent) {
        this.endEvent = endEvent;
    }

    /******* others method ********/

public static void participatingInEvent(Player playerId){
playerList.add(playerId);

    }
public void deleteEvent(Event event){
list.removeIf(evt -> event.getEventId() == evt.eventId);
}


public  void addEvent(String gameName,DateFormat startEvent,DateFormat endEvent,Long score){

}




}
