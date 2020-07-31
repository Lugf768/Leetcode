package com.lgf.array;

public class findMagicIndex {

    public static void main(String[] args) {
        int[] a = {12296169, 14481887, 19365401, 71948694, 101256536, 137449705, 147615033, 169095970, 182939974, 183054331, 191033174, 200069688, 210281043, 211549396, 227193353, 252408327, 263757832, 268669870, 271916258, 293898012, 322628245, 329246885, 348479255, 405807814, 431800160, 449369511, 477566467, 481431749, 481880069, 487953610, 509211052, 520721303, 527744664, 550058864, 571603718, 571617555, 579098239, 582152388, 645340207, 681566032, 685774515, 706348591, 708774328, 717815831, 721421995, 724666698, 745560058, 746289154, 769651867, 781893631, 789714924, 807615645, 882508445, 884260053, 916797901, 920985226, 924045345, 932899253,
                950715182, 987825772, 1015158842, 1016121780, 1065377233, 1072449577};
        int magicIndex1 = findMagicIndex2(a);
        System.out.println(magicIndex1);
    }

    public static int findMagicIndex1(int[] nums) {

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == i){
                return i;
            }
        }
        return -1;
    }

    public static int findMagicIndex2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static int helper(int[] nums, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        int res = helper(nums, lo, mid - 1);
        if (res != -1) {
            return res;
        } else if (nums[mid] == mid) {
            return mid;
        } else {
            return helper(nums, mid + 1, hi);
        }
    }

}
