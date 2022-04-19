package com.example.graduation_project_2021.model;

public class ValueHolder {
    private Integer ultrasound;
    private Integer enzAmylase;
    private Integer enzLipase;
    private Integer crp;
    private Integer ggt;
    private Integer ast;
    private Integer choledoch;
    private Integer wbc;
    private Integer bilirubin;
    private Boolean abdominalPain;
    private Boolean gallbladderHydropic;
    private Boolean murphySymptom;


    public Integer getCrp() {
        return crp;
    }

    public void setCrp(Integer crp) {
        this.crp = crp;
    }

    public Integer getGgt() {
        return ggt;
    }

    public void setGgt(Integer ggt) {
        this.ggt = ggt;
    }

    public Integer getAst() {
        return ast;
    }

    public void setAst(Integer ast) {
        this.ast = ast;
    }

    public Integer getCholedoch() {
        return choledoch;
    }

    public void setCholedoch(Integer choledoch) {
        this.choledoch = choledoch;
    }

    public Integer getWbc() {
        return wbc;
    }

    public Integer getUltrasound() { return ultrasound; }

    public void setUltrasound(Integer ultrasound) { this.ultrasound = ultrasound; }

    public void setWbc(Integer wbc) {
        this.wbc = wbc;
    }

    public Integer getBilirubin() {
        return bilirubin;
    }

    public void setBilirubin(Integer bilirubin) {
        this.bilirubin = bilirubin;
    }

    public Boolean getGallbladderHydropic() {
        return gallbladderHydropic;
    }

    public void setGallbladderHydropic(Boolean gallbladderHydropic) { this.gallbladderHydropic = gallbladderHydropic; }

    public Integer getEnzAmylase() {
        return enzAmylase;
    }

    public void setEnzAmylase(Integer enzAmylase) {
        this.enzAmylase = enzAmylase;
    }

    public Integer getEnzLipase() {
        return enzLipase;
    }

    public void setEnzLipase(Integer enzLipase) {
        this.enzLipase = enzLipase;
    }

    public Boolean getAbdominalPain() {
        return abdominalPain;
    }

    public void setAbdominalPain(Boolean abdominalPain) {
        this.abdominalPain = abdominalPain;
    }

    public Boolean getMurphySymptom() {
        return murphySymptom;
    }

    public void setMurphySymptom(Boolean murphySymptom) {
        this.murphySymptom = murphySymptom;
    }
}
