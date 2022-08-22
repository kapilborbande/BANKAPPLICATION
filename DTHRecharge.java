package Bank.model;

public class DTHRecharge 
{
	private String custid;
	private double rechargeamt;
	private String servicep;
	public DTHRecharge(String custid, double rechargeamt, String servicep) {
		super();
		this.custid = custid;
		this.rechargeamt = rechargeamt;
		this.servicep = servicep;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public double getRechargeamt() {
		return rechargeamt;
	}
	public void setRechargeamt(double rechargeamt) {
		this.rechargeamt = rechargeamt;
	}
	public String getServicep() {
		return servicep;
	}
	public void setServicep(String servicep) {
		this.servicep = servicep;
	}
	
	
}
