package unipu.hr.rezije;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DeleteScreen extends AppCompatActivity {

    private Button btnDelete;
    DatabaseHelper db;

    private int selektiranid;
    private String selektiranime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_screen);
        btnDelete=(Button)findViewById(R.id.btnDelete);


        db = new DatabaseHelper(this);
        Intent receivedIntent = getIntent();

        selektiranid = receivedIntent.getIntExtra("id",-1);

        selektiranime = receivedIntent.getStringExtra("name");


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteName(selektiranid,selektiranime);
                Intent editScreenIntent = new Intent(DeleteScreen.this, MainMenu.class);
                startActivity(editScreenIntent);

            }
        });
    }
}
