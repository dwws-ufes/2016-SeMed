package br.ufes.inf.nemo.semed.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Semester extends PersistentObjectSupport implements Comparable<Semester> {

	private Integer year;
	private Integer number;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public int compareTo(Semester o){
		if (year == null)	return 1;
		if (o.year == null)	return -1;
		int cmp = year.compareTo(o.year);
		if (cmp != 0)	return cmp;
		
		if (number == null)	return 1;
		if (o.number == null)	return -1;
		cmp = number.compareTo(o.number);
		if (cmp != 0)	return cmp;
		
		return uuid.compareTo(o.uuid);
	}
	
}
