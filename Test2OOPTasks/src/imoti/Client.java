package imoti;

public abstract class Client {
	protected  String name;
	private String phone;
	private Agent agent;
	protected Agency agency;
	protected double budget;
	
	public String getName() {
		return name;
	}
	
	public Agent getAgent() {
		return agent;
	}
	
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	public Agency getAgency() {
		return agency;
	}
	
	public double getBudget() {
		return budget;
	}
	
	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	public Client(String name, String phone, Agency agency, double budget) {
		this.name = name;
		this.phone = phone;
		this.agency = agency;
		this.budget = budget;
	}
	
	
}
