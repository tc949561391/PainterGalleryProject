package com.market.beans;

import java.sql.Date;

public class Goods {
	private int id;
	private String name;
	private int count;
	private int salednumber;
	private int provider_id;
	private int price;
	private Date productDate;
	private Date saveDate;
	private String providerName;

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public Goods() {
		// TODO Auto-generated constructor stub
	}

	public Goods(int id, String name, int count, int salednumber, int provider_id,int price) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
		this.salednumber = salednumber;
		this.provider_id = provider_id;
		this.price=price;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", count=" + count + ", salednumber=" + salednumber
				+ ", provider_id=" + provider_id + "]";
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

	public int getSalednumber() {
		return salednumber;
	}

	public void setSalednumber(int salednumber) {
		this.salednumber = salednumber;
	}

	public int getProvider_id() {
		return provider_id;
	}

	public void setProvider_id(int provider_id) {
		this.provider_id = provider_id;
	}
}
