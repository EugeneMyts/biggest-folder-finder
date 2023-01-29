import java.io.File;
import java.util.HashMap;

public class SizeCalculator {

    private static char[] sizeMultipliers = {'B', 'K', 'M', 'G', 'T'};
  private static  HashMap<Character, Integer> char2mulptiplier = getMultipliers();


    public static String getHumanReadableSize(long size) {

        for (int i = 0; i < sizeMultipliers.length; i++) {


            double value = ((double) size) / Math.pow(1024., i);

            if (value < 1024) {
                return Math.round(value * 100)/100. + " " + sizeMultipliers[i] +
                        (i > 0 ? "b" : "");

            }

        }
        return "Very big!";

    }

    public static long getSizeFromHumanReadable(String size) {


        char sizeFactor = size
                .replaceAll("[0-9\\s+]+", "")
                .charAt(0);

        
        int mulptiplier = char2mulptiplier.get(sizeFactor);
        long length = mulptiplier * Long.valueOf(size.replaceAll("[^0-9]", ""));

        return length;
    }


    private  static HashMap<Character, Integer> getMultipliers() {


        HashMap<Character, Integer> char2mupltiplier = new HashMap<>();
        for (int i = 0; i < sizeMultipliers.length; i++) {
            char2mupltiplier.put(sizeMultipliers[i] ,(int) Math.pow(1024, i));
        }

        return char2mupltiplier;
    }


}
