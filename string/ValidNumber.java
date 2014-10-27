/**
 * Validate if a given string is numeric.
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 *
 * Note: It is intended for the problem statement to be ambiguous.
 * You should gather all requirements up front before implementing one.
 */
public class Solution {
    // Confirm:
    // 1. could start with non-digits characters? --> could contain white-space, other non-digits characters return false
    // 2. could ended with non-digits characters? --> could contain white-space, other non-digits characters return false
    // 3. return true or false if s is an empty string, or only contains white-spaces? --> false
    // 4. could prefix with '+' '-'? --> only first char or the char after 'e' could be '+' '-'
    // 5. may contain float number? could float number be expressed as ".1", "1."? --> it's allowed
    // 6. may contain scientific notation?  --> it's allowed
    // 7. is this 2e08, 2e-9 correct? --> yes
    // 8. how about 2e? --> no
    // 9. how about 2e5.3? --> no
    // 10. how about 1.e10? -->
    // correct items: number, dot, e, +, -

    public boolean isNumber(String s) {
        if (s == null) {
            // invalid input
            return false;
        }
        // trim leading and trailing whitesapces
        s = s.trim();

        if (s.isEmpty()) {
            return false;
        }

        int len = s.length();
        boolean hasDigit = false;
        boolean hasExp = false;
        boolean hasDot = false;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                hasDigit = true;
            } else if (c == 'e') {
                if (!hasDigit || hasExp) {
                    return false;
                }
                hasExp = true;
                hasDigit = false;
            } else if (c == '.') {
                if (hasExp || hasDot) {
                    return false;
                }
                hasDot = true;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return hasDigit;
    }
}
