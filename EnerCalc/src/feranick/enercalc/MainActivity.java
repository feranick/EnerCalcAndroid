package feranick.enercalc;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	static final String version = "EnerCalc - v. 2.9.0-20240906";
	static final double a=11604;
	static final double b=8065.54;
	static final double c=1.6021773e-19;
	static final double d=1239.8;
	static final double sl=2.99792458e17;
	static final double hzf=1e12;
	static final double ryc = 13.605692; //eV
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EditText editeV = (EditText) findViewById(R.id.editeV);
		EditText editinc = (EditText) findViewById(R.id.editinc);
		editeV.requestFocus();
		editeV.setText("1.0");
		editinc.setText("0.1");
		
		MainActivity testing = this;
		testing.convert(editeV);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	
	/** Called when a menu item in the menu is clicked. */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	 switch (item.getItemId()) {
	  case R.id.menuabout:
	   Toast.makeText(this, version, Toast.LENGTH_SHORT).show();
	   return true;
	 
	  default: 
	   if (!item.hasSubMenu()) {
	    return true;
	   }
	   break;
	 }
	  
	 return false;
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
		String Thz = "";
		String ry = "";

		
		if(editJ.hasFocus() && editJ.getText().toString().compareTo("")!=0)
			{double Jd = Double.valueOf(editJ.getText().toString());
			double eVd = Jd/c;
		
			J = nF.format(Jd);
			eV = dec2.format(eVd);
			K = dec2.format(eVd*a);
			wn = dec2.format(eVd*b);
			nm = dec2.format(d/eVd);
			Thz = dec2.format((sl/(d/eVd))/hzf);
			ry = dec3.format(eVd/ryc);
			}
		
		if(editeV.hasFocus() && editeV.getText().toString().compareTo("")!=0)
			{double eVd = Double.valueOf(editeV.getText().toString());
			
			J = nF.format(eVd*c);
			eV = dec2.format(eVd);
			K = dec2.format(eVd*a);
			wn = dec2.format(eVd*b);
			nm = dec2.format(d/eVd);
			Thz = dec2.format((sl/(d/eVd))/hzf);	
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
			Thz = dec2.format((sl/(d/eVd))/hzf);
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
			Thz = dec2.format((sl/(d/eVd))/hzf);
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
			Thz = dec2.format((sl/nmd)/hzf);
			ry = dec3.format(eVd/ryc);
			}
		
	    if(edithz.hasFocus() && edithz.getText().toString().compareTo("")!=0)
			{double Ghzd = Double.valueOf(edithz.getText().toString());
			double nmd = sl/(Ghzd*1e12);
			double eVd = d/nmd;
			
			J = nF.format(eVd*c);
			K = dec2.format(eVd*a);
			eV = dec2.format(eVd);
			wn = dec2.format(eVd*b);
			nm = dec2.format(nmd);
			Thz = dec2.format(Ghzd);
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
			Thz = dec2.format((sl/(d/eVd))/hzf);
			ry = dec3.format(ryd);
			}
	    
		editJ.setText(J);
		editeV.setText(eV);
	    editK.setText(K);
	    editwn.setText(wn);
	    editnm.setText(nm);
	    edithz.setText(Thz);
	    editry.setText(ry);
	    
	}
	
	
	public void reset(View view) {
		EditText editeV = (EditText) findViewById(R.id.editeV);		
	    EditText editinc = (EditText) findViewById(R.id.editinc);	
	    editeV.setText("1.0");
	    editeV.requestFocus();
	    editinc.setText("0.1");
	    convert(editeV);
		
	}
	
	public void clearfield(View view) {
		EditText editeV = (EditText) findViewById(R.id.editeV);
		EditText editwn = (EditText) findViewById(R.id.editwn);
		EditText editnm = (EditText) findViewById(R.id.editnm);
		EditText editJ = (EditText) findViewById(R.id.editJ);
		EditText editK = (EditText) findViewById(R.id.editK);
		EditText edithz = (EditText) findViewById(R.id.edithz);
		EditText editry = (EditText) findViewById(R.id.editry);
		EditText editinc = (EditText) findViewById(R.id.editinc);
		
		if(editeV.hasFocus())
			{editeV.setText("");
			editinc.setText(String.format("%.0f",0.1));}
		if(editwn.hasFocus())
			{editwn.setText("");
			editinc.setText(String.format("%d",100));}
		if(editnm.hasFocus())
			{editnm.setText("");
			editinc.setText(String.format("%.d",50));}
		if(editJ.hasFocus())
			{editJ.setText("");
			editinc.setText(String.format("%.0f",0.1e-19));}
		if(editK.hasFocus())
			{editK.setText("");
			editinc.setText(String.format("%d",100));}
		if(edithz.hasFocus())
			{edithz.setText("");
			editinc.setText(String.format("%d",100));}
		if(editry.hasFocus())
			{editry.setText("");
			editinc.setText(String.format("%.0f", 0.01));}
	}
	
	public void change(View view, double incr) {
		//EditText editinc = (EditText) findViewById(R.id.editinc);
		EditText editeV = (EditText) findViewById(R.id.editeV);
		EditText editwn = (EditText) findViewById(R.id.editwn);
		EditText editnm = (EditText) findViewById(R.id.editnm);
		EditText editJ = (EditText) findViewById(R.id.editJ);
		EditText editK = (EditText) findViewById(R.id.editK);
		EditText edithz = (EditText) findViewById(R.id.edithz);
		EditText editry = (EditText) findViewById(R.id.editry);
		
		//double incr = Double.valueOf(editinc.getText().toString());
		
		NumberFormat nF  = new DecimalFormat("0.000E0");
		DecimalFormat dec2 = new DecimalFormat("0.00");
		DecimalFormat dec3 = new DecimalFormat("0.000");
		
		if(editeV.hasFocus() && editeV.getText().toString().compareTo("")!=0)
			{//double d = Double.valueOf(editeV.getText().toString()) + incr;
			editeV.setText(dec2.format(Double.valueOf(editeV.getText().toString()) + incr));
			convert(editeV);}
		
		if(editwn.hasFocus() && editwn.getText().toString().compareTo("")!=0)
			{//double d = Double.valueOf(editwn.getText().toString()) + incr;
			editwn.setText(dec2.format(Double.valueOf(editwn.getText().toString()) + incr));
			convert(editwn);}
		
		if(editnm.hasFocus() && editnm.getText().toString().compareTo("")!=0)
			{//double d = Double.valueOf(editnm.getText().toString()) + incr;
			editnm.setText(dec2.format(Double.valueOf(editnm.getText().toString()) + incr));
			convert(editnm);}
		
		if(editJ.hasFocus() && editJ.getText().toString().compareTo("")!=0)
			{//double d = Double.valueOf(editJ.getText().toString()) + incr;
			editJ.setText(nF.format(Double.valueOf(editJ.getText().toString()) + incr));
			convert(editJ);}
		
		if(editK.hasFocus() && editK.getText().toString().compareTo("")!=0)
			{//double d = Double.valueOf(editK.getText().toString()) + incr;
			editK.setText(dec2.format(Double.valueOf(editK.getText().toString()) + incr));
			convert(editK);}
		
		if(edithz.hasFocus() && edithz.getText().toString().compareTo("")!=0)
			{//double d = Double.valueOf(edithz.getText().toString()) + incr;
			edithz.setText(nF.format(Double.valueOf(edithz.getText().toString()) + incr));
			convert(edithz);}
		
		if(editry.hasFocus() && editry.getText().toString().compareTo("")!=0)
			{//double d = Double.valueOf(editry.getText().toString()) + incr;
			editry.setText(dec3.format(Double.valueOf(editry.getText().toString()) + incr));
			convert(editry);}
		
	}
	
	public void inc(View view)
		{EditText editinc = (EditText) findViewById(R.id.editinc);
		//double incr = Double.valueOf(editinc.getText().toString());
		change(view, Double.valueOf(editinc.getText().toString()));	
		}
	
	public void dec(View view)
		{EditText editinc = (EditText) findViewById(R.id.editinc);
		//double incr = Double.valueOf(editinc.getText().toString());
		change(view, -1.00*Double.valueOf(editinc.getText().toString()));	
		}
	
}
