import org.apache.xmlrpc.*;

public class HelloServer { 
 public String hello() {
  return "Hello from Future";
  }

 public String chatMsg(String msg) {
   System.out.println( "Received: "+ msg);
   String nstr = "";
   char ch;
     for (int i=0; i<msg.length(); i++)
      {
        ch= msg.charAt(i); //extracts each character
        nstr= ch+nstr; //adds each character in front of the existing string
      }
      System.out.println("Reversed word: "+ nstr);
  return new String("Reply from server: "+ nstr);
  }
  
 public static void main (String [] args) {
  try {
	 System.out.println("Starting Server..."); 
   WebServer server = new WebServer(80);
   server.addHandler("sample", new HelloServer());
   server.start();
uk.co.wilson.xml.MinML.xmlinfo = true;
  } catch (Exception exception) {
   System.err.println("JavaServer: " + exception);
   }
  }
}
 