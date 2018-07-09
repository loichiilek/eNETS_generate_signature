using System;
using System.Security.Cryptography;
using System.Text;

string GenerateSignature(string txnReq, string secretKey) {
    string concatenated = txnReq + secretKey;
    byte[] bytes = Encoding.UTF8.GetBytes(concatenated);
    byte[] hash = new SHA256Managed().ComputeHash(bytes);
    string encoded = Convert.ToBase64String(hash);
    return encoded;
}
