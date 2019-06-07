package unipu.hr.rezije;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        mainGrid = (GridLayout)findViewById(R.id.mainGrid);
        
        
        setSingleEvent(mainGrid);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        for (int i=0; i<mainGrid.getChildCount();i++){
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finalI==0){
                        Bundle bundle=new Bundle();
                        final Intent i=new Intent(MainMenu.this, MainActivity.class);
                        startActivity(i);
                    }
                    if (finalI==1){
                        Bundle bundle=new Bundle();
                        final Intent i=new Intent(MainMenu.this, voda.class);
                        startActivity(i);
                    }
                    if (finalI==2){
                        Bundle bundle=new Bundle();
                        final Intent i=new Intent(MainMenu.this, plin.class);
                        startActivity(i);
                    }
                    if (finalI==3){
                        Bundle bundle=new Bundle();
                        final Intent i=new Intent(MainMenu.this, OstaloKalkulator.class);
                        startActivity(i);
                    }
                    if (finalI==4){
                        Bundle bundle=new Bundle();
                        final Intent i=new Intent(MainMenu.this, ListLayout.class);
                        startActivity(i);
                    }
                }
            });
        }
    }

}
