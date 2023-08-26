package com.abhi.briefbot;

import java.io.IOException;
import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@SpringBootApplication
public class BriefBotApplication {

	public static void main(String[] args)  {
		SpringApplication.run(BriefBotApplication.class, args);
		
		
		WebClient webClient = new WebClient();
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		
		try {
			HtmlPage page = webClient.getPage("https://stackoverflow.com/questions/44616036/how-to-create-an-overlay-for-a-button");
			Iterable<DomElement> textContent = page.getElementsByTagName("p");
			Iterator<DomElement> iterator = textContent.iterator();
		
			while (iterator.hasNext()) {
				DomElement domElement = (DomElement) iterator.next();
				if(domElement.mayBeDisplayed()) {
				
					String normalizedText = domElement.asNormalizedText();
					String[] sarr = normalizedText.split("\\s+");
					for(String s : sarr) {
						System.out.print(s+" ")	;
					}
				System.out.println();
				}
				
			}
			
		} catch (FailingHttpStatusCodeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
