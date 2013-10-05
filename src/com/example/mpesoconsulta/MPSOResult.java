package com.example.mpesoconsulta;

public class MPSOResult {
	public Boolean Error;
	public String Mensaje;
	public int FechaConsulta;
	public double Saldo;
	public String TarjetaTucNo;
	
	@Override
	public String toString() {
		return "# Tarjeta TUC: " + TarjetaTucNo + " Consulta de saldo: C$ " + Saldo;
	}
}
