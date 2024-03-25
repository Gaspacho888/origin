import java.util.TreeMap;

public class Konvert {
    TreeMap<Character, Integer> romeKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabKeyMap = new TreeMap<>();

    public Konvert() {
        romeKeyMap.put('I', 1);
        romeKeyMap.put('V', 5);
        romeKeyMap.put('X', 10);
        romeKeyMap.put('L', 50);
        romeKeyMap.put('C', 100);

        arabKeyMap.put(1, "I");
        arabKeyMap.put(5, "V");
        arabKeyMap.put(10, "X");
        arabKeyMap.put(50, "L");
        arabKeyMap.put(100, "C");

    }

    public boolean isRoman(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (!romeKeyMap.containsKey(num.charAt(i))) {
                
                return false;
            }
        }
        return true;
    }

    public String intToRoman(int num) {
        String roman = "";
        int arabKey;

        do {
            arabKey = arabKeyMap.floorKey(num);
            roman += arabKeyMap.get(arabKey);
            num -= arabKey;

        

        } while (num != 0);
        return roman;
    }

    public int romanToInt(String str) {
        int end = str.length() - 1; 
        char[] array = str.toCharArray(); 
        int arab;
        int result = romeKeyMap.get(array[end]);
        for (int i = end - 1; i >= 0; i--) {
            arab = romeKeyMap.get(array[i]);
            if (arab < romeKeyMap.get(array[i + 1])) { 
                result -= arab;
            } else {
                result += arab;
            }
        }
        return result;
    } 
}
