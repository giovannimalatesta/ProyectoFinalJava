package edu.ar.model;

public class Pelicula {

//Atributos y metodos
    private int id;
    private String titulo;
    private String descripcion;
    private String genero;
    private int calificacion;
    private int anio;
    private byte estrellas;
    private String director;

//constructorres
    public Pelicula(int idx, String tit, String desc, String gen, int calif, int an, byte estrellas, String dir){
        this.id = idx;
        this.titulo = tit;
        this.descripcion = desc;
        this.genero = gen;
        this.calificacion = calif;
        this.anio = an; 
        this.estrellas = estrellas;
        this.director = dir;
    }
    public Pelicula(String titulo, String descripcion, String genero, int calificacion, int anio, byte estrellas, String director) {
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.genero = genero;
    this.calificacion = calificacion;
    this.anio = anio;
    this.estrellas = estrellas;
    this.director = director;
  }
  //----------------------  
  //getters y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }


    public int getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }


    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }


    public byte getEstrellas() {
        return estrellas;
    }
    public void setEstrellas(byte estrellas) {
        this.estrellas = estrellas;
    }


    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }


    public boolean esEstreno(){
        boolean estreno = false;
        if(anio == 2024){
            estreno = true;
        }
        return estreno;
    }



    //métodos personalizados
  @Override
  public String toString() {
    return "Pelicula [id=" + id + ", nombre=" + titulo + ", anio=" + anio + ", genero=" + genero + ", descripcion="
        + descripcion + ", calificacion=" + calificacion + ", estrellas=" + estrellas + ", director= " + director + "]";
  }


   
     
}
