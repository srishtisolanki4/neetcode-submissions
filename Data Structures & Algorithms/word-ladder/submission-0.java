class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordLists) {
        Set<String> wordList=new HashSet<>();
        for(String w:wordLists){
            wordList.add(w);
        }
        Queue<Pair<String,Integer>> q=new LinkedList<>();
        q.add(new Pair<>(beginWord,1));
        

        while(!q.isEmpty()){
            Pair<String,Integer> polled=q.poll();
            String word=polled.getKey();
            int level=polled.getValue();
            if(word.equals(endWord))return level;
            char [] charArray=word.toCharArray();
            for(int i=0;i<charArray.length;i++){
                char original=charArray[i];
                for(char c='a';c<='z';c++){
                    if(charArray[i]==c)continue;
                    charArray[i]=c;
                    String newWord=String.valueOf(charArray);

                    if(wordList.contains(newWord)){
                        q.add(new Pair<>(newWord,level+1));
                        wordList.remove(newWord);
                    }
                }
                charArray[i]=original;
            }
        }
        return 0;
    }
}
