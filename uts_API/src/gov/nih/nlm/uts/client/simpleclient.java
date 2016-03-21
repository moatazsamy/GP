package gov.nih.nlm.uts.client;
import gov.nih.nlm.uts.webservices.content.*;

import java.util.ArrayList;
import java.util.List;

import gov.nih.nlm.uts.webservice.finder.*;
import gov.nih.nlm.uts.webservice.history.*;
import gov.nih.nlm.uts.webservice.metadata.*;
import gov.nih.nlm.uts.webservice.security.*;


public class simpleclient {
	public static void main (String[] args) {
		try {
			// Runtime properties
			String username = "moatazsamy";
			String password = "001247_umls";
			String umlsRelease = "2011AB";
			String serviceName = "http://umlsks.nlm.nih.gov";
			
			
       	UtsWsContentController utsContentService  = (new UtsWsContentControllerImplService())
       			.getUtsWsContentControllerImplPort();
     
       	UtsWsSecurityController utsSecurityService  = (new UtsWsSecurityControllerImplService())
       			.getUtsWsSecurityControllerImplPort();
       	
       	String ticketGrantingTicket = utsSecurityService.getProxyGrantTicket(username, password);
           String SingleUseTicket1=utsSecurityService.getProxyTicket(ticketGrantingTicket, serviceName);
           
           ConceptDTO myConcept = utsContentService.getConcept(SingleUseTicket1, umlsRelease, "C0011980");
          
          
           System.out.println(myConcept.getUi());
           System.out.println(myConcept.getDefaultPreferredName());
           
           
           
         
			
			
			 
           
       }
       catch (Exception ex)
       {
       	ex.printStackTrace();
       	
       	
       }
       
	
		
       
	}

}
			
