package com.example.graduation_project_2021;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.graduation_project_2021.calc.DiseaseCalculator;
import com.example.graduation_project_2021.model.ValueHolder;

public class MainActivity3 extends AppCompatActivity {

    EditText ultrasound, amylase, lipase, bilirubin, ggt, ast, wbc, crp, choledoch;
    RadioGroup radioPain, radioHyropic, radioMurphy;
    Button btnCalculate, btnClear;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //edit text
        ultrasound = findViewById(R.id.edtUltrasound);
        amylase = findViewById(R.id.edtAmylase);
        lipase = findViewById(R.id.edtLipase);
        bilirubin = findViewById(R.id.edtBilirubin);
        ggt = findViewById(R.id.edtGGT);
        ast = findViewById(R.id.edtAST);
        wbc = findViewById(R.id.edtWBC);
        crp = findViewById(R.id.edtCRP);
        choledoch = findViewById(R.id.edtCholedoch);
        //Radio groups
        radioHyropic = findViewById(R.id.radiohyropic);
        radioPain = findViewById(R.id.radiopain);
        radioMurphy = findViewById(R.id.radioMurphy);
        //function and text view
        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);
        result = findViewById(R.id.text_result);

      btnClear.setOnClickListener(v -> {
          ValueHolder value = new ValueHolder();
          radioPain.getCheckedRadioButtonId();
          crp.setText("");
          wbc.setText("");
          ggt.setText("");
          ast.setText("");
          choledoch.setText("");
          bilirubin.setText("");
          amylase.setText("");
          lipase.setText("");
          ultrasound.setText("");
          radioPain.clearCheck();
          radioMurphy.clearCheck();
          radioHyropic.clearCheck();

      });

        btnCalculate.setOnClickListener(v -> {
            ValueHolder valueHolder = new ValueHolder();
            //Checking integer values are null or not null
            if (!choledoch.getText().toString().isEmpty()) {
                valueHolder.setCholedoch(Integer.parseInt(choledoch.getText().toString()));
            }

            if (!ggt.getText().toString().isEmpty()){
                valueHolder.setGgt(Integer.parseInt(ggt.getText().toString()));
            }

            if (!ast.getText().toString().isEmpty()){
                valueHolder.setAst(Integer.parseInt(ast.getText().toString()));
            }

            if (!wbc.getText().toString().isEmpty()){
                valueHolder.setWbc(Integer.parseInt(wbc.getText().toString()));
            }

            if (!crp.getText().toString().isEmpty()){
                valueHolder.setCrp(Integer.parseInt(crp.getText().toString()));
            }

            if (!bilirubin.getText().toString().isEmpty()){
                valueHolder.setBilirubin(Integer.parseInt(bilirubin.getText().toString()));
            }

            if (!ultrasound.getText().toString().isEmpty()){
                valueHolder.setUltrasound(Integer.parseInt(ultrasound.getText().toString()));
            }

            if (!amylase.getText().toString().isEmpty()){
                valueHolder.setEnzAmylase(Integer.parseInt(amylase.getText().toString()));
            }

            if (!lipase.getText().toString().isEmpty()) {
                valueHolder.setEnzLipase(Integer.parseInt(lipase.getText().toString()));
            }

            valueHolder.setAbdominalPain(radioPain.getCheckedRadioButtonId() == R.id.RadioAbdPainYes);
            valueHolder.setMurphySymptom(radioMurphy.getCheckedRadioButtonId() == R.id.RadioMurphyPositive);
            valueHolder.setGallbladderHydropic(radioHyropic.getCheckedRadioButtonId() == R.id.RadioHydropicYes);

            StringBuilder resultBuilder = new StringBuilder();
            boolean hasAcutePancreatitis = DiseaseCalculator.hasAcutePancreatitis(valueHolder);
            if (hasAcutePancreatitis) {
                resultBuilder.append("Patient has acute Pancreatitis, consult a doctor!!\n");
            }

            boolean hasAcuteCholangitis = DiseaseCalculator.hasAcuteCholangitis(valueHolder);
            if(hasAcuteCholangitis){
                resultBuilder.append("Patient has Acute Cholangitis, consult a doctor!!\n");
            }

            boolean hasCholecystitis = DiseaseCalculator.hasCholecystitis(valueHolder);
            if(hasCholecystitis){
                resultBuilder.append("Patient has acute Cholecystitis, consult a doctor!!\n");
            }


            if (resultBuilder.toString().isEmpty()) {
                result.setText("No Disease found!");
            } else {
                result.setText(resultBuilder.toString());
            }
        });

    }

}