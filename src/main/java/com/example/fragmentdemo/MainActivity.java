package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button fragment1, fragment2;
    //fragmnet ko context hudeina ....activity service ra broadcastreceiver ko mtra context huncha. single_item lai ni manifest ma define garna pardeina.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = findViewById(R.id.first);
        fragment2 = findViewById(R.id.second);

        fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //load first fragment (Homefragment)
                //FragmentTransaction (same as intent)
                //k ma load kun ma load

                FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                //add fragment

                ft.add(R.id.frameLayout,new HomeFragment());
                ft.commit();
            }
        });

        fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                //replace fragment
                ft.replace(R.id.frameLayout, new AboutFragment());
                ft.commit();
            }
        });
    }
}