package com.example.practicaextra.models;

public class Operacion {
    private Double numero1;
    private Double numero2;
    private Double resultado;
    private String nombre;
    private String imgUrl;


    public Operacion (String nombre){
        this.nombre = nombre;
    }
    public Operacion (Double numero1, Double numero2, String nombre, String imgUrl){
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.nombre = nombre;
        this.imgUrl = imgUrl;
    }
    public void setNumero1(Double numero1) {
        this.numero1 = numero1;
    }
    public void setNumero2(Double numero2) {
        this.numero2 = numero2;
    }
    public Double getResultado() {
        return resultado;
    }
    public String getNombre() {
        return nombre;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public void suma(){
        resultado = numero1 + numero2;
    }
    public void resta(){
        resultado = numero1 - numero2;
    }
    public void multiplicacion(){
        resultado = numero1 * numero2;
    }
    public void division(){
        resultado = numero1 / numero2;
    }
}
