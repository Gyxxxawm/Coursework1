public class StringManipulation {
    public static String[] splitSentence(String sentence){
        return sentence.split(" ");
    }

    public static String capitalizeWord(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();

    }

    public static String joinWords(String[] words) {
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append(" "); // 将单词连接起来
        }
        return result.toString().trim(); // 返回连接后的句子，并去掉末尾空格
    }

    public static void main(String[] args) {
        String sentence = "hello world! this is a test sentence.";
        String[] words = splitSentence(sentence); // 拆分句子

        for (int i = 0; i < words.length; i++) {
            words[i] = capitalizeWord(words[i]);
        }
        String capitalizedSentence = joinWords(words);
        System.out.println(capitalizedSentence); // 输出结果
    }
}

