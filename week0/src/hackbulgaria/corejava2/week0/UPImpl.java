package hackbulgaria.corejava2.week0;

import java.util.ArrayList;
import java.util.Arrays;

public class UPImpl implements UP {
    
    @Override
    public boolean isOdd(int number) {
        return (number % 2 != 0);
    }
    
    @Override
    public boolean isPrime(int number) {
        for (int i = 2; i < number; i++)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }
    
    @Override
    public int min(int... array) {
        int min = array[0];
        for (int element : array)
        {
            if (element < min)
            {
                min = element;
            }
        }
        return min;
    }
    
    @Override
    public int kthMin(int k, int[] array) {
        for (int i = 0; i < array.length-1; i++)
        {
            for (int j = i+1; j < array.length; j++)
            {
                if (array[i] > array[j])
                {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array[k-1];
    }
    
    @Override
    public float getAverage(int[] array) {
        float sum = 0;
        float n = 0;
        for (int element : array)
        {
            sum += element;
            n += 1;
        }
        return sum / n;
    }
    
    public long gcd(long a, long b) 
    { 
        return b == 0 ? a : gcd(b, a % b); 
    } 
    
    @Override
    public long getSmallestMultiple(int upperBound) 
    { 
        if (upperBound == 2) 
            return 2; 
        else 
        { 
            long b = getSmallestMultiple(upperBound - 1); 
            return (upperBound - 1) * b /gcd(upperBound - 1, b); 
        } 
    }
    
    public boolean isPalindrom(long n)
    {
        long x = n;
        ArrayList<Long> pal = new ArrayList<Long>();
        while(x != 0)
        {
            pal.add(x%10);
            x = x/10;
        }
        int len = pal.size();
        for (int i = 0; i < len; i++)
        {
            if (pal.get(i) != pal.get(len-i-1))
            {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public long getLargestPalindrome(long N) {
        N--;
        while (N != 0)
        {
            if(isPalindrom(N) == true)
                break;
            N--;
        }
        return N;
    }
    
    public int getCount(int n, short[][] image)
    {
        int count = 0;
        for(int i = 0; i < image.length; i++)
        {
            for(int j = 0; j < image.length; j++)
            {
                if (image[i][j] == n)
                    count++;
            }
        }
        return count;
    }
    
    //@Override
    public int[] histogram(short[][] image) {
        int[] arr = new int[256];
        for(int i = 0; i < 256; i++)
        {
            arr[i] = getCount(i, image);
        }
        return arr;
        
    }
    
    //@Override
    public long doubleFac(int n) {
        int fact = 1;
        int k = 0;
        while (k != 2)
        {
            if (n == 0)
            {
                n = fact;
                fact = 1;
                k++;
            }
            else
            {
                fact = fact*n;
                n--;
            }   
        }
        return n;
    }
    
    @Override
    public long kthFac(int k, int n) {
        int fact = 1;
        for (int i = 1; i <= n; i += k)
        {
            fact *= i;
        }
        return fact;
    }
    
    @Override
    public int getOddOccurrence(int... array) {
    	Arrays.sort(array);
	  	int i = 0;
	  	int index = 0;
	  	int counter = 1;
	  	while (i+1 != array.length)
	  	{
	  		if (array[i] == array[i+1])
	  		{
	  			counter++;
	  			i++;
	  		}
	  		else
	  		{
	  			if (counter % 2 != 0)
	  			{
	  				index = i;
	  				break;
	  			}
	  			
	  			counter=1;
	  			i++;
	  		}
	  	}
	  	return array[index];
    }
    
    @Override
    public long pow(int a, int b) {
        long n = a;
        if (b == 0)
            return 1;
        for (int i = 1; i < b; i++)
        {
            n *= a;
        }
        return n;
    }
    
    public void sort(int[] a)
    {
        for(int i = 0; i < a.length;i++)
        {
            for (int j = i+1; j < a.length; j++)
            {
                if (a[i] < a[j])
                {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                
            }
        }
    }
    
    @Override
    public long maximalScalarSum(int[] a, int[] b) {
        sort(a);
        sort(b);
        long sum = 0;
        for(int i = 0; i < a.length; i++)
        {
            sum += a[i]*b[i];
        }
        return sum;
    }
    
    @Override
    public int maxSpan(int[] array) {
        int span = 0;
        int index = 0;
        int len = array.length;
        for (int i = 0; i < len - 1; i++)
        {
            for (int j = i+1; j < len; j++)
            {
                if (array[j] == array[i])
                    index = j;
            }
            int sum = index - i + 1;
            if (span < sum)
                span = sum;
        }
        return span;
    }
    
    public int sumOfOneHalf(int[] numbers, int start, int end)
    {
        int sum = 0;
        for(int i = start; i < end; i++)
        {
            sum += numbers[i];
        }
        return sum;
    }
    
    @Override
    public boolean canBalance(int[] array) {
        int i = 0;
        boolean flag = false;
        int sum = 0;
        while (array.length != i && !flag)
        {
            if (sum == sumOfOneHalf(array, i, array.length))
                flag = true;
            else
                sum += array[i];
                i++;
        }
        return flag;
    }
    
    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) 
    {
        double ratioX = (double) newWidth / original.length;
        double ratioY = (double) newHeight / original[0].length;
        
        int[][] rescaledImage = new int[newWidth][newHeight]; 
        for (int i = 0; i < newWidth; i++)
        {
            for (int j = 0; j < newHeight; j++)
            {
                
                rescaledImage[i][j] = original[(int) (i/ratioX)][(int) (j/ratioY)];
                
            }
        }
        return rescaledImage;
    }
    
    @Override
    public String reverseMe(String argument) {
        String reverse = new String();
        int len = argument.length();
        for (int i = 0 ; i < len; i++)
        {
            reverse += argument.charAt(len-i-1);
        }
        return reverse;
    }
    
    @Override
    public String copyEveryChar(String input, int k) {
        String newstr = new String();
        int len = input.length();
        for (int i = 0; i < len; i++)
        {
            for(int j = 0 ; j < k; j++)
            {
                newstr += input.charAt(i);
            }
        }
        return newstr;
    }
    
    @Override
    public String reverseEveryWord(String arg) {
        String[] splitedArg = arg.split(" ");
        int len = splitedArg.length;
        String reversed = new String();
        for (int i = 0; i < len-1; i++)
        {
            reversed += reverseMe(splitedArg[i]) + " ";
        }
        reversed += reverseMe(splitedArg[len-1]);
        return reversed;
    }
    
    @Override
    public boolean isPalindrome(String argument) {
        int len = argument.length();
        boolean flag = true;
        for (int i = 0; i < len && flag; i++)
        {
            if (argument.charAt(i) != argument.charAt(len - i - 1))
                flag = false;
        }
        return flag;
    }
    
    @Override
    public boolean isPalindrome(int number) {
        int x = number;
        ArrayList<Integer> pal = new ArrayList<Integer>();
        while(x != 0)
        {
            pal.add(x%10);
            x = x/10;
        }
        int len = pal.size();
        for (int i = 0; i < len; i++)
        {
            if (pal.get(i) != pal.get(len-i-1))
            {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int getPalindromeLength(String input) {
        int k = input.length() / 2 +1;
        int i = k - 2;
        int counter = 0;
        while(i != -1 || k != input.length())
        {
            if (input.charAt(i) == input.charAt(k))
            {
                counter++;
                i--;
                k++;
            }
            else
                break;
        }
        return counter;
    }
    
    @Override
    public int countOcurrences(String needle, String haystack) {
        return (haystack.length() - haystack.replace(needle, "").length()) / needle.length();
    }
    
    @Override
    public String decodeURL(String input) {
        return input.replace("%20", " ").replace("%3A", ":").replace("%3D", "?").replace("%2F", "/");
    }
    
    @Override
    public int sumOfNumbers(String input) {
        int len = input.length();
        int sum = 0;
        ArrayList<String> l = new ArrayList<String>();
        int i = 0;
        int k = 0;
        while (i != len)
        {
            boolean flag = true;
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9')
            {
                System.out.println(i);
                String str = new String();
                if (i != 0)
                {
                    if (input.charAt(i-1) == '-')
                        str+= input.charAt(i-1);
                }
                str += input.charAt(i);
                
                k = i;
                for (int j = i + 1; j < len && flag; j++)
                {
                    if (input.charAt(j) < '0' || input.charAt(j) > '9')
                    {
                        flag = false;
                    }
                    else
                    {
                        str += input.charAt(j);
                        k++;
                    }
                        
                }
                System.out.println(str.toString());
                i = k;
                l.add(str);
            }
            i++;
            System.out.println(i);

        }
        
        System.out.println(l.toString());
        for(int h = 0; h < l.size(); h++)
        {
            if (l.get(h) != "")
                sum += Integer.parseInt(l.get(h));
        }
        return sum;
    }
    
    @Override
    public boolean areAnagrams(String A, String B) {
        ArrayList<Character> l = new ArrayList<Character>();
        for(int i = 0; i < A.length(); i++)
        {
            l.add(A.charAt(i));
        }
        
        int len = B.length();
        
        if (len != l.size())
            return false;
        
        for(int i = 0 ; i < len; i++)
        {
            if (l.contains(B.charAt(i)))
            {
                for(int j = 0; j < l.size(); j++)
                {
                    if (l.get(j) == B.charAt(i))
                        l.remove(j);
                }
            
            }
        }
        
        if (l.size() == 0)
            return true;
        else return false;
    }
    
    @Override
    public boolean hasAnagramOf(String string, String string2) 
    {
        int len = string.length();
        for (int i = 0 ; i < string2.length()-len+1; i++)
        {
            if (areAnagrams(string, string2.substring(i, i+len)) == true)
            {
                return true;
            }
        }
        return false;
    }
    
    
}