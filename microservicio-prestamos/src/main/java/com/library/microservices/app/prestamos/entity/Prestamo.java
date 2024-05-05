package com.library.microservices.app.prestamos.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.library.microservices.app.commonlibros.entity.Libro;
import com.library.microservices.app.commonusuarios.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name="prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fecha_incio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    
    @Column(name = "munOrden")
    private String orderNum;
    
    @Column(name = "fecha_fin")
    private String endDate;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
    private String observacion;
    
    @Column(name = "estado")
    private boolean state;
    
    @Column(name = "multa")
    private int penalty;
    
    @Column(name = "cantidad_libros")
    private int booksQuantity;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "libro_id")
    private List<Libro> books;
    
    
    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
        this.state = true;
        this.penalty = 0;
    }
}
