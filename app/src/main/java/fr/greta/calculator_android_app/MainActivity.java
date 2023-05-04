package fr.greta.calculator_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//récuperer les view
        EditText nbr1 =findViewById(R.id.nbr1);
        EditText nbr2  =findViewById(R.id.nbr2);
        Button bottonCompte = findViewById(R.id.buttonCompte);
        TextView textViewResult = findViewById(R.id.TextViewResult);
        ListView listViewResults = findViewById(R.id.listViewResults);
// récuperer les donnée en form de list
        List<String> data = new ArrayList<>();
//créer un adapter

        ArrayAdapter<String> stringArrayAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
//declencheur
        bottonCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount1 =Double.parseDouble(nbr1.getText().toString() );
                double amount2 =Double.parseDouble(nbr2.getText().toString() );

                double result = amount1 + amount2;
                textViewResult.setText(String.valueOf(result));
                data.add(amount1+ "  + "+amount2 +"  = "+ result);
                //informer list view que modele à changer
                stringArrayAdapter.notifyDataSetChanged();

                //enfin effacer la zone de text
                nbr1.setText("");
                nbr2.setText("");

            }
        });

//affiche l'historique dans a list
listViewResults.setAdapter(stringArrayAdapter);

    }
}