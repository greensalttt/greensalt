package greensalt.customer.domain;

import java.util.Date;

public class CustHistoryDto {
    private int c_hist_num;
    private int c_id;
    private String c_cng_cd;
    private String c_bf;
    private String c_af;
    private Date frst_reg_dt;
    private String frst_reg_id;
    private Date last_mod_dt;
    private String last_mod_id;

    public CustHistoryDto(){}

    public CustHistoryDto(int c_id, String c_cng_cd, String c_bf, String c_af){
        this.c_id = c_id;
        this.c_cng_cd = c_cng_cd;
        this.c_bf = c_bf;
        this.c_af = c_af;
    }

    @Override
    public String toString() {
        return "CustHistoryDto{" +
                "c_hist_num=" + c_hist_num +
                ", c_id=" + c_id +
                ", c_cng_cd='" + c_cng_cd + '\'' +
                ", c_bf='" + c_bf + '\'' +
                ", c_af='" + c_af + '\'' +
                ", frst_reg_dt=" + frst_reg_dt +
                ", frst_reg_id='" + frst_reg_id + '\'' +
                ", last_mod_dt=" + last_mod_dt +
                ", last_mod_id='" + last_mod_id + '\'' +
                '}';
    }

    public int getC_hist_num() {
        return c_hist_num;
    }

    public void setC_hist_num(int c_hist_num) {
        this.c_hist_num = c_hist_num;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_cng_cd() {
        return c_cng_cd;
    }

    public void setC_cng_cd(String c_cng_cd) {
        this.c_cng_cd = c_cng_cd;
    }

    public String getC_bf() {
        return c_bf;
    }

    public void setC_bf(String c_bf) {
        this.c_bf = c_bf;
    }

    public String getC_af() {
        return c_af;
    }

    public void setC_af(String c_af) {
        this.c_af = c_af;
    }

    public Date getFrst_reg_dt() {
        return frst_reg_dt;
    }

    public void setFrst_reg_dt(Date frst_reg_dt) {
        this.frst_reg_dt = frst_reg_dt;
    }

    public String getFrst_reg_id() {
        return frst_reg_id;
    }

    public void setFrst_reg_id(String frst_reg_id) {
        this.frst_reg_id = frst_reg_id;
    }

    public Date getLast_mod_dt() {
        return last_mod_dt;
    }

    public void setLast_mod_dt(Date last_mod_dt) {
        this.last_mod_dt = last_mod_dt;
    }

    public String getLast_mod_id() {
        return last_mod_id;
    }

    public void setLast_mod_id(String last_mod_id) {
        this.last_mod_id = last_mod_id;
    }
}
