package com.example.ObjectModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ATHObject {
	
	private int id;
	private String titre;
	private int imageId;
	private String numTel;
	private Date heureMin;
	private Date heureMax;
	//Liste des jours checker à déterminer...
	List<String> listeSMS;
	
	//À ajouter dans les paramètre --> , Date heureMin, Date heureMax
	public ATHObject(int id, String titre, String numTel)
	{
		this.id = id;
		this.titre = titre;
		this.numTel = numTel;
		//this.heureMin = heureMin;
		//this.heureMax = heureMax;
		listeSMS = new ArrayList<String>();
	}

	public void ajouterSMS(String message)
	{
		listeSMS.add(message);
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public Date getHeureMin() {
		return heureMin;
	}

	public void setHeureMin(Date heureMin) {
		this.heureMin = heureMin;
	}

	public Date getHeureMax() {
		return heureMax;
	}

	public void setHeureMax(Date heureMax) {
		this.heureMax = heureMax;
	}

	public List<String> getListeSMS() {
		return listeSMS;
	}

	public void setListeSMS(List<String> listeSMS) {
		this.listeSMS = listeSMS;
	}
	
	

}
