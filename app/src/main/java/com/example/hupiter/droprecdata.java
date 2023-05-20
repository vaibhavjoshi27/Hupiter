package com.example.hupiter;

public class droprecdata {
    int image;
    String merchantname;
    String timendate,amnt;
    String init;
    public droprecdata(int image,String merchantname,String timendate,String amnt)
    {
        this.image=image;
        this.merchantname=merchantname;
        this.timendate=timendate;
        this.amnt=amnt;
    }

    public droprecdata(String merchantname,String init) {
        this.merchantname = merchantname;
        this.init = init;
    }
}
