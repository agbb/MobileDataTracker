import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class dataThreaded extends Thread  {
	private Globals data;
	
	public dataThreaded(Globals data){
		this.data= data;
	}
	public void run(){
		
			
		
		try {
			Document doc = Jsoup.connect("http://add-on.ee.co.uk/status").get();

			Elements summaryData = doc.getElementsByClass("data-used");
			Elements summaryTime = doc.getElementsByClass("ends-in-value");
			Elements summary = doc.getElementsByClass("data-usage");
			
			if(summary.hasText()){
				data.setOnNetwork(true);
				regex.regexSort(summary.text());
				
			}else{
				data.setOnNetwork(false);
				System.out.println("not on network");
			}
		
			
			//System.out.println(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
	

