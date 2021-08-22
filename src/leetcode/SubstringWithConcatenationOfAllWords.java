package leetcode;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
  public static void main(String[] args) {
    System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
    System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring("foobarfoobar", new String[]{"foo","bar"}));
    System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring("aaaaaaaaaaaaaa", new String[]{"aa","aa"}));
  }

  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();

    Map<String, Integer> map = new HashMap<>();

    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    int firstWordLen = words[0].length();
    int len = words.length;

    for (int i = 0; i <= s.length() - len * firstWordLen; i++) {
      Map<String, Integer> checkMap = new HashMap<>();

      for (int j = 0; j < len; j++) {
        int start = i + j * firstWordLen;

        String checkWord = s.substring(start, start + firstWordLen);

        if (!map.containsKey(checkWord)) {
          break;
        }

        checkMap.put(checkWord, checkMap.getOrDefault(checkWord, 0) + 1);

        if (checkMap.get(checkWord) > map.get(checkWord)) {
          break;
        }

        if (j + 1 == len) {
          result.add(i);
        }
      }
    }

    return result;
  }
}
