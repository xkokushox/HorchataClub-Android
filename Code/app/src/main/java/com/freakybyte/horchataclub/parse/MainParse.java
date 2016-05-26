/**
 * @author Kokusho Torres
 */

package com.freakybyte.horchataclub.parse;


import com.freakybyte.horchataclub.util.DebugUtil;

public class MainParse {

    static long init, now;


    public static void startParsed() {
        init = System.currentTimeMillis();
    }

    public static void stopParsed() {
        now = System.currentTimeMillis();
        DebugUtil.logDebug("Parse en :: " + (now - init) + " ms");
    }

    public static String getStringFromByte(byte[] responseBody) {
        try {
            return new String(responseBody, "UTF-8");
        } catch (Exception ex) {
            DebugUtil.logError("MainParse", ex);
            return "";
        }
    }

}
