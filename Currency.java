

public class Currency {
    
    String cname1;
    String cname2;
    String data;
    Double value;
    Integer number;

    public Currency(){};

    public Currency(String c1,String c2, String d, double v, int n ) 
    {
    this.cname1 = c1;
    this.cname2 = c2;
    this.data = d;
    this.value = v;
    this.number = n;
    }




   
}

// For the next java code, write a  depth-first search method ,which finds the object throm  ArrayList<Currency> "currencies" according to the value number from class "Currency" : 
// public class Currency {
    
//     String cname1;
//     String cname2;
//     String data;
//     Double value;
//     Integer number;

//     public Currency(){};

//     public Currency(String c1,String c2, String d, double v, int n ) 
//     {
//     this.cname1 = c1;
//     this.cname2 = c2;
//     this.data = d;
//     this.value = v;
//     this.number = n;
//     }
// }

// public class Linear{
//     public static void main(String[] args) {
//         ArrayList<Currency> currencies = new ArrayList<Currency>();
//         ArrayList<Currency> currencies2 = new ArrayList<Currency>();
        
//         String fileName = "CurrencyData.csv";
//         try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
//             String line;
//             while ((line = br.readLine()) != null) {
//                 String[] values = line.split(",");
//                 String cname1 = values[0];
//                 String cname2 = values[1];
//                 String data = values[2];
//                 Double value = Double.parseDouble(values[3]);
//                 Integer number = Integer.parseInt(values[4]);
//                 Currency currency = new Currency(cname1, cname2, data, value, number);
//                 currencies.add(currency);
//             }  
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }