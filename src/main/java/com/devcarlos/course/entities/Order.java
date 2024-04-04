package com.devcarlos.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order") // isto é nome da tabela que vai ser criado la no banco de dados. 
// se nao tivesse dado  esse nome @Table(name = "tb_order") e pegaria directamente o nome da classe, no nosso caso vaai dar conflito porque "é palavra reservado "
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	// indica a nossa cheve primario é o atrebuto id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // isto é para gerar id automatimente
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-HH-dd'T'HH:mm.ss'Z'", timezone ="GMT" )
	private Instant moment;

	@ManyToOne // isto é para informaca a JPA que isso é uma relacao de muitos pora um
	// com isto a JPA vaai colocar isto cuma uma chave estrangeira

	@JoinColumn(name = "client_id") // assim infomamos o nome que esta chave estrangeiraa vai ter na no banco de
									// dados
	private User client;

	public Order() {

	}

	public Order(Long id, Instant moment, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

}
