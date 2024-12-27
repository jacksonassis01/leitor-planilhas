package com.models;

public class Veiculo {
    String modelo;
    String marca;
    double valor;

    public Veiculo(String modelo, String marca, double valor) {
        this.modelo = modelo;
        this.marca = marca;
        this.valor = valor;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public double getValor() {
        return valor;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Veiculo [modelo=" + modelo + ", marca=" + marca + ", valor=" + valor + "]";
    }
}
