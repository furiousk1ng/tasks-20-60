import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.*;
import java.lang.*;
import java.security.MessageDigest;

public class Tasks {
    public static void main(String[] args) {
        System.out.println("Задача 10:" + repeat("mice", 5));
        int a = differenceMaxMin(new int[]{44, 32, 86, 19});
        System.out.println("Задача 11: " + a);
        System.out.println(isAvgWhole(new int[]{1, 5, 6}));
        cumulativeSum(new int[]{3, 3, -2, 408, 3, 3});
        System.out.println(getDecimalPlaces("400.33544343"));
        System.out.println(Fibonacci(12));
        System.out.println(isValid("59001"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(boxSeq(2));
        ///30
        System.out.println("Часть 3");
        System.out.println(solutions(1, 0, 1));
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(checkPerfect(97));
        System.out.println(flipEndChars("Ada"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(same(new int[]{9, 8, 7, 6}, new int[]{4, 4, 3, 1}));
        System.out.println(isKaprekar(297));
        System.out.println(longestZero("11111"));
        System.out.println(rightTriangle(70, 130, 110));
        /*   System.out.println("Следующее простое число" + nextPrime(24));*/
        /// 40
        split("()()()(((())))()()((()))");
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("getColor"));
        System.out.println(overTime(new double[]{9, 17, 30, 1.5}));
        System.out.println(BMI("154 pounds", "2 meters"));
        System.out.println(bugger(114));
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println("Trouble " + trouble("451999277", "41177722899"));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println("50 - десятые");
        /////////50
        encrypt("Sunshine");
        System.out.println(decrypt(new int[]{72, 33, -73, 84, -12, -3, 13, -13, -68}));
        System.out.println(canMove("Queen", "G6", "G1"));
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(sumDigProd(new int[]{16, 28}));
        sameVowelGroup("toe", "ocelot", "maniac");
        System.out.println(validateCard("1234567890123452"));
        System.out.println(numToEng(911));
        System.out.println(getSha256Hash(("password123")));
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(hexLattice(19));
        //////////////60
        System.out.println(bell(3));
        System.out.println(translateWord(("flag")));
        System.out.println(translateSentence("I like to eat honey waffles.") );
        System.out.println(validColor("rgba(0,0,0,0.123456789)") );
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[]{"b"})  );
        getHashTags("Visualizing Science");
        System.out.println(ulam(206));
        System.out.println(longestNonrepeatingSubstring("abcda"));
        System.out.println(convertToRoman(12));
        System.out.println(formula("18 / 17 = 2")  );
        System.out.println(palindromedescendant(13001120));
    }

    public static String repeat(String l, int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < l.length(); i++) {
            for (int j = 0; j < n; j++) {
                s.append(l.charAt(i));
            }
        }
        String j = s.toString();
        return j;
    }

