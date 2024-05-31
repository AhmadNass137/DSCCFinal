package com.example.PurchaseService;

public class PurchaseResponse {
static int Response_num=0;
private String company1;
private String company2;

private double purchasecost;

    public PurchaseResponse(int response_num, String company1, String company2, Double purchasecost) {
        Response_num++;
        this.company1 = company1;
        this.company2 = company2;
        this.purchasecost = purchasecost;
    }

    public int getResponse_num() {
        return Response_num;
    }



    public String getCompany1() {
        return company1;
    }

    public void setCompany1(String company1) {
        this.company1 = company1;
    }

    public String getCompany2() {
        return company2;
    }

    public void setCompany2(String company2) {
        this.company2 = company2;
    }

    public double getCost() {
        return purchasecost;
    }

    public void setCost(double purchasecost) {
        this.purchasecost = purchasecost;
    }
}
