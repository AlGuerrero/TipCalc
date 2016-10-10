package com.a13x.tipcalc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.inputBill)
    EditText inputBill;
    @Bind(R.id.btnSubmit)
    Button btnSubmit;
    @Bind(R.id.inputPercentege)
    EditText inputPercentege;
    @Bind(R.id.btnIncrease)
    Button btnIncrease;
    @Bind(R.id.btnDecrease)
    Button btnDecrease;
    @Bind(R.id.btnClear)
    Button btnClear;
    @Bind(R.id.txtTip)
    TextView txtTip;

    private final static int TIP_STEP_CHANGE = 1;
    private final static int DEFAULT_TIP_CHANGE = 10; //CUESTIONES DE MANTENIBILIDAD

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_about) {
            about();
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btnSubmit)
    public void handleSubmit(){
        hideKeyboard();

        String strInputTotal = inputBill.getText().toString().trim();

        if(!strInputTotal.isEmpty()) {  //verificar que este vacio
            double total = Double.parseDouble(strInputTotal);
            int tipPercentage = getTipPercentage();

            double tip =total * (tipPercentage/100d);

            String strTip = String.format(getString(R.string.global_message_tip, tip));
            txtTip.setVisibility(View.VISIBLE);
            txtTip.setText(strTip);
        }
    }

    public void handleClickIncrease(){
        //cuando des click a + debe llamar a handleTipChange y sumar 1
    }

    public void handleClickDecrease(){
        //Cuando des click a - debe llamar a handleTipChange y restar 1
    }

    //publ
    public int getTipPercentage() {
        //
        //1.- Crear una variable tipPercentage en la que guardemos DEFAULT_TIP_CHANGE
        //2.- Crear una variable String strInputTipPercentage que tome el valor del inputPercentage
        //3.- Verificar que la cadena no venga vacia
        //3a.- Si no viene Vacia sobre escribir tipPercentage con el valor de strInputPercentage
        //3b.- inputPercentage.setText(String.valueOf(DEFAULT_TIP_PERCENTAGE));
        //4.- Devolver el valor de tipPercentage
        return DEFAULT_TIP_CHANGE;
    }

    public void handleTipChange(int change) {
        //1.- Llammar a get tip Percentage(en una variable)
        //2.- Aplicar el incremento/decremento que viene en change
        //4.- s tip percentage mayor que cero entonces colocar el valor en el input
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        try {
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch(NullPointerException npe) {
            Log.e(getLocalClassName(), Log.getStackTraceString(npe));
        }
    }

    private void about() {
        TipCalcApp app = (TipCalcApp) getApplication();
        String strUrl = app.getAboutUrl();

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(strUrl));
        startActivity(intent);
    }

}
