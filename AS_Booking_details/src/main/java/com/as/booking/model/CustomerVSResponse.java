package com.as.booking.model;

public class CustomerVSResponse {

	private Customer customer;
	private String vehicleType;
	private String makeOfVehicle;
	private String purchaseDate;
	private String lastServiceDate;
	private String change_Oil_Filter;	
	private String change_Brake_Pads;
	private String change_Engine_Oil;
	private String change_AC_Filter;
	private String do_Washing;
	private String do_Polishing;
	private String do_Battery_Replace;
	
	public CustomerVSResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CustomerVSResponse(Customer customer, String vehicleType, String makeOfVehicle, String purchaseDate,
			String lastServiceDate, String change_Oil_Filter, String change_Brake_Pads, String change_Engine_Oil,
			String change_AC_Filter, String do_Washing, String do_Polishing, String do_Battery_Replace) {
		super();
		this.customer = customer;
		this.vehicleType = vehicleType;
		this.makeOfVehicle = makeOfVehicle;
		this.purchaseDate = purchaseDate;
		this.lastServiceDate = lastServiceDate;
		this.change_Oil_Filter = change_Oil_Filter;
		this.change_Brake_Pads = change_Brake_Pads;
		this.change_Engine_Oil = change_Engine_Oil;
		this.change_AC_Filter = change_AC_Filter;
		this.do_Washing = do_Washing;
		this.do_Polishing = do_Polishing;
		this.do_Battery_Replace = do_Battery_Replace;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getMakeOfVehicle() {
		return makeOfVehicle;
	}

	public void setMakeOfVehicle(String makeOfVehicle) {
		this.makeOfVehicle = makeOfVehicle;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(String lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	public String getChange_Oil_Filter() {
		return change_Oil_Filter;
	}

	public void setChange_Oil_Filter(String change_Oil_Filter) {
		this.change_Oil_Filter = change_Oil_Filter;
	}

	public String getChange_Brake_Pads() {
		return change_Brake_Pads;
	}

	public void setChange_Brake_Pads(String change_Brake_Pads) {
		this.change_Brake_Pads = change_Brake_Pads;
	}

	public String getChange_Engine_Oil() {
		return change_Engine_Oil;
	}

	public void setChange_Engine_Oil(String change_Engine_Oil) {
		this.change_Engine_Oil = change_Engine_Oil;
	}

	public String getChange_AC_Filter() {
		return change_AC_Filter;
	}

	public void setChange_AC_Filter(String change_AC_Filter) {
		this.change_AC_Filter = change_AC_Filter;
	}

	public String getDo_Washing() {
		return do_Washing;
	}

	public void setDo_Washing(String do_Washing) {
		this.do_Washing = do_Washing;
	}

	public String getDo_Polishing() {
		return do_Polishing;
	}

	public void setDo_Polishing(String do_Polishing) {
		this.do_Polishing = do_Polishing;
	}

	public String getdo_Battery_Replace() {
		return do_Battery_Replace;
	}

	public void setdo_Battery_Replace(String do_Battery_Replace) {
		this.do_Battery_Replace = do_Battery_Replace;
	}
	
	public CustomerVSResponse response(VS vs, Customer customer) {
		
		CustomerVSResponse customerVSResponse = new CustomerVSResponse();
		
		customerVSResponse.setCustomer(customer);
		customerVSResponse.setVehicleType(vs.getVehicleType());
		customerVSResponse.setMakeOfVehicle(vs.getMakeOfVehicle());
		customerVSResponse.setPurchaseDate(vs.getPurchaseDate());
		customerVSResponse.setLastServiceDate(vs.getLastServiceDate());
		
		if(vs.getFlagOilFilter()==1)
			customerVSResponse.setChange_Oil_Filter("Yes");
		else customerVSResponse.setChange_Oil_Filter("No");
		if(vs.getFlagBrakePads()==1)
			customerVSResponse.setChange_Brake_Pads("Yes");
		else customerVSResponse.setChange_Brake_Pads("No");
		if(vs.getFlagEngineOil()==1)
			customerVSResponse.setChange_Engine_Oil("Yes");
		else customerVSResponse.setChange_Engine_Oil("No");
		if(vs.getFlagAcFilter()==1)
			customerVSResponse.setChange_AC_Filter("Yes");
		else customerVSResponse.setChange_AC_Filter("No");
		if(vs.getFlagWashing()==1)
			customerVSResponse.setDo_Washing("Yes");
		else customerVSResponse.setDo_Washing("No");
		if(vs.getFlagPolishing()==1)
			customerVSResponse.setDo_Polishing("Yes");
		else customerVSResponse.setDo_Polishing("No");
		if(vs.getFlagBatteryReplace()==1)
			customerVSResponse.setdo_Battery_Replace("Yes");
		else customerVSResponse.setdo_Battery_Replace("No");
		
		return customerVSResponse;
	}
	
	@Override
	public String toString() {
		return "CustomerVSResponse [customer=" + customer + ", vehicleType=" + vehicleType + ", makeOfVehicle="
				+ makeOfVehicle + ", purchaseDate=" + purchaseDate + ", lastServiceDate=" + lastServiceDate
				+ ", change_Oil_Filter=" + change_Oil_Filter + ", change_Brake_Pads=" + change_Brake_Pads
				+ ", change_Engine_Oil=" + change_Engine_Oil + ", change_AC_Filter=" + change_AC_Filter
				+ ", do_Washing=" + do_Washing + ", do_Polishing=" + do_Polishing + ", do_Battery_Replace="
				+ do_Battery_Replace + "]";
	}
	
}
