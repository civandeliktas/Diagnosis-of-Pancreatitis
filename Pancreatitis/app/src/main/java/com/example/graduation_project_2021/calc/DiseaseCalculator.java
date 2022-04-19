package com.example.graduation_project_2021.calc;

import androidx.annotation.NonNull;

import com.example.graduation_project_2021.model.ValueHolder;

public class DiseaseCalculator {
    //Function for acute pancreatitis
    //Eğer (amiaz>300 veya lipaz>200) ve (karın ağrısı varsa) = Akut pankreatit
    public static boolean hasAcutePancreatitis(@NonNull ValueHolder valueHolder) {
        return ((valueHolder.getEnzAmylase() != null && valueHolder.getEnzAmylase() > 300) ||
                (valueHolder.getEnzLipase() != null && valueHolder.getEnzLipase() > 200)) &&
                valueHolder.getAbdominalPain();
    }
    //Function for acute cholangitis
    // Eğer( bil>2 veya ggt>60  veya ast>60)  ve (( BK>12.000 veya BK<4000) veya(CRP>50)) ve (koledok>8mm  ) = akut kolanjit
    public static boolean hasAcuteCholangitis(@NonNull ValueHolder valueHolder){
        return ((valueHolder.getBilirubin() != null && valueHolder.getBilirubin() >= 2) || (valueHolder.getGgt() != null && valueHolder.getGgt() >= 60) ||
                (valueHolder.getAst() != null && valueHolder.getAst() >= 60)) && ((valueHolder.getWbc() != null && (valueHolder.getWbc() > 12000 || valueHolder.getWbc() < 4000) ||
                (valueHolder.getCrp() != null && valueHolder.getCrp() >= 50)) && (valueHolder.getCholedoch() != null && valueHolder.getCholedoch() >= 8));

    }

    //Function for cholecystitis
    // Eğer ( kese duvar> 4mm  veya hidrops  kese varsa) ve ((BK>12.000 veya BK<4.000) veya CRP>50) ve (murphy bulgusu varsa) = A. Kolesistit
    public static boolean hasCholecystitis(@NonNull ValueHolder valueHolder){
        return (valueHolder.getUltrasound() != null && valueHolder.getUltrasound() >= 4 || valueHolder.getGallbladderHydropic()) &&
                (valueHolder.getWbc() != null && (valueHolder.getWbc() > 12000 || valueHolder.getWbc() < 4000) ||
                        (valueHolder.getCrp() != null && valueHolder.getCrp() >= 50)) && (valueHolder.getMurphySymptom());
    }

}
