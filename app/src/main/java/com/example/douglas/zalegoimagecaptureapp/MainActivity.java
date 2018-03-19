package com.example.douglas.zalegoimagecaptureapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity
{


 /*   private static int RESULT_LOAD_IMAGE = 1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note);

        Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

*/



	Button btnSignIn,btnSignUp,btnabt,btnaddimage;
	LoginDataBaseAdapter loginDataBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// create a instance of SQLite Database
		loginDataBaseAdapter=new LoginDataBaseAdapter(this);
		loginDataBaseAdapter=loginDataBaseAdapter.open();

		// Get The Refference Of Buttons
		btnSignIn=(Button)findViewById(R.id.buttonSignIN);
		btnSignUp=(Button)findViewById(R.id.buttonSignUP);
		btnabt=(Button)findViewById(R.id.btnabt1);

		// Set OnClick Listener on SignUp button
		btnSignUp.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub

				/// Create Intent for SignUpActivity  abd Start The Activity
				Intent intentSignUP=new Intent(getApplicationContext(),SignUpActivity.class);
				startActivity(intentSignUP);
			}
		});

		btnabt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub

				/// Create Intent for SignUpActivity  abd Start The Activity
				Intent intentSignUP=new Intent(getApplicationContext(),About.class);
				startActivity(intentSignUP);
			}
		});
	}
	// Methos to handleClick Event of Sign In Button
	public void signIn(View V)
	{
		final Dialog dialog = new Dialog(MainActivity.this);
		dialog.setContentView(R.layout.login_layout);
		dialog.setTitle("Login");

		// get the Refferences of views
		final  EditText editTextlogin_emailid=(EditText)dialog.findViewById(R.id.login_emailid);
		final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.login_password);

		Button btnSignIn=(Button)dialog.findViewById(R.id.loginBtn);

		// Set On ClickListener
		btnSignIn.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// get The User name and Password
				String email=editTextlogin_emailid.getText().toString();
				String password=editTextPassword.getText().toString();

				// fetch the Password form database for respective user name
				String storedPassword=loginDataBaseAdapter.getSinlgeEntry(email);

				// check if the Stored password matches with  Password entered by user
				if(password.equals(storedPassword))
				{
					Toast.makeText(MainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
					dialog.dismiss();
					Intent intentSignin=new Intent(MainActivity.this,MainActivity2.class);
					startActivity(intentSignin);
				}
				else
				{
					Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
				}
			}
		});

		dialog.show();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// Close The Database
		loginDataBaseAdapter.close();
	}
}
