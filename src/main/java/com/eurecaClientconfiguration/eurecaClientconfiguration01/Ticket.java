package com.eurecaClientconfiguration.eurecaClientconfiguration01;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TBL_TICKET")
public class Ticket {

	@Id
	@SequenceGenerator(name = "TICKET_ID_SEQUNCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TICKET_ID_SEQUNCE")
	private int ticketid;
	private String source;
	private String destination;
	private String passengername;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date travelingdate;
	private double ticketfare;

	public int getTicketid() {
		return ticketid;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPassengername() {
		return passengername;
	}

	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}

	public Date getTravelingdate() {
		return travelingdate;
	}

	public void setTravelingdate(Date travelingdate) {
		this.travelingdate = travelingdate;
	}

	public double getTicketfare() {
		return ticketfare;
	}

	public void setTicketfare(double ticketfare) {
		this.ticketfare = ticketfare;
	}

	@Override
	public String toString() {
		return "Ticket [ticketid=" + ticketid + ", source=" + source + ", destination=" + destination
				+ ", passengername=" + passengername + ", travelingdate=" + travelingdate + ", ticketfare=" + ticketfare
				+ "]";
	}

}
