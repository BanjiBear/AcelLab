package io.acellab.service.web.startline.Util;

public enum UserPlan {
	STARTUP(1, "STARTUP"),
	FREE_PLAN(1, "FREE"),
	BUSINESS_PLAN(2, "BUSINESS"),
	ENTERPRISE_PLAN(3, "ENTERPRISE"),
	ERROR(-1, "ERROR");

	private Integer db_value;
	private final String plan;

	UserPlan(Integer db_value, String plan) {
		this.db_value = db_value;
		this.plan = plan;
	}
	
	//UserPlan(boolean b, String plan) {}

	public Integer getPlanValue() {return this.db_value;}
	public String getPlanName() {return this.plan;}
}