package com.example.ccruzado.formulario.domain.model;

public class PedidoDomain {

    private String sec;
    private String operacion;
    private String puntodeventa;

    public PedidoDomain() {
    }

    public PedidoDomain(String sec, String operacion, String puntodeventa) {
        this.sec = sec;
        this.operacion = operacion;
        this.puntodeventa = puntodeventa;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getPuntodeventa() {
        return puntodeventa;
    }

    public void setPuntodeventa(String puntodeventa) {
        this.puntodeventa = puntodeventa;
    }
}
