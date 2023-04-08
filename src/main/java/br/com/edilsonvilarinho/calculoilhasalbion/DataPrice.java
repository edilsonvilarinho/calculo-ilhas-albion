package br.com.edilsonvilarinho.calculoilhasalbion;

import java.io.Serializable;

public class DataPrice implements Serializable {

    private String item_id;
    private String city;
    private float quality;
    private float sell_price_min;
    private String sell_price_min_date;
    private float sell_price_max;
    private String sell_price_max_date;
    private float buy_price_min;
    private String buy_price_min_date;
    private float buy_price_max;
    private String buy_price_max_date;


    // Getter Methods

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getQuality() {
        return quality;
    }

    public void setQuality(float quality) {
        this.quality = quality;
    }

    public float getSell_price_min() {
        return sell_price_min;
    }

    public void setSell_price_min(float sell_price_min) {
        this.sell_price_min = sell_price_min;
    }

    public String getSell_price_min_date() {
        return sell_price_min_date;
    }

    public void setSell_price_min_date(String sell_price_min_date) {
        this.sell_price_min_date = sell_price_min_date;
    }

    public float getSell_price_max() {
        return sell_price_max;
    }

    // Setter Methods

    public void setSell_price_max(float sell_price_max) {
        this.sell_price_max = sell_price_max;
    }

    public String getSell_price_max_date() {
        return sell_price_max_date;
    }

    public void setSell_price_max_date(String sell_price_max_date) {
        this.sell_price_max_date = sell_price_max_date;
    }

    public float getBuy_price_min() {
        return buy_price_min;
    }

    public void setBuy_price_min(float buy_price_min) {
        this.buy_price_min = buy_price_min;
    }

    public String getBuy_price_min_date() {
        return buy_price_min_date;
    }

    public void setBuy_price_min_date(String buy_price_min_date) {
        this.buy_price_min_date = buy_price_min_date;
    }

    public float getBuy_price_max() {
        return buy_price_max;
    }

    public void setBuy_price_max(float buy_price_max) {
        this.buy_price_max = buy_price_max;
    }

    public String getBuy_price_max_date() {
        return buy_price_max_date;
    }

    public void setBuy_price_max_date(String buy_price_max_date) {
        this.buy_price_max_date = buy_price_max_date;
    }

    @Override
    public String toString() {
        return "DataPrice{" + "item_id='" + item_id + '\'' + ", city='" + city + '\'' + ", quality=" + quality + ", sell_price_min=" + sell_price_min + ", sell_price_min_date='" + sell_price_min_date + '\'' + ", sell_price_max=" + sell_price_max + ", sell_price_max_date='" + sell_price_max_date + '\'' + ", buy_price_min=" + buy_price_min + ", buy_price_min_date='" + buy_price_min_date + '\'' + ", buy_price_max=" + buy_price_max + ", buy_price_max_date='" + buy_price_max_date + '\'' + '}';
    }
}
