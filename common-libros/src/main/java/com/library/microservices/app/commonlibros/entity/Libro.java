package com.library.microservices.app.commonlibros.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name="libros")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    
    @Column(name = "titulo")
    private String title;
    
    @Column(name = "referencia")
    private String reference;
    
    @Column(name = "autor")
    private String author;
    
    @Column(name = "categoria")
    private String category;
    
    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

}
