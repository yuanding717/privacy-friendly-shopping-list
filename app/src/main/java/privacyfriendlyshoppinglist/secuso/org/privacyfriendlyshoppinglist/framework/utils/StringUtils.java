package privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.framework.utils;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * Description:
 * Author: Grebiel Jose Ifill Brito
 * Created: 12.06.16 creation date
 */
public abstract class StringUtils
{

    private static final String EMPTY = "";

    public static boolean isEmpty(String string)
    {
        return string == null || string.isEmpty();
    }

    public static String getDoubleAsString(double number, String format)
    {
        String numberAsString;
        try
        {
            DecimalFormat df = new DecimalFormat(format);
            numberAsString = df.format(number);
        }
        catch ( Exception e )
        {
            numberAsString = EMPTY;
        }
        return numberAsString;
    }

    public static Double getStringAsDouble(String numberAsString, String format)
    {
        DecimalFormat df = new DecimalFormat(format);
        try
        {
            Number parse = df.parse(numberAsString);
            return parse.doubleValue();
        }

        catch ( ParseException e )
        {
            try
            {
                Number parse = df.parse(numberAsString.replace(".", ","));
                return parse.doubleValue();
            }

            catch ( ParseException e1 )
            {
                return 0.0;
            }
        }
    }

    public static Double getStringAsDouble(String productPrice, String priceFormat2, String priceFormat1, String priceFormat0)
    {
        Double stringAsDouble;
        try
        {

            stringAsDouble = StringUtils.getStringAsDouble(productPrice, priceFormat2);
        }
        catch ( Exception e1 )
        {
            try
            {
                stringAsDouble = StringUtils.getStringAsDouble(productPrice, priceFormat1);
            }
            catch ( Exception e2 )
            {
                try
                {
                    stringAsDouble = StringUtils.getStringAsDouble(productPrice, priceFormat0);
                }
                catch ( Exception e3 )
                {
                    stringAsDouble = 0.0;
                }
            }
        }

        return stringAsDouble;
    }
}
