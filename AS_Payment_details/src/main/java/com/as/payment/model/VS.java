package com.as.payment.model;

public class VS {
	
	private Integer bookingId;
	private Integer customerId;
	
	// Vehicle properties
	private Integer vehicleId;
	private String vehicleType;
	private String makeOfVehicle;
	private String purchaseDate;
	private String lastServiceDate;
	
	// Service properties
	private Integer flagOilFilter;	
	private Integer flagBrakePads;
	private Integer flagEngineOil;
	private Integer flagAcFilter;
	private Integer flagWashing;
	private Integer flagPolishing;
	private Integer flagBatteryReplace;
	
	public VS() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VS(Integer bookingId, Integer customerId, Integer vehicleId, String vehicleType, String makeOfVehicle,
			String purchaseDate, String lastServiceDate, Integer flagOilFilter, Integer flagBrakePads,
			Integer flagEngineOil, Integer flagAcFilter, Integer flagWashing, Integer flagPolishing,
			Integer flagBatteryReplace) {
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.makeOfVehicle = makeOfVehicle;
		this.purchaseDate = purchaseDate;
		this.lastServiceDate = lastServiceDate;
		this.flagOilFilter = flagOilFilter;
		this.flagBrakePads = flagBrakePads;
		this.flagEngineOil = flagEngineOil;
		this.flagAcFilter = flagAcFilter;
		this.flagWashing = flagWashing;
		this.flagPolishing = flagPolishing;
		this.flagBatteryReplace = flagBatteryReplace;
	}
	
	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
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

	public Integer getFlagOilFilter() {
		return flagOilFilter;
	}

	public void setFlagOilFilter(Integer flagOilFilter) {
		this.flagOilFilter = flagOilFilter;
	}

	public Integer getFlagBrakePads() {
		return flagBrakePads;
	}

	public void setFlagBrakePads(Integer flagBrakePads) {
		this.flagBrakePads = flagBrakePads;
	}

	public Integer getFlagEngineOil() {
		return flagEngineOil;
	}

	public void setFlagEngineOil(Integer flagEngineOil) {
		this.flagEngineOil = flagEngineOil;
	}

	public Integer getFlagAcFilter() {
		return flagAcFilter;
	}

	public void setFlagAcFilter(Integer flagAcFilter) {
		this.flagAcFilter = flagAcFilter;
	}

	public Integer getFlagWashing() {
		return flagWashing;
	}

	public void setFlagWashing(Integer flagWashing) {
		this.flagWashing = flagWashing;
	}

	public Integer getFlagPolishing() {
		return flagPolishing;
	}

	public void setFlagPolishing(Integer flagPolishing) {
		this.flagPolishing = flagPolishing;
	}

	public Integer getFlagBatteryReplace() {
		return flagBatteryReplace;
	}

	public void setFlagBatteryReplace(Integer flagBatteryReplace) {
		this.flagBatteryReplace = flagBatteryReplace;
	}

	@Override
	public String toString() {
		return "VS [vehicleType=" + vehicleType + ", makeOfVehicle=" + makeOfVehicle + ", purchaseDate=" + purchaseDate
				+ ", lastServiceDate=" + lastServiceDate + "]";
	}
	
}
