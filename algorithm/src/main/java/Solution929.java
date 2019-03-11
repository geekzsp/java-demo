import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangshipeng
 * 2018-12-21
 */
public class Solution929 {
    public static int numUniqueEmails(String[] emails) {
        Set emailSet = new HashSet();
        for (int i = 0; i < emails.length; i++) {
            String email = emails[i];
            String[] split = email.split("@");
            String emailFirst = split[0];
            String emailEnd = split[1];
            emailFirst = emailFirst.replace(".", "");
            int i1 = emailFirst.indexOf("+");
            if (i1 != -1) {
                emailFirst = emailFirst.substring(0, i1);
            }
            emailSet.add(emailFirst + emailEnd);
        }
        return emailSet.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }


}
