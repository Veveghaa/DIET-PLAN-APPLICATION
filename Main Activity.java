package com.example.dietplan;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	float h,w,bmi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button b=(Button)findViewById(R.id.button1);
		final EditText e1=(EditText)findViewById(R.id.editText1);
		final EditText e2=(EditText)findViewById(R.id.editText2);
		final TextView t1=(TextView)findViewById(R.id.textView1);
		final TextView t2=(TextView)findViewById(R.id.textView2);
		final TextView t3=(TextView)findViewById(R.id.textView3);
		final TextView t4=(TextView)findViewById(R.id.textView4);
		
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				h = Float.parseFloat(e1.getText().toString());
			    w = Float.parseFloat(e2.getText().toString());
			    float nh=h/100;
			    bmi=w/(nh*nh);
			    double roundoff = Math.round(bmi * 100.0) / 100.0;
			    t4.setText("BMI : "+roundoff);
			    if(roundoff<18.5)
			    {
			    	Intent o = new Intent(getApplicationContext(), Under.class);
					startActivity(o);
			    }
			    else if(roundoff>18.5 && roundoff<24.9)
			    {
			    	Intent o1 = new Intent(getApplicationContext(),Normal.class);
			    	startActivity(o1);
			    }
			    else if(roundoff>25)
			    {
			    	Intent o2 = new Intent(getApplicationContext(),Over.class);
			    	startActivity(o2);
			    }
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
