package br.com.desafio_berkan.model;

public class Irpf {
	
	private int id_irpf;
	private double salario_irpf;
	private double aliquota_irpf;
	private double desconto_irpf;
	
	public int getId_irpf() {
		return id_irpf;
	}
	
	public void setId_irpf(int id_irpf) {
		this.id_irpf = id_irpf;
	}
	
	public double getSalario_irpf() {
		return salario_irpf;
	}
	
	public void setSalario_irpf(double salario_irpf) {
		this.salario_irpf = salario_irpf;
	}
	
	public double getAliquota_irpf() {
		return aliquota_irpf;
	}
	
	public void setAliquota_irpf(double aliquota_irpf) {
		this.aliquota_irpf = aliquota_irpf;
	}
	
	public double getDesconto_irpf() {
		return desconto_irpf;
	}
	
	public void setDesconto_irpf(double desconto_irpf) {
		this.desconto_irpf = desconto_irpf;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(aliquota_irpf);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(desconto_irpf);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id_irpf;
		temp = Double.doubleToLongBits(salario_irpf);
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
		Irpf other = (Irpf) obj;
		if (Double.doubleToLongBits(aliquota_irpf) != Double.doubleToLongBits(other.aliquota_irpf))
			return false;
		if (Double.doubleToLongBits(desconto_irpf) != Double.doubleToLongBits(other.desconto_irpf))
			return false;
		if (id_irpf != other.id_irpf)
			return false;
		if (Double.doubleToLongBits(salario_irpf) != Double.doubleToLongBits(other.salario_irpf))
			return false;
		return true;
	}
	
}