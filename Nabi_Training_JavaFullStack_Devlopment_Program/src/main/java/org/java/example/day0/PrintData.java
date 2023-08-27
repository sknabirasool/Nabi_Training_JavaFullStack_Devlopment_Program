package org.java.example.day0;
public class PrintData {
   public int sumofnumbers(int arr[])
    {
       int max=arr[0];
       for (int i=1;i<arr.length;i++)
        {
            if(arr[i]>max){
                max=arr[i];
            }
        }
       return max;
    }
    public static void main(String[] args) {

       int a[]={10,20,30,40,50};

        PrintData data=new PrintData();

        System.out.println(data.sumofnumbers(a));



    }
}
