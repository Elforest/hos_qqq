package com.qqq.bean;

public class V_orders {
	private String patient_id;
	private String repeat_indicator;
	private String order_text;
	private String order_code;
	private String dosage;
	private String dosage_units;
	private String administration;
	private String start_date_time;
	private String doctor;

	public V_orders() {
	}

	public V_orders(String patient_id, String repeat_indicator,
			String order_text, String order_code, String dosage,
			String dosage_units, String administration, String start_date_time,
			String doctor) {
		super();
		this.patient_id = patient_id;
		this.repeat_indicator = repeat_indicator;
		this.order_text = order_text;
		this.order_code = order_code;
		this.dosage = dosage;
		this.dosage_units = dosage_units;
		this.administration = administration;
		this.start_date_time = start_date_time;
		this.doctor = doctor;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getRepeat_indicator() {
		return repeat_indicator;
	}

	public void setRepeat_indicator(String repeat_indicator) {
		this.repeat_indicator = repeat_indicator;
	}

	public String getOrder_text() {
		return order_text;
	}

	public void setOrder_text(String order_text) {
		this.order_text = order_text;
	}

	public String getOrder_code() {
		return order_code;
	}

	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getDosage_units() {
		return dosage_units;
	}

	public void setDosage_units(String dosage_units) {
		this.dosage_units = dosage_units;
	}

	public String getAdministration() {
		return administration;
	}

	public void setAdministration(String administration) {
		this.administration = administration;
	}

	public String getStart_date_time() {
		return start_date_time;
	}

	public void setStart_date_time(String start_date_time) {
		this.start_date_time = start_date_time;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "V_orders [patient_id=" + patient_id + ", repeat_indicator="
				+ repeat_indicator + ", order_text=" + order_text
				+ ", order_code=" + order_code + ", dosage=" + dosage
				+ ", dosage_units=" + dosage_units + ", administration="
				+ administration + ", start_date_time=" + start_date_time
				+ ", doctor=" + doctor + "]";
	}

}
