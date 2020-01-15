public class HexCalc {

    public int base_ = 16, constant_1 = 48, constant_2 = 55, constant_0 = 0;

    /**
     * Addition two Hexadecimal base values.
     *
     * @param hexnumber_1 the first {@code String} to addition
     * @param hexnumber_2 the second {@code String} to addition
     * @return the string of hexadecimal base value
     */
    public String add(String hexnumber_1, String hexnumber_2) {
        return decimalTOhexadecimal(hexadecimalTODecimal(hexnumber_1)
                + hexadecimalTODecimal(hexnumber_2));
    }

    /**
     * Multiplication two Hexadecimal base values.
     *
     * @param hexnumber_1 the first {@code String} to multiplication
     * @param hexnumber_2 the second {@code String} to multiplication
     * @return the string of hexadecimal base value
     * @since 1.7
     */
    public String mul(String hexnumber_1, String hexnumber_2) {
        return decimalTOhexadecimal(hexadecimalTODecimal(hexnumber_1)
                * hexadecimalTODecimal(hexnumber_2));
    }

    /**
     * Subtraction two Hexadecimal base values.
     *
     * @param hexnumber_1 the first {@code String} to subtract
     * @param hexnumber_2 the second {@code String} to subtract
     * @return the string of hexadecimal base value
     * @since 1.7
     */
    public String sub(String hexnumber_1, String hexnumber_2) {
        return decimalTOhexadecimal(hexadecimalTODecimal(hexnumber_1)
                - hexadecimalTODecimal(hexnumber_2));
    }

    /**
     * Division two Hexadecimal base values.
     *
     * @param hexnumber_1 the first {@code String} to division
     * @param hexnumber_2 the second {@code String} to division
     * @return the string of hexadecimal base value
     */
    public String div(String hexnumber_1, String hexnumber_2) {
        return decimalTOhexadecimal(hexadecimalTODecimal(hexnumber_1)
                / hexadecimalTODecimal(hexnumber_2));
    }

    /**
     * Compare 2 Hexadecimal values and check hexnumber_1 is equal to hexnumber_2 or not..
     *
     * @param hexnumber_1 the first {@code String} to compare
     * @param hexnumber_2 the second {@code String} to compare
     * @return the boolean value
     */
    public boolean eql(String hexnumber_1, String hexnumber_2) {
        if (hexnumber_1.equals(hexnumber_2))
            return true;
        else
            return false;
    }

    /**
     * Compare 2 Hexadecimal values and check hexnumber_1 is less then hexnumber_2 or not..
     *
     * @param hexnumber_1 the first {@code String} to compare
     * @param hexnumber_2 the second {@code String} to compare
     * @return the boolean value
     */
    public boolean less(String hexnumber_1, String hexnumber_2) {
        if (hexnumber_1.length() == hexnumber_2.length())
            if (hexnumber_1.compareTo(hexnumber_2) < constant_0)
                return true;
            else
                return false;
        else if (hexnumber_1.length() > hexnumber_2.length())
            return false;
        else
            return true;
    }

    /**
     * Compare 2 Hexadecimal values and check hexnumber_1 is greater then hexnumber_2 or not.
     *
     * @param hexnumber_1 the first {@code String} to compare
     * @param hexnumber_2 the second {@code String} to compare
     * @return the boolean value
     */
    public boolean grt(String hexnumber_1, String hexnumber_2) {
        if (hexnumber_1.length() == hexnumber_2.length())
            if (hexnumber_1.compareTo(hexnumber_2) > constant_0)
                return true;
            else
                return false;
        else if (hexnumber_1.length() < hexnumber_2.length())
            return false;
        else
            return true;
    }

    /**
     * Addition two Hexadecimal base values numerically.
     *
     * @param hexnumber_1 the first {@code String} to convert
     * @return the Decimal base value
     */
    public int hexadecimalTODecimal(String hexnumber_1) {
        int decimal = constant_0, base = 1;

        for (int i = hexnumber_1.length() - 1; i >= 0; i--) {

            if (hexnumber_1.charAt(i) >= '0' && '9' >= hexnumber_1.charAt(i)) {
                decimal += (hexnumber_1.charAt(i) - constant_1) * base;
                base = base * base_;
            }

            if (hexnumber_1.charAt(i) >= 'A' && 'F' >= hexnumber_1.charAt(i)) {
                decimal += (hexnumber_1.charAt(i) - constant_2) * base;
                base = base * base_;
            }
        }

        return decimal;
    }

    /**
     * Convert Decimal to Hexadecimal values.
     *
     * @param decimal_number the first {@code int} to convert
     * @return the string of hexadecimal base value
     */
    public String decimalTOhexadecimal(int decimal_number) {
        int remainder, base = 10, negative_number = constant_0;
        String hexa_decimal_number = "";

        if (decimal_number < constant_0) {
            decimal_number = decimal_number * -1;
            negative_number = 1;
        }

        while (decimal_number != constant_0) {
            remainder = decimal_number % base_;
            if (remainder < base) {
                hexa_decimal_number = (char) (constant_1 + remainder)
                        + hexa_decimal_number;
            } else {
                hexa_decimal_number = (char) (constant_2 + remainder)
                        + hexa_decimal_number;
            }
            decimal_number = decimal_number / base_;
        }

        if (negative_number == constant_0)
            return hexa_decimal_number;
        else
            return "-" + hexa_decimal_number;
    }
}
