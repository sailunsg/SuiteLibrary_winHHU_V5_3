package com.suite;


import android.os.Bundle;
import android.util.Log;

import com.chilkatsoft.SuiteSecurityGenerator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String K = "30303030303030303030303030303030"; //16 bytes
        String IV = "45434C3132333435000000E3";
        String AAD = "3030303030303030303030303030303030";//17 bytes
        String PT="01000000065F1F040000181DFFFF";
        //SuiteSecurityFragment test =new SuiteSecurityFragment(K,IV,AAD,PT);

        String Tag = SuiteSecurityGenerator.SecurityTagGenerator(MainActivity.this,K,IV,AAD,PT);
        Log.e("SUITE MAIN ","SUITE MAIN ACTIVITY"+ Tag);

         /* satyam sir data
        String K = "30303030303030303030303030303030"; //16 bytes
        String IV = "45434C3132333435000000E3";
        String AAD = "3030303030303030303030303030303030";//17 bytes
        String PT="C301C10046000060030AFF02010F00";*/

        /* subbu  sir data


        String K = "30303030303030303030303030303030"; //16 bytes
        String IV = "45434C313233343500000001";
        String AAD = "3030303030303030303030303030303030";//17 bytes
        String PT="01000000065F1F040000181DFFFF";
        */
    }
}