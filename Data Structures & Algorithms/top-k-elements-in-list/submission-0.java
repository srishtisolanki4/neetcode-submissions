class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int key:map.keySet()){
            pq.add(new int[]{key,map.get(key)});
            if(pq.size()>k){pq.poll();}
        }

        int res[]=new int[k];
        for(int i=0;i<k;i++){
            res[i]=pq.poll()[0];
        }
        return res;
    }
}
