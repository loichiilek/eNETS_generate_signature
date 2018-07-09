import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class GenerateHmac {

	public static final String TXNREQ ="{\"mti\":\"0100\",\"process_code\":\"330000\",\"amount\":\"1111\",\"stan\":\"1\",\"transaction_time\":\"174741\",\"transaction_date\":\"0706\",\"entry_mode\":\"000\",\"condition_code\":\"85\",\"institution_code\":\"20000000003\",\"host_tid\":\"35172701\",\"host_mid\":\"11135172700\",\"npx_data\":{\"E103\":\"35172701\",\"E201\":\"00000123\",\"E202\":\"SGD\"},\"txn_identifier\":\"NETSQPAY035172701####111351727000000012c39b887010000111100010b50e9f49TEST: NEW POS NET4824\"}";
	private static final String SECRETKEY = "21296dd3-5bf6-4dfc-b8a2-03fbcc213b7b";
	public static void main(String[] args) {
		System.out.println(generateSignature(TXNREQ, SECRETKEY));
		System.out.println(TXNREQ+SECRETKEY);
	}

    public static String generateSignature(String txnReq, String secretKey){
        String concatPayloadAndSecretKey = txnReq + secretKey;
        String hmac = encodeBase64(hashSHA256ToBytes(concatPayloadAndSecretKey.getBytes()));
        return hmac;
    }

    public static byte[] hashSHA256ToBytes(byte[] input){
        byte[] byteData;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(input);
            byteData = md.digest();
            return byteData;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String encodeBase64(byte[] data){
        return DatatypeConverter.printBase64Binary(data);
    }
}
