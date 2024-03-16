package com.example.appxemphim.Domain;

public class Slider {
    private int Image;
    private String Tieude;

    public Slider(int image, String tieude) {
        Image = image;
        Tieude = tieude;
    }

    public int getImage() {
        return Image;
    }

    public String getTieude() {
        return Tieude;
    }

    public void setImage(int image) {
        Image = image;
    }

    public void setTieude(String tieude) {
        Tieude = tieude;
    }
}
