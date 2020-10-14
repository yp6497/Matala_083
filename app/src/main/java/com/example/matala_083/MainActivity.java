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

    TextView tv1,tv2;
    Spinner spinI,spinM;
    ListView lv;
    int x,pos,y;
    String [][] Medinot={{"Congo","madagascar","morocco","nigeria","Tanzania","Uganda","sudan"}, {"Argentina", "canada","Brazil","colombia","Mexico","United States","Venezuela"},
            {"Chaina", "India","Israel","Japan","Russia","Turkey","Yemen"}, {"Bulgaria", "France","Germany","Hungary","Italy","Norway","Sweden"}};
    String [] Ibashot={"Choose a continent","Africa","America","Asia","Europe"};
    String [][] CitiesAfrica={{"a","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}/*1*/,{"b","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},/*2*/
    {"c","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}/*3*/,{"d","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}/*4*/,
    {"e","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}/*5*/,{"f","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}/*6*/,
    {"f","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}};/*7*/
    String [][] arrayS=new String[7][4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        spinI=findViewById(R.id.spin1);
        spinM=findViewById(R.id.spin2);
        lv=findViewById(R.id.lv);



        spinI.setOnItemSelectedListener(this);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,Ibashot);
        spinI.setAdapter(adp);
        //spinI.setOnItemSelectedListener(new IbashitClass());
        spinM.setOnItemSelectedListener(new MedinotClass());

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position==0) {
            y++;
        }

        else {
            pos = position - 1;
            spinM.setOnItemSelectedListener(this);
            ArrayAdapter<String> a = new ArrayAdapter<String>(this,
                    R.layout.support_simple_spinner_dropdown_item, Medinot[pos]);
            spinM.setAdapter(a);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    class MedinotClass implements AdapterView.OnItemSelectedListener
    {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            lv.setOnItemSelectedListener(this);
            ArrayAdapter<String> ad = new ArrayAdapter<String>(this,
                    R.layout.support_simple_spinner_dropdown_item,CitiesAfrica);
            lv.setAdapter(ad);
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


}