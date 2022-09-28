package com.romijulianto.restapicarspringboot.wrappers;

public class CarImageWrapper {

    /* add object to insert/upload image postman */
    private int carId;
    private String contentType;
    private String base64;

    /* add Getter and Setter */

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    /* add toString() */

    @Override
    public String toString() {
        return "CarImageWrapper{" +
                "carId=" + carId +
                ", contentType='" + contentType + '\'' +
                ", base64='" + base64 + '\'' +
                '}';
    }
}
