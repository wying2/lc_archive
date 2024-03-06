class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        wordList = set(wordList)
        if endWord not in wordList:
            return 0
        
        def diffByOne (word1, word2):
            count = 0
            for i in range(len(word1)):
                if word1[i] != word2[i]:
                    count += 1
            return count <= 1
        
        graph = {}
        for word in wordList:
            if word not in graph:
                graph[word] = []
        
        queue = []
        visited = set()
        queue.append(beginWord)
        visited.add(beginWord)
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
                        if new_word in wordList and new_word not in visited:
                            wordList.remove(new_word)
                            visited.add(new_word)
                            nex.append(new_word)
            queue = nex
            steps += 1
        return 0