package com.example.mpesoconsulta;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MPsoActivity extends Activity {
	//private MPSOAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mpso);
		final EditText editText = (EditText) findViewById(R.id.editTUC);
		final TextView txtResult = (TextView) findViewById(R.id.textResult);
		//TODO: Implementar retorno de valores a una lista cuando se vuelva a consultar utilizando el adaptar
		//ListView list = (ListView) findViewById(R.id.list);
		//adapter = new MPSOAdapter(this);
		//list.setAdapter(adapter);
		editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					String tarjetaTUC = editText.getText().toString();
					MPesoCaller mpsoCaller = new MPesoCaller(getBaseContext());
					
					if(editText.getText().length()<8 || editText.getText().length()>8)
					{
						txtResult.setTextColor(Color.parseColor("#FF0000"));
						txtResult.setText("No es un Número de tarjeta válida");
					}
					else
					{
						
						if(editText.getText().length() == 8)
						{
							//TODO: Feedback al usuario que esta trabajando??
							mpsoCaller.consultarSaldo(tarjetaTUC,txtResult);
						}
							
					}
					
					Log.d("MPESOAPP", "On Editor Action");
					return true;
				}

				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mpso, menu);
		return true;
	}

}
