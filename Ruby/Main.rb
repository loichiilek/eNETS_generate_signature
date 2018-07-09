require_relative 'GenerateHMAC'

secret_key = "38a4b473-0295-439d-92e1-ad26a8c60279"
txn_req = "{\"ss\":\"1\",\"msg\":{\"netsMid\":\"UMID_877772003\",\"tid\":\"\",\"submissionMode\":\"B\",\"txnAmount\":\"1000\",\"merchantTxnRef\":\"Test3221\",\"merchantTxnDtm\":\"20170605 10:26:51.989\",\"paymentType\":\"SALE\",\"currencyCode\":\"SGD\",\"paymentMode\":\"\",\"merchantTimeZone\":\"+8:00\",\"b2sTxnEndURL\":\"https://sit2.enets.sg/MerchantApp/sim/b2sTxnEndURL.jsp\",\"b2sTxnEndURLParam\":\"\",\"s2sTxnEndURL\":\"https://sit2.enets.sg/MerchantApp/rest/s2sTxnEnd\",\"s2sTxnEndURLParam\":\"\",\"clientType\":\"W\",\"supMsg\":\"\",\"netsMidIndicator\":\"U\",\"ipAddress\":\"127.0.0.1\",\"language\":\"en\"}}"

print generate_signature(txn_req, secret_key)
