package com.example.myapplicationhms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 10yrs", "Mobile No : 9898989898", "1000"},
                    {"Doctor Name : Swapnil Kadam", "Hospital Address : Pimpri ", "Exp : 7yrs", "Mobile No : 9865986598", "800"},
                    {"Doctor Name : Rani Kale", "Hospital Address : Chinchwad", "Exp : 5yrs", "Mobile No : 9922972299", "700"},
                    {"Doctor Name : Ashok Deshmukh", "Hospital Address : Pune", "Exp : 15yrs", "Mobile No : 7788997899", "1200"},
                    {"Doctor Name : Raj Tiwari", "Hospital Address : Katraj", "Exp : 8yrs", "Mobile No : 9494989877", "800"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Neelam Patil", "Hospital Address : Pimpri", "Exp : 6yrs", "Mobile No : 7894561237", "700"},
                    {"Doctor Name : Swati Pawar", "Hospital Address : Hadapsar", "Exp : 9yrs", "Mobile No : 9493929998", "800"},
                    {"Doctor Name : Nayan Zha", "Hospital Address : Bhosari", "Exp : 12yrs", "Mobile No : 7879747578", "1000"},
                    {"Doctor Name : Mayuri Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No : 9798999994", "700"},
                    {"Doctor Name : Raju Rastogi", "Hospital Address : Swargate", "Exp : 9yrs", "Mobile No :1234567890 ", "900"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Prathmesh Shinde", "Hospital Address : Nigdi", "Exp : 10yrs", "Mobile No : 9898329898", "1000"},
                    {"Doctor Name : Swapnil Katkar", "Hospital Address : Pimpri ", "Exp : 7yrs", "Mobile No : 9865216598", "800"},
                    {"Doctor Name : Rajesh Kadam", "Hospital Address : Talegaon", "Exp : 5yrs", "Mobile No : 9922142299", "700"},
                    {"Doctor Name : Ashok Deshpande", "Hospital Address : Pune", "Exp : 15yrs", "Mobile No : 7788857899", "1200"},
                    {"Doctor Name : Raj Singh", "Hospital Address : Katraj", "Exp : 8yrs", "Mobile No : 9494969877", "800"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Kiran Mali", "Hospital Address : Nigdi", "Exp : 10yrs", "Mobile No : 9898989785", "1000"},
                    {"Doctor Name : Sonali Patil", "Hospital Address : Pimpri ", "Exp : 7yrs", "Mobile No : 9865986598", "800"},
                    {"Doctor Name : Ram Singh", "Hospital Address : Chinchwad", "Exp : 5yrs", "Mobile No : 9922972457", "700"},
                    {"Doctor Name : Aarati Raut", "Hospital Address : Pune", "Exp : 15yrs", "Mobile No : 7218997899", "1200"},
                    {"Doctor Name : Nilesh Borate", "Hospital Address : Katraj", "Exp : 8yrs", "Mobile No : 9494289877", "800"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Swapnali Pawar", "Hospital Address : Nigdi", "Exp : 10yrs", "Mobile No : 9898987498", "1000"},
                    {"Doctor Name : Viraj Kadam", "Hospital Address : Pimpri ", "Exp : 7yrs", "Mobile No : 9864586598", "800"},
                    {"Doctor Name : Manju Rastogi", "Hospital Address : Chinchwad", "Exp : 5yrs", "Mobile No : 9922987299", "700"},
                    {"Doctor Name : Ajay Deshmukh", "Hospital Address : Pune", "Exp : 15yrs", "Mobile No : 7788997890", "1200"},
                    {"Doctor Name : Anil Shinde", "Hospital Address : Baner", "Exp : 8yrs", "Mobile No : 9494989456", "800"}
            };

    TextView tv;
    Button btn;
    String [][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonBMDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if (title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

            list = new ArrayList();
            for (int i=0;i< doctor_details.length;i++){
                item = new HashMap<String,String>();
                item.put("line1", doctor_details[i][0]);
                item.put("line2", doctor_details[i][1]);
                item.put("line3", doctor_details[i][2]);
                item.put("line4", doctor_details[i][3]);
                item.put("line5", "Cons Fees:"+doctor_details[i][4]+"/-");
                list.add(item);
            }
            sa = new SimpleAdapter(this,list,R.layout.multi_lines, new String[]{"line1","line2","line3","line4","line5"},
                 new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst = findViewById(R.id.editTextTextBMDMultiline);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}