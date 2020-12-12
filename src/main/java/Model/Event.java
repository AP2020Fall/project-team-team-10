package Model;

import Model.Acount.Player;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private static List<Player> playerList=new ArrayList<>();
    public String gameName;
    public DateFormat eventDate;
    public DateFormat startEvent;
    public DateFormat endEvent;
    public String eventId;
    public Point point;
    public List<Event> list =new ArrayList<>();


    public Event(String gameName, DateFormat eventDate, DateFormat startEvent, DateFormat endEvent, String eventId, Point point) {
        this.gameName = gameName;
        this.eventDate = eventDate;
        this.startEvent = startEvent;
        this.endEvent = endEvent;
        this.eventId = eventId;
        this.point = point;
    }

    /********* getter and setter ***************/
    public String getGameName() {
        return gameName;
    }

    public DateFormat getEventDate() {
        return eventDate;
    }

    public String getEventId() {
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

    public void setEventId(String eventId) {
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
list.removeIf(evt -> event.getEventId().equals(evt.eventId));
}







}
