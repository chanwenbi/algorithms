/**
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 *
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class Solution {

    // version 1: using split
    public String simplifyPath(String path) {
        if (path == null) {
            return null;
        }

        String[] items = path.split("/");
        List<String> pathItems = new ArrayList<String>();
        for (String item : items) {
            if (item.equals(".") || item.isEmpty()) {
                // ignore
            } else if (item.equals("..")) {
                if (!pathItems.isEmpty()) {
                    pathItems.remove(pathItems.size() - 1);
                }
            } else {
                pathItems.add(item);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : pathItems) {
            sb.append("/").append(s);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }

    // version 2: not using split
    public String simplifyPath(String path) {
        if (path == null) {
            return "";
        }

        List<String> pathItems = new ArrayList<String>();
        int len = path.length();
        int startPos = 0;
        int endPos = 0;
        while (endPos < len) {
            startPos = endPos;
            endPos = startPos + 1;
            while (endPos < len && path.charAt(endPos) != '/') {
                endPos++;
            }
            if (startPos + 1 >= len) {
                continue;
            }

            String item = path.substring(startPos + 1, endPos);
            if (item.equals(".") || item.isEmpty()) {
                continue;
            } else if (item.equals("..")) {
                if (pathItems.size() > 0) {
                    pathItems.remove(pathItems.size() - 1);
                }
            } else {
                pathItems.add(item);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (String s : pathItems) {
            sb.append(s).append("/");
        }

        return sb.length() > 1 ? sb.substring(0, sb.length() - 1) : sb.toString();
    }


}
