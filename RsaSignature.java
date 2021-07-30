import java.security.*; 
import java.util.*; 
import java.security.spec.*; 

public class Main {
     
    public static void main(String[] args) throws Exception {

        String value1 = "2344";
        String value2 = "clean code";
        String value3 = "is good";


        String data = value1 + value2 + value3;
         
        // Please Remember to replace with your OWN private key!
        String MyPrivateKey = 
        "MIIEoQIBAAKCAQB2+/6eXujlgfKLl2TrIf/LNLcVdDhi2oaWwWI5KCFzmdINKd6Ota+qPUp+BH5/EXeEwDlswD9MmEEKL6flQ3cTB1EGiSVPyO469qT1S+7ue1WBS0mZNhbXegs8B3rCGtKPvruHXEIvTtCLylSBMcjFa6/8TrIlzU3XcB1kt9u8gNKcU7KrjS5VpM580xSqo1doZitF3ooSjpwitc5M6VZq6w2ojK5oBrjncTlrE7cm+GZq3La27vEF/R/z4R2Upgci90TkXnXned8Pym01Kr110FNtkkiuNf6F+6Wr3xE0LjyPeXRQhnfbnDTW+B/0rxil6B2m49QuWG0nzP27Zv25AgMBAAECggEARpjMAWGk5BAPPj3stgqtP/+eJc+YaSbptmc1hV5HQtTgqcjO8XPhr6vAGDdIatKNTKnVKK6EoEiyRn3yK3i1HQg5ThxvlABPQZL4W0bblIp/OEDYgVxzfxQ9uDdj4emSR5HOqMjXyEQGPvsk2qcUTfbQK27yCrXe2tX9yrXAXf5tVrpUoJVzd6wlJRsTfYZcm3zSNIn5n4PjQG0l64ghPfY2J7sh0Lmb6Z6SeRM4Kd6C295nxFmgXMlI5n9I9EwvKdWdYCwC8e5NKx/PHQpBiQ7in/YQhAWIl0EdOoNRZO6NKemBGZW8qHd771RpOCrBSjvu96uEEssd4MjxtKInAQKBgQDAwRJGzzpjHTO+IXBeNbIFZgdanOU7wS97BiOkslZImMqwI5iwlD3YNLXf8xyzAsJlenyJCKp4ldbXYIGuU0kFedKFvAwux0B/1Fa3uzU16MUU0DWsj3fB/+Skghh9Juk/O1drS6kh3as2oAfRFoWBtx81iMQEsjPU8oSMqeELmQKBgQCeBmtUZBaRRzRWuE3LAAAqUXfu5wCm7cJ4M+7m97KrZYqhCk6QXTZ4JNPaTBMbQW5Ep42+zzIT+I5D/rc+F6Y0n6NukfHcigUDPOuWKNxlfFvIZvAY4jvTfDW/Et/n3Wu9UGb7+6lzGlkq/YWGw7/jYx7hJ6kchECpiV5qCj/XIQKBgG/NTQmPV2F35bRJdwDeCkUBWhCf4oKXWi/0bqYv3sY7AY3LB9ycD4chg8DDJYlbd2Ae/K8LPL22w6enTXDM1BT+BTMW0MYtQmcixa3KQ2HigrXA0vElQiRfhcI5x3SIJlBL3jfY6eA/z/heOEp50rRbgBmwG2pR5qiEhoeEXYk5AoGAYSQzEGKimNX7r5+GetbaQylnn52zgepAlKHgJ213EPPPv2VVnFsgo8SH0vbW+/dB8MRLV1OJRkuSMOxA+tOQ4WKNFehzlI3nvPDTJbCio2RKC6xzxeg0vLHrXDUfHSq5E1x8okQ3C0HUNKA6V/i3WfHRxrkZtST7lvyR5H++dOECgYAem4fYPZ8SP8IYQ2o23ZWq8kQ34AKgJSBn/JJDKKFRexPLK25gA6idDwuh/y2khO6apyRHvJkiHXj00HJ2pDaSMlN7qY4oGRwViHYWngYFQ6d+MjfW76GjVWh59AWA5jkvIlAsfNi1HwjFP79BQVVOnhwH8Mh3ro9oeaAQtye9hA==";
        signSHA256RSA(data,MyPrivateKey);
    }
 
    // Create base64 encoded signature using SHA256/RSA.
    private static void signSHA256RSA(String input, String MyPrivateKey) throws Exception {
        PKCS8EncodedKeySpec encodedPrivateKeySpec = new PKCS8EncodedKeySpec( Base64.getDecoder().decode(MyPrivateKey) );
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(encodedPrivateKeySpec);

        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(privateKey);
        signature.update(input.getBytes("UTF-8"));
        byte[] signatureValue = signature.sign();
        System.out.println("Data=" + input);
        System.out.println("Signature=" + Base64.getEncoder().encodeToString(signatureValue));
    }
}
