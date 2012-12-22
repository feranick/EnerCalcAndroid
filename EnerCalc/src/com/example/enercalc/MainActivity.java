package com.example.enercalc;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	
	double a=11604;
	double b=8065.54;
	double c=1.6021773e-19;
	double d=1239.8;
	double sl=2.99792458e17;
	double hzf=1e9;
	double ryc = 13.605692; //eV
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EditText editJ = (EditText) findViewById(R.id.editJ);
		editJ.requestFocus();
		editJ.setText("1.602E-19");
		
		MainActivity testing = this;
		testing.convert(editJ);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
		
	public void convert(View view) {
		EditText editJ = (EditText) findViewById(R.id.editJ);
		EditText editeV = (EditText) findViewById(R.id.editeV);
		EditText editK = (EditText) findViewById(R.id.editK);
		EditText editwn = (EditText) findViewById(R.id.editwn);
		EditText editnm = (EditText) findViewById(R.id.editnm);
		EditText edithz = (EditText) findViewById(R.id.edithz);
		EditText editry = (EditText) findViewById(R.id.editry);
		
		NumberFormat nF  = new DecimalFormat("0.000E0");
		DecimalFormat dec2 = new DecimalFormat("#.00");
		DecimalFormat dec3 = new DecimalFormat("#.000");
		String J = "";
		String eV = "";
		String K = "";
		String wn = "";
		String nm = "";
		String mhz = "";
		String ry = "";
	
		
		if(editJ.hasFocus() && editJ.getText().toString().compareTo("")!=0)
			{double Jd = Double.valueOf(editJ.getText().toString());
			double eVd = Jd/c;
		
			J = nF.format(Jd);
			eV = dec2.format(eVd);
			K = dec2.format(eVd*a);
			wn = dec2.format(eVd*b);
			nm = dec2.format(d/eVd);
			mhz = nF.format((sl/(d/eVd))/hzf);
			ry = dec3.format(eVd/ryc);
			}
		
		if(editeV.hasFocus() && editeV.getText().toString().compareTo("")!=0)
			{double eVd = Double.valueOf(editeV.getText().toString());
			
			J = nF.format(eVd*c);
			eV = dec2.format(eVd);
			K = dec2.format(eVd*a);
			wn = dec2.format(eVd*b);
			nm = dec2.format(d/eVd);
			mhz = nF.format((sl/(d/eVd))/hzf);	
			ry = dec3.format(eVd/ryc);
			}
		
		if(editK.hasFocus() && editK.getText().toString().compareTo("")!=0)
			{double Kd = Double.valueOf(editK.getText().toString());
			double eVd = Kd/a;
			
			J = nF.format(eVd*c);
			K = dec2.format(Kd);
			eV = dec2.format(eVd);
			wn = dec2.format(eVd*b);
			nm = dec2.format(d/eVd);
			mhz = nF.format((sl/(d/eVd))/hzf);
			ry = dec3.format(eVd/ryc);
			}
	    
	    if(editwn.hasFocus() && editwn.getText().toString().compareTo("")!=0)
			{double wnd = Double.valueOf(editwn.getText().toString());
			double eVd = wnd/b;
			
			J = nF.format(eVd*c);
			K = dec2.format(eVd*a);
			eV = dec2.format(eVd);
			wn = dec2.format(wnd);
			nm = dec2.format(d/eVd);
			mhz = nF.format((sl/(d/eVd))/hzf);
			ry = dec3.format(eVd/ryc);
			}
	    
	    if(editnm.hasFocus() && editnm.getText().toString().compareTo("")!=0)
			{double nmd = Double.valueOf(editnm.getText().toString());
			double eVd = d/nmd;
			
			J = nF.format(eVd*c);
			K = dec2.format(eVd*a);
			eV = dec2.format(eVd);
			wn = dec2.format(eVd*b);
			nm = dec2.format(nmd);
			mhz = nF.format((sl/nmd)/hzf);
			ry = dec3.format(eVd/ryc);
			}
		
	    if(edithz.hasFocus() && edithz.getText().toString().compareTo("")!=0)
			{double mhzd = Double.valueOf(edithz.getText().toString());
			double nmd = sl/(mhzd*1e4);
			double eVd = d/nmd;
			
			J = nF.format(eVd*c);
			K = dec2.format(eVd*a);
			eV = dec2.format(eVd);
			wn = dec2.format(eVd*b);
			nm = dec2.format(nmd);
			mhz = nF.format(mhzd);
			ry = dec3.format(eVd/ryc);
			}
	    
	    if(editry.hasFocus() && editry.getText().toString().compareTo("")!=0)
			{double ryd = Double.valueOf(editry.getText().toString());
		    	double eVd = ryd*ryc;
			
		    J = nF.format(eVd*c);
			eV = dec2.format(eVd);
			K = dec2.format(eVd*a);
			wn = dec2.format(eVd*b);
			nm = dec2.format(d/eVd);
			mhz = nF.format((sl/(d/eVd))/hzf);
			ry = dec3.format(ryd);
			}
	    
		editJ.setText(J);
		editeV.setText(eV);
	    editK.setText(K);
	    editwn.setText(wn);
	    editnm.setText(nm);
	    edithz.setText(mhz);
	    editry.setText(ry);
	    
	}
	
	
	public void reset(View view) {
		EditText editJ = (EditText) findViewById(R.id.editJ);		
		editJ.setText("1.602E-19");
	    editJ.requestFocus();
	    convert(editJ);
		
	}
	
	public void clearfield(View view) {
		EditText editJ = (EditText) findViewById(R.id.editJ);
		EditText editeV = (EditText) findViewById(R.id.editeV);
		EditText editK = (EditText) findViewById(R.id.editK);
		EditText editwn = (EditText) findViewById(R.id.editwn);
		EditText editnm = (EditText) findViewById(R.id.editnm);
		EditText edithz = (EditText) findViewById(R.id.edithz);
		EditText editry = (EditText) findViewById(R.id.editry);
		
		if(editJ.hasFocus())
			editJ.setText("");
		if(editeV.hasFocus())
			editeV.setText("");
		if(editK.hasFocus())
			editK.setText("");
		if(editwn.hasFocus())
			editwn.setText("");
		if(editnm.hasFocus())
			editnm.setText("");
		if(edithz.hasFocus())
			edithz.setText("");
		if(editry.hasFocus())
			editry.setText("");
		
	}
	
}
