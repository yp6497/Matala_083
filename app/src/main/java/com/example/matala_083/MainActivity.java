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
    String [][] CitiesAfrica = {{"Bandundu", "Boma", "Bukavu", "Kananga", "Lubumbashi"}, {"Antananarivo","Antsirabe", "Antsiranana", "Toamasina","Toliara"}, {"Azrou","Berrechid","Casablanca", "Tangier","Khenifra"}, {"Aba", "Bida", "Ikare", "Kano", "Lagos"},
            {"Dodoma", "Handeni","Iringa", "Lindi", "Mpanda"}, {"Entebbe", "Hoima", "Gulu", "Masaka", "Ssabagabo"}, {"Al-Fashir", "El-Obied", "Nyala", "Omdurman", "Port Sudan"}};
    String [][] CitiesAmerica = {{"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}};
    String [][] CitiesAsia = {{"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}};
    String [][] CitiesEurope = {{"", "", "", "", ""}, {"", "", "","", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}};
    String [][] IaboutCitiesAf = {{"222 km2","143,435"},{"65 km2","162,521"},{"60 km2 ","870,954"},{"7,428 km2 ","1,271,704"},{"747 km2","1,794,118"}/*1*/,{"85.01 km2","1,275,207"},{"132.94 km2","257,163"},{"42 km2","115,015"},{"20 km2","300,813"},{"16 km2","156,710"},/*2*/
            {"9 km2","81,350"},{"43 km2","136,634"},{"220 km2","3,359,818"},{"150 km2","947,952"},{"228,567","34 km2"},/*3*/{"72 km2","534,265"},{"51 km2","188,181"},{"41 km2","160,600"},{"449 km2","2,828,861"},{"1,171.3 km2","8,048,430"},/*4*/{"2,576 km2","410,956"},
            {"8,322 km2","79,056"}, {"458 km2","1,211,900"},{"5,673 km2","41,549"},{"6,655 km2","45,977"},/*5*/{"56.2 km2","69,958"},{"23 km2","100,099"},{"35 km2","152,276"},{"44 km2","103,829"},{"61 km2","284,067"},/*6*/{"73 km2","263,243"},{"58 km2","418,280"},{"55 km2","565,734"},{"614.9 km2","2,395,159"},{"172 km2","489,725"},/*7*/};
    String [][] IaboutCitiesAm = {{"",""},{"",""},{"",""},{"",""},{"",""},/*1*/{"",""},{"",""},{"",""},{"",""},{"",""},/*2*/
            {"",""},{"",""},{"",""},{"",""},{"",""},/*3*/{"",""},{"",""},{"",""},{"",""},{"",""},/*4*/
            {"",""},{"",""},{"",""},{"",""},{"",""},/*5*/{"",""},{"",""},{"",""},{"",""},{"",""},/*6*/{"",""},{"",""},{"",""},{"",""},{"",""},/*7*/};
    String [][] IaboutCitiesAs = {{"",""},{"",""},{"",""},{"",""},{"",""},/*1*/{"",""},{"",""},{"",""},{"",""},{"",""},/*2*/
        {"",""},{"",""},{"",""},{"",""},{"",""},/*3*/{"",""},{"",""},{"",""},{"",""},{"",""},/*4*/
        {"",""},{"",""},{"",""},{"",""},{"",""},/*5*/{"",""},{"",""},{"",""},{"",""},{"",""},/*6*/{"",""},{"",""},{"",""},{"",""},{"",""},/*7*/};
    String [][] IaboutCitiesEr = {{"",""},{"",""},{"",""},{"",""},{"",""},/*1*/{"",""},{"",""},{"",""},{"",""},{"",""},/*2*/
        {"",""},{"",""},{"",""},{"",""},{"",""},/*3*/{"",""},{"",""},{"",""},{"",""},{"",""},/*4*/
        {"",""},{"",""},{"",""},{"",""},{"",""},/*5*/{"",""},{"",""},{"",""},{"",""},{"",""},/*6*/{"",""},{"",""},{"",""},{"",""},{"",""},/*7*/};
    //populoation=second area=first
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