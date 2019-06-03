package unipu.hr.rezije;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class OstaloKalkulator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ostalo_kalkulator);
    }

    public void racunaj(View view) {
        TextView rezultat = (TextView) findViewById(R.id.textView21);
        rezultat.setText("");

        EditText struja = (EditText) findViewById(R.id.editText12);
        String struja_broj = struja.getText().toString();
        int struja_broj_final=0;
        if(struja_broj.matches("")){
            struja_broj_final = 0;
        } else {
            struja_broj_final = Integer.parseInt(struja_broj);
        }

        EditText voda = (EditText) findViewById(R.id.editText11);
        String voda_broj = voda.getText().toString();
        int voda_broj_final=0;
        if(voda_broj.matches("")){
            voda_broj_final = 0;
        } else {
            voda_broj_final = Integer.parseInt(voda_broj);
        }

        EditText plin = (EditText) findViewById(R.id.editText13);
        String plin_broj = plin.getText().toString();
        int plin_broj_final=0;
        if(plin_broj.matches("")){
            plin_broj_final = 0;
        } else {
            plin_broj_final = Integer.parseInt(plin_broj);
        }

        EditText TV = (EditText) findViewById(R.id.editText16);
        String TV_broj = TV.getText().toString();
        int TV_broj_final=0;
        if(TV_broj.matches("")){
            TV_broj_final = 0;
        } else {
            TV_broj_final = Integer.parseInt(TV_broj);
        }

        EditText komunalije = (EditText) findViewById(R.id.editText14);
        String komunalije_broj = komunalije.getText().toString();
        int komunalije_broj_final=0;
        if(komunalije_broj.matches("")){
            komunalije_broj_final = 0;
        } else {
            komunalije_broj_final = Integer.parseInt(komunalije_broj);
        }

        EditText gorivo = (EditText) findViewById(R.id.editText18);
        String gorivo_broj = gorivo.getText().toString();
        int gorivo_broj_final=0;
        if(gorivo_broj.matches("")){
            gorivo_broj_final = 0;
        } else {
            gorivo_broj_final = Integer.parseInt(gorivo_broj);
        }

        EditText telefon = (EditText) findViewById(R.id.editText17);
        String telefon_broj = telefon.getText().toString();
        int telefon_broj_final=0;
        if(telefon_broj.matches("")){
            telefon_broj_final = 0;
        } else {
            telefon_broj_final = Integer.parseInt(telefon_broj);
        }

        EditText mobitel = (EditText) findViewById(R.id.editText20);
        String mobitel_broj = mobitel.getText().toString();
        int mobitel_broj_final=0;
        if(mobitel_broj.matches("")){
            mobitel_broj_final = 0;
        } else {
            mobitel_broj_final = Integer.parseInt(mobitel_broj);
        }

        EditText kredit = (EditText) findViewById(R.id.editText19);
        String kredit_broj = kredit.getText().toString();
        int kredit_broj_final=0;
        if(kredit_broj.matches("")){
            kredit_broj_final = 0;
        } else {
            kredit_broj_final = Integer.parseInt(kredit_broj);
        }

        double izracun = kredit_broj_final+ mobitel_broj_final+telefon_broj_final+gorivo_broj_final+
                komunalije_broj_final+TV_broj_final+ plin_broj_final+ voda_broj_final+ struja_broj_final;

        String x = String.format("%.2f", izracun);

        rezultat.setText(x + " kn");
    }
}
