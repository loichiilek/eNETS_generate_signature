Python Code for HMAC Generation

import base64
import hashlib

def generate_signature(txn_req, secret_key):

    concat_payload_and_secret_key = bytes(txn_req + secret_key, 'utf-8')
    h = hashlib.sha256()
    h.update(concat_payload_and_secret_key)
    convert_to_byte_array = bytearray(h.digest())
    encode_base64 = base64.b64encode(convert_to_byte_array)
    
    return encode_base64.decode('utf-8')
