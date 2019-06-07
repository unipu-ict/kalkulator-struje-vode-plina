package unipu.hr.rezije;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListLayout extends AppCompatActivity {
    private static final String Tag = "ListLayout";
    private ListView Listview1;
    private ListView Listview2;
    DatabaseHelper db;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout);
        Listview1 = (ListView)findViewById(R.id.Listview1);
        Listview2 = (ListView)findViewById(R.id.Listview2);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        db = new DatabaseHelper(this);

        populateListView();
    }

    private void populateListView(){
        Cursor data = db.getData();
        List<String> listData = new ArrayList<>();
        List<String> listData1= new ArrayList<>();


        while(data.moveToNext()){
            listData.add(data.getString(1));
            listData1.add(data.getString(2));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        Listview2.setAdapter(adapter);
        ListAdapter adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData1);
        Listview1.setAdapter(adapter1);


        Listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();

                Cursor data = db.getItemID(name);
                int itemID = -1;
                while(data.moveToNext()){
                    itemID = data.getInt(0);
                }
                if(itemID > -1){
                    Intent editScreenIntent = new Intent(ListLayout.this, DeleteScreen.class);
                    editScreenIntent.putExtra("id",itemID);
                    editScreenIntent.putExtra("name",name);
                    startActivity(editScreenIntent);
                }
                else{
                    toastMessage("Nema id");
                }
            }
        });
    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
