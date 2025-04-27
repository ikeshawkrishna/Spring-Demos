package DSA.Strivers.ProblemsOnArrays.Easy;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class start {

    public static void main(String[] args) {
        System.out.println(findUnion(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{2, 3, 4, 4, 5, 11, 12}));
        System.out.println(maximumConsecurtiveOne(new int[]{1,1,1,1,0,0,1,1,1}));
        System.out.println(findNumberAppearOnce(new int[]{2,3,4,4,2,1,3,6,1}));
    }

    static int findNumberAppearOnce(int[] number){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : number){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> val : map.entrySet()){
            if(val.getValue() == 1){
                return val.getKey();
            }
        }
        return -1;
    }

    /*=======================================================*/

    static int maximumConsecurtiveOne(int[] number){ // 1,1,0,0,1,1,1
        int maxi = 0;
        int count = 0;
        for(int num : number){
            if(num == 1){
                count++;
            } else {
                count = 0;
            }
            maxi = Math.max(maxi, count);
        }
        return maxi;
    }

    /*=======================================================*/

    static String findUnion(int[] arr1, int[] arr2){
//        Set<Integer> setvalues = new TreeSet<>();
//        for(int num : arr1){
//            setvalues.add(num);
//        }
//
//        for(int num : arr2){
//            setvalues.add(num);
//        }

        List<Integer> setvalues = new ArrayList<>();
        int i = 0, j = 0;
        while(i < arr1.length && j <arr2.length){
            if(arr1[i] <= arr2[j]){
                if(setvalues.size() == 0 || setvalues.get(setvalues.size()   - 1) != arr1[i]){
                    setvalues.add(arr1[i]);

                }
                i++;
            } else {
                if(setvalues.size() == 0 || setvalues.get(setvalues.size() - 1) != arr2[j]){
                    setvalues.add(arr2[j]);

                }
                j++;
            }
        }

        while(i < arr1.length){
            if(setvalues.get(setvalues.size() - 1) != arr1[i]){
                setvalues.add(arr1[i]);
            }
            i++;
        }
        while(j < arr2.length){
            if(setvalues.get(setvalues.size() - 1) != arr2[j]){
                setvalues.add(arr2[j]);
            }
            j++;
        }

        return Arrays.toString(setvalues.toArray());
    }

    /*=======================================================*/

    static void moveZeroToEnd(int[] number){
        int index = 0;
        for(int i = 0; i < number.length; i++){
            if(number[i] != 0){
                number[index] = number[i];
                index++;
            }
        }
        for(int i = index; i < number.length; i++){
            number[i] = 0;
            index++;
        }
        System.out.println(Arrays.toString(number));
    }

    /*=======================================================*/

    static void removeDuplicateInSortedArray(int[] number){
        Set<Integer> element = new HashSet<>();
        for(int num : number){
            element.add(num);
        }
        System.out.println(element);
    }

    /*=======================================================*/

    static boolean checkSorted(int[] number){
        //Approach 1
//        for(int i = 0; i < number.length - 1; i++){
//            if(number[i] > number[i+1]){
//                return false;
//            }
//        }

        //Approach 2
        boolean allMatch = IntStream.range(0, number.length - 1)
                .allMatch(i -> number[i] < number[i+1]);
        return allMatch;
    }

    /*=======================================================*/

    static int maxElement(int[] number, List<Integer> numberList){
        //Approach 1
        int size = number.length;
        int max = number[0];
        for(int i = 1; i < size; i++){
            if(number[i] > max){
                max = number[i];
            }
        }

        //Approach 2
//        int max = Arrays.stream(number)
//                .max().getAsInt();

        //Approach 3
//        Integer max = Collections.max(numberList);

        return max;
    }

    /*=======================================================*/

    static void printDivisor(int number){
        //Approach 1
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                System.out.println(" >> " + i);
            }
        }

        //Approach 2
//        IntStream.rangeClosed(1, number)
//                .filter(num -> number % num == 0)
//                .forEach(num -> System.out.println(num));
    }
}
