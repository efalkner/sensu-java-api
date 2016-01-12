package com.commercehub.sensu.api;


public class Event {
    private String id;
    private Client client;
    private EventCheck check;
    private int occurrences;
    private String action;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public EventCheck getCheck() {
        return check;
    }

    public void setCheck(EventCheck check) {
        this.check = check;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", client=" + client +
                ", check=" + check +
                ", occurrences=" + occurrences +
                ", action='" + action + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (occurrences != event.occurrences) return false;
        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (client != null ? !client.equals(event.client) : event.client != null) return false;
        if (check != null ? !check.equals(event.check) : event.check != null) return false;
        return !(action != null ? !action.equals(event.action) : event.action != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (check != null ? check.hashCode() : 0);
        result = 31 * result + occurrences;
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }

}
