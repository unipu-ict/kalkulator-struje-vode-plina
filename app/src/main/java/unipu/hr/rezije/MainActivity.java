package unipu.hr.rezije;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button spremi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        spremi = findViewById(R.id.Spremi);
        final TextView rezultat = (TextView) findViewById(R.id.textView7);


        Spinner spinner_tarife_ = (Spinner) findViewById(R.id.spinner_tarife);

        Button gumb = (Button) findViewById(R.id.button);

        spinner_tarife_.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString(); //this is your selected item
                if(selectedItem.equalsIgnoreCase("Plavi jednotarifni") || selectedItem.equalsIgnoreCase("Crni jednotarifni")){
                    EditText niza_staro = (EditText) findViewById(R.id.editText2);
                    EditText niza_novo = (EditText) findViewById(R.id.editText3);
                    TextView niza = (TextView) findViewById(R.id.textView10);
                    niza_novo.setClickable(false);
                    niza_staro.setClickable(false);
                    niza.setVisibility(View.INVISIBLE);
                    niza_novo.setVisibility(View.INVISIBLE);
                    niza_staro.setVisibility(View.INVISIBLE);
                } else {
                    EditText niza_staro = (EditText) findViewById(R.id.editText2);
                    EditText niza_novo = (EditText) findViewById(R.id.editText3);
                    TextView niza = (TextView) findViewById(R.id.textView10);
                    niza_novo.setEnabled(true);
                    niza_staro.setEnabled(true);
                    niza_novo.setVisibility(View.VISIBLE);
                    niza_staro.setVisibility(View.VISIBLE);
                    niza.setVisibility(View.VISIBLE);
                }
            }
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        spremi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = rezultat.getText().toString();
                String predmet= new String("Struja");
                if (!number.equals("") && db.addData(number, predmet)){
                    Toast.makeText(MainActivity.this, "Spremljeno", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,"Nije spremljeno", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void racunaj_struju(View view) {
        TextView rezultat = (TextView) findViewById(R.id.textView7);
        rezultat.setText("");
        Spinner spinner_razdoblja = (Spinner) findViewById(R.id.spinner_razdoblja);
        String odabrano_razdoblje = spinner_razdoblja.getSelectedItem().toString();

        Spinner spinner_tarife_ = (Spinner) findViewById(R.id.spinner_tarife);
        String odabrana_tarifa = spinner_tarife_.getSelectedItem().toString();

        EditText niza_staro = (EditText) findViewById(R.id.editText2);
        String niza_staro_broj = niza_staro.getText().toString();
        int niza_staro_broj_final=0;
        if(niza_staro_broj.matches("")){
            niza_staro_broj_final = 0;
        } else {
            niza_staro_broj_final = Integer.parseInt(niza_staro_broj);
        }

        EditText visa_staro = (EditText) findViewById(R.id.editText4);
        String visa_staro_broj = visa_staro.getText().toString();
        int visa_staro_broj_final=0;
        if(visa_staro_broj.matches("")){
            visa_staro_broj_final = 0;
        } else {
            visa_staro_broj_final = Integer.parseInt(visa_staro_broj);
        }

        EditText visa_novo = (EditText) findViewById(R.id.editText5);
        String visa_novo_broj = visa_novo.getText().toString();
        int visa_novo_broj_final=0;
        if(visa_novo_broj.matches("")){
            visa_novo_broj_final = 0;
        } else {
            visa_novo_broj_final = Integer.parseInt(visa_novo_broj);
        }

        EditText niza_novo = (EditText) findViewById(R.id.editText3);
        String niza_novo_broj = niza_novo.getText().toString();
        int niza_novo_broj_final=0;
        if(niza_novo_broj.matches("")){
            niza_novo_broj_final = 0;
        } else {
            niza_novo_broj_final = Integer.parseInt(niza_novo_broj);
        }

        Button izracunaj = (Button) findViewById(R.id.button);



        double visa_tarifa = 0;
        double niza_tarifa = 0;
        double naknada = 0;
        int razdoblje = Integer.parseInt(odabrano_razdoblje);

        if(odabrana_tarifa.equalsIgnoreCase("Bijeli dvotarifni")){
            if (visa_novo_broj.matches("") || visa_staro_broj.matches("") || niza_novo_broj.matches("") || niza_staro_broj.matches("")) {
                Toast.makeText(this, "Sva polja moraju biti popunjena!", Toast.LENGTH_SHORT).show();
                return;
            }
            visa_tarifa = 0.84;
            niza_tarifa = 0.41;
            naknada = 17.40;
        }

        if(odabrana_tarifa.equalsIgnoreCase("Crveni dvotarifni")){
            if (visa_novo_broj.matches("") || visa_staro_broj.matches("") || niza_novo_broj.matches("") || niza_staro_broj.matches("")) {
                Toast.makeText(this, "Sva polja moraju biti popunjena!", Toast.LENGTH_SHORT).show();
                return;
            }
            visa_tarifa = 0.70;
            niza_tarifa = 0.34;
            naknada = 48.70;
        }

        if(odabrana_tarifa.equalsIgnoreCase("Plavi jednotarifni")){
            if (visa_novo_broj.matches("") || visa_staro_broj.matches("")) {
                Toast.makeText(this, "Sva polja moraju biti popunjena!", Toast.LENGTH_SHORT).show();
                return;
            }
            visa_tarifa = 0.77;
            naknada = 17.40;
            niza_tarifa=0;
            niza_novo_broj_final=0;
            niza_staro_broj_final=0;
        }

        if(odabrana_tarifa.equalsIgnoreCase("Crni jednotarifni")){
            if (visa_novo_broj.matches("") || visa_staro_broj.matches("")) {
                Toast.makeText(this, "Sva polja moraju biti popunjena!", Toast.LENGTH_SHORT).show();
                return;
            }
            visa_tarifa = 0.37;
            naknada = 6.20;
            niza_tarifa=0;
            niza_novo_broj_final=0;
            niza_staro_broj_final=0;
        }

        if ( visa_staro_broj_final>visa_novo_broj_final || niza_staro_broj_final>niza_novo_broj_final) {
            Toast.makeText(this, "Novo stanje treba biti veće od starog!", Toast.LENGTH_SHORT).show();
            return;
        }


        double izracun = ((visa_novo_broj_final - visa_staro_broj_final)*visa_tarifa
                             + (niza_novo_broj_final - niza_staro_broj_final)*niza_tarifa
                             + naknada*razdoblje
                             + ((visa_novo_broj_final - visa_staro_broj_final)+(niza_novo_broj_final - niza_staro_broj_final))*0.1050);

        double izracun_pdv = (izracun*0.13)+izracun;

        String x = String.format("%.2f", izracun_pdv);


        rezultat.setText(x + " kn");

    }
}
