class Solution {
    public boolean halvesAreAlike(String s) {
        int u=s.length();
        String str=s.substring(0,u/2);
        String str2=s.substring(u/2,u);
        int c2=0;
        int c1=0;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ||c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
                c2++;
            }
        }
        for(int i=0;i<str2.length();i++){
            char c=str2.charAt(i);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ||c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
                c1++;
            }
        }
        if(c2==c1){
            return true;
        }
        return false;
    }
}