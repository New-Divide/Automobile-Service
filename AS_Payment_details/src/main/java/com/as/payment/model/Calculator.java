package com.as.payment.model;

public class Calculator {
	
	private Double amount;
	
	public Double calculateAmount(VS vs) {
		
		amount=0.00;
		
		if(vs.getFlagOilFilter()==1 & vs.getVehicleType().equals("Four-Wheeler"))
			amount += 400.00;
		if(vs.getFlagBrakePads()==1 & vs.getVehicleType().equals("Four-Wheeler"))
			amount += 1000.00;
		if(vs.getFlagEngineOil()==1 & vs.getVehicleType().equals("Four-Wheeler"))
			amount += 2200.00;
		if(vs.getFlagEngineOil()==1 & vs.getVehicleType().equals("Two-Wheeler"))
			amount += 800.00;
		if(vs.getFlagAcFilter()==1 & vs.getVehicleType().equals("Four-Wheeler"))
			amount += 300.00;
		if(vs.getFlagWashing()==1 & vs.getVehicleType().equals("Four-Wheeler"))
			amount += 200.00;
		if(vs.getFlagWashing()==1 & vs.getVehicleType().equals("Two-Wheeler"))
			amount += 200.00;
		if(vs.getFlagPolishing()==1 & vs.getVehicleType().equals("Four-Wheeler"))
			amount += 1500.00;
		if(vs.getFlagPolishing()==1 & vs.getVehicleType().equals("Two-Wheeler"))
			amount += 300.00;
		if(vs.getFlagBatteryReplace()==1 & vs.getVehicleType().equals("Four-Wheeler"))
			amount += 4800.00;
		if(vs.getFlagBatteryReplace()==1 & vs.getVehicleType().equals("Two-Wheeler"))
			amount += 2100.00;
		
		return amount;
	}
}
