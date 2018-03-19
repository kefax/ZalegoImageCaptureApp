package com.example.douglas.zalegoimagecaptureapp;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Toast;

public class MainActivity2 extends Activity {
    /** Called when the activity is first created. */
        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        try {
            View.OnClickListener handler = new View.OnClickListener(){
                public void onClick(View v) {

                    switch (v.getId()) {

                        case R.id.btnPatients:
                            Intent intentP=new Intent(getApplicationContext(),AddEditNotes.class);
                            startActivity(intentP);
                            break;

                        case R.id.btnDoctor:
                            Intent intentD=new Intent(getApplicationContext(),MMainActivity.class);
                            startActivity(intentD);
                            break;

                        case R.id.btnHelp:
                            Intent intentH=new Intent(getApplicationContext(),Help.class);
                            startActivity(intentH);
                            break;

                        case R.id.btnAdmin:
                            Intent intenta=new Intent(getApplicationContext(),MMainActivity.class);
                            startActivity(intenta);
                            break;
                    }
                }
            };

            //we will set the listeners
            findViewById(R.id.btnPatients).setOnClickListener(handler);
            findViewById(R.id.btnDoctor).setOnClickListener(handler);
            findViewById(R.id.btnOther).setOnClickListener(handler);
            findViewById(R.id.btnHelp).setOnClickListener(handler);
            findViewById(R.id.btnAdmin).setOnClickListener(handler);

        }catch(Exception e){
            Log.e("Oops", e.toString());
        }
    }
}