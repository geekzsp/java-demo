package xyz.mosss.spring.examples.springboot.leetcode;

public class Code191 {
    // you need to treat n as an unsigned value
    public  static int hammingWeight01(int n) {
        int count=0;
        while(n!=0){
            if((n&1)==1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    public  static int hammingWeight(int n) {
        int count = 0;
        while(n!=0) {
            if((n&1)==1){
                count=count+1;
            }
            //ones = ones + (n & 1);
            n = n>>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        //System.out.println(hammingWeight(1));
        //System.out.println(hammingWeight(2));
        //System.out.println(hammingWeight(3));
        //System.out.println(hammingWeight(0b110));
        //System.out.println(hammingWeight(0b111));
        System.out.println(hammingWeight(0b11111111111111111111111111111111));
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(0b10000111111111111111111111111111);
        System.out.println(-3>>1);
        System.out.println(-3>>>1);
        System.out.println(-3<<1);
    }
}
//-3
//00000000 00000000 00000000 00000011  //3
//11111111 11111111 11111111 11111100
//11111111 11111111 11111111 11111101  //-3

//-2
//11111111 11111111 11111111 11111110

//2
//00000000 00000000 00000000 00000010
//11111111 11111111 11111111 11111101
//11111111 11111111 11111111 11111110  //-2


//11111111 11111111 11111111 11111101  -3

//11111111 11111111 11111111 11111010  <<

//11111111 11111111 11111111 11111001

//00000000 00000000 00000000 00000110

