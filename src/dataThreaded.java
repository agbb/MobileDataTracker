import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class dataThreaded extends Thread implements Globals {

	public void run(){
		while(refeshCycle){
			
		try {
			Thread.sleep(updateFreqMillis);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Document doc = Jsoup.connect("http://add-on.ee.co.uk/status").get();

			Elements summaryData = doc.getElementsByClass("data-used");
			Elements summaryTime = doc.getElementsByClass("ends-in-value");
			Elements summary = doc.getElementsByClass("data-usage");


			if(summary.hasText()){
				System.out.println(summary.text());
				System.out.println(summaryTime.text());
				System.out.println(summaryData.text());
			}else{
				System.out.println("not on network");
			}
		
			
			//System.out.println(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
}
