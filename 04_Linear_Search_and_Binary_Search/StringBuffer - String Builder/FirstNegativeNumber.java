public class FirstNegativeNumber {
    public static int firstneg(int[] arr){
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<0){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = {3,5,6,-8,9};
        System.out.println(firstneg(arr));
    }
}
