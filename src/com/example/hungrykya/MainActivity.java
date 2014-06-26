package com.example.hungrykya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button codeSubmit;
	EditText digitCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_code);

		digitCode = (EditText) findViewById(R.id.text_code);
		codeSubmit = (Button) findViewById(R.id.but_code_submit);

		codeSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (digitCode.getText().toString().equals("2684")) {
					Toast.makeText(MainActivity.this, "Successful",
							Toast.LENGTH_LONG).show();
					Intent menuPage = new Intent(MainActivity.this,
							MainMenu.class);
					startActivity(menuPage);
				} else
					Toast.makeText(MainActivity.this, "Invalid Code",
							Toast.LENGTH_LONG).show();
			}
		});

	}

}
