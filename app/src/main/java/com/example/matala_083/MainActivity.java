package com.example.matala_083;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    TextView tv1, tv2;
    Spinner spinI, spinM;
    ListView lv;
    int x, pos=-1,pos2=0, y,z,a;
    String[][] Medinot = {{"Choose a c in af","Congo", "madagascar", "morocco", "nigeria", "Tanzania", "Uganda", "sudan"}, {"Choose a c in am","Argentina", "canada", "Brazil", "colombia", "Mexico", "United States", "Venezuela"},
            {"Choose a c in as","Chaina", "India", "Israel", "Japan", "Russia", "Turkey", "Yemen"}, {"Choose a c in er","Bulgaria", "France", "Germany", "Hungary", "Italy", "Norway", "Sweden"}};
    String[] Ibashot = {"Choose a continent", "Africa", "America", "Asia", "Europe"};
    String [][] CitiesAfrica = {{"a", "", "", "", ""}, {"b", "", "", "", ""}, {"c", "", "", "", ""}, {"d", "", "", "", ""}, {"e", "", "", "", ""}, {"f", "", "", "", ""}, {"g", "", "", "", ""}};
    String [][] CitiesAmerica = {{"aa", "", "", "", ""}, {"bb", "", "", "", ""}, {"cc", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}};
    String [][] CitiesAsia = {{"aaa", "", "", "", ""}, {"bbb", "", "", "", ""}, {"ccc", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}};
    String [][] CitiesEurope= {{"aaaa", "", "", "", ""}, {"bbbb", "bbbb", "","", ""}, {"cccc", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}};
    String [][] IaboutCitiesAf={{"y","y"},{"n",""},{"",""},{"",""},{"",""}/*1*/,{"z","n"},{"d",""},{"",""},{"",""},{"",""},{"fg",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},
            {"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"n","n"},{"",""},{"",""},{"",""},{"",""},};
    String [][] arrayS = new String[7][5];

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
        pos=position-1;

        if (spinner.getId()==R.id.spin1) {
            if(position==1) arrayS=CitiesAfrica;
            else if (position==2) arrayS=CitiesAmerica;
            else if (position==3) arrayS=CitiesAsia;
            else if(position==4) arrayS=CitiesEurope;
            tv2.setText(position+"pos");
            if (position == 0) {
                y++;
            } else {
                spinM.setOnItemSelectedListener(this);
                ArrayAdapter<String> a = new ArrayAdapter<String>(this,
                        R.layout.support_simple_spinner_dropdown_item, Medinot[pos]);
                spinM.setAdapter(a);
            }
        }
        else if(spinner.getId()== R.id.spin2){
            z=position-1;
            if (position == 0) {
                lv.setAdapter(null);
            }
            else {
                lv.setOnItemClickListener(this);
                ArrayAdapter<String> adpl = new ArrayAdapter<String>(this,
                        R.layout.support_simple_spinner_dropdown_item, arrayS[z]);
                lv.setAdapter(adpl);
                a=pos;
                tv1.setText(a+"a");
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

        /*if(a>0) {
            for (int i = 0; i < a; i++) {
                pos2 = pos2 + 5;
            }
        }
         */
        if(a==1) x=5;
        else if(a==2) x=10;
        else if(a==3) x=15;
        else if(a==4) x=20;
        else if(a==5) x=25;
        else if(a==6) x=30;
        x=x+position;
        //else if(a==0) pos2=position;
        //if(position==0) pos2=position;
        //else if(position>0) pos2=position+5;
        tv1.setText(IaboutCitiesAf[x][0]+" p");
        tv2.setText(IaboutCitiesAf[x][1]+" po");
    }


}