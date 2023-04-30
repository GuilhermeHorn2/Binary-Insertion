package misc;





public class main_misc {
    
	
	public static void main(String[] args) {
	  
	
	String n = "10000000000";
	String m = "10011";
	System.out.println(insertion(n,m,2,6));
	  

	 
	}
	
	private static String and_bits(String x,String y){
		if(x.equals("1") && y.equals("1")){
			return "1";
		}
		else {
			return "0";
		}
	}
	
	private static String or_bits(String x,String y){
		
		if(x.equals("0") && y.equals("0")) {
			return "0";
		}
		return "1";
		
	}
	
	private static String insertion(String n,String m,int i,int j){
		
		StringBuilder mask_app = new StringBuilder();
		int i1 = (n.length()-i)-1;
		int j1 = (n.length()-j)-1;
		
		i = i1;
		j = j1;
		
		
		for(int k = 0;k < n.length();k++){
			if(k >= j && k <= i){
				mask_app.append(0);//Zeros between i and j
				continue;
			}
			mask_app.append(1);//Ones between i and j
		}
		String mask = mask_app.toString();//mask to clear the bits of n from i to j
		//That mask is something like 111...100...0111...1
		
		StringBuilder cleared_app = new StringBuilder();//Anding the numbers will clear from i to j and copy the rest
		for(int k = 0;k < n.length();k++){
			String bit = and_bits(n.substring(k, k+1),mask.substring(k, k+1));
			cleared_app.append(bit);
		}
		
		String cleared = cleared_app.toString();
		
		StringBuilder result_app = new StringBuilder();//The result is the or operation between the cleared number and m
		int g = 0;
		for(int k = 0;k < cleared.length();k++){
			if(k >= j && k <= i){
			   String bit = or_bits(cleared.substring(k,k+1),m.substring(g,g+1));
			   result_app.append(bit);
			   g++;
			   continue;
			}
			else {
				result_app.append(cleared.substring(k,k+1));
			}
		}
		
		return result_app.toString();
		
	}
		
	
	}
	
	
