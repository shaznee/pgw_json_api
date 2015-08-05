# Payeezy Gateway JSON API
Payeezy Gateway Java API Library

INTENDED FOR DEMONSTRATION PURPOSES ONLY.  NOT FOR PRODUCTION USE.

This is the primary class for interfacing with Payeezy Gateway JSON API.

#Quick Start:
  
     import com.firstdata.payeezygateway.*;
  
      public Class Client {
 		     public static void main(String[] args) {
 			     PayeezyGateway pgw = new PayeezyGateway(Environment.DEMO, GATEWAY_ID, PASSWORD, KEY_ID, HMAC_KEY);
      			
 			     Request request = pgw.getRequest();
      
  		     request
  			     .cardholder_name("PGW Java Tester")
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
 
