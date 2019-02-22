package com.example.andro42codingchallenge2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText input1 = findViewById(R.id.numberInput);
        if(input1 != null){
            input1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    boolean handle= false;
                    if(actionId == EditorInfo.IME_ACTION_SEND){
                        dialNumber();
                        handle=true;
                    }
                    return handle;
                }
            });
        }
    }
    private void dialNumber(){
        EditText input1 = findViewById(R.id.numberInput);
        String phoneNum=null;
        if(input1 != null) phoneNum="tel:"+input1.getText().toString();
        Log.d("TAG", "dialNumber: "+phoneNum);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(phoneNum));
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else{
            Log.d("Implicit Intent","Can't handle this!");
        }
    }
}
