/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the
 * empty slots on the left will be assigned more spaces than the slots on the
 * right.
 *
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 *
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 *
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Note: Each word is guaranteed not to exceed L in length.
 *
 * click to show corner cases.
 *
 * Corner Cases:
 * A line other than the last line might contain only one word. What should you
 * do in this case?
 * In this case, that line should be left-justified.
 */
public class Solution {

    public List<String> fullJustify(String[] words, int L) {
        List<String> ret = new ArrayList<String>();

        int currentSize = 0;
        List<String> sentence = new ArrayList<String>();
        int i = 0;
        while (i < words.length) {
            if (currentSize + sentence.size() + words[i].length() <= L) {
                currentSize += words[i].length();
                sentence.add(words[i]);
                i++;
            } else {
                ret.add(packSentence(sentence, L - currentSize, false));
                currentSize = 0;
                sentence.clear();
            }

            if (i == words.length) {
                ret.add(packSentence(sentence, L - currentSize, true));
            }
        }

        return ret;
    }

    private String packSentence(List<String> sentence, int paddingSize, boolean last) {
        StringBuilder sb = new StringBuilder();

        int size = sentence.size();
        if (size == 1) {
            sb.append(sentence.get(0));
            addPadding(sb, paddingSize);
            return sb.toString();
        }

        int len = last ? 1 : paddingSize / (size - 1);
        int remaining = last ? 0 : paddingSize % (size - 1);
        for (int i = 0; i < size; i++) {
            sb.append(sentence.get(i));
            if (i != size - 1) {
                addPadding(sb, remaining-- > 0 ? len + 1 : len);
            }
        }

        if (last) {
            addPadding(sb, paddingSize - size + 1);
        }
        return sb.toString();
    }

    private void addPadding(StringBuilder sb, int len) {
        for (int j = 0; j < len; j++) {
            sb.append(" ");
        }
    }
}
