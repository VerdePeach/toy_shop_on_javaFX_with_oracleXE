package com.appfx.vlad.models.toyUtils;

import com.appfx.vlad.models.Toy;
import org.apache.log4j.Logger;

public class ToyUtil {

    private final static Logger logger = Logger.getLogger(ToyUtil.class);

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
