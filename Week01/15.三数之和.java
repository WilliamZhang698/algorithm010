class Solution {
    //非自己作答：测试其他人的题解
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        // negSize：负数的数量
        // posSize：正数的数量
        // zeroSize：0的数量
        int negSize = 0, posSize = 0, zeroSize = 0;
        for (int v : nums) {
            if (v < minValue) {
                minValue = v;
            }
            if (v > maxValue) {
                maxValue = v;
            }
            if (v > 0) {
                posSize++;
            } else if (v < 0) {
                negSize++;
            } else {
                zeroSize++;
            }
        }
        if (zeroSize >= 3) { // 超过3个0
            res.add(Arrays.asList(0, 0, 0));
        }
        // 如果没有负数或没有正数
        if (negSize == 0 || posSize == 0) return res;

        // 如果max/min的绝对值超过了另一边的两倍，将其设置为另一边的两倍，省掉了超界的部分
        if ((minValue << 1) + maxValue > 0) {
            maxValue = -minValue << 1;
        } else if ((maxValue << 1) + minValue < 0) {
            minValue = -maxValue << 1;
        }

        // 类似游标数组，n对应下标为n-minValue
        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v < minValue || v > maxValue) continue;
            if (map[v - minValue]++ != 0) continue;
            //每个位置存放数组中对应数字的个数,poses和negs存放正、负数
            if (v > 0) {
                poses[posSize++] = v;
            } else if (v < 0) {
                negs[negSize++] = v;
            }
        }
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        int nv;
        //遍历负数数组
        for (int i = negSize - 1; i >= 0; i--) {
            nv = negs[i];
            //minp最大为当前负数绝对值的一半(正数向左取整)
            int minp = -nv >>> 1;
            //在poses中basej及其左边的，有2pv+nv<0，因为向左取整右边不一定有2pv+nv>=0
            while (basej < posSize && poses[basej] < minp) {
                basej++;
            }
            //直接从右边开始，省掉了左边的时间
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                //cv的值为
                int cv = -nv - pv;
                //pv+2nv<=0,且2pv+nv>=0,因为右面不一定有2pv+nv>=0，所以还是要有后面的条件
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - minValue] > 1) {
                            res.add(Arrays.asList(nv, nv, pv));
                        }
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1) {
                            res.add(Arrays.asList(nv, pv, pv));
                        }
                    } else if (map[cv - minValue] > 0) {
                        res.add(Arrays.asList(nv, cv, pv));
                    }
                } else if (cv < nv) {
                    // cv<nv即pv+2nv>0,退出循环，找下一个nv,省掉了过大的时间
                    break;
                }
            }
        }
        return res;
    }
}