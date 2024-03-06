class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        wordList = set(wordList)
        if endWord not in wordList:
            return 0
        queue = []
        queue.append(beginWord)
        n = len(beginWord)
        steps = 1
        alph = "abcdefghijklmnopqrstuvwxyz"
        while queue:
            nex = []
            for word in queue:
                if word == endWord:
                    return steps
                for i in range(len(word)):
                    for c in alph:
                        new_word = word[:i] + c + word[i+1:]
                        if new_word in wordList:
                            wordList.remove(new_word)
                            nex.append(new_word)
            queue = nex
            steps += 1
        return 0