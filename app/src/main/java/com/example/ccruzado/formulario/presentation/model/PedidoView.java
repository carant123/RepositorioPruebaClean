package com.example.ccruzado.formulario.presentation.model;

public class PedidoView {

    private String sec;
    private String operacion;
    private String puntodeventa;

    public PedidoView() {
    }

    public PedidoView(String sec, String operacion, String puntodeventa) {
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
