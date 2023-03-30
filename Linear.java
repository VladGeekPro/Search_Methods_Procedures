import java.util.HashSet;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Linear{
    public static void main(String[] args) {
        ArrayList<Currency> currencies = new ArrayList<Currency>();
        ArrayList<Currency> currencies2 = new ArrayList<Currency>();
        
        String fileName = "CurrencyData.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String cname1 = values[0];
                String cname2 = values[1];
                String data = values[2];
                Double value = Double.parseDouble(values[3]);
                Integer number = Integer.parseInt(values[4]);
                Currency currency = new Currency(cname1, cname2, data, value, number);
                currencies.add(currency);
            }  
        } catch (IOException e) {
            e.printStackTrace();
        }

        currencies2.addAll(currencies);

        System.out.println("Unsorted table");

        for (Currency currency : currencies) {
            System.out.println(currency.cname1 + ", " + currency.cname2 + ", " + currency.data + ", " + currency.value + ", " + currency.number);
        }
       
        System.out.println("");

       Collections.sort(currencies2, (c1, c2) -> c1.number.compareTo(c2.number));

       System.out.println("Sorted table");

       for (Currency currency : currencies2) {
            System.out.println(currency.cname1 + ", " + currency.cname2 + ", " + currency.data + ", " + currency.value + ", " + currency.number);
         }

////////////////////// linearSearch ///////////////////////////
         long startTime = System.currentTimeMillis();
        System.out.println("");

        Currency result = linearSearch(currencies,554);
        if (result != null ) {
            System.out.println("Method 1, currency found in unsorted table: " + result.cname1 + ", " + result.cname2 + ", " + result.data + ", " + result.value + ", " + result.number);
        } else { System.out.println("Method 1, currency not found in unsorted table."); }
        
        Currency result2 = linearSearch(currencies2,554);
        if (result2 != null ) {
            System.out.println("Method 1, currency found in sorted table: " + result.cname1 + ", " + result.cname2 + ", " + result.data + ", " + result.value + ", " + result.number);
        } else { System.out.println("Method 1, currency not found in sorted table  "); }

        long endTime = System.currentTimeMillis(); 
        long timeTaken = endTime - startTime;
        System.out.println("Time taken: " + timeTaken + " milliseconds");
////////////////////// linearSearch End ///////////////////////////

// поиска в неотсортированных массивах древовидно структурированных END // 
long startTime2 = System.currentTimeMillis();
    System.out.println("");

    Currency result3 = dfs(currencies, 124);
    if (result3 != null) {
        System.out.println("Method 2, currency found in unsorted table: " + result3.cname1 + ", " + result3.cname2+ ", " + result3.data + ", " + result3.value + ", " + result3.number);
    } else {
        System.out.println("Method 2, currency not found in unsorted table.");
    }

    Currency result4 = dfs(currencies2, 124);
    if (result4 != null) {
        System.out.println("Method 2, currency found in sorted table: " + result4.cname1 + ", " + result4.cname2+ ", " + result4.data + ", " + result4.value + ", " + result4.number);
    } else {
        System.out.println("Method 2, currency not found in sorted table.");
    }

    long endTime2 = System.currentTimeMillis();  
    long timeTaken2 = endTime2 - startTime2;
    System.out.println("Time taken: " + timeTaken2 + " milliseconds");
// Function поиска в неотсортированных массивах древовидно структурированных END // 

// binary search // 

long startTime3 = System.currentTimeMillis(); 

System.out.println("");

Currency result5 = binarySearch(currencies, 417);
if (result5 != null) {
    System.out.println("Method 3, currency found in unsorted table: " + result5.cname1 + ", " + result5.cname2+ ", " + result5.data + ", " + result5.value + ", " + result5.number);
} else {
    System.out.println("Method 3, currency not found in unsorted table");
}

