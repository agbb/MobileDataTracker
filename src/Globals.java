import java.util.Observable;
import java.util.Observer;

public class Globals extends Observable {
	
	private float totalGigs =0.0f;
	private float totalRemaining =0.0f;
	private int updateFreqMillis=10000;
	private boolean refeshCycle= true;
	private boolean onNetwork= false;
	private int daysRemaing =0;
	private String allowanceUnit="GB";
	private String remainingUnit="GB";
	
	
	public String getGigsDay(){
		return String.format("%.2f", (totalRemaining/ (float)daysRemaing));
	}
	public int[] getDataForProgressBar(){
		int[] value= new int[2];
		value[0] = 51-(int)totalRemaining;
		value[1] = (int)totalGigs;
		return value;
	}
	
	public int getDaysRemaing() {
		return daysRemaing;
	}
	public String getAllowanceUnit() {
		return allowanceUnit;
	}
	public String getRemainingUnit() {
		return remainingUnit;
	}
	public void setDaysRemaing(int daysRemaing) {
		this.daysRemaing = daysRemaing;
		setChanged();
		notifyObservers();
	}

	public void setAllowanceUnit(String allowanceUnit) {
		this.allowanceUnit = allowanceUnit;
		setChanged();
		notifyObservers();
	}

	public void setRemainingUnit(String remainingUnit) {
		this.remainingUnit = remainingUnit;
		setChanged();
		notifyObservers();
	}

	public Globals() {
		
	}
	
	public float getTotalGigs() {
		return totalGigs;
	}

	public float getTotalRemaining() {
		return totalRemaining;
	}

	public int getUpdateFreqMillis() {
		return updateFreqMillis;
	}

	public boolean isRefeshCycle() {
		return refeshCycle;
	}

	public boolean isOnNetwork() {
		return onNetwork;
	}

	public void setTotalGigs(float totalGigs) {
		this.totalGigs = totalGigs;
		setChanged();
		notifyObservers();
	}

	public void setTotalRemaining(float totalRemaining) {
		this.totalRemaining = totalRemaining;
		setChanged();
		notifyObservers();
	}

	public void setUpdateFreqMillis(int updateFreqMillis) {
		this.updateFreqMillis = updateFreqMillis;
		setChanged();
		notifyObservers();
	}

	public void setRefeshCycle(boolean refeshCycle) {
		this.refeshCycle = refeshCycle;
		setChanged();
		notifyObservers();
	}

	public void setOnNetwork(boolean onNetwork) {
		this.onNetwork = onNetwork;
		setChanged();
		notifyObservers();
	}


	public void updateLiveData(float totalGigs, float totalRemaining, int daysRemaining, String allowanceUnit, String remainingUnit){
		this.totalGigs=totalGigs;
		this.totalRemaining=totalRemaining;
		this.daysRemaing = daysRemaining;
		this.allowanceUnit=allowanceUnit;
		this.remainingUnit=remainingUnit;
		setChanged();
		notifyObservers();
	}
}

