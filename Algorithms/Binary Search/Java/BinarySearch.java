
public class BinarySearch{
    public static void main(String[] args) {
        int[] testArr1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] testArr2 = new int[]{1, 2};
        int[] testArr3 = new int[]{};
        int[] testArr4 = new int[]{1, 2, 3, 4, 5, 6, 7, 10, 15, 22, 96, 102, 133, 145, 176, 200, 203, 204, 288, 293, 304, 351, 371, 388, 389, 390};

        System.out.println(recursiveBinarySearch(testArr1, 2, 0, testArr1.length));
        System.out.println(recursiveBinarySearch(testArr2, 5, 0, testArr2.length));
        System.out.println(recursiveBinarySearch(testArr3, 1, 0, testArr3.length));
        System.out.println(recursiveBinarySearch(testArr4, 293, 0, testArr4.length));

        System.out.println(iterativeBinarySearch(testArr1, 2));
        System.out.println(iterativeBinarySearch(testArr2, 5));
        System.out.println(iterativeBinarySearch(testArr3, 1));
        System.out.println(iterativeBinarySearch(testArr4, 293));
    }

    private static int recursiveBinarySearch(int[] arr, int target, int low, int high){
        if(arr.length == 0) return -1;

        int middle = (low + high) / 2;

        if(arr[middle] == target){
            return middle;
        } else if(high - low == 1){
            return -1;
        }

        if(arr[middle - 1] >= target){
            return recursiveBinarySearch(arr, target, low, middle);
        } else{
            return recursiveBinarySearch(arr, target, middle, high);
        }
    }

    private static int iterativeBinarySearch(int[] arr, int target){
        if(arr.length == 0) return -1;

        int low = 0;
        int high = arr.length;

        while(high - low > 1){
            int middle = (low + high) / 2;

            if(arr[middle] == target) return middle;

            if(arr[middle - 1] >= target){
                high = middle;
            } else{
                low = middle;
            }
        }

        return -1;
    }
}