Currency result6 = binarySearch(currencies2, 417);
if (result6 != null) {
    System.out.println("Method 3, currency found in sorted table: " + result6.cname1 + ", " + result6.cname2+ ", " + result6.data + ", " + result6.value + ", " + result6.number);
} else {
    System.out.println("Method 3, currency not found in sorted table");
}

long endTime3 = System.currentTimeMillis();
long timeTaken3 = endTime3 - startTime3;
System.out.println("Time taken: " + timeTaken3 + " milliseconds");
// binary search END //

// Fibonacci  search // 
long startTime4 = System.currentTimeMillis();
System.out.println("");

Currency result7 = fibonacciSearch(currencies, 414);
if (result7 != null) {
    System.out.println("Method 4, currency found in unsorted table: " + result7.cname1 + ", " + result7.cname2+ ", " + result7.data + ", " + result7.value + ", " + result7.number);
} else {
    System.out.println("Method 4, currency not found in unsorted table");
}

Currency result8 = fibonacciSearch(currencies2, 414);
if (result8 != null) {
    System.out.println("Method 4, currency found in sorted table: " + result8.cname1 + ", " + result8.cname2+ ", " + result8.data + ", " + result8.value + ", " + result8.number);
} else {
    System.out.println("Method 4, currency not found in sorted table");
}

long endTime4 = System.currentTimeMillis(); 
long timeTaken4 = endTime4 - startTime4;
System.out.println("Time taken: " + timeTaken4 + " milliseconds");
// Fibonacci  search // 
System.out.println("");
System.out.println("");
}


////////////////////// Function linearSearch ///////////////////////////
public static Currency linearSearch(ArrayList<Currency> currencies, int number){
    for (Currency currency : currencies) {
        if (currency.number.equals(number)) {
            return currency;
        }                
    }
return null;
} 
////////////////////// Function linearSearch End ///////////////////////////


 // Function поиска в неотсортированных массивах древовидно структурированных // 
public static Currency dfs(ArrayList<Currency> currencies, int number) {
    
    Stack<Currency> stack = new Stack<>();    
    
    HashSet<Currency> visited = new HashSet<>();    
    
    stack.push(currencies.get(0));    
    
    while (!stack.isEmpty()) {
    
        Currency curr = stack.pop();        
    
        if (curr.number == number) {
            return curr;
        }
    
         visited.add(curr);        
    
        for (Currency neighbor : currencies) {
            if (!visited.contains(neighbor)) {
                stack.push(neighbor);
            }
        }
    }
    
    return null;
}
 // Function поиска в неотсортированных массивах древовидно структурированных END // 

// Function binary search // 
 public static Currency binarySearch(ArrayList<Currency> currencies, int number) {
    int left = 0;
    int right = currencies.size() - 1;

    while (left <= right) {
        int mid = (left + right) / 2;

        if (currencies.get(mid).number == number) {
            return currencies.get(mid);
        } else if (currencies.get(mid).number < number) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return null;
}
// Function binary search END// 

// Function Fibonacci  search // 
public static Currency fibonacciSearch(ArrayList<Currency> currencies, int targetNumber) {
    int n = currencies.size();
    int fib2 = 0; 
    int fib1 = 1; 
    int fib = fib2 + fib1; 

    
    while (fib < n) {
        fib2 = fib1;
        fib1 = fib;
        fib = fib2 + fib1;
    }

    int offset = -1; 
    while (fib > 1) {
        int i = Math.min(offset + fib2, n - 1);
        Currency currency = currencies.get(i);

        if (currency.number < targetNumber) {
            
            fib = fib1;
            fib1 = fib2;
            fib2 = fib - fib1;
            offset = i;
        } else if (currency.number > targetNumber) {
            
            fib = fib2;
            fib1 = fib1 - fib2;
            fib2 = fib - fib1;
        } else {
           
            return currency;
        }
    }

   
    if (fib1 == 1 && offset + 1 < n && currencies.get(offset + 1).number == targetNumber) {
        return currencies.get(offset + 1);
    }

    
    return null;
   
    }
}
    




