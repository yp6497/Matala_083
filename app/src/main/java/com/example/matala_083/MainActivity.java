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
    int x=0, pos, y,z,a;

    String[][] Medinot = {{"Choose a c in af","Congo", "madagascar", "morocco", "nigeria", "Tanzania", "Uganda", "sudan"}, {"Choose a c in am","Argentina", "canada", "Brazil", "colombia", "Mexico", "United States", "Venezuela"},
            {"Choose a c in as","China", "India", "Israel", "Japan", "Russia", "Turkey", "Yemen"}, {"Choose a c in er","Bulgaria", "France", "Germany", "Hungary", "Italy", "Norway", "Sweden"}};
    String[] Ibashot = {"Choose a continent", "Africa", "America", "Asia", "Europe"};
    String [][] CitiesAfrica = {{"Bandundu", "Boma", "Bukavu", "Kananga", "Lubumbashi"}, {"Antananarivo","Antsirabe", "Antsiranana", "Toamasina","Toliara"}, {"Azrou","Berrechid","Casablanca", "Tangier","Khenifra"}, {"Aba", "Bida", "Ikare", "Kano", "Lagos"},
            {"Dodoma", "Handeni","Iringa", "Lindi", "Mpanda"}, {"Entebbe", "Hoima", "Gulu", "Masaka", "Ssabagabo"}, {"Al-Fashir", "El-Obied", "Nyala", "Omdurman", "Port Sudan"}};
    String [][] CitiesAmerica = {{"Rosario","Cordoba","Corrientes","Formosa","Salta"}, {"Alberta","Manitoba","New Brunswick","Ontario","Yukon"},
            {"Aracaju", "Belem", "Brasilia", "Itaborai", "Sorocaba"}, {"Anori", "Barbosa", "Caldas", "Fredonia", "Marinilla"}, {"Cancוn", "Chimalhuacán", "Fresnillo", "Iguala", "Minatitlán"}, {"Boston", "Detroit", "Miami", "Stockton", "Tucson"}, {"Araure", "Barinas", "Cumana", "Guacara", "Mariara"}};
    String [][] CitiesAsia = {{"Anqing", "Beijing", "Fuyang", "Huainan", "Longyan"}, {"Amravati", "Bhiwandi", "Firozabad", "Guntur", "Noida"},{"Beersheba","Hifa", "Jerusalem", "Natanya", "Tel Aviv"}, {"Anjo", "Chita", "Gamagōri", "Ōbu", "Yatomi"}, {"Berezniki", "Dimitrovgrad", "Kaspiysk", "Nazran","Obninsk"}, {"Ankara", "Batman", "Darıca", "İzmit", "KırıkkaleSiverek"}, {"Aden", "Hajjah", "Ibb", "Khamir", "Socotra"}};
    String [][] CitiesEurope = {{"Burgas", "Dobrich", "Haskovo", "Pernik", "Shumen"}, {"Bordeaux", "Dijon", "Fréjus","Laval", "Vannes"}, {"Berlin", "Bremen", "Dortmund", "Mannheim", "Salzgitter"}, {"Budapest", "Debrecen", "Győr", "Kecskemét", "Szeged"}, {"Latina", "Olbia", "Prato", "Rome", "Terni"}, {"Arendal", "Bergen", "Floro", "Grimstad", "Moss"}, {"Arboga", "Arvika", "Boden", " Hjo", "Kiruna"}};
    String [][] IaboutCitiesAf = {/*1*/{"222 km2","143,435"},{"65 km2","162,521"},{"60 km2 ","870,954"},{"7,428 km2 ","1,271,704"},{"747 km2","1,794,118"}/*2*/,{"85.01 km2","1,275,207"},{"132.94 km2","257,163"},{"42 km2","115,015"},{"20 km2","300,813"},{"16 km2","156,710"},/*3*/
            {"9 km2","81,350"},{"43 km2","136,634"},{"220 km2","3,359,818"},{"150 km2","947,952"},{"228,567","34 km2"},/*4*/{"72 km2","534,265"},{"51 km2","188,181"},{"41 km2","160,600"},{"449 km2","2,828,861"},{"1,171.3 km2","8,048,430"},/*5*/{"2,576 km2","410,956"},
            {"8,322 km2","79,056"}, {"458 km2","1,211,900"},{"5,673 km2","41,549"},{"6,655 km2","45,977"},/*5*/{"56.2 km2","69,958"},{"23 km2","100,099"},{"35 km2","152,276"},{"44 km2","103,829"},{"61 km2","284,067"},/*6*/{"73 km2","263,243"},{"58 km2","418,280"},{"55 km2","565,734"},{"614.9 km2","2,395,159"},{"172 km2","489,725"},/*7*/};
    String [][] IaboutCitiesAm = {/*1*/{"178.69 km2","1,236,089"},{"576 km2","1,391,298"},{"500 km2","346,334"},{"72,066 km2","234,000"},{"125 km2","535,303"},/*2*/{"661,848 km2","4,067,175"},{"649,950 km2","1,278,365 "},{"72,907 km2","747,101"},{"1,076,395 km2","13,448,494 "},{"482,443 km2","35,874"},
            /*3*/{"181.857 km2","641,523"},{"1,059.40 km2","1,439,561"},{"5,802 km2","3,039,444"},{"430.375 km2","238,695"},{"450.38 km2","644,919"},/*4*/{"1,430 km2 ","14,502"},{"234 km2","53,943"},{"133.40 km2","82,234"},{"9 km2","18,790"},{"31 km2","57,403"},/*5*/{"1,978.75 km2","743,626"},{"44.69 km2","614,453"},{"4,900 km2","110,892"},{"21 km2","110,390"},{"4,124 km2","356,020"},
            /*6*/{"125.1 km2","692,600"},{"359.5 km2","670,031"},{"93.2 km2","467,963"},{"169.01 km2","291,707"},{"623.65 km2","520,116"},/*7*/{"144.166 km2","11,908"},{"322.71 km2 ","353,442"},{"598 km2","423,546"},{"320 km2 ","178,000"},{"150 km2","115,515"},};
    String [][] IaboutCitiesAs = {/*1*/{"13,590 km2","5,311,379"},{"16,410.5 km2","21,542,000"},{"9,775 km2","7,599,913"},{"5,533 km2","2,333,896"},{"19,069 km2","2,559,545"},/*2*/{"183 km2 ","647,057"},{"195 km2","709,665"},{"155 km2","603,797"},{"168.4 km2","743,354"},{"203 km2","637,272"},
            /*3*/{"117.5 km2","209,687"},{"63.666 km2","285,316"},{"125.156 km2","936,425"},{"34.75 km2","221,353"},{"52 km2","460,613"},/*4*/{"86.05 km2","188,693"},{"45.90 km2","83,891"},{"56.92 km2","80,063"},{"33.66 km2","92,179"},{"49.00 km2","44,589"},
            /*5*/{"89 km2","156,466"},{"84 km2","122,580"},{"32.94 km2 ","100,129"},{"80 km2","93,335"},{"42.97 km2","104,739"},/*6*/{"24,521 km2","5,700,000"},{"563.59 km2","348,963"},{"231 km2 ","157,304"},{"318.07 km2","192,473"},{"4,366.84 km2","120,556"},/*7*/{"760 km2","863,000"},{"54 km2","53,887"},{"139 km2","160,000"},{"12 km2","18,645"},{"3,796 km2","60,000"},};
    String [][] IaboutCitiesEr = {/*1*/{"253.644 km2"," 202,694"},{"109.018 km2","88,281"},{"25.555 km2","75 641"},{"72.289 km2","75,191"},{"136.358 km2","75,550"},/*2*/{"49.36 km2","252,040"},{"40.41 km2","153,668"},{"102.27 km2","52,532"},{"34.2 km2 ","51,182"},{"32.3 km2","52,648"},
            /*3*/{"891.1 km2","3,769,495"},{"419.38 km2","681,032"},{"280.71 km2 ","588,250"},{"144.96 km2 ","310,658"},{"223.92 km2","104,291"},/*4*/{"525.2 km2","1,752,286"},{"461.25 km2","202,402"},{"174.62 km2","129,301"},{"321.36 km2","110,813"},{"280.84 km2 ","160,766"},
            /*5*/{"277 km2","129,133"},{"383.64 km2","60,261"},{"97.35 km2","194,913"},{"1,285 km2","2,837,332"},{"211.9 km2","110,530"},/*6*/{"30.86 km2","42,788"},{"464.71 km2","283,929"},{"6.45 km2","9,024"},{"9.41 km2","12,522"},{"63 km2 ","32 570"},/*7*/{"9.50 km2","10,330"},{"10.62 km2","14,244"},{"19.98 km2","18,277"},{"4.54 km2","6,094"},{"16.53 km2","22,906"}};
    //area=first populoation=second

    String [][] arrayS = new String[7][5];
    String [][] arrayI = new String[35][2];


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

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinner = (Spinner) parent;
        pos=position-1;

        if (spinner.getId()==R.id.spin1) {
            if(position==1) {
                arrayS = CitiesAfrica;
                arrayI= IaboutCitiesAf;
            }
            else if (position==2){
                arrayS=CitiesAmerica;
                arrayI= IaboutCitiesAm;
            }
            else if (position==3) {
                arrayS=CitiesAsia;
                arrayI= IaboutCitiesAs;
            }
            else if(position==4) {
                arrayS=CitiesEurope;
                arrayI= IaboutCitiesEr;
            }
            if (position == 0) {

            } else {
                spinM.setOnItemSelectedListener(this);
                ArrayAdapter<String> a = new ArrayAdapter<String>(this,
                        R.layout.support_simple_spinner_dropdown_item, Medinot[pos]);
                spinM.setAdapter(a);
            }
        }
        else if(spinner.getId()== R.id.spin2){

            tv1.setText("");
            tv2.setText("");
            pos=position-1;

            if (position == 0) {
                lv.setAdapter(null);
            }
            else {
                lv.setOnItemClickListener(this);
                ArrayAdapter<String> adpl = new ArrayAdapter<String>(this,
                        R.layout.support_simple_spinner_dropdown_item, arrayS[pos]);
                lv.setAdapter(adpl);
                a=pos;
            }
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if(a==1) x=5;
        else if(a==2) x=10;
        else if(a==3) x=15;
        else if(a==4) x=20;
        else if(a==5) x=25;
        else if(a==6) x=30;

        x=x+position;
        tv1.setText("area: "+arrayI[x][0]);
        tv2.setText("populotion: "+arrayI[x][1]);
    }
}