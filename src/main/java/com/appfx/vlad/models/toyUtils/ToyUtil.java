package com.appfx.vlad.models.toyUtils;

import org.apache.log4j.Logger;

/**
 * Class for checking toy parameters.
 */
public class ToyUtil {

    private final static Logger logger = Logger.getLogger(ToyUtil.class);

    /**
     * Method checks correctness of id of the toy.
     *
     * @param id - id of the toy.
     * @return id of the toy.
     * @throws NumberFormatException if id is wrong method throw this exception.
     */
    public int checkAndGetId(String id) throws NumberFormatException {
        if (id.length() == 0) {
            return -1;
        } else if (Integer.valueOf(id) < 0) {
            logger.error("Id is invalid.");
            throw new NumberFormatException("incorrect id");
        } else {
            return Integer.valueOf(id);
        }
    }

    /**
     * Method checks correctness of price of the toy.
     *
     * @param price - price of thr toy.
     * @return price of the toy.
     * @throws NumberFormatException if price is wrong method throw this exception.
     */
    public float checkAndGetPrice(String price) throws NumberFormatException {
        if (price.length() == 0) {
            return -1;
        } else if (Float.valueOf(price) < 0) {
            logger.error("Price is invalid.");
            throw new NumberFormatException("incorrect price");
        } else {
            return Float.valueOf(price);
        }
    }

    /**
     * Method checks correctness of amount of the toys.
     *
     * @param amount - amount of the toys.
     * @return amount of the toys.
     * @throws NumberFormatException if amount is wrong method throw this exception.
     */
    public int checkAndGetAmount(String amount) throws NumberFormatException {
        if (amount.length() == 0) {
            return -1;
        } else if (Integer.valueOf(amount) < 0) {
            logger.error("Amount is invalid.");
            throw new NumberFormatException("incorrect amount");
        } else {
            return Integer.valueOf(amount);
        }
    }

    /**
     * Method checks correctness of start age of child for the toy.
     *
     * @param sAge - start age of a child.
     * @return start age.
     * @throws NumberFormatException if start age is wrong method throw this exception.
     */
    public int checkAndGetSAge(String sAge) throws NumberFormatException {
        if (sAge.length() == 0) {
            return  -1;
        } else if (Integer.valueOf(sAge) < 0) {
            logger.error("Start age is invalid.");
            throw new NumberFormatException("incorrect start age");
        } else {
            return Integer.valueOf(sAge);
        }
    }

    /**
     * Method checks correctness of end age of child for the toy.
     * @param eAge - end age of a child.
     * @return end age.
     * @throws NumberFormatException if end age is wrong method throw this exception.
     */
    public int checkAndGetEAge(String eAge) throws NumberFormatException {
        if (eAge.length() == 0) {
            return  -1;
        } else if (Integer.valueOf(eAge) < 0) {
            logger.error("End age is invalid.");
            throw new NumberFormatException("incorrect end age");
        } else {
            return Integer.valueOf(eAge);
        }
    }
}
