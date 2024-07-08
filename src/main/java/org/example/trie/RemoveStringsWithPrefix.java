package org.example.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    private final TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                return false;
            }
        }
        return true; // Prefix fully matched
    }
}

public class RemoveStringsWithPrefix {

    public static List<String> removeStringsWithPrefix(List<String> strings) {
        Trie trie = new Trie();
        List<String> output = new ArrayList<>();

        // Sort the list to ensure that prefixes are checked appropriately
        Collections.sort(strings);

        for (String string : strings) {
            // Only add to output and trie if no prefix in trie matches the current string
            if (!trie.startsWith(string)) {
                trie.insert(string);
                output.add(string);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        List<String> inputStrings = java.util.Arrays.asList("ar", "arp", "fin", "finance", "lb", "win", "winner");
        List<String> result = removeStringsWithPrefix(inputStrings);
        System.out.println(result);
    }
}
