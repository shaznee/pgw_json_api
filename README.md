# e4api
Payeezy Gateway Java API Library

INTENDED FOR DEMONSTRATION PURPOSES ONLY.  NOT FOR PRODUCTION USE.

This is the primary class for interfacing with Global Gateway E4 API.

#Quick Start:
  
     import com.firstdata.globalgatewaye4.*;
  
      public Class Client {
 		     public static void main(String[] args) {
 			     GlobalGatewayE4 e4 = new GlobalGatewayE4(Environment.DEMO, GATEWAY_ID, PASSWORD, KEY_ID, HMAC_KEY);
      			
 			     Request request = e4.getRequest();
      
  		     request
  			     .cardholder_name("E4 Java Tester")
  			     .cc_number("")
  			     .cc_expiry("0420")
  			     .transaction_type(TransactionType.PreAuthorization)
  			     .amount("1.00");
       
      		try {
      			Response response = request.submit();
      			System.out.println("Transaction Approved: " + response.transaction_approved());
      			System.out.println("Bank Message:" + response.bank_message());
      			System.out.println(response.ctr());
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
      		}
      }
 
