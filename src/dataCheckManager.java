
public class dataCheckManager extends Thread {

	private Globals data;
	public dataCheckManager(Globals data){
		this.data = data;
	}
	
	public void run(){
		while(data.isRefeshCycle()){
			
		
		dataThreaded dt = new dataThreaded(data);
		
		dt.start();
		
		try {
			Thread.sleep(data.getUpdateFreqMillis());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
	}
}
