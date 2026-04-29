class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++) set.add(wordList.get(i));
        set.remove(beginWord);
        if(!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s=0;s<size;s++){
                String word = q.poll();
                if(word.equals(endWord)) return level;

                char[] arr = word.toCharArray();
                for(int i=0; i<arr.length; i++){
                    char org = arr[i];

                    for(char c='a';c<='z';c++){
                        arr[i] = c;
                        String next = new String(arr); //
                        if(set.contains(next)) {
                            set.remove(next);
                            q.add(next);
                        }
                    }
                    arr[i] = org;
                }
            }
            level ++;
        }
        return 0;
    }
}