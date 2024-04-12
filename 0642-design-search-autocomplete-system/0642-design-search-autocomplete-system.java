class TrieNode {
    Map<Character, TrieNode> children;
    Map<String, Integer> sentences;
    public TrieNode() {
        children = new HashMap<>();
        sentences = new HashMap<>();
    }
}

class AutocompleteSystem {
    TrieNode root;
    StringBuilder currSentence;
    TrieNode curr;
    TrieNode dead;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        for (int i = 0; i < sentences.length; i ++) {
            addToTrie(sentences[i], times[i]);
        }
        currSentence = new StringBuilder();
        
        curr = root;
        dead = new TrieNode();
    }
    
    public List<String> input(char c) {
        List<String> ans = new ArrayList<>();
        if (c == '#') {
            addToTrie(currSentence.toString(), 1);
            currSentence.setLength(0);
            curr = root;
            return ans;
        }
        
        currSentence.append(c);
        if (!curr.children.containsKey(c)) {
            curr = dead;
            return ans;
        }
        
        curr = curr.children.get(c);
        List<String> sentences = new ArrayList<>(curr.sentences.keySet());
        Collections.sort(sentences, (a, b) -> {
            int hotA = curr.sentences.get(a);
            int hotB = curr.sentences.get(b);
            if (hotA == hotB)
                return a.compareTo(b);
            return hotB - hotA;
        });
        for (int i = 0; i < Math.min(3, sentences.size()); i ++) {
            ans.add(sentences.get(i));
        }
        return ans;
    }
    
    private void addToTrie(String sentence, int count) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            if (!node.children.containsKey(c))
                node.children.put(c, new TrieNode());
            node = node.children.get(c);
            node.sentences.put(sentence, node.sentences.getOrDefault(sentence, 0) + count);
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */