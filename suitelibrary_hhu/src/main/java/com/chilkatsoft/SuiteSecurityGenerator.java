package com.chilkatsoft;

import android.content.Context;
import android.util.Log;

public class SuiteSecurityGenerator {
    static {
        System.loadLibrary("chilkat");
    }
    public static String SecurityTagGenerator(Context c, String key,String IV,String AAD,String PT){
        CkCrypt2 crypt = new CkCrypt2();
        Log.e(" CALLING CRYPT LIBRARY ","CALLING CRYPT LIBRARY AFTER CALL");
        String Tag = encrypt(crypt,key,IV,AAD,PT);
       // Toast.makeText(c,message,Toast.LENGTH_SHORT).show();
        return Tag;
    }
    public static String encrypt(CkCrypt2 crypt,String key,String IV,String AAD,String PT){
        crypt.put_CryptAlgorithm("aes");
        crypt.put_CipherMode("gcm");
        crypt.put_KeyLength(128);

        // String T = "5bc94fbc3221a5db94fae95ae7121a47"; //32 charecter
        crypt.put_EncodingMode("hex");
        crypt.SetEncodedIV(IV,"hex");
        crypt.SetEncodedKey(key,"hex");
        boolean success = crypt.SetEncodedAad(AAD,"hex");
        Log.e("Last Error text","Boolean Result :" + success );
        Log.e("Pla Text -- ","Pla Text -- " + PT);

        String Cipher_text = crypt.encryptEncoded(PT);
        Log.e("Cip Text - ","Cip Text - " + Cipher_text);

        String cAuthTag = crypt.getEncodedAuthTag("hex");

        Log.e("computed authTag: ","computed authTag: " + cAuthTag);
        //Log.e("Decryption Mechanism","Decryption Mechanism Started ------------------");
        String encoded_PT = crypt.decryptEncoded(Cipher_text);
        Log.e("Decry PT  - ","Decry PT  " + encoded_PT);
        return cAuthTag;
    }
}
