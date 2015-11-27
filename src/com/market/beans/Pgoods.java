package com.market.beans;

import java.sql.Date;

public class Pgoods {
	private int id;
	private String name;
	private int count;
	private int providerid;
	private int providerprice;
	private Date productDate;
	private Date saveDate;
	private String providerName;

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public int getProviderprice() {
		return providerprice;
	}

	public void setProviderprice(int provider_price) {
		this.providerprice = provider_price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getProviderid() {
		return providerid;
	}

	public void setProviderid(int provider_id) {
		this.providerid = provider_id;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public Date getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}

	public Pgoods(int id, String name, int count, int provider_id) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
		this.providerid = provider_id;
	}

	public Pgoods() {
		super();
	}

	@Override
	public String toString() {
		return "Pgoods [id=" + id + ", name=" + name + ", count=" + count + ", provider_id=" + providerid
				+ ", provider_price=" + providerprice + ", productDate=" + productDate + ", saveDate=" + saveDate + "]";
	}

}
