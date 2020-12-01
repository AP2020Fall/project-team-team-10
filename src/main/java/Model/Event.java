package Model;

import java.text.DateFormat;

public class Event {
    public String gameName;
    public DateFormat eventDate;
    public String eventId;
    public Point point;

    public Event(String gameName, DateFormat eventDate, String eventId, Point point) {
        this.gameName = gameName;
        this.eventDate = eventDate;
        this.eventId = eventId;
        this.point = point;
    }


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
}