    public static int differenceMaxMin(int[] a) {
        int minValue = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < minValue) {
                minValue = a[i];
            }
        }
        int maxValue = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > maxValue) {
                maxValue = a[i];
            }
        }
        int value = maxValue - minValue;
        return value;
    }

    public static boolean isAvgWhole(int[] a) {
        int sred = 0;
        for (int i = 0; i < a.length; i++) {
            sred += a[i];
        }
        return sred % (a.length - 1) == 0;

    }

    public static int[] cumulativeSum(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            a[i + 1] = a[i] + a[i + 1];
        }
        System.out.println(Arrays.toString(a));
        return a;
    }

    public static int getDecimalPlaces(String n) {
        int indexM = n.indexOf(".");
        int count = 0;
        if (indexM == -1) {
            return 0;
        } else {
            for (int i = indexM; i < n.length() - 1; i++) {
                count++;
            }
            return count;
        }
    }

    public static int Fibonacci(int n) {
        int f1 = 0;
        int f2 = 1;
        for (int i = 1; i <= n; i++) {
            int next = f1 + f2;
            f1 = f2;
            f2 = next;
        }
        return f2;
    }

    public static boolean isValid(String s) {
        if (s.length() <= 5) {
            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        } else
            return false;
    }

    public static boolean isStrangePair(String s, String s1) {//remake
        if ((s.charAt(0) == s1.charAt(s1.length() - 1) && (s1.charAt(0) == s.charAt(s.length() - 1)))) {
            return true;
        } else
            return false;

    }

    public static boolean isPrefix(String s, String s1) {
        s1 = s1.replace("-", "");
        return s.startsWith(s1);

    }

    public static boolean isSuffix(String s, String s1) {
        s1 = s1.replace("-", "");
        return s.endsWith(s1);
    }

    public static int boxSeq(int n) {
        int shag = 0;
        int pol = 0;
        while (shag < n) {
            shag++;
            if (shag % 2 == 0) {
                pol = pol - 1;
            } else {
                pol = pol + 3;
            }
        }
        return pol;
    }

    ///30
    public static int solutions(double a, double b, double c) {
        if ((b * b - 4 * a * c) > 0) {
            return 2;
        } else if ((b * b - 4 * a * c) == 0) {
            return 1;
        } else
            return 0;
    }

    public static int findZip(String s) {
        s = s.replaceFirst("zip", "");
        if (s.contains("zip")) {
            return s.indexOf("zip") + 3;
        } else
            return -1;
    }

    public static boolean checkPerfect(int n) {
        int ssum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                ssum += i;
            }
        }
        return ssum == n;
    }

    public static String flipEndChars(String s) {
        if (s.length() <= 2)
            return "Incompatible.";
        else if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return "Two's a pair.";
        } else {
            StringBuilder sb = new StringBuilder(s);
            char start = sb.charAt(0);
            char end = sb.charAt(s.length() - 1);
            sb.setCharAt(0, end);
            sb.setCharAt(s.length() - 1, start);
            return sb.toString();
        }
    }

    public static boolean isValidHexCode(String s) {
        if (s.charAt(0) == '#' && s.length() == 7) {
            for (int i = 1; i <= 6; i++) {
                char c = s.charAt(i);
                if ((c < '0' || c > '9') && (c < 'A' || c > 'F') && (c < 'a' || c > 'f')) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean same(int[] arr1, int[] arr2) {
        int count = 0;
        int count2 = 0;
        Set set = new HashSet();
        for (int i = 0; i < arr1.length; i++) {
            if (set.add(arr1[i])) {
                count++;

            }
        }
        Set set2 = new HashSet();
        for (int i = 0; i < arr2.length; i++) {
            if (set.add(arr2[i])) {
                count2++;

            }
        }
        if (count == count2)
            return true;
        else
            return false;

    }

    public static boolean isKaprekar(int n) {
        int lll;
        int ii;
        int count = 0;
        int kw = n * n;
        StringBuilder s = new StringBuilder();
        StringBuilder l = new StringBuilder();
        String kapr = String.valueOf(kw);
        for (int i = 0; i < kapr.length(); i++) {
            count++;
        }

        if (count % 2 == 0 || count != 1) {
            for (int i = 0; i < kapr.length() / 2; i++) {
                s.append(kapr.charAt(i));
            }
            String j = s.toString();
            ii = Integer.parseInt(j);
            for (int i = kapr.length() / 2; i < kapr.length(); i++) {
                l.append(kapr.charAt(i));
            }
            String ll = l.toString();
            lll = Integer.parseInt(ll);

        } else {
            ii = 0;
            lll = kw;
        }
        return ((lll + ii) == n);

    }

    public static String longestZero(String str) {
        StringBuilder s = new StringBuilder();
        int count = 0;
        int maximum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count = 0;
            } else {
                count++;
                if (count > maximum)
                    maximum = count;
            }
        }
        for (int j = 0; j < maximum; j++) {
            s.append("0");
        }
        if (maximum == 0) {
            return "' '";
        } else {
            String jj = s.toString();
            return jj;
        }
    }

    public static int nextPrime(int number) {

        boolean prime = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }
        if (prime == false) {
            for (int j = 2; j < number; j++) {
                if (number % j == 0) {
                    number++;
                    j--;
                }
            }
        }
        return number;
    }

    public static boolean rightTriangle(int x, int y, int z) {
        return (x * x == y * y + z * z || y * y == z * z + x * x || z * z == y * y + x * x);
    }
    //////// 40


    public static String text(int n, int k, String str) {
        String st = "";
        int m = 0;
        String[] j = new String[n];
        j = str.split(" ");
        for (int i = 0; i < n; i++) {
            if (m + j[i].length() < k + 1) {
                st = st + " " + j[i];
                m = m + j[i].length();
            } else {
                st = st + "\n" + j[i];
                m = j[i].length();
            }
        }
        return st.trim(); //без пробелов в начале в конце строки
    }

    public static void split(String s) {
        String k = "";
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                start++;
            }

            if (s.charAt(i) == ')') {
                end++;
            }
            k = k + s.charAt(i);
            if (start == end) {
                k = k + " ";
            }
        }
        System.out.println(Arrays.toString(k.split(" ")));
    }

    public static String toCamelCase(String s) {
        while (s.contains("_")) {
            char t = s.charAt(s.indexOf("_") + 1);
            s = s.replace("_" + t, String.valueOf(Character.toUpperCase(t)));
        }
        return s;
    }

    public static String toSnakeCase(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                String l = String.valueOf(s.charAt(i));
                char m = s.charAt(i);
                s = s.replace(l, "_" + String.valueOf(Character.toLowerCase(m)));

            }
        }
        return s;
    }

    public static String overTime(double[] a) {
        double m = 0.0;
        if (a[1] > 17.00) {
            m = (((a[1] - 17.00) * a[2] * a[3]) + (17.00 - a[0]) * a[2]);
        } else
            m = (a[1] - a[0]) * a[2];
        return "$" + String.format("%.2f", m);
    }

    public static String BMI(String s1, String s2) {
        double mas = 0.0;
        double high = 0.0;
        double imt = 0.0;
        String[] arr = s1.split(" ");
        String[] arr2 = s2.split(" ");
        double l = Double.valueOf(arr[0]);
        double h = Double.valueOf(arr2[0]);
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.CEILING);
        if (arr[1].equals("pounds")) {
            mas = l * 0.45;
        } else
            mas = l;
        if (arr2[1].equals("inches")) {
            high = (h * 2.54) / 100;
        } else
            high = h;
        imt = mas / (high * high);


        if (imt < 18.5) {
            return String.valueOf(df.format(imt)) + " Underweight";
        } else if (imt >= 18.5 && imt < 25.0) {
            return String.valueOf(df.format(imt)) + " Normal weight";
        } else {
            return String.valueOf(df.format(imt)) + " Overweight";
        }
    }

    public static int bugger(int n) {
        int t = 1;
        int count = 0;

        while (n > 9) {
            t *= n % 10;
            n /= 10;
            if (n < 10) {
                t *= n % 10;
                n = t;
                t = 1;
                count++;
            }
        }
        return count;
    }

    public static String toStarShorthand(String s) {
        String a = "";
        int n = 1;
        char c = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i) && i != s.length() - 1) {
                n++;
            } else {
                a = a + c;
                if (n > 1) {
                    a = a + "*" + n;
                }
                n = 1;
                c = s.charAt(i);
            }
        }
        return a;
    }

    public static boolean doesRhyme(String str1, String str2) {
        String[] j = new String[str1.length()];
        String[] j1 = new String[str1.length()];
        String[] j2 = new String[str1.length()];
        String[] j3 = new String[str1.length()];
        boolean m = false;
        j = str1.split(" ");
        j1 = str2.split(" ");
        int p = 0, q = 0;
        for (int i = 0; i < j[j.length - 1].length(); i++) {
            if (j[j.length - 1].substring(i, i + 1).matches("^(?i:[aeiouy]).*")) //matches() возращает true, если вся строка совпадает с шаблоном
            {
                j2[p] = j[j.length - 1].substring(i, i + 1).toLowerCase();
                p++;
            }
        }
        for (int i = 0; i < j1[j1.length - 1].length(); i++) {
            if (j1[j1.length - 1].substring(i, i + 1).matches("^(?i:[aeiouy]).*")) {
                j3[q] = j1[j1.length - 1].substring(i, i + 1).toLowerCase();
                q++;
            }
        }
        if (p == q) {
            for (int i = 0; i < p; i++) {
                if (j2[i].charAt(0) == j3[i].charAt(0)) {
                    m = true;
                } else {
                    m = false;
                }
            }
        }
        return m;
    }

    public static boolean trouble(String a, String b) {// переделал
        StringBuilder l = new StringBuilder(a);
        StringBuilder l1 = new StringBuilder(b);
        int count = 0;
        int count1 = 0;
        char cc = ' ';
        for (int i = 0; i < a.length() - 2; i++) {
            if (l.charAt(i) == l.charAt(i + 1) && l.charAt(i) == l.charAt(i + 2)) {
                cc = l.charAt(i);
                count++;
            }
        }
        for (int i = 0; i < b.length() - 1; i++) {
            if (l1.charAt(i) == cc && l1.charAt(i + 1) == cc) {
                count1++;
            }

        }
        if (count == 1 && count1 == 1) {
            return true;
        }

        return false;

    }

    public static int countUniqueBooks(String text, char bookEnd) {
        HashSet<Character> h = new HashSet();

        for (int i = 0; i < text.length(); ++i) {
            if (text.charAt(i) != bookEnd) {
                h.add(text.charAt(i));
            }
        }

        return h.size();
    }

    /////////////////////50
    public static int[] encrypt(String s) {
        int[] digits = new int[s.length()];
        StringBuilder l = new StringBuilder(s);
        for (int i = 0; i < s.length() - 1; i++) {
            char character = s.charAt(i);
            char character1 = s.charAt(i + 1);
            int ascii = (int) character;
            int ascii1 = (int) character1;
            if (i == 0) {
                digits[i] = ascii;
            }
            digits[i + 1] = ascii1 - ascii;
        }
        System.out.println(Arrays.toString(digits));
        return digits;
    }

    public static String decrypt(int[] a) {
        StringBuilder l = new StringBuilder();

        for (int i = 0; i < a.length - 1; i++) {
            a[i + 1] = a[i] + a[i + 1];
        }
        for (int i = 0; i < a.length; i++) {
            int ascii = a[i];
            char character = (char) ascii;
            l.append(character);
        }
        return l.toString();
    }

    public static boolean canMove(String piece, String start, String end) {
        boolean can = false;
        int x1 = start.charAt(0);
        int x2 = end.charAt(0);
        int y1 = start.charAt(1);
        int y2 = end.charAt(1);
        int first = Math.abs(start.charAt(0) - end.charAt(0));
        int second = Math.abs(start.charAt(1) - end.charAt(1));
        byte var7 = -1;
        switch (piece.hashCode()) {
            case -2042963283:
                if (piece.equals("Knight")) {
                    var7 = 5;
                }
                break;
            case 2338743:
                if (piece.equals("King")) {
                    var7 = 4;
                }
                break;
            case 2480296:
                if (piece.equals("Pawn")) {
                    var7 = 3;
                }
                break;
            case 2553081:
                if (piece.equals("Rook")) {
                    var7 = 0;
                }
                break;
            case 78391050:
                if (piece.equals("Queen")) {
                    var7 = 2;
                }
                break;
            case 1990023133:
                if (piece.equals("Bishop")) {
                    var7 = 1;
                }
        }

        switch (var7) {
            case 0:
                if (x1 == x2 || y1 == y2) {//rook
                    can = true;
                }
                break;
            case 1:
                if (x1 - x2 == y1 - y2 || x1 - x2 == y2 - y1) {//bishop
                    can = true;
                }
                break;
            case 2:
                if ((x1 - x2 == y1 - y2 || x1 - x2 == y2 - y1) || (x1 == x2 || y1 == y2)) {//Queen
                    can = true;
                }
                break;
            case 3:
                if (first == 1 && second <= 1 || first == 2 && second == 0) {//pawn
                    can = true;
                }
                break;
            case 4:
                if (first <= 1 && second <= 1) {//king
                    can = true;
                }
                break;
            case 5:
                if (first == 2 && second == 1 || first == 1 && second == 2) {//knight
                    can = true;
                }
        }

        return can;
    }

    public static boolean canComplete(String s1, String s2) {

        int i = 0;

        for (int j = 0; j < s2.length(); j++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }

            if (i == s1.length()) {
                return true;
            }
        }

        return false;
    }

    public static int sumDigProd(int[] a) {
        int n = 0;
        int[] l = a;
        int ll = a.length;

        for (int i = 0; i < ll; i++) {
            int value = l[i];
            n += value;
        }

        int temp = n;

        int t = 1;

        while (temp > 9) {
            t *= temp % 10;
            temp /= 10;
            if (temp < 10) {
                t *= temp % 10;
                temp = t;
                t = 1;
            }
        }
        return temp;
    }

    public static String[] sameVowelGroup(String... n) {
        int p = 1; //счётчик удовлетворяющих слов
        boolean y = true, qw = false;
        String q = "";
        String[] j = new String[n.length];
        j[0] = n[0];
        for (int j1 = 0; j1 < n[0].length(); j1++) {
            if ((n[0].substring(j1, j1 + 1).matches("^(?i:[aeiouy]).*")) && !q.contains(n[0].substring(j1, j1 + 1))) {
                q = q + n[0].substring(j1, j1 + 1);
            }
        }
        for (int i = 1; i < n.length; i++) {
            for (int j1 = 0; j1 < n[i].length(); j1++) {
                if (n[i].substring(j1, j1 + 1).matches("^(?i:[aeiouy]).*")) {
                    if (!q.contains(n[i].substring(j1, j1 + 1))) {
                        y = false;
                    }
                    qw = true;
                }
            }
            if (y && qw) {
                j[p] = n[i];
                p++;
            }
            y = true;
            qw = false;
        }
        String[] arr = new String[p];
        for (int i = 0; i < p; i++) {
            arr[i] = j[i];
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static boolean validateCard(String num) {

        if (num.length() <= 19 && num.length() >= 14) {
            int lastDigit = Integer.parseInt(String.valueOf(num.charAt(num.length() - 1)));
            int sum = 0;
            int sum1 = 0;
            StringBuilder ll = new StringBuilder(num.substring(0, num.length() - 1)).reverse();
            String s1 = ll.toString();
            String[] ary = s1.split("");
            int[] arr = new int[ary.length];
            int kk = 0;
            for (int j = 0; j < ary.length; j++) {
                arr[j] = Integer.parseInt(ary[kk]);
                kk++;
            }
            for (int j1 = 0; j1 < arr.length; j1 += 2) {
                arr[j1] *= 2;
                if (arr[j1] > 9) {
                    sum = 0;
                    sum += arr[j1] % 10;
                    arr[j1] /= 10;
                    sum += arr[j1] % 10;
                    arr[j1] = sum;
                } else {
                    sum += arr[j1];
                }
            }
            for (int ii = 0; ii < arr.length; ii++) {
                sum1 += arr[ii];
            }
            int prov = 10 - (sum1 % 10);
            return prov == lastDigit;
        }
        return false;
    }

    public static String numToEng(int num) {
        String first = "";
        String second = "";
        String third = "";
        switch (num % 10) {
            case 1:
                first = "one";
                break;
            case 2:
                first = "two";
                break;
            case 3:
                first = "three";
                break;
            case 4:
                first = "four";
                break;
            case 5:
                first = "five";
                break;
            case 6:
                first = "six";
                break;
            case 7:
                first = "seven";
                break;
            case 8:
                first = "eight";
                break;
            case 9:
                first = "nine";
        }

        num /= 10;
        label88:
        switch (num % 10) {
            case 1:
                int var5 = -1;
                switch (first.hashCode()) {
                    case 0:
                        if (first.equals("")) {
                            var5 = 0;
                        }
                        break;
                    case 110182:
                        if (first.equals("one")) {
                            var5 = 1;
                        }
                        break;
                    case 113890:
                        if (first.equals("six")) {
                            var5 = 6;
                        }
                        break;
                    case 115276:
                        if (first.equals("two")) {
                            var5 = 2;
                        }
                        break;
                    case 3143346:
                        if (first.equals("five")) {
                            var5 = 5;
                        }
                        break;
                    case 3149094:
                        if (first.equals("four")) {
                            var5 = 4;
                        }
                        break;
                    case 3381426:
                        if (first.equals("nine")) {
                            var5 = 9;
                        }
                        break;
                    case 96505999:
                        if (first.equals("eight")) {
                            var5 = 8;
                        }
                        break;
                    case 109330445:
                        if (first.equals("seven")) {
                            var5 = 7;
                        }
                        break;
                    case 110339486:
                        if (first.equals("three")) {
                            var5 = 3;
                        }
                }

                switch (var5) {
                    case 0:
                        first = "ten";
                        break label88;
                    case 1:
                        first = "eleven";
                        break label88;
                    case 2:
                        first = "twelve";
                        break label88;
                    case 3:
                        first = "thirteen";
                        break label88;
                    case 4:
                        first = "fourteen";
                        break label88;
                    case 5:
                        first = "fifteen";
                        break label88;
                    case 6:
                        first = "sixteen";
                        break label88;
                    case 7:
                        first = "seventeen";
                        break label88;
                    case 8:
                        first = "eighteen";
                        break label88;
                    case 9:
                        first = "nineteen";
                    default:
                        break label88;
                }
            case 2:
                second = "twenty ";
                break;
            case 3:
                second = "thirty ";
                break;
            case 4:
                second = "forty ";
                break;
            case 5:
                second = "fifty ";
                break;
            case 6:
                second = "sixty ";
                break;
            case 7:
                second = "seventy ";
                break;
            case 8:
                second = "eighty ";
                break;
            case 9:
                second = "ninety ";
        }

        num /= 10;
        switch (num % 10) {
            case 1:
                third = "one hundred ";
                break;
            case 2:
                third = "two hundred ";
                break;
            case 3:
                third = "three hundred ";
                break;
            case 4:
                third = "four hundred ";
                break;
            case 5:
                third = "five hundred ";
                break;
            case 6:
                third = "sex hundred ";
                break;
            case 7:
                third = "seven hundred ";
                break;
            case 8:
                third = "eight hundred ";
                break;
            case 9:
                third = "nine hundred ";
        }

        return third + second + first;
    }

    public static String getSha256Hash(String string) {
//Creating the MessageDigest object
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

//Passing data to the created MessageDigest Object
        md.update(string.getBytes());

//Compute the message digest
        byte[] digest = md.digest();

//Converting the byte array in to HexString format
        StringBuilder hexString = new StringBuilder();

        for (int i = 0; i < digest.length; i++) {
            hexString.append(Integer.toHexString(0xFF & digest[i]));
        }
        return hexString.toString();

    }

    public static String correctTitle(String string) {
        String title = "";
        String[] words = string.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            word = word.toLowerCase();
            if (!word.equals("and") && !word.equals("the") && !word.equals("of") && !word.equals("in")) {
                title = title + Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
            } else {
                title = title + word + " ";
            }
        }

        return title;
    }

    public static String hexLattice(int n) {
        String ans = "";
        int temp = 1;

        int l;
        for (l = 1; temp < n; ++l) {
            temp += l * 6;
        }

        if (temp != n) {
            return "Invalid";
        } else {
            int i;
            int j;
            for (i = l; i <= 2 * l - 1; ++i) {
                ans = ans + repeat(" ", 2 * l - i);

                for (j = 0; j < i; ++j) {
                    ans = ans + " o";
                }

                ans = ans + "\n";
            }

            for (i = 2 * l - 2; i >= l; --i) {
                ans = ans + repeat(" ", 2 * l - i);

                for (j = 0; j < i; ++j) {
                    ans = ans + " o";
                }

                ans = ans + "\n";
            }

            return ans;
        }
    }

    ////////////////////60
    public static int bell(int n) {
        int ans = 0;

        for (int i = 0; i <= n; ++i) {
            ans += stirling(n, i);
        }

        return ans;
    }

    private static int stirling(int n, int k) {
        if (n == 0 && k == 0) {
            return 1;
        } else if (k == 0) {
            return 0;
        } else {
            return k > n ? 0 : stirling(n - 1, k - 1) + k * stirling(n - 1, k);
        }
    }

    public static String translateWord(String n)
    {
        int i = 1;
        if(n.substring(0,1).matches("^(?i:[aeiouy]).*"))
        {
            n = n + "yay";
        }
        if(n.substring(0,1).matches("^(?i:[qwrtpsdfghjklzxcvbnm]).*"))
        {
            while(!n.substring(i,i+1).matches("^(?i:[aeiouy]).*"))
            {
                i++;
            }
            n = n.substring(i) + n.substring(0,i) + "ay";
        }
        return(n);
    }

    public static String translateSentence(String n)
    {
        String[] j = new String[n.length()];
        j = n.split(" ");
        String q = "";
        for(int i = 0; i < j.length; i++) {
            if (!j[i].contains(",") && !j[i].contains(".") && !j[i].contains("?") && !j[i].contains("!")) {
                q = q + " " + translateWord(j[i]);
            }

            else
            {
                for(int k = 0; k < j[i].length(); k++)
                {
                    if(j[i].charAt(k) == ',')
                    {
                        q = q + j[i].substring(k,k+1) + translateWord(j[i].substring(1));
                    }
                    if(j[i].charAt(k) == '!' || j[i].charAt(k) == '?' || j[i].charAt(k) == '.')
                    {
                        q = q + " " + translateWord(j[i].substring(0,j[i].length()-1)) + j[i].substring(k,k+1);
                    }
                }
            }
        }
        return q.trim();
    }

    public static boolean validColor(String string) {
        String type = string.substring(0, string.indexOf("("));
        String[] numbers = string.substring(string.indexOf("(") + 1, string.indexOf(")")).split(",");

        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i].equals("")) {
                return false;
            }
        }

        boolean first = Integer.parseInt(numbers[0]) < 256 && Integer.parseInt(numbers[0]) >= 0;
        boolean second = Integer.parseInt(numbers[1]) < 256 && Integer.parseInt(numbers[1]) >= 0;
        boolean third = Integer.parseInt(numbers[2]) < 256 && Integer.parseInt(numbers[2]) >= 0;
        int var7 = -1;
        switch (type.hashCode()) {
            case 112845:
                if (type.equals("rgb")) {
                    var7 = 0;
                }
                break;
            case 3498292:
                if (type.equals("rgba")) {
                    var7 = 1;
                }
        }

        switch (var7) {
            case 0:
                if (numbers.length != 3) {
                    return false;
                }

                return first && second && third;
            case 1:
                if (numbers.length != 4) {
                    return false;
                }

                boolean forth = Double.parseDouble(numbers[3]) >= 0.0D && Double.parseDouble(numbers[3]) < 256.0D;
                return first && second && third && forth;
            default:
                return false;
        }
    }

    public static String stripUrlParams(String url) {
        if (!url.contains("?")) {
            return url;
        } else {
            HashMap<String, Integer> map = new HashMap();
            String paramsAfter = "";
            String host = url.substring(0, url.indexOf("?"));
            String[] parms = url.substring(url.indexOf("?") + 1).split("&");
            String[] var5 = parms;

            for (int i = 0; i < parms.length; ++i) {
                String parm = var5[i];
                map.put(parm.substring(0, parm.indexOf("=")), Integer.parseInt(parm.substring(parm.indexOf("=") + 1)));
            }

            String parm;
            for (Iterator var9 = map.keySet().iterator(); var9.hasNext(); paramsAfter = paramsAfter + "&" + parm + "=" + map.get(parm)) {
                parm = (String) var9.next();
            }

            return paramsAfter.equals("") ? host : host + "?" + paramsAfter.substring(1);
        }
    }

    public static String stripUrlParams(String url, String[] params) {
        if (!url.contains("?")) {
            return url;
        } else {
            HashMap<String, Integer> map = new HashMap();
            String paramsAfter = "";
            String host = url.substring(0, url.indexOf("?"));
            String[] parms = url.substring(url.indexOf("?") + 1).split("&");
            String[] var6 = parms;
            int var7 = parms.length;

            int var8;
            String parm;
            for (var8 = 0; var8 < var7; ++var8) {
                parm = var6[var8];
                map.put(parm.substring(0, parm.indexOf("=")), Integer.parseInt(parm.substring(parm.indexOf("=") + 1)));
            }

            var6 = params;
            var7 = params.length;

            for (var8 = 0; var8 < var7; ++var8) {
                parm = var6[var8];
                if (map.containsKey(parm)) {
                    map.remove(parm);
                }
            }

            for (Iterator var10 = map.keySet().iterator(); var10.hasNext(); paramsAfter = paramsAfter + "&" + parm + "=" + map.get(parm)) {
                parm = (String) var10.next();
            }

            return paramsAfter.equals("") ? host : host + "?" + paramsAfter.substring(1);
        }
    }

    public static void getHashTags(String str) {
        String str2 = str.replaceAll("[^A-Za-zА-Яа-я0-9]", " ");
        String str3 = "";

        String[] sentence = str2.toLowerCase().split(" ");
        Arrays.sort(sentence, Tasks::func);
        String[] ss = new String[sentence.length];
        if (sentence.length >= 3) {
            for (int i = 0; i < 3; i++) {
                ss[i] = "#" + sentence[i];
                str3 = str3 + ss[i] + " ";
            }
            System.out.println(str3);
        } else
        {
            for (int i = 0; i < sentence.length; i++) {
                ss[i] = "#" + sentence[i];
                str3 = str3 + ss[i] + " ";
            }
        System.out.println(str3);
    }
    }

    private static int func(String a, String b) {
        if (a.length() > b.length()) {
            return -1;
        }
        if (a.length() < b.length()) {
            return 1;
        }
        return 0;
    }
    public static int ulam(int n) {
        int[] posl = new int[n];
        int num = 3;
        posl[0] = 1;
        posl[1] = 2;

        for(int i = 2; i < n; ++i) {
            int counter = 0;

            for(int j = 0; j < i; ++j) {
                for(int k = j + 1; k < i; ++k) {
                    if (posl[j] + posl[k] == num) {
                        ++counter;
                    }
                }
            }

            if (counter == 1) {
                posl[i] = num;
            } else {
                --i;
            }

            ++num;
        }

        return posl[n - 1];
    }
    public static String longestNonrepeatingSubstring(String str)
    {
        String a = "", b = "", c= "";
        for(int i = 0; i<str.length(); i++)
        {
            if(!a.contains(str.substring(i, i+1)))
            {
                a=a+str.substring(i, i+1);
                c = a;
            }
            else
            {
                if(a.length()>b.length())
                {
                    b = a;
                    a="";
                }
            }
        }
        if(b.length()>c.length())
            return b;
        else
            return c;
    }
    public static String convertToRoman(int n)
    {
        if (n < 1 || n > 3999)
            return "Невозможно перевести!";
        String s = "";
        while (n >= 1000)
        {
            s += "M";
            n -= 1000;
        }
        if (n >= 900)
        {
            s += "CM";
            n -= 900;
        }
        if (n >= 500)
        {
            s += "D";
            n -= 500;
        }
        if (n >= 400)
        {
            s += "CD";
            n -= 400;
        }
        while (n >= 100)
        {
            s += "C";
            n -= 100;
        }
        if (n >= 90)
        {
            s += "XC";
            n -= 90;
        }
        if (n >= 50)
        {
            s += "L";
            n -= 50;
        }
        if (n >= 40)
        {
            s += "XL";
            n -= 40;
        }
        while (n >= 10)
        {
            s += "X";
            n -= 10;
        }
        if (n >= 9)
        {
            s += "IX";
            n -= 9;
        }
        if (n >= 5)
        {
            s += "V";
            n -= 5;
        }
        if (n >= 4)
        {
            s += "IV";
            n -= 4;
        }
        while (n >= 1)
        {
            s += "I";
            n -= 1;
        }
        return s;
    }
    public static boolean formula(String n)
    {
        double a,b,c;
        String[] j = new String[n.length()];
        j = n.split(" ");
        if(j.length >= 5)
            return false;
        a = Double.parseDouble(j[0].trim());
        b = Double.parseDouble(j[2].trim());
        c = Double.parseDouble(j[4].trim());
        if(j[1].equals("+"))
        {
            return (a+b==c&&j[3].equals("="));
        }
        if(j[1].equals("-"))
        {
            return (a-b==c&&j[3].equals("="));
        }
        if(j[1].equals("*"))
        {
            return (a*b==c&&j[3].equals("="));
        }
        if(j[1].equals("/"))
        {
            return (a/b==c&&j[3].equals("="));
        }
        return false;
    }
    public static boolean palindromedescendant(int n)
    {
        if(n%1000<100)
        {
            if((n%10)*10 == (n%100-n%10))
            {
                return true;
            }
            if((n%10)*10 + (n%100-n%10)>9)
            {
                return palindromedescendant(potomok(n));
            }
        }
        else
        {
            if(String.valueOf(n).equals(reversestring(String.valueOf(n))))
                return true;
            else
            {
                return palindromedescendant(potomok(n));
            }
        }
        return false;
    }
    public static String reversestring(String str)
    {
        String g = "";
        for (int i = str.length()-1; i>=0; i--)
        {
            g = g+str.charAt(i);
        }
        return g;
    }
    public static int potomok(int n)
    {
        int k, b = 0, c = 0, m = 0, g = 0, z = 0;
        k = n;
        while (k>0)
        {
            k = k/10;
            b++;
        }
        k = n;
        int u[] = new int[b];
        int u2[] = new int[b+1];
        for (int j = b-1; j>=0; j--)
        {
            u[j] = k%10;
            k=k/10;
        }
        m=0;
        for (int i = 0; i<b; i++)
        {
            u2[m] = u[i]+u[i+1];
            m++;
            i++;
        }
        k = 0;
        for (int i = 0; i<m; i++)
        {
            k = k+u2[i]*(int)Math.pow(10,m - i-1);
        }
        return k;
    }

}





