package hackbulgaria.corejava2.week0;

public interface UP {
    
    boolean isOdd(int number);
    
    boolean isPrime(int number);
    
    int min(int... array);
    
    int kthMin(int k, int[] array);
    
    float getAverage(int[] array);
    
    long doubleFac(int n);
    
    long kthFac(int k, int n);
    
    long getSmallestMultiple(int upperBound);
    
    long getLargestPalindrome(long n);
    
    int[] histogram(short[][] image);
    
    long pow(int a, int b);
    
    int getOddOccurrence(int... array);
    
    long maximalScalarSum(int[] a, int[] b);
    
    int maxSpan(int[] numbers);
    
    boolean canBalance(int[] numbers);
    
    int[][] rescale(int[][] original, int newWidth, int newHeight);
    
    String reverseMe(String argument);
    
    String reverseEveryWord(String arg);
    
    boolean isPalindrome(String argument);
    
    boolean isPalindrome(int argument);
    
    String copyEveryChar(String input, int k);
    
    int getPalindromeLength(String input);
    
    int countOcurrences(String needle, String haystack);
    
    String decodeURL(String input);
    
    int sumOfNumbers(String input);
    
    boolean areAnagrams(String A, String B);
    
    boolean hasAnagramOf(String string, String string2);
    
}
