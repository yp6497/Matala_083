package com.example.matala_083;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    TextView tv1, tv2;
    Spinner spinI, spinM;
    ListView lv;
    int x, pos=-1, y,z=-1;
    String[][] Medinot = {{"Choose a c in af","Congo", "madagascar", "morocco", "nigeria", "Tanzania", "Uganda", "sudan"}, {"Choose a c in am","Argentina", "canada", "Brazil", "colombia", "Mexico", "United States", "Venezuela"},
            {"Choose a c in as","Chaina", "India", "Israel", "Japan", "Russia", "Turkey", "Yemen"}, {"Choose a c in er","Bulgaria", "France", "Germany", "Hungary", "Italy", "Norway", "Sweden"}};
    String[] Ibashot = {"Choose a continent", "Africa", "America", "Asia", "Europe"};
    String [][] CitiesAfrica = {{"a", "", "", "", ""}, {"b", "", "", "", ""}, {"c", "", "", "", ""}, {"d", "", "", "", ""}, {"e", "", "", "", ""}, {"f", "", "", "", ""}, {"g", "", "", "", ""}};
    String[][] arrayS = new String[7][4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        spinI = findViewById(R.id.spin1);
        spinM = findViewById(R.id.spin2);
        lv = findViewById(R.id.lv);


        spinI.setOnItemSelectedListener(this);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, Ibashot);
        spinI.setAdapter(adp);

        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //spinI.setOnItemSelectedListener(new IbashitClass());
        //spinM.setOnItemSelectedListener(new MedinotClass());


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;

        x=position;
        pos=position-1;

        if (spinner.getId()==R.id.spin1) {
            tv2.setText(position+"pos");
            //lv.setAdapter(null);
            if (position == 0) {
                y++;
            } else {
                //pos = position - 1;
                spinM.setOnItemSelectedListener(this);
                ArrayAdapter<String> a = new ArrayAdapter<String>(this,
                        R.layout.support_simple_spinner_dropdown_item, Medinot[pos]);
                spinM.setAdapter(a);
            }
        }
        else if(spinner.getId()== R.id.spin2){
            //if(position==0) pos=0;
            //lv.setAdapter(null);
            if (position == 0) {
                lv.setAdapter(null);
            }
            //if(z==0) lv.setAdapter(null);
            //else {
            else {
                lv.setOnItemClickListener(this);
                ArrayAdapter<String> adpl = new ArrayAdapter<String>(this,
                        R.layout.support_simple_spinner_dropdown_item, CitiesAfrica[pos]);
                lv.setAdapter(adpl);
            }
            }
        }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /*lass MedinotClass implements AdapterView.OnItemSelectedListener
    {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        ArrayAdapter<String> adpl = new ArrayAdapter<String>(this,
                    R.layout.support_simple_spinner_dropdown_item, CitiesAfrica[0]);
            lv.setAdapter(adpl);
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
     */

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


}