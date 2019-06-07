package unipu.hr.rezije;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class plin extends AppCompatActivity {

    DatabaseHelper db;
    Button spremi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plin);

        db = new DatabaseHelper(this);
        spremi = findViewById(R.id.Spremi);
        final TextView rezultat = (TextView) findViewById(R.id.textView16);

        spremi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = rezultat.getText().toString();
                String predmet= new String("Plin");
                if (!number.equals("") && db.addData(number, predmet)){
                    Toast.makeText(plin.this, "Spremljeno", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(plin.this,"Nije spremljeno", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void racunaj_plin(View view) {

        EditText cijena_po_m3 = (EditText) findViewById(R.id.editText15);
        String cijena_po_m3_broj = cijena_po_m3.getText().toString();
        int cijena_po_m3_broj_final=0;
        if(cijena_po_m3_broj.matches("")){
            cijena_po_m3_broj_final = 0;
        } else {
            cijena_po_m3_broj_final = Integer.parseInt(cijena_po_m3_broj);
        }

        EditText pretplata = (EditText) findViewById(R.id.editText8);
        String pretplata_broj = pretplata.getText().toString();
        int pretplata_broj_final=0;
        if(pretplata_broj.matches("")){
            pretplata_broj_final = 0;
        } else {
            pretplata_broj_final = Integer.parseInt(pretplata_broj);
        }

        EditText staro_stanje = (EditText) findViewById(R.id.editText);
        String  staro_stanje_broj =  staro_stanje.getText().toString();
        int  staro_stanje_broj_final = 0;
        if(staro_stanje_broj.matches("")){
            staro_stanje_broj_final = 0;
        } else {
            staro_stanje_broj_final = Integer.parseInt(staro_stanje_broj);
        }

        EditText novo_stanje = (EditText) findViewById(R.id.editText6);
        String novo_stanje_broj = novo_stanje.getText().toString();
        int  novo_stanje_broj_final = 0;
        if(novo_stanje_broj.matches("")){
            novo_stanje_broj_final = 0;
        } else {
            novo_stanje_broj_final = Integer.parseInt(novo_stanje_broj);
        }

        if ( cijena_po_m3_broj.matches("") || pretplata_broj.matches("") || staro_stanje_broj.matches("") || novo_stanje_broj.matches("")) {
            Toast.makeText(this, "Sva polja moraju biti popunjena!", Toast.LENGTH_SHORT).show();
            return;
        }

        if ( novo_stanje_broj_final < staro_stanje_broj_final) {
            Toast.makeText(this, "Novo stanje treba biti veće od starog!", Toast.LENGTH_SHORT).show();
            return;
        }


        double izracun = ((novo_stanje_broj_final-staro_stanje_broj_final)*cijena_po_m3_broj_final)+pretplata_broj_final;

        String x = String.format("%.2f", izracun);

        TextView rezultat = (TextView) findViewById(R.id.textView16);
        rezultat.setText(x + " kn");
    }
}
