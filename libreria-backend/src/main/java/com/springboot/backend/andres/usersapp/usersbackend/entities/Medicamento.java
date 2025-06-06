package com.springboot.backend.andres.usersapp.usersbackend.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "materiales")
public class Medicamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    public Double getPrecioCompra() {
        return PrecioCompra;
    }
    public void setPrecioCompra(Double precioCompra) {
        PrecioCompra = precioCompra;
    }
    public Double getPrecioMayor() {
        return PrecioMayor;
    }
    public void setPrecioMayor(Double precioMayor) {
        PrecioMayor = precioMayor;
    }
    private String nombre;
    private Double precio;
    private Double PrecioCompra;
    private Double PrecioMayor;
    private String categoria;

    @ManyToOne
    private Laboratorio laboratorio;

    //no muestra nada de venta. correcto
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonIgnoreProperties({"medicamento", "handler", "hibernateLazyInitializer"})
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "medicamento")
    private List<DetalleVenta> detalleVentas;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonIgnoreProperties({"medicamento", "handler", "hibernateLazyInitializer"})
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "medicamento")
    private List<DetalleAlmacen> detalleAlmacenes;

    
    
    public Medicamento() {
        detalleVentas = new ArrayList<>();
    }
    public Medicamento(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
    
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public List<DetalleAlmacen> getDetalleAlmacenes() {
        return detalleAlmacenes;
    }
    public void setDetalleAlmacenes(List<DetalleAlmacen> detalleAlmacenes) {
        this.detalleAlmacenes = detalleAlmacenes;
    }
    public List<DetalleVenta> getDetalleVentas() {
        return detalleVentas;
    }
    public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
        this.detalleVentas = detalleVentas;
    }
    public Laboratorio getLaboratorio() {
        return laboratorio;
    }
    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
    
}
