package br.com.desafio_berkan.model;

public class Inss {

	private int id_inss;
	private double salario_inss;
	private double aliquota_inss;
	
	public int getId_inss() {
		return id_inss;
	}
	
	public void setId_inss(int id_inss) {
		this.id_inss = id_inss;
	}
	
	public double getSalario_inss() {
		return salario_inss;
	}
	
	public void setSalario_inss(double salario_inss) {
		this.salario_inss = salario_inss;
	}
	
	public double getAliquota_inss() {
		return aliquota_inss;
	}
	
	public void setAliquota_inss(double aliquota_inss) {
		this.aliquota_inss = aliquota_inss;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(aliquota_inss);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id_inss;
		temp = Double.doubleToLongBits(salario_inss);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inss other = (Inss) obj;
		if (Double.doubleToLongBits(aliquota_inss) != Double.doubleToLongBits(other.aliquota_inss))
			return false;
		if (id_inss != other.id_inss)
			return false;
		if (Double.doubleToLongBits(salario_inss) != Double.doubleToLongBits(other.salario_inss))
			return false;
		return true;
	}

}