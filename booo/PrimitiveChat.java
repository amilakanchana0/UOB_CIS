import javax.swing.*;
import java.util.*;
import org.apache.xmlrpc.*;

public class PrimitiveChat {

// The procedure:
 public String printText(String str) {
   // System.out.println( "Received: "+ (str.equals("ado")?"Ai bn?" :"hehe"));

try {
   
   XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); //
   Vector params = new Vector();
   params.addElement(new String(str)); 
   Object result = server.execute("sample.chatMsg",params );
   System.out.println(  result.toString());
  } catch (Exception exception) {
   System.err.println("JavaClient: " + exception);
   }
    return "ok";
    }
  
   

 public static void main (String [] args) {
  String input;
  PrimitiveChat pc = new PrimitiveChat();

  do {
    input = JOptionPane.showInputDialog("Enter your message");
    if( input != null ) {
        pc.printText(input); // a local procedure call.
        }
    } while ( input != null );
  System.exit(0);
  }
}