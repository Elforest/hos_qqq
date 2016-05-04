package com.qqq.bean;

public class Shortterm_Ordermgt {
	private String shord_patic;
	private String shord_dateord;
	private String shord_timeord;
	private String shord_usr1;
	private String shord_drug;
	private String shord_actst;
	private String shord_dtactst;
	private String shord_usr2;
	private String shord_comment;
	private String shord_intake;
	private String shord_freq;
	private String shord_nurs;
	private String shord_medway;

	public Shortterm_Ordermgt() {
	}

	public Shortterm_Ordermgt(String shord_patic, String shord_dateord,
			String shord_timeord, String shord_usr1, String shord_drug,
			String shord_actst, String shord_dtactst, String shord_usr2,
			String shord_comment, String shord_intake, String shord_freq,
			String shord_nurs, String shord_medway) {
		super();
		this.shord_patic = shord_patic;
		this.shord_dateord = shord_dateord;
		this.shord_timeord = shord_timeord;
		this.shord_usr1 = shord_usr1;
		this.shord_drug = shord_drug;
		this.shord_actst = shord_actst;
		this.shord_dtactst = shord_dtactst;
		this.shord_usr2 = shord_usr2;
		this.shord_comment = shord_comment;
		this.shord_intake = shord_intake;
		this.shord_freq = shord_freq;
		this.shord_nurs = shord_nurs;
		this.shord_medway = shord_medway;
	}

	public String getShord_patic() {
		return shord_patic;
	}

	public void setShord_patic(String shord_patic) {
		this.shord_patic = shord_patic;
	}

	public String getShord_dateord() {
		return shord_dateord;
	}

	public void setShord_dateord(String shord_dateord) {
		this.shord_dateord = shord_dateord;
	}

	public String getShord_timeord() {
		return shord_timeord;
	}

	public void setShord_timeord(String shord_timeord) {
		this.shord_timeord = shord_timeord;
	}

	public String getShord_usr1() {
		return shord_usr1;
	}

	public void setShord_usr1(String shord_usr1) {
		this.shord_usr1 = shord_usr1;
	}

	public String getShord_drug() {
		return shord_drug;
	}

	public void setShord_drug(String shord_drug) {
		this.shord_drug = shord_drug;
	}

	public String getShord_actst() {
		return shord_actst;
	}

	public void setShord_actst(String shord_actst) {
		this.shord_actst = shord_actst;
	}

	public String getShord_dtactst() {
		return shord_dtactst;
	}

	public void setShord_dtactst(String shord_dtactst) {
		this.shord_dtactst = shord_dtactst;
	}

	public String getShord_usr2() {
		return shord_usr2;
	}

	public void setShord_usr2(String shord_usr2) {
		this.shord_usr2 = shord_usr2;
	}

	public String getShord_comment() {
		return shord_comment;
	}

	public void setShord_comment(String shord_comment) {
		this.shord_comment = shord_comment;
	}

	public String getShord_intake() {
		return shord_intake;
	}

	public void setShord_intake(String shord_intake) {
		this.shord_intake = shord_intake;
	}

	public String getShord_freq() {
		return shord_freq;
	}

	public void setShord_freq(String shord_freq) {
		this.shord_freq = shord_freq;
	}

	public String getShord_nurs() {
		return shord_nurs;
	}

	public void setShord_nurs(String shord_nurs) {
		this.shord_nurs = shord_nurs;
	}

	public String getShord_medway() {
		return shord_medway;
	}

	public void setShord_medway(String shord_medway) {
		this.shord_medway = shord_medway;
	}

	@Override
	public String toString() {
		return "Shortterm_Ordermgt [shord_patic=" + shord_patic
				+ ", shord_dateord=" + shord_dateord + ", shord_timeord="
				+ shord_timeord + ", shord_usr1=" + shord_usr1
				+ ", shord_drug=" + shord_drug + ", shord_actst=" + shord_actst
				+ ", shord_dtactst=" + shord_dtactst + ", shord_usr2="
				+ shord_usr2 + ", shord_comment=" + shord_comment
				+ ", shord_intake=" + shord_intake + ", shord_freq="
				+ shord_freq + ", shord_nurs=" + shord_nurs + ", shord_medway="
				+ shord_medway + "]";
	}

}
