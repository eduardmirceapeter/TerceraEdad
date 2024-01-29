package com.example.terceraedad;

public class Event {
    private String title;
    private String fecha;

    public Event(String title, String fecha) {
        this.title = title;
        this.fecha = fecha;
    }

    public String getTitle() {
        return title;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }
}
