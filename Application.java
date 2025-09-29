import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;

public class GetAccessToken {
    private static final Logger logger = Logger.getLogger(GetAccessToken.class.getName());
    /**
     * Main method to generate an OAuth 2.0 token using client credentials grant.
     * To run this program, provide the path to a properties file as a command line argument.
     * The properties file should contain the following keys (and be adjusted accordingly to your environment)
     * audience=https://services.socialsecurity.be/REST/oauth/v5/token
     * authUrl=https://services.socialsecurity.be/REST/oauth/v5/token
     * clientId=self_service_chaman_xxxxxxxxxxxxxxxx  // replace with your client ID
     * scope=scope:rsz-onss:socialdebt:retention:billretainment-rest:post-billretainment
     * password=your-key-store-password // replace with your keystore password
     * certificate=path-to-your-PKCS12-file // replace with the path to your PKCS12 file
     * keyAlias=your key alias // replace with your key alias
     *
     * @param args Command line arguments should include the path to the properties file.
     */
    public static void main(String[] args) {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(args[0])) {
            prop.load(fis);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return;
        }
        // Extract necessary properties for OAuth token request
        String audience = prop.getProperty("audience");
        String authUrl = prop.getProperty("authUrl");
        String clientId = prop.getProperty("clientId");
        String scope = prop.getProperty("scope");
        String password = prop.getProperty("password");
        String certificate = prop.getProperty("certificate");
        String keyAlias = prop.getProperty("keyAlias");
        try {
            // Generate and print the access token
            String accessTokenResponse = getAccessToken(certificate, password, keyAlias, audience, clientId, authUrl, scope);
            logger.log(Level.INFO, accessTokenResponse);
        } catch (Exception ex) {
            logger.log(Level.SEVERE,ex.getMessage(), ex);
        }

		#feature102 code changes by developer ethan in his userTransactions module in sept 2024
		class Sum_Product_ofDigit{
      public static void main(String args[]){
            int num = Integer.parseInt(args[0]);         //taking value as command line argument.
            int temp = num,result=0;
            //Logic for sum of digit
            while(temp>0){
               result = result + temp;
               temp--;
			         temp = num;
            result = 1;
            while(temp > 0){
                 result = result * temp;
                 temp--;
            }
            }
		#end of feature102 code changes   

		#feature101 code changes by Developer Vivek on Reports Module in sept 2024
		class Maxof2{
			public static void main(String args[]){
			//taking value as command line argument.
			//Converting String format to Integer value
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);

		  if(i > j)
			  System.out.println(i+" is greater than "+j);
		  else
			  System.out.println(j+" is greater than "+i);
	  }
	}
	#end of feature101 changes

    }