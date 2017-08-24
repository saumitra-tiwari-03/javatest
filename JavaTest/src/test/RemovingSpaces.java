package test;

public class RemovingSpaces {

	public static void main(String[] args) {
		RemovingSpaces r = new RemovingSpaces();
		r.rempveSpaces("LONE STAR                       TX75668       USA");
	}
	
	public String rempveSpaces(String str){
		char [] arr= str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++){
			if(arr[i] != ' '){
				sb.append(arr[i]+"");
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
