class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();

        for(int i = 0; i<= s.length()-10; i++){
            String dnaSeq = s.substring(i,i+10);
            if(set.contains(dnaSeq)){
                res.add(dnaSeq);
            }
            set.add(dnaSeq);
        }

        return new ArrayList<String>(res);
    }
}