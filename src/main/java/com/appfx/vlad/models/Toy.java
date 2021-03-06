package com.appfx.vlad.models;

import javafx.beans.property.*;
import org.apache.log4j.Logger;

/**
 * Class of main entity
 */
public class Toy {

    private final static Logger logger = Logger.getLogger(Toy.class);

    private IntegerProperty id;
    private StringProperty name;
    private FloatProperty price;
    private IntegerProperty amount;
    private IntegerProperty startAge;
    private IntegerProperty endAge;

    /**
     * Empty Constructor.
     */
    public Toy() {}

    /**
     * Constructor with one parameter.
     *
     * @param name - name of thr toy.
     */
    public Toy(String name) {
        this.name = new SimpleStringProperty(name);
    }

    /**
     * Constructor with five parameters.
     *
     * @param name     - name of thr toy.
     * @param price    - price of thr toy.
     * @param amount   - amount of thr toys.
     * @param startAge - start age of children that can play with this toy.
     * @param endAge   - end age of children that adult to play with this toy.
     */
    public Toy(String name, float price, int amount, int startAge, int endAge) {
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleFloatProperty(price);
        this.amount = new SimpleIntegerProperty(amount);
        this.startAge = new SimpleIntegerProperty(startAge);
        this.endAge = new SimpleIntegerProperty(endAge);
        logger.info("Toy was successfully created.");
    }

    /**
     * @param id       - unique identifier of the toy.
     * @param name     - name of thr toy.
     * @param price    - price of thr toy.
     * @param amount   - amount of thr toys.
     * @param startAge - start age of children that can play with this toy.
     * @param endAge   - end age of children that adult to play with this toy.
     */
    public Toy(int id, String name, float price, int amount, int startAge, int endAge) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleFloatProperty(price);
        this.amount = new SimpleIntegerProperty(amount);
        this.startAge = new SimpleIntegerProperty(startAge);
        this.endAge = new SimpleIntegerProperty(endAge);
        logger.info("Toy was successfully created.");
    }

    public IntegerProperty getId() {
        return id;
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public StringProperty getName() {
        return name;
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public FloatProperty getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = new SimpleFloatProperty(price);
    }

    public IntegerProperty getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = new SimpleIntegerProperty(amount);
    }

    public IntegerProperty getStartAge() {
        return startAge;
    }

    public void setStartAge(int startAge) {
        this.startAge = new SimpleIntegerProperty(startAge);
    }

    public IntegerProperty getEndAge() {
        return endAge;
    }

    public void setEndAge(int endAge) {
        this.endAge = new SimpleIntegerProperty(endAge);
    }

    /**
     * Method that gives information about the toy.
     *
     * @return string that describing toy.
     */
    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", startAge=" + startAge +
                ", endAge=" + endAge +
                '}';
    }
}
